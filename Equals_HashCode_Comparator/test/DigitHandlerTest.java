import HW_L5_T2_Equals.DigitHandler;
import org.junit.Test;
import org.junit.Assert;

public class DigitHandlerTest {

    DigitHandler digit1 = new DigitHandler(78);
    DigitHandler digit2 = new DigitHandler(456);
    DigitHandler digit3 = new DigitHandler(78);

    /**
     * Этот тест проверяет работу метода equals(Object o). Значения объектов равны
     */
    @Test
    public void equals1() {
        Assert.assertEquals(true, digit1.equals(digit3));
    }

    /**
     * Этот тест проверяет работу метода equals(Object o). Значения объектов различаются
     */
    @Test
    public void equals2() {
        Assert.assertEquals(false, digit1.equals(digit2));
    }

    /**
     * Этот тест проверяет работу метода equals(Object o). Переменные ссылаются на один объект
     */
    @Test
    public void equals3() {
        DigitHandler digit4 = digit1;
        Assert.assertEquals(true, digit1.equals(digit4));
    }

    /**
     * Этот тест проверяет работу метода equals(Object o). Одна из переменных содержит значение null.
     */
    @Test
    public void equals4() {
        DigitHandler digit4 = null;
        Assert.assertEquals(false, digit1.equals(digit4));
    }

    /**
     * Этот тест проверяет работу метода hashCode(). Сравниваются хэш-коды разных объектов.
     */
    @Test
    public void hashCode1() {
        Assert.assertNotEquals(digit1.hashCode(), digit2.hashCode());
    }

    /**
     * Этот тест проверяет работу метода hashCode(). Сравниваются хэш-коды одного объекта (используются разные переменные со
     * ссылкой на один объект).
     */
    @Test
    public void hashCode2() {
        DigitHandler digit4 = digit1;
        Assert.assertEquals(digit1.hashCode(), digit4.hashCode());
    }

}