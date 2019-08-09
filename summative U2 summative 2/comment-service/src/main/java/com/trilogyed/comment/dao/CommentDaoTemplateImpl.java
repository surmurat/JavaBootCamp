package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoTemplateImpl implements CommentDao {

    @Autowired
    public CommentDaoTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_COMMENT_SQL =
            "insert into comment (post_id, create_date, commenter_name, comment) values (?,?,?,?)";
    private static final String SELECT_COMMENT_SQL =
            "select * from post where comment_id = ?";
    private static final String SELECT_ALL_COMMENT_SQL =
            "select * from comment";
    private static final String DELETE_COMMENT_SQL =
            "delete from comment where comment_id = ?";
    private static final String UPDATE_COMMENT_SQL =
            "update comment set comment post_id =?, create_date =?, commenter_name =?, comment =? where comment_id =?";
    private static final String GET_COMMENT_BY_POST_ID =
            "select * from comment where post_id =?";


    @Override
    public Comment addComment(Comment comment) {

        jdbcTemplate.update(INSERT_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        comment.setCommentId(id);

        return comment;
    }

    @Override
    public Comment getComment(int id) {
        try {

            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL, this::mapRowToComment, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }



    @Override
    public List<Comment> getAllComments() {

        return jdbcTemplate.query(SELECT_ALL_COMMENT_SQL,this::mapRowToComment);
    }

    @Override
    public void updateComment(Comment comment) {
        jdbcTemplate.update(UPDATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),comment.getCommentId());
    }

    @Override
    public void deleteComment(int id) {

        jdbcTemplate.update(DELETE_COMMENT_SQL,id);
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        return jdbcTemplate.query(GET_COMMENT_BY_POST_ID, this::mapRowToComment,postId);
    }

    private Comment  mapRowToComment(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getNString("commenter_name"));
        comment.setComment("comment");
        return comment;
    }
}
