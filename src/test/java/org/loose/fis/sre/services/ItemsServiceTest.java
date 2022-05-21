package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.exceptions.IdAlreadyExistsException;
import org.loose.fis.sre.exceptions.IdDoesNotExistException;
import org.loose.fis.sre.model.Item;

import static org.testfx.assertions.api.Assertions.assertThat;

public class ItemsServiceTest{

    public static final String idf = "id";
    public static final String namef = "name";
    public static final String pricef = "price";
    public static final String sizef = "size";
    public static final String imagef = "omage";

    @AfterEach
    void tearDown(){
        ItemsService.getDataBase1().close();
        ItemsService.getDataBase2().close();
        ItemsService.getDataBase3().close();
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        ItemsService.initDatabase();
        ItemsService.initDatabaseChart();
        ItemsService.initDatabaseHistory();
    }


    @Test
    void testDatabaseIsInitializedAndNoItemIsPersisted() {
        assertThat(ItemsService.Lista1()).isNotNull();
        assertThat(ItemsService.Lista1()).isEmpty();
        assertThat(ItemsService.Lista2()).isNotNull();
        assertThat(ItemsService.Lista2()).isEmpty();
        assertThat(ItemsService.Lista3()).isNotNull();
        assertThat(ItemsService.Lista3()).isEmpty();
    }

    @Test
    void testItemIsAddedToDataBase() throws Exception{
        ItemsService.addItem(idf,namef,pricef,sizef,imagef);
        ItemsService.moveItemHistory(idf,namef,pricef,sizef);
        ItemsService.addItemChart(idf,namef,pricef,sizef);

        assertThat(ItemsService.Lista1()).isNotEmpty();
        assertThat(ItemsService.Lista1()).size().isEqualTo(1);
        assertThat(ItemsService.Lista2()).isNotEmpty();
        assertThat(ItemsService.Lista2()).size().isEqualTo(1);
        assertThat(ItemsService.Lista3()).isNotEmpty();
        assertThat(ItemsService.Lista3()).size().isEqualTo(1);

        Item item1 = ItemsService.Lista1().get(0);
        Item item2 = ItemsService.Lista2().get(0);
        Item item3 = ItemsService.Lista3().get(0);

        assertThat(item1).isNotNull();
        assertThat(item1.getId()).isEqualTo(idf);
        assertThat(item1.getName()).isEqualTo(namef);
        assertThat(item1.getPrice()).isEqualTo(pricef);
        assertThat(item1.getSize()).isEqualTo(sizef);
        assertThat(item1.getImg()).isEqualTo(imagef);

        assertThat(item2).isNotNull();
        assertThat(item2.getId()).isEqualTo(idf);
        assertThat(item2.getName()).isEqualTo(namef);
        assertThat(item2.getPrice()).isEqualTo(pricef);
        assertThat(item2.getSize()).isEqualTo(sizef);

        assertThat(item3).isNotNull();
        assertThat(item3.getId()).isEqualTo(idf);
        assertThat(item3.getName()).isEqualTo(namef);
        assertThat(item3.getPrice()).isEqualTo(pricef);
        assertThat(item3.getSize()).isEqualTo(sizef);

    }

    @Test
    void testManagerDeleteItem() throws IdDoesNotExistException, IdAlreadyExistsException {
        ItemsService.addItem(idf,namef,pricef,sizef,imagef);
        ItemsService.deleteItem(idf);
        assertThat(ItemsService.Lista1()).isEmpty();
    }

}
