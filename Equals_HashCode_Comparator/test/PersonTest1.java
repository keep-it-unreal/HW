import HW_L5_T1_Comparators.Person;
import org.junit.Test;
import org.junit.Assert;

public class PersonTest1 {

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
     * В данном тесте проверяется корректность работы метода .compareTo(Person person). Сравнивается по городам, т.к.
     * они отличаются.
     */
    @Test
    public void compareTo1() {
        Assert.assertEquals(1, person1.compareTo(person2));
    }

    /**
     * В данном тесте проверяется корректность работы метода .compareTo(Person person). Сравнивается по именам, т.к.
     * город не отличается.
     */
    @Test
    public void compareTo2() {
        Person person3 = new Person("Victor Angesov", "Kirov", 90);
        Assert.assertEquals(-1, person2.compareTo(person3));
    }

    /**
     * В данном тесте проверяется корректность работы метода .compareTo(Person person). В качестве имени одного из
     * лиц указано null.
     */
    @Test
    public void compareTo3() throws Exception{
        Person person3 = new Person(null, "Kirov", 90);
        try {
            person2.compareTo(person3);
            throw new Exception("incorrect work");
        } catch (IllegalArgumentException e){}

    }

    /**
     * В данном тесте проверяется корректность работы метода .toString().
     */
    @Test
    public void testToString() {
        Assert.assertEquals("Ivan Ivanov lives in Moscow 29y.o.", person1.toString());
    }

}