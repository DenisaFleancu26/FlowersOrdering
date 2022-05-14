package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class UserManager {
    @Id
    private String flowerShopName;
    private String username;
    private String password;
    private String role;
    private String address;
    private String email;
    private String phoneNumber;

    public UserManager(String flowerShopName, String username, String password, String role, String address, String email, String phoneNumber) {
        this.flowerShopName = flowerShopName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserManager(){

    }

    public void setFlowerShopName(String flowerShopName) {
        this.flowerShopName = flowerShopName;
    }

    public String getFlowerShopName() {
        return flowerShopName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserManager user = (UserManager) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (flowerShopName != null ? !flowerShopName.equals(user.flowerShopName) : user.flowerShopName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;

        return role != null ? role.equals(user.role) : user.role == null;
    }


    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (flowerShopName != null ? flowerShopName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);

        return result;
    }
}