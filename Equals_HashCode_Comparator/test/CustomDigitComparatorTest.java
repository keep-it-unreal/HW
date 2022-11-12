import HW_L5_T1_Comparators.CustomDigitComparator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CustomDigitComparatorTest {
    /**
     * Этот unit-тест проверяет корректность метода .compare(Integer lhs, Integer rhs). При условии, что
     * левое значение четное, а правое - нет.
     */
    @Test
    public void compare1() {
        CustomDigitComparator comparator = new CustomDigitComparator();
        Assert.assertEquals(1, comparator.compare(120, 99));
    }

    /**
     * Этот unit-тест проверяет корректность метода .compare(Integer lhs, Integer rhs). При условии, что
     * правое значение четное, а левое - нет.
     *
     */
    @Test
    public void compare2() {
        CustomDigitComparator comparator = new CustomDigitComparator();
        Assert.assertEquals(-1, comparator.compare(539, 4000));
    }

    /**
     * Этот unit-тест проверяет корректность метода .compare(Integer lhs, Integer rhs). При условии, что оба
     * значения четные.
     */
    @Test
    public void compare3() {
        CustomDigitComparator comparator = new CustomDigitComparator();
        Assert.assertEquals(0, comparator.compare(10, 2));
    }

    /**
     * Этот unit-тест проверяет корректность метода .compare(Integer lhs, Integer rhs). При условии, что в
     * метод отправлено null-значение
     */
    @Test
    public void compare4() throws Exception{
        CustomDigitComparator comparator = new CustomDigitComparator();
        try{
            Assert.assertEquals(1, comparator.compare(null, 99));
            throw new Exception("incorrect work");
        } catch (IllegalArgumentException e){}
    }

}
