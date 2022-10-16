import org.junit.Assert;
import org.junit.Test;
import ru.edu.lecture3.Gender;
import ru.edu.lecture3.User;
import ru.edu.lecture3.UserStorage;
import ru.edu.lecture3.UserStorageClass;
import java.time.LocalDate;
import java.util.List;

public class UserStorageTests {

    private UserStorage userStorage = null;

    /**
     * Этот unit-тест проверяет корректность работы метода .getUserByLogin(String login). Проверены случаи, когда различается
     * регистр, когда в качестве логина приходит null или пустая строка.
     */
    @Test
    public void getUserByLoginTest() {
        userStorage = new UserStorageClass();
        User user1 = new User("1UuU", "Ivan", "Ivanov", LocalDate.of(1999, 1, 2), Gender.MALE);
        userStorage.put(user1);
        User user2 = new User("2UuU", "Maria", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);
        userStorage.put(user2);
        Assert.assertEquals(user1, userStorage.getUserByLogin("1UUU"));
        Assert.assertEquals(user2, userStorage.getUserByLogin("2UUU"));

        try{
            userStorage.getUserByLogin(null);
            throw new RuntimeException("incorrect work");
        }catch (IllegalArgumentException e){}

        try{
            userStorage.getUserByLogin("");
            throw new RuntimeException("incorrect work");
        }catch (IllegalArgumentException e){}
    }

    /**
     * Этот unit-тест проверяет корректность работы метода .put(User user). Проверены случаи, когда различается
     * регистр, когда поля объекта некорректно заполнены, когда пользователь уже существует.
     */
    @Test
    public void putTest() throws Exception{
        userStorage = new UserStorageClass();
        User user1 = new User("1UuU", "Ivan", "Ivanov", LocalDate.of(2023, 1, 2), Gender.MALE);
        User user2 = new User("2UuU", "", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);

        try {
            userStorage.put(user1);
            throw new Exception("incorrect work");
        }catch (RuntimeException e){}
        try {
            userStorage.put(user2);
            throw new Exception("incorrect work");
        } catch (RuntimeException e){}

        User user3 = new User("2UuU", "Nastya", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);
        userStorage.put(user3);
        try{
            userStorage.put(user3);
            throw new RuntimeException("incorrect work");
        }catch (RuntimeException e){}
    }

    /**
     * Этот unit-тест проверяет корректность работы метода .remove(String login). Проверены случаи, когда различается
     * регистр, когда поля объекта некорректно заполнены, когда пользователь отсутствует(уже удален).
     */
    @Test
    public void removeTest() throws Exception{
        userStorage = new UserStorageClass();
        User user2 = new User("2UuU", "Maria", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);
        userStorage.put(user2);
        try {
            userStorage.remove("");
            throw new Exception("incorrect work");
        }catch (IllegalArgumentException e){}

        userStorage.remove("2UuU");
        try {
            userStorage.remove("2UuU");
            throw new Exception("incorrect work");
        } catch (RuntimeException e){}
    }

    /**
     * Этот unit-тест проверяет корректность работы метода .getAllUsers().
     */
    @Test
    public void getAllUsersTest() {
        userStorage = new UserStorageClass();
        User user1 = new User("1UuU", "Ivan", "Ivanov", LocalDate.of(1999, 1, 2), Gender.MALE);
        userStorage.put(user1);
        User user2 = new User("2UuU", "Maria", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);
        userStorage.put(user2);
        List<User> allUsers = userStorage.getAllUsers();
        Assert.assertTrue(allUsers.contains(user1));
        Assert.assertTrue(allUsers.contains(user2));
    }

    /**
     * Этот unit-тест проверяет корректность работы метода .getAllUsersByGender(Gender gender).Проверяется
     * исключение, когда гендер введен некорректно.
     */
    @Test
    public void getAllUsersByGenderTest() {
        userStorage = new UserStorageClass();
        User user1 = new User("1UuU", "Ivan", "Ivanov", LocalDate.of(1999, 1, 2), Gender.MALE);
        userStorage.put(user1);
        User user2 = new User("2UuU", "Maria", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);
        userStorage.put(user2);
        List<User> maleList = userStorage.getAllUsersByGender(Gender.MALE);
        Assert.assertTrue(maleList.contains(user1));
        Assert.assertTrue(!maleList.contains(user2));
        List<User> femaleList = userStorage.getAllUsersByGender(Gender.FEMALE);
        Assert.assertTrue(femaleList.contains(user2));
        Assert.assertTrue(!femaleList.contains(user1));

        try{
            List<User> list = userStorage.getAllUsersByGender(null);
        }catch (IllegalArgumentException e){}
    }

    /**
     * Этот unit-тест проверяет корректность работы метода .getUserAge(String login).Проверяется
     * исключение, когда логин введен неверно, когда пользователь с таким логином отсутствует.
     */
    @Test
    public void getUserAgeTest() throws Exception{
        userStorage = new UserStorageClass();
        User user1 = new User("1UuU", "Ivan", "Ivanov", LocalDate.of(1999, 1, 2), Gender.MALE);
        userStorage.put(user1);
        User user2 = new User("2UuU", "Maria", "Fedorova", LocalDate.of(2000, 10, 7), Gender.FEMALE);
        userStorage.put(user2);

        Assert.assertEquals(23, userStorage.getUserAge("1uuu"));
        Assert.assertEquals(21, userStorage.getUserAge("2uuu"));

        try{
            userStorage.getUserAge(null);
            throw new Exception("incorrect work");
        } catch(IllegalArgumentException e){}

        try{
            userStorage.getUserAge("3uuu");
            throw new Exception("incorrect work");
        } catch(RuntimeException e){}
    }
}