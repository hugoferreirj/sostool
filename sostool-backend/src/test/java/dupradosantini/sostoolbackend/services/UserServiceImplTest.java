package dupradosantini.sostoolbackend.services;

import dupradosantini.sostoolbackend.domain.AppUser;
import dupradosantini.sostoolbackend.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkspaceMemberRepository workspaceMemberRepository;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl (
                userRepository,
                workspaceMemberRepository);
    }

    @Test
    void createCorrectUser() {
        AppUser user = new AppUser("Hugo", "hugo@usp.br", "");

        AppUser returnedUser = userService.createUser(user);

        assertEquals(user, returnedUser, "Correct user wasn't accepted");
    }

    @Test
    void createUserNameWithLessThan3Characters() {
        AppUser user = new AppUser("Lu", "lu@gmail.com", "");

        AppUser returnedUser = userService.createUser(user);

        assertNotEquals(user, returnedUser, "Name with less than 3 characters accepted");
    }

    @Test
    void createUserNameWithMoreThan60Characters() {
        AppUser user = new AppUser("hafufhfaduhhfdufdshfdshudfuhfauasfsafhafufhfaduhhfdufdshfdsht", "lu@gmail.com", "");

        AppUser returnedUser = userService.createUser(user);

        assertNotEquals(user, returnedUser, "Name with more than 60 characters accepted");
    }

    @Test
    void createUserEmailWithMoreThan70Characters() {
        AppUser user = new AppUser("Mariana", "hafufhfaduhhfdufdshfdshudfuhfauasfsafhafufhfaduhhfdufdshfdshtaaaaaaaaaa", "");

        AppUser returnedUser = userService.createUser(user);

        assertNotEquals(user, returnedUser, "Email with more than 70 characters accepted");
    }

    @Test
    void createUserEmailEmpty() {
        AppUser user = new AppUser("Mariana", "", "");

        AppUser returnedUser = userService.createUser(user);

        assertNotEquals(user, returnedUser, "Email empty field accepted");
    }

    @Test
    void createUserNameEmpty() {
        AppUser user = new AppUser("", "mariana@gmail.com", "");

        AppUser returnedUser = userService.createUser(user);

        assertNotEquals(user, returnedUser, "Name empty field accepted");
    }
}