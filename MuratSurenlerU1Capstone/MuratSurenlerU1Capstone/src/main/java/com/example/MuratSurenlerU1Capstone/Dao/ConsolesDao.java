package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Consoles;


import java.util.List;

public interface ConsolesDao {
    Consoles addConsoles(Consoles consoles);

    Consoles getConsoles(int id);

    List<Consoles> getAllConsoles();

    void updateConsoles(Consoles consoles);

    void deleteConsoles(int id);

    List<Consoles> getConsolesByManufacturer(String manufacturer);
}
