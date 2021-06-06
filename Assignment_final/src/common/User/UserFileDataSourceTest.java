package common.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFileDataSourceTest {
    private UserFileDataSource userTest;
    private static final User A = new User("a1","a2","a3","a4","a5");
    private static final User B = new User("b1","b2","b3","b4","b5");
    private static final User C = new User("c1","c2","c3","c4","c5");


    @BeforeEach
    void initUserFileDataSourceTest() 
    {
        userTest = new UserFileDataSource();
    }

    @Test
    void addUser() 
    {
        userTest.addUser(A);
        userTest.addUser(B);
        userTest.addUser(C);
        userTest.getUser(A.getName());
        userTest.getUser(B.getName());
        userTest.getUser(C.getName());
        userTest.getSize();
        assertEquals(8, userTest.getSize());
    }

    @Test
    void deleteUser() 
    {
        userTest.deleteUser(A.getName());
        userTest.deleteUser(B.getName());
        userTest.deleteUser(C.getName());
        userTest.getUser(A.getName());
        userTest.getUser(B.getName());
        userTest.getUser(C.getName());
        userTest.getSize();
        assertEquals(5, userTest.getSize());
    }
}