package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.IdAlreadyExistsException;
import org.loose.fis.sre.exceptions.IdDoesNotExistException;
import org.loose.fis.sre.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;
import static org.loose.fis.sre.services.FileSystemService.getPathToFile;


public class ItemsService {

    private static ObjectRepository<Item> userRepository;
    private static ObjectRepository<Item> userChartRepository;
    private static ObjectRepository<Item> userHistoryRepository;
    private static Nitrite database1;
    private static Nitrite database2;
    private static Nitrite database3;

    private List<Item> items = new ArrayList<>();

    public static List<Item> getDataa() {
        List<Item> items = new ArrayList<>();
        Item itm;

            for (Item item : userRepository.find()){
                itm = new Item();
                itm.setId(item.getId());
                itm.setName(item.getName());
                itm.setPrice(item.getPrice());
                itm.setSize(item.getSize());
                itm.setImg(item.getImg());
                items.add(itm);
            }
        return items;
    }

    public static List<Item> getDataaChart() {
        List<Item> items = new ArrayList<>();
        Item itm;

        for (Item item : userChartRepository.find()){
            itm = new Item();
            itm.setId(item.getId());
            itm.setName(item.getName());
            itm.setPrice(item.getPrice());
            itm.setSize(item.getSize());
            items.add(itm);
        }
        return items;
    }

    public static List<Item> getDataaHistory() {
        List<Item> items = new ArrayList<>();
        Item itm;

        for (Item item : userHistoryRepository.find()){
            itm = new Item();
            itm.setId(item.getId());
            itm.setName(item.getName());
            itm.setPrice(item.getPrice());
            itm.setSize(item.getSize());
            items.add(itm);
        }
        return items;
    }

    public static void initDatabase() {
        database1 = Nitrite.builder()
                .filePath(getPathToFile("Flowers-OrderingItems.db").toFile())
                .openOrCreate("Flower15", "Blummen");

        userRepository = database1.getRepository(Item.class);
    }

    public static void initDatabaseChart() {
        database2 = Nitrite.builder()
                .filePath(getPathToFile("Flowers-OrderingItemsChart.db").toFile())
                .openOrCreate("Flower15", "Blummen");

        userChartRepository = database2.getRepository(Item.class);
    }

    public static void initDatabaseHistory() {
        database3 = Nitrite.builder()
                .filePath(getPathToFile("Flowers-OrderingItemsHistory.db").toFile())
                .openOrCreate("Flower15", "Blummen");

        userHistoryRepository = database3.getRepository(Item.class);
    }

    public static void deleteItem(String id ) throws IdDoesNotExistException {
        checkIdDoesNotExist(id);
        userRepository.remove(eq("id", id));
    }

    public static void addItem(String id, String name, String price, String size, String img) throws IdAlreadyExistsException {
        checkIdDoesNotAlreadyExist(id);
        userRepository.insert(new Item(id, name, price, size, img));
    }

    public static void moveItemHistory(String id, String name, String price, String size){
        userHistoryRepository.insert(new Item(id,name,price,size));
    }

    public static void addItemChart(String id, String name, String price, String size) {
        userChartRepository.insert(new Item(id, name, price, size));
    }

    private static void checkIdDoesNotExist(String id) throws IdDoesNotExistException {
        int ok =0;
        for (Item item : userRepository.find())
            if (Objects.equals(id, item.getId()))
                ok = 1;
        if ( ok == 0 )
            throw new IdDoesNotExistException(id);


    }

    private static void checkIdDoesNotAlreadyExist(String id) throws IdAlreadyExistsException {
        for (Item item : userRepository.find())
            if (Objects.equals(id, item.getId()))
                throw new IdAlreadyExistsException(id);

    }

    public static Nitrite getDataBase1() {
        return database1;
    }
    public static Nitrite getDataBase2() {
        return database2;
    }
    public static Nitrite getDataBase3() {
        return database3;
    }

    public static ObservableList<Item> Lista1()
    {
        ObservableList<Item> list1= FXCollections.observableArrayList();

        for (Item k : userRepository.find()) {
            list1.add(k);
        }
        return list1;
    }
    public static ObservableList<Item> Lista2() {
        ObservableList<Item> list2 = FXCollections.observableArrayList();

        for (Item k : userChartRepository.find()) {
            list2.add(k);
        }
        return list2;
    }
    public static ObservableList<Item> Lista3() {
        ObservableList<Item> list3 = FXCollections.observableArrayList();

        for (Item k : userHistoryRepository.find()) {
            list3.add(k);
        }
        return list3;
    }

}
