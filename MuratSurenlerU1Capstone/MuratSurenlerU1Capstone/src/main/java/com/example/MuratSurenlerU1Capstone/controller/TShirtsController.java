package com.example.MuratSurenlerU1Capstone.controller;


import com.example.MuratSurenlerU1Capstone.Model.TShirts;
import com.example.MuratSurenlerU1Capstone.servicelayer.ServiceLayer;
import com.example.MuratSurenlerU1Capstone.viewmodel.GamesViewModel;
import com.example.MuratSurenlerU1Capstone.viewmodel.TshirtsViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tshirts")
public class TShirtsController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtsViewModel> getAllTShirts() {
        return serviceLayer.findAllTShirts();
    }

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtsViewModel createTShirts(@RequestBody @Valid TshirtsViewModel tShirts) {
        return serviceLayer.saveTShirt(tShirts);
    }

    @GetMapping("{id}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public TshirtsViewModel getTShirts(@PathVariable("id") int tShirtsId) {
        TshirtsViewModel tshirtsViewModel = serviceLayer.findTShirtsbyId(tShirtsId);
        if (tshirtsViewModel == null)
            throw new IllegalArgumentException("TShirts could not be retrieved for id " + tShirtsId);
        return tshirtsViewModel;
    }

    @DeleteMapping("{id}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirts(@PathVariable("id") int tShirtsId) {
        serviceLayer.removeTShirt(tShirtsId);
    }

    @PutMapping("{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirts(@PathVariable("id") int tShirtsId, @RequestBody @Valid TshirtsViewModel tshirtsViewModel) {
        if (tshirtsViewModel.getId() == 0)
            tshirtsViewModel.setId(tShirtsId);
        if (tShirtsId != tshirtsViewModel.getId()) {
            throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
        }
        serviceLayer.updateTShirt(tshirtsViewModel);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtsViewModel> getTShirtsByColor(@PathVariable("color") String color) {
        List<TshirtsViewModel> tShirts = serviceLayer.findTShirtsByColor(color);
        if (tShirts != null && tShirts.size() == 0)
            throw new IllegalArgumentException("TShirts could not be retrieved for customer " + color);
        return tShirts;
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtsViewModel> getTShirtsBySize(@PathVariable("size") String size) {
        List<TshirtsViewModel> tShirts = serviceLayer.findTShirtsBySize(size);
        if (tShirts != null && tShirts.size() == 0)
            throw new IllegalArgumentException("TShirts could not be retrieved for customer " + size);
        return tShirts;
    }
}
