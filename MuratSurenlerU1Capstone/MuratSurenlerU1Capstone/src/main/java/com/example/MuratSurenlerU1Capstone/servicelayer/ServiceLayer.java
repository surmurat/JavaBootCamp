package com.example.MuratSurenlerU1Capstone.servicelayer;

import com.example.MuratSurenlerU1Capstone.Dao.*;
import com.example.MuratSurenlerU1Capstone.Model.*;
import com.example.MuratSurenlerU1Capstone.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    ConsolesDao consolesDao;
    GamesDao gamesDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxDao salesTaxDao;
    TShirtsDao tShirtsDao;

    @Autowired
    public ServiceLayer(ConsolesDao consolesDao, GamesDao gamesDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxDao salesTaxDao, TShirtsDao tShirtsDao) {
        this.consolesDao = consolesDao;
        this.gamesDao = gamesDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxDao = salesTaxDao;
        this.tShirtsDao = tShirtsDao;
    }

    public List<TshirtsViewModel> findAllTShirts(){

        List<TShirts> tShirtsList = tShirtsDao.getAllTShirts();
        List<TshirtsViewModel> tshirtsViewModelList = new ArrayList<>();

        tShirtsList.stream()
                .forEach(tShirts -> {
                    TshirtsViewModel tvm = buildTShirtsViewModel(tShirts);
                    tshirtsViewModelList.add(tvm);
                });
        return tshirtsViewModelList;
    }



    public TshirtsViewModel saveTShirt(TshirtsViewModel tshirtsViewModel) {

        TShirts tShirts = new TShirts();

        tShirts.setSize(tshirtsViewModel.getSize());
        tShirts.setColor(tshirtsViewModel.getColor());
        tShirts.setDescription(tshirtsViewModel.getDescription());
        tShirts.setPrice(tshirtsViewModel.getPrice());
        tShirts.setQuantity(tshirtsViewModel.getQuantity());

        tShirts =  tShirtsDao.addTShirts(tShirts);

        tshirtsViewModel.setId(tShirts.getId());
        return tshirtsViewModel;
    }

    public TshirtsViewModel findTShirtsbyId(int id) {

        TShirts tShirts =  tShirtsDao.getTShirts(id);
        if(tShirts == null)
            return null;
        else
            return buildTShirtsViewModel(tShirts);
    }

    public void removeTShirt(int id){

        tShirtsDao.deleteTShirts(id);
    }

    public void updateTShirt(TshirtsViewModel tshirtsViewModel){

        TShirts tShirts = new TShirts();

        tShirts.setId(tshirtsViewModel.getId());
        tShirts.setSize(tshirtsViewModel.getSize());
        tShirts.setColor(tshirtsViewModel.getColor());
        tShirts.setDescription(tshirtsViewModel.getDescription());
        tShirts.setPrice(tshirtsViewModel.getPrice());
        tShirts.setQuantity(tshirtsViewModel.getQuantity());

        tShirtsDao.updateTShirts(tShirts);
    }



    public List<TshirtsViewModel> findTShirtsByColor(String color){

        List<TShirts> tShirtsList = tShirtsDao.getTShirtsByColor(color);
        List<TshirtsViewModel> tshirtsViewModelList = new ArrayList<>();

        tShirtsList.stream()
                .forEach(tShirts -> {
                    TshirtsViewModel tvm = buildTShirtsViewModel(tShirts);
                    tshirtsViewModelList.add(tvm);
                });
        return tshirtsViewModelList;
    }

    public List<TshirtsViewModel> findTShirtsBySize(String size){

        List<TShirts> tShirtsList = tShirtsDao.getTShirtsBySize(size);
        List<TshirtsViewModel> tshirtsViewModelList = new ArrayList<>();

        tShirtsList.stream()
                .forEach(tShirts -> {
                    TshirtsViewModel tvm = buildTShirtsViewModel(tShirts);
                    tshirtsViewModelList.add(tvm);
                });
        return tshirtsViewModelList;
    }


    public List<GamesViewModel> findAllGames(){

        List<Games> gamesList = gamesDao.getAllGames();
        List<GamesViewModel> gamesViewModelList = new ArrayList<>();

        gamesList.stream()
                .forEach(games -> {
                    GamesViewModel tvm = buildGameViewModel(games);
                    gamesViewModelList.add(tvm);
                });
        return gamesViewModelList;
    }

    public GamesViewModel saveGame(GamesViewModel gamesViewModel) {

        Games games = new Games();

        games.setTitle(gamesViewModel.getTitle());
        games.setErsbRating(gamesViewModel.getErsbRating());
        games.setDescription(gamesViewModel.getDescription());
        games.setPrice(gamesViewModel.getPrice());
        games.setStudio(gamesViewModel.getStudio());
        games.setQuantity(gamesViewModel.getQuantity());

        games =  gamesDao.addGames(games);

        gamesViewModel.setId(games.getId());
        return gamesViewModel;



    }

    public GamesViewModel findGamesbyId(int id) {

        Games games =  gamesDao.getGames(id);
        if(games == null)
            return null;
        else
            return buildGameViewModel(games);

         }

    public void removeGame(int id){

        gamesDao.deleteGames(id);
    }

    public void updateGame(GamesViewModel gamesViewModel){

        Games games = new Games();

        games.setId(gamesViewModel.getId());
        games.setTitle(gamesViewModel.getTitle());
        games.setErsbRating(gamesViewModel.getErsbRating());
        games.setDescription(gamesViewModel.getDescription());
        games.setPrice(gamesViewModel.getPrice());
        games.setStudio(gamesViewModel.getStudio());
        games.setQuantity(gamesViewModel.getQuantity());


        gamesDao.updateGames(games);

    }

    public List<GamesViewModel> findGamesByStudio(String studio){

        List<Games> gamesList = gamesDao.getGamesByStudio(studio);
        List<GamesViewModel> gamesViewModelList = new ArrayList<>();

        gamesList.stream()
                .forEach(games -> {
                    GamesViewModel gvm = buildGameViewModel(games);
                    gamesViewModelList.add(gvm);
                });
        return gamesViewModelList;
    }

    public List<GamesViewModel> findGamesByErsb(String ersb){

        List<Games> gamesList = gamesDao.getGamesByErsb(ersb);
        List<GamesViewModel> gamesViewModelList = new ArrayList<>();

        gamesList.stream()
                .forEach(games -> {
                    GamesViewModel gvm = buildGameViewModel(games);
                    gamesViewModelList.add(gvm);
                });
        return gamesViewModelList;
    }

    public List<GamesViewModel> findGamesByTitle(String title){

        List<Games> gamesList = gamesDao.getGamesByTitle(title);
        List<GamesViewModel> gamesViewModelList = new ArrayList<>();

        gamesList.stream()
                .forEach(games -> {
                    GamesViewModel gvm = buildGameViewModel(games);
                    gamesViewModelList.add(gvm);
                });
        return gamesViewModelList;
    }


    public List<ConsoleViewModel> findAllConsoles(){

        List<Consoles> consolesList = consolesDao.getAllConsoles();
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();

        consolesList.stream()
                .forEach(consoles -> {
                    ConsoleViewModel cvm = buildConsoleViewModel(consoles);
                    consoleViewModelList.add(cvm);
                    });
        return consoleViewModelList;
    }

    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {

        Consoles consoles = new Consoles();
        consoles.setModel(consoleViewModel.getModel());
        consoles.setManufacturer(consoleViewModel.getManufacturer());
        consoles.setMemoryAmount(consoleViewModel.getMemoryAmount());
        consoles.setProcessor(consoleViewModel.getProcessor());
        consoles.setPrice(consoleViewModel.getPrice());
        consoles.setQuantity(consoleViewModel.getQuantity());
        consoles =  consolesDao.addConsoles(consoles);

        consoleViewModel.setId(consoles.getGameId());
        return consoleViewModel;
    }



    public ConsoleViewModel findConsolesbyId(int id) {

        Consoles consoles =  consolesDao.getConsoles(id);
        if(consoles == null)
            return null;
        else
            return buildConsoleViewModel(consoles);
    }



    public void removeConsole(int id) {

        consolesDao.deleteConsoles(id);
    }



    public void updateConsole(ConsoleViewModel consoleViewModel){

        Consoles consoles = new Consoles();
        consoles.setGameId(consoleViewModel.getId());
        consoles.setModel(consoleViewModel.getModel());
        consoles.setManufacturer(consoleViewModel.getManufacturer());
        consoles.setMemoryAmount(consoleViewModel.getMemoryAmount());
        consoles.setProcessor(consoleViewModel.getProcessor());
        consoles.setPrice(consoleViewModel.getPrice());
        consoles.setQuantity(consoleViewModel.getQuantity());


       consolesDao.updateConsoles(consoles);
    }



    public List<ConsoleViewModel> findConsolesByManufacturer(String manufacturer){

        List<Consoles> consolesList = consolesDao.getConsolesByManufacturer(manufacturer);
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();

        consolesList.stream()
                .forEach(consoles -> {
                    ConsoleViewModel cvm = buildConsoleViewModel(consoles);
                    consoleViewModelList.add(cvm);
                });
        return consoleViewModelList;
    }


    public InvoiceViewModel saveInvoice(PurchasingViewModel purchasingViewModel) {

        Invoice invoice = new Invoice();

        invoice.setName(purchasingViewModel.getName());
        invoice.setStreet(purchasingViewModel.getStreet());
        invoice.setCity(purchasingViewModel.getCity());
        invoice.setState(purchasingViewModel.getState());
        invoice.setZipCode(purchasingViewModel.getZipCode());
        invoice.setItemId(purchasingViewModel.getItemId());
        invoice.setItemType(purchasingViewModel.getItemType());
        invoice.setQuantity(purchasingViewModel.getQuantity());


        // Calculations
        BigDecimal unitPrice;
        BigDecimal subtotal;
        BigDecimal tax;
        BigDecimal fees;
        BigDecimal total;


        if(invoice.getItemType().equals("Consoles")){

                Consoles c = consolesDao.getConsoles(invoice.getItemId());
                unitPrice = c.getPrice();

                if (invoice.getQuantity() > c.getQuantity()){
                    throw new IllegalArgumentException("Not enough items in stock");
                }else {
                    c.setQuantity(c.getQuantity()-invoice.getQuantity());
                    consolesDao.updateConsoles(c);
                }
        }else if (invoice.getItemType().equals("Games")){

                Games g = gamesDao.getGames(invoice.getItemId());
                unitPrice = g.getPrice();

            if (invoice.getQuantity() > g.getQuantity()){
                throw new IllegalArgumentException("Not enough items in stock");
            }else {
                g.setQuantity(g.getQuantity()-invoice.getQuantity());
                gamesDao.updateGames(g);
            }


        }else if (invoice.getItemType().equals("T-Shirts")){

                TShirts t = tShirtsDao.getTShirts(invoice.getItemId());
                unitPrice = t.getPrice();

            if (invoice.getQuantity() > t.getQuantity()){
                throw new IllegalArgumentException("Not enough items in stock");
            }else {
                t.setQuantity(t.getQuantity()-invoice.getQuantity());
                tShirtsDao.updateTShirts(t);
            }

        }else{
            throw new IllegalArgumentException("Product type is not correct");
        }

        //
        subtotal = unitPrice.multiply(BigDecimal.valueOf(invoice.getQuantity())).setScale(2, RoundingMode.HALF_UP);

        //
        tax = salesTaxDao.getSalesTaxRateByState(invoice.getState()).getRate().multiply(subtotal).setScale(2,RoundingMode.HALF_UP);
        //
        fees = processingFeeDao.getProcessingFeeByProducts(invoice.getItemType()).getFee();

        if (invoice.getQuantity() > 10){
            fees = fees.add(new BigDecimal(15.49)).setScale(2,RoundingMode.HALF_UP) ;
        }
        //
        total = subtotal.add(tax).add(fees).setScale(2,RoundingMode.HALF_UP);
        //
        invoice.setUnitPrice(unitPrice);
        invoice.setSubTotal(subtotal);
        invoice.setTax(tax);
        invoice.setProcessingFee(fees);
        invoice.setTotal(total);

        invoice =  invoiceDao.addInvoice(invoice);

        return buildInvoiceViewModel(invoice);
    }


    private ConsoleViewModel buildConsoleViewModel(Consoles consoles) {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setId(consoles.getGameId());
        consoleViewModel.setModel(consoles.getModel());
        consoleViewModel.setManufacturer(consoles.getManufacturer());
        consoleViewModel.setMemoryAmount(consoles.getMemoryAmount());
        consoleViewModel.setProcessor(consoles.getProcessor());
        consoleViewModel.setPrice(consoles.getPrice());
        consoleViewModel.setQuantity(consoles.getQuantity());

        return consoleViewModel;
    }

    private TshirtsViewModel buildTShirtsViewModel(TShirts tShirts) {

        TshirtsViewModel tshirtsViewModel = new TshirtsViewModel();

        tshirtsViewModel.setId(tShirts.getId());
        tshirtsViewModel.setSize(tShirts.getSize());
        tshirtsViewModel.setColor(tShirts.getColor());
        tshirtsViewModel.setDescription(tShirts.getDescription());
        tshirtsViewModel.setPrice(tShirts.getPrice());
        tshirtsViewModel.setQuantity(tShirts.getQuantity());

            return tshirtsViewModel;
        }

    private GamesViewModel buildGameViewModel(Games games) {

            GamesViewModel gamesViewModel = new GamesViewModel();

        gamesViewModel.setId(games.getId());
        gamesViewModel.setTitle(games.getTitle());
        gamesViewModel.setErsbRating(games.getErsbRating());
        gamesViewModel.setDescription(games.getDescription());
        gamesViewModel.setPrice(games.getPrice());
        gamesViewModel.setStudio(games.getStudio());
        gamesViewModel.setQuantity(games.getQuantity());

            return gamesViewModel;
        }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setId(invoice.getId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipCode(invoice.getZipCode());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubTotal(invoice.getSubTotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        return ivm;
        }
















}



