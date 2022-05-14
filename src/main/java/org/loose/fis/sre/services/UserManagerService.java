package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.InvalidDataException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.EmailAlreadyExistsException;
import org.loose.fis.sre.exceptions.FlowerNameAlreadyExistsException;
import org.loose.fis.sre.model.UserManager;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserManagerService {

    private static ObjectRepository<UserManager> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Flowers-OrderingManager.db").toFile())
                .openOrCreate("Flower15", "Blummen");

        userRepository = database.getRepository(UserManager.class);
    }

    public static void addUserManager(String flowerShopName, String username, String password, String address, String email, String phoneNumber ) throws UsernameAlreadyExistsException, EmailAlreadyExistsException, FlowerNameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username, email, flowerShopName);
        userRepository.insert(new UserManager(flowerShopName, username, encodePassword(username, password), "Manager", address, email,  phoneNumber));
    }

    private static void checkUserDoesNotAlreadyExist(String username, String email, String flowerShopName) throws UsernameAlreadyExistsException, EmailAlreadyExistsException, FlowerNameAlreadyExistsException {
        for (UserManager user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);

            if (Objects.equals(email, user.getEmail()))
                throw new EmailAlreadyExistsException(email);

            if (Objects.equals(flowerShopName, user.getFlowerShopName()))
                throw new FlowerNameAlreadyExistsException(flowerShopName);


        }
    }

    public static int checkInvalidLogin(String username,String password,String role) {
        for(UserManager user: userRepository.find()){
            String encryptedPassword = encodePassword(username, password);
            if(Objects.equals(username, user.getUsername()) && Objects.equals(role, user.getRole()) && Objects.equals(encryptedPassword, user.getPassword()))
                return 1;
        }
        return 0;
    }

    public static void checkInvalidData(String username,String role,String newPasswordField,String confirmNewPasswordField) throws InvalidDataException {
        int ok=0;
        for (UserManager user : UserManagerService.userRepository.find()) {
            if(newPasswordField!=null && confirmNewPasswordField!=null)
                if (Objects.equals(username, user.getUsername()) && Objects.equals(role, user.getRole()) && Objects.equals(newPasswordField, confirmNewPasswordField))
                {
                    String encryptedPassword = encodePassword(username, newPasswordField);
                    user.setPassword(encryptedPassword);
                    userRepository.update(user);
                    ok=1;
                }
        }
        if(ok==0) throw new InvalidDataException();
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
