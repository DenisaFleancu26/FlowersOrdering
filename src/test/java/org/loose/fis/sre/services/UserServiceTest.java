package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.exceptions.EmailAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;

import static org.testfx.assertions.api.Assertions.assertThat;


public class UserServiceTest {

    public static final String CUSTOMER = "testtt";

    @AfterEach
    void tearDown(){
        UserService.getDatabase().close();
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Test
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.Lista()).isNotNull();
        assertThat(UserService.Lista()).isEmpty();
    }

    @Test
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        UserService.addUser(CUSTOMER, CUSTOMER, CUSTOMER, CUSTOMER, CUSTOMER, CUSTOMER, CUSTOMER);
        assertThat(UserService.Lista()).isNotEmpty();
        assertThat(UserService.Lista()).size().isEqualTo(1);
        User user = UserService.Lista().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(CUSTOMER);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(CUSTOMER, CUSTOMER));
        assertThat(user.getRole()).isEqualTo("Customer");
    }

    @Test
    void testEncodePassword(){
        assertThat(UserService.encodePassword(CUSTOMER,CUSTOMER)).isEqualTo(UserService.encodePassword(CUSTOMER,CUSTOMER));
    }


}
