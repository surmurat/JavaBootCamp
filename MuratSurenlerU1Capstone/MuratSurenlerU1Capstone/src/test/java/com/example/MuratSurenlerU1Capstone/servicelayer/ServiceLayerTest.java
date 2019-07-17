package com.example.MuratSurenlerU1Capstone.servicelayer;

import com.example.MuratSurenlerU1Capstone.Dao.*;
import com.example.MuratSurenlerU1Capstone.Model.*;
import com.example.MuratSurenlerU1Capstone.viewmodel.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {



    GamesDao gamesDao;
    TShirtsDao tShirtsDao;
    ConsolesDao consolesDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxDao salesTaxDao;
    InvoiceDao invoiceDao;
    ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {

        setUpConsolesDaoMock();
        setUpGamesDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxDaoMock();
        setUpTShirtsDaoMock();


        serviceLayer = new ServiceLayer(consolesDao, gamesDao,invoiceDao,processingFeeDao,salesTaxDao, tShirtsDao);
    }

    @Test
    public void findAllTShirts() {

        TshirtsViewModel tshirtsViewModel =new TshirtsViewModel();

        tshirtsViewModel.setId(5);
        tshirtsViewModel.setSize("small");
        tshirtsViewModel.setColor("blue");
        tshirtsViewModel.setDescription("short sleeve");
        tshirtsViewModel.setPrice(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        tshirtsViewModel.setQuantity(25);

        List<TshirtsViewModel> tshirtsViewModels = serviceLayer.findAllTShirts();
        assertEquals(tshirtsViewModels.size(),1);

    }

    @Test
    public void saveFindTShirt() {

        TshirtsViewModel tshirtsViewModel = new TshirtsViewModel();

        tshirtsViewModel.setSize("small");
        tshirtsViewModel.setColor("blue");
        tshirtsViewModel.setDescription("short sleeve");
        tshirtsViewModel.setPrice(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        tshirtsViewModel.setQuantity(25);

        tshirtsViewModel = serviceLayer.saveTShirt(tshirtsViewModel);
        TshirtsViewModel fromService = serviceLayer.findTShirtsbyId(tshirtsViewModel.getId());
        assertEquals(tshirtsViewModel, fromService);

    }


    @Test
    public void findTShirtsByColor() {

        TshirtsViewModel tshirtsViewModel = new TshirtsViewModel();

        tshirtsViewModel.setSize("small");
        tshirtsViewModel.setColor("blue");
        tshirtsViewModel.setDescription("short sleeve");
        tshirtsViewModel.setPrice(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        tshirtsViewModel.setQuantity(25);

        tshirtsViewModel = serviceLayer.saveTShirt(tshirtsViewModel);
        List<TshirtsViewModel> tshirtsViewModels = serviceLayer.findTShirtsByColor("blue");
        assertEquals(tshirtsViewModels.size(),1);
        assertEquals(tshirtsViewModels.get(0), tshirtsViewModel);
    }

    @Test
    public void findTShirtsBySize() {
        TshirtsViewModel tshirtsViewModel = new TshirtsViewModel();

        tshirtsViewModel.setSize("small");
        tshirtsViewModel.setColor("blue");
        tshirtsViewModel.setDescription("short sleeve");
        tshirtsViewModel.setPrice(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        tshirtsViewModel.setQuantity(25);

        tshirtsViewModel = serviceLayer.saveTShirt(tshirtsViewModel);
        List<TshirtsViewModel> tshirtsViewModels = serviceLayer.findTShirtsBySize("small");
        assertEquals(tshirtsViewModels.size(),1);
        assertEquals(tshirtsViewModels.get(0), tshirtsViewModel);

    }



    @Test
    public void findAllGames() {

        GamesViewModel gamesViewModel =new GamesViewModel();

        gamesViewModel.setId(1);
        gamesViewModel.setTitle("shinobi");
        gamesViewModel.setErsbRating("9");
        gamesViewModel.setDescription("ninja");
        gamesViewModel.setPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        gamesViewModel.setStudio("sony");
        gamesViewModel.setQuantity(22);

        List<GamesViewModel> gamesViewModels = serviceLayer.findAllGames();
        assertEquals(gamesViewModels.size(),1);
    }

    @Test
    public void saveFindGame() {

        GamesViewModel gamesViewModel = new GamesViewModel();


        gamesViewModel.setTitle("shinobi");
        gamesViewModel.setErsbRating("9");
        gamesViewModel.setDescription("ninja");
        gamesViewModel.setPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        gamesViewModel.setStudio("sony");
        gamesViewModel.setQuantity(22);

        gamesViewModel = serviceLayer.saveGame(gamesViewModel);
        GamesViewModel fromService = serviceLayer.findGamesbyId(gamesViewModel.getId());
        assertEquals(gamesViewModel, fromService);
    }





    @Test
    public void findGamesByStudio() {

        GamesViewModel gamesViewModel = new GamesViewModel();

        gamesViewModel.setTitle("shinobi");
        gamesViewModel.setErsbRating("9");
        gamesViewModel.setDescription("ninja");
        gamesViewModel.setPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        gamesViewModel.setStudio("sony");
        gamesViewModel.setQuantity(22);

        gamesViewModel = serviceLayer.saveGame(gamesViewModel);
        List<GamesViewModel> gamesViewModels = serviceLayer.findGamesByStudio("sony");
        assertEquals(gamesViewModels.size(),1);
        assertEquals(gamesViewModels.get(0), gamesViewModel);
    }

    @Test
    public void findGamesByErsb() {

        GamesViewModel gamesViewModel = new GamesViewModel();

        gamesViewModel.setTitle("shinobi");
        gamesViewModel.setErsbRating("9");
        gamesViewModel.setDescription("ninja");
        gamesViewModel.setPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        gamesViewModel.setStudio("sony");
        gamesViewModel.setQuantity(22);

        gamesViewModel = serviceLayer.saveGame(gamesViewModel);
        List<GamesViewModel> gamesViewModels = serviceLayer.findGamesByErsb("9");
        assertEquals(gamesViewModels.size(),1);
        assertEquals(gamesViewModels.get(0), gamesViewModel);
    }

    @Test
    public void findGamesByTitle() {

        GamesViewModel gamesViewModel = new GamesViewModel();

        gamesViewModel.setTitle("shinobi");
        gamesViewModel.setErsbRating("9");
        gamesViewModel.setDescription("ninja");
        gamesViewModel.setPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        gamesViewModel.setStudio("sony");
        gamesViewModel.setQuantity(22);

        gamesViewModel = serviceLayer.saveGame(gamesViewModel);
        List<GamesViewModel> gamesViewModels = serviceLayer.findGamesByTitle("shinobi");
        assertEquals(gamesViewModels.size(),1);
        assertEquals(gamesViewModels.get(0), gamesViewModel);
    }

    @Test
    public void findAllConsoles() {

        ConsoleViewModel consolesViewModel =new ConsoleViewModel();

        consolesViewModel.setModel("ps4");
        consolesViewModel.setManufacturer("sony");
        consolesViewModel.setMemoryAmount("64");
        consolesViewModel.setProcessor("q4");
        consolesViewModel.setPrice(new BigDecimal(47.00).setScale(2, RoundingMode.HALF_UP));
        consolesViewModel.setQuantity(22);

        List<ConsoleViewModel> consoleViewModels = serviceLayer.findAllConsoles();
        assertEquals(consoleViewModels.size(),1);
    }

    @Test
    public void saveFindConsoles(){

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setModel("ps4");
        consoleViewModel.setManufacturer("sony");
        consoleViewModel.setMemoryAmount("64");
        consoleViewModel.setProcessor("q4");
        consoleViewModel.setPrice(new BigDecimal(47.00).setScale(2, RoundingMode.HALF_UP));
        consoleViewModel.setQuantity(22);

        consoleViewModel = serviceLayer.saveConsole(consoleViewModel);
        ConsoleViewModel fromService = serviceLayer.findConsolesbyId(consoleViewModel.getId());
        assertEquals(consoleViewModel, fromService);
    }



    @Test
    public void findConsolesByManufacturer() {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setModel("ps4");
        consoleViewModel.setManufacturer("sony");
        consoleViewModel.setMemoryAmount("64");
        consoleViewModel.setProcessor("q4");
        consoleViewModel.setPrice(new BigDecimal(47.00).setScale(2, RoundingMode.HALF_UP));
        consoleViewModel.setQuantity(22);

        consoleViewModel = serviceLayer.saveConsole(consoleViewModel);
        List<ConsoleViewModel> consoleViewModels = serviceLayer.findConsolesByManufacturer("sony");
        assertEquals(consoleViewModels.size(),1);
        assertEquals(consoleViewModels.get(0), consoleViewModel);
    }

    @Test
    public void saveInvoice() {
        //input
        PurchasingViewModel purchasingViewModel = new PurchasingViewModel();
        purchasingViewModel.setName("joe");
        purchasingViewModel.setStreet("eight");
        purchasingViewModel.setCity("union");
        purchasingViewModel.setState("nj");
        purchasingViewModel.setZipCode("07087");
        purchasingViewModel.setItemType("Games");
        purchasingViewModel.setItemId(1);
        purchasingViewModel.setQuantity(1);
        //service
        InvoiceViewModel fromService = serviceLayer.saveInvoice(purchasingViewModel);

        //output
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(1);
        invoiceViewModel.setName("joe");
        invoiceViewModel.setStreet("eight");
        invoiceViewModel.setCity("union");
        invoiceViewModel.setState("nj");
        invoiceViewModel.setZipCode("07087");
        invoiceViewModel.setItemType("Games");
        invoiceViewModel.setItemId(1);
        invoiceViewModel.setUnitPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setQuantity(1);
        invoiceViewModel.setSubTotal(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setTax(new BigDecimal(0.5).setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setProcessingFee(new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setTotal(new BigDecimal(11.99).setScale(2, RoundingMode.HALF_UP));
        //assert
        assertEquals(invoiceViewModel,fromService);


    }

    private void setUpConsolesDaoMock() {

        consolesDao = mock(ConsolesDaoJdbcTemplateImpl.class);

        Consoles consoles = new Consoles();

        consoles.setGameId(5);
        consoles.setModel("ps4");
        consoles.setManufacturer("sony");
        consoles.setMemoryAmount("64");
        consoles.setProcessor("q4");
        consoles.setPrice(new BigDecimal(47.00).setScale(2, RoundingMode.HALF_UP));
        consoles.setQuantity(22);

        Consoles consoles1 = new Consoles();

        consoles1.setModel("ps4");
        consoles1.setManufacturer("sony");
        consoles1.setMemoryAmount("64");
        consoles1.setProcessor("q4");
        consoles1.setPrice(new BigDecimal(47.00).setScale(2, RoundingMode.HALF_UP));
        consoles1.setQuantity(22);

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(consoles);

        doReturn(consoles).when(consolesDao).addConsoles(consoles1);
        doReturn(consoles).when(consolesDao).getConsoles(5);
        doReturn(consolesList).when(consolesDao).getAllConsoles();
        doReturn(consolesList).when(consolesDao).getConsolesByManufacturer(consoles.getManufacturer());
    }


    private void setUpGamesDaoMock() {

        gamesDao = mock(GamesDaoJdbcTemplateImpl.class);

        Games games = new Games();

        games.setId(1);
        games.setTitle("shinobi");
        games.setErsbRating("9");
        games.setDescription("ninja");
        games.setPrice(new BigDecimal(10).setScale(2, RoundingMode.HALF_UP));
        games.setStudio("sony");
        games.setQuantity(22);

        Games games1 = new Games();

        games1.setTitle("shinobi");
        games1.setErsbRating("9");
        games1.setDescription("ninja");
        games1.setPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        games1.setStudio("sony");
        games1.setQuantity(22);

        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);

        doReturn(games).when(gamesDao).addGames(games1);
        doReturn(games).when(gamesDao).getGames(1);
        doReturn(gamesList).when(gamesDao).getAllGames();
        doReturn(gamesList).when(gamesDao).getGamesByErsb(games.getErsbRating());
        doReturn(gamesList).when(gamesDao).getGamesByStudio(games.getStudio());
        doReturn(gamesList).when(gamesDao).getGamesByTitle(games.getTitle());
    }


    private void setUpInvoiceDaoMock() {

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();

        invoice.setId(1);
        invoice.setName("joe");
        invoice.setStreet("eight");
        invoice.setCity("union");
        invoice.setState("nj");
        invoice.setZipCode("07087");
        invoice.setItemType("Games");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        invoice.setQuantity(1);
        invoice.setSubTotal(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal(11.99).setScale(2, RoundingMode.HALF_UP));

        Invoice invoice1 = new Invoice();

        invoice1.setName("joe");
        invoice1.setStreet("eight");
        invoice1.setCity("union");
        invoice1.setState("nj");
        invoice1.setZipCode("07087");
        invoice1.setItemType("Games");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        invoice1.setQuantity(1);
        invoice1.setSubTotal(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP));
        invoice1.setTax(new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP));
        invoice1.setProcessingFee(new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP));
        invoice1.setTotal(new BigDecimal(11.99).setScale(2, RoundingMode.HALF_UP));

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);

    }


    private void setUpProcessingFeeDaoMock() {

        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();

        processingFee.setProductType("Games");
        processingFee.setFee(new BigDecimal(1.49).setScale(2, RoundingMode.HALF_UP));

        doReturn(processingFee).when(processingFeeDao).getProcessingFeeByProducts("Games");

    }

    private void setUpSalesTaxDaoMock() {

        salesTaxDao = mock(SalesTaxDaoJdbcTemplateImpl.class);

        SalesTax salesTax = new SalesTax();

        salesTax.setState("nj");
        salesTax.setRate(new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP));

        doReturn(salesTax).when(salesTaxDao).getSalesTaxRateByState("nj");

    }

    private void setUpTShirtsDaoMock() {

        tShirtsDao = mock(TShirtsDaoJdbcTemplateImpl.class);

        TShirts tShirts = new TShirts();

        tShirts.setId(5);
        tShirts.setSize("small");
        tShirts.setColor("blue");
        tShirts.setDescription("short sleeve");
        tShirts.setPrice(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        tShirts.setQuantity(25);

        TShirts tShirts1 = new TShirts();

        tShirts1.setSize("small");
        tShirts1.setColor("blue");
        tShirts1.setDescription("short sleeve");
        tShirts1.setPrice(new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        tShirts1.setQuantity(25);

        List<TShirts> tShirtsList = new ArrayList<>();
        tShirtsList.add(tShirts);

        doReturn(tShirts).when(tShirtsDao).addTShirts(tShirts1);
        doReturn(tShirts).when(tShirtsDao).getTShirts(5);
        doReturn(tShirtsList).when(tShirtsDao).getAllTShirts();
        doReturn(tShirtsList).when(tShirtsDao).getTShirtsByColor(tShirts.getColor());
        doReturn(tShirtsList).when(tShirtsDao).getTShirtsBySize(tShirts.getSize());
    }






}