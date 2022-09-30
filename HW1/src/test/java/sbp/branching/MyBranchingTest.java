package sbp.branching;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sbp.common.Utils;

import static org.mockito.ArgumentMatchers.anyString;

public class MyBranchingTest {
    /**
     * Этот unit-тест проверяет корректность метода в зависимости от возможных реализаций: когда одно из чисел больше,
     * когда числа равны, или случай, когда результат выполнения функции Utils#utilFunc2 == true. Для случаев сравнения
     * используем класс Assert с соответствующими методами. Для проверки корректности метода в случае, когда результат
     * выполнения функции Utils#utilFunc2 == true, используем объект - заглушку и методы библиотеки Mockito.
     */
    @Test
    public void maxInt_Test(){
        Utils utilsMock = Mockito.mock(Utils.class);
        MyBranching myBranching = new MyBranching(utilsMock);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Assert.assertEquals(0, myBranching.maxInt(-3, 5));
        Assert.assertEquals(0, myBranching.maxInt(6, 0));
        Assert.assertEquals(0, myBranching.maxInt(6, 6));

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Assert.assertEquals(5, myBranching.maxInt(-3, 5));
        Assert.assertEquals(6, myBranching.maxInt(6, 0));
        Assert.assertEquals(6, myBranching.maxInt(6, 6));
    }

    /**
     * Этот unit-тест проверяет корректность метода в зависимости от возможных реализаций: когда результат выполнения
     * функции Utils#utilFunc2 == true или == false. Для имитации возврата соответствующего значения
     * как результата выполнения функции Utils#utilFunc2,используем объект - заглушку и методы библиотеки Mockito.
     * После получения значения из метода сравниваем с помощью методов класса Assert.
     */
    @Test
    public void ifElseExample_Test(){
        Utils utilsMock = Mockito.mock(Utils.class);
        MyBranching myBranching = new MyBranching(utilsMock);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Assert.assertEquals(true, myBranching.ifElseExample());

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Assert.assertEquals(false, myBranching.ifElseExample());

    }

    /**
     * Этот unit-тест проверяет корректность метода в случае, если значение аргумента метода равно 1. Для имитации
     * возврата соответствующего значения как результата выполнения функции Utils#utilFunc2,используем объект - заглушку
     * и методы библиотеки Mockito. В данном тесте проверяем количество вызовов соответствующих функций.
     */
    @Test
    public void switchExample_Test1(){
        final int i = 1;
        Utils utilsMock = Mockito.mock(Utils.class);
        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();

        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
    /**
     * Этот unit-тест проверяет корректность метода в случае, если значение аргумента метода равно 1. Для имитации
     * возврата соответствующего значения как результата выполнения функции Utils#utilFunc2,используем объект - заглушку
     * и методы библиотеки Mockito. В данном тесте проверяем количество вызовов соответствующих функций.
     */
    @Test
    public void switchExample_Test2(){
        final int i = 2;
        Utils utilsMock = Mockito.mock(Utils.class);
        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);
        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
    /**
     * Этот unit-тест проверяет корректность метода в случае, если значение аргумента метода равно 1. Для имитации
     * возврата соответствующего значения как результата выполнения функции Utils#utilFunc2,используем объект - заглушку
     * и методы библиотеки Mockito. В данном тесте проверяем количество вызовов соответствующих функций.
     */
    @Test
    public void switchExample_Test0(){
        final int i = 0;
        Utils utilsMock = Mockito.mock(Utils.class);
        MyBranching myBranching = new MyBranching(utilsMock);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        myBranching.switchExample(i);
        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();

        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        myBranching.switchExample(i);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
}
