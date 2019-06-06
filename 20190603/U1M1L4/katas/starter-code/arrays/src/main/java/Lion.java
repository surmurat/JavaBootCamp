public class Lion {

    private String name;
    private int age;
    private int weight;
    private String sex;

    public Lion(String name, int age, int weight, String sex){
        this.name= name;
        this.age =age;
        this.weight = weight;
        this.sex=sex;
    }

    public  void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return this.sex;
    }

    public void roar(){
        System.out.println("roar");
    }

    public static void main(String[] args) {

    }
}
