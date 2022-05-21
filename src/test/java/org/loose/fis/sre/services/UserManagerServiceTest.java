package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.exceptions.EmailAlreadyExistsException;
import org.loose.fis.sre.exceptions.FlowerNameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.UserManager;

import static org.assertj.core.api.Assertions.assertThat;

public class UserManagerServiceTest {

    public static final String MANAGER = "testtt";

    @AfterEach
    void tearDown(){
        UserManagerService.getDatabase().close();
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserManagerService.initDatabase();
    }

    @Test
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        assertThat(UserManagerService.Lista()).isNotNull();
        assertThat(UserManagerService.Lista()).isEmpty();
    }

    @Test
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException, EmailAlreadyExistsException, FlowerNameAlreadyExistsException {
        UserManagerService.addUserManager(MANAGER, MANAGER, MANAGER, MANAGER, MANAGER, MANAGER);
        assertThat(UserManagerService.Lista()).isNotEmpty();
        assertThat(UserManagerService.Lista()).size().isEqualTo(1);
        UserManager user = UserManagerService.Lista().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(MANAGER);
        assertThat(user.getPassword()).isEqualTo(UserManagerService.encodePassword(MANAGER, MANAGER));
        assertThat(user.getRole()).isEqualTo("Manager");
        assertThat(user.getFlowerShopName()).isEqualTo(MANAGER);
        assertThat(user.getEmail()).isEqualTo(MANAGER);
        assertThat(user.getPhoneNumber()).isEqualTo(MANAGER);
    }

    @Test
    void testEncodePassword(){
        assertThat(UserManagerService.encodePassword(MANAGER,MANAGER)).isEqualTo(UserManagerService.encodePassword(MANAGER,MANAGER));
    }

}
