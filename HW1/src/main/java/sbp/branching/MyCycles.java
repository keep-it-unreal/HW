package sbp.branching;

import sbp.common.Utils;

public class MyCycles
{
    private final Utils utils;

    public MyCycles(Utils utils)
    {
        this.utils = utils;
    }

    /**
     * Необходимо написать реализацию метода с использованием for()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Должна присутствовать проверка возврщаемого значения от Utils#utilFunc1()
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param iterations - количество итераций
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleForExample(int iterations, String str)
    {
        boolean result = false;
        for(int i = 0; i < iterations; ++i){
            result = utils.utilFunc1(str);
            if (result == false) {
                break;
            }
        }
    }

    /**
     * Необходимо написать реализацию метода с использованием while()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Должна присутствовать проверка возврщаемого значения от Utils#utilFunc1()
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param iterations - количество итераций
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleWhileExample(int iterations, String str)
    {
        boolean result = true;
        int i = 0;
        while(i < iterations && result){
            result = utils.utilFunc1(str);
            ++i;
        }
    }

    /**
     * Необходимо написать реализацию метода с использованием while()
     -     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     -     * Реализация Utils#utilFunc1() неизвестна
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     * Должна присутствовать проверка возврщаемого значения
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param from - начальное значение итератора
     * @param to - конечное значение итератора
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleDoWhileExample(int from, int to, String str)
    {
        int iterations = from - to;
        if(iterations <= 0){
            return;
        }
        boolean result = false;
        int i = 0;
        do {
            result = utils.utilFunc1(str);
            ++i;
        } while(i < iterations && result);
    }
}
