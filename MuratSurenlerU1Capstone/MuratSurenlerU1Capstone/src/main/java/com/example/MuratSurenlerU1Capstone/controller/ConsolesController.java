package com.example.MuratSurenlerU1Capstone.controller;

import com.example.MuratSurenlerU1Capstone.servicelayer.ServiceLayer;
import com.example.MuratSurenlerU1Capstone.viewmodel.ConsoleViewModel;
import com.example.MuratSurenlerU1Capstone.viewmodel.GamesViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsolesController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllconsoles() {
        return serviceLayer.findAllConsoles();
    }

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsoles(@RequestBody @Valid ConsoleViewModel consoles) {
        return serviceLayer.saveConsole(consoles);
    }

    @GetMapping("/{id}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsoles(@PathVariable("id") int consoleId) {
        ConsoleViewModel consoleViewModel = serviceLayer.findConsolesbyId(consoleId);
        if (consoleViewModel == null)
            throw new IllegalArgumentException("Console could not be retrieved for id " + consoleId);
        return consoleViewModel;
    }

    @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsoles(@PathVariable("id") int consoleId) {
        serviceLayer.removeConsole(consoleId);
    }

    @PutMapping("/{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsoles(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getId() == 0)
            consoleViewModel.setId(consoleId);
        if (consoleId != consoleViewModel.getId()) {
            throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
        }
        serviceLayer.updateConsole(consoleViewModel);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> consoles = serviceLayer.findConsolesByManufacturer(manufacturer);
        if (consoles != null && consoles.size() == 0)
            throw new IllegalArgumentException("Game could not be retrieved for customer " + manufacturer);
        return consoles;
    }



}
