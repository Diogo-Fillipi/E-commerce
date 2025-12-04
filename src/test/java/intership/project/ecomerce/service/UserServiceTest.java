package intership.project.ecomerce.service;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService;

    @Test
    void findProductByNameTest(){
        userService.getProductByName("name");
    }
}
