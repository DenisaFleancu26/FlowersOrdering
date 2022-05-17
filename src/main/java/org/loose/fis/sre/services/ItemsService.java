package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.IdAlreadyExistsException;
import org.loose.fis.sre.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;


public class ItemsService {

    private static ObjectRepository<Item> userRepository;

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

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Flowers-OrderingItems.db").toFile())
                .openOrCreate("Flower15", "Blummen");

        userRepository = database.getRepository(Item.class);
    }

    public static void addItem(String id, String name, String price, String size, String img) throws IdAlreadyExistsException {
        checkIdDoesNotAlreadyExist(id);
        userRepository.insert(new Item(id, name, price, size, img));
    }

    private static void checkIdDoesNotAlreadyExist(String id) throws IdAlreadyExistsException {
        for (Item item : userRepository.find())
            if (Objects.equals(id, item.getId()))
                throw new IdAlreadyExistsException(id);

    }

}