import HW_L5_T2_Equals.Person;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class PersonTest {

    Person person1 = new Person("Ivan Ivanov", "Moscow", 29);
    Person person2 = new Person("Anna Ivanova", "Kirov", 10);
    /**
     * В данном тесте проверяется корректность работы метода .getName().
     */
    @Test
    public void getName() {
        Assert.assertEquals("Anna Ivanova", person2.getName());
    }
    /**
     * В данном тесте проверяется корректность работы метода .getCity().
     */
    @Test
    public void getCity() {
        Assert.assertEquals("Moscow", person1.getCity());
    }
    /**
     * В данном тесте проверяется корректность работы метода .getAge().
     */
    @Test
    public void getAge() {
        Assert.assertEquals(29, person1.getAge());
    }

    /**
     * В данном тесте проверяется корректность работы метода equals(Object o).
     */
    @Test
    public void equals1() {
        Assert.assertEquals(false, person1.equals(person2));
    }
    /**
     * В данном тесте проверяется корректность работы метода equals(Object o). В качестве имени одного из
     * лиц указано null.
     */
    @Test
    public void equals2() throws Exception{
        Person person3 = new Person(null, "Kirov", 90);
        try {
            person2.equals(person3);
            throw new Exception("incorrect work");
        } catch (IllegalArgumentException e){}
    }

    /**
     * Этот тест проверяет работу метода equals(Object o). Переменные ссылаются на один объект
     */
    @Test
    public void equals3() {
        Person person3 = person1;
        Assert.assertEquals(true, person1.equals(person3));
    }

    /**
     * Этот тест проверяет работу метода equals(Object o). Одна из переменных содержит значение null.
     */
    @Test
    public void equals4() {
        Person person3 = null;
        Assert.assertEquals(false, person1.equals(person3));
    }

    /**
     * Этот тест проверяет работу метода hashCode(). Сравниваются хэш-коды разных объектов.
     */
    @Test
    public void hashCode1() {
        Assert.assertNotEquals(person1.hashCode(), person2.hashCode());
    }
    /**
     * Этот тест проверяет работу метода hashCode(). Сравниваются хэш-коды одного объекта (используются разные переменные со
     * ссылкой на один объект).
     */
    @Test
    public void hashCode2() {
        Person person3 = person1;
        Assert.assertEquals(person1.hashCode(), person3.hashCode());
    }


    /**
     * В данном тесте проверяется корректность работы метода .toString().
     */
    @Test
    public void testToString() {
        Assert.assertEquals("Ivan Ivanov lives in Moscow 29y.o.", person1.toString());
    }


}