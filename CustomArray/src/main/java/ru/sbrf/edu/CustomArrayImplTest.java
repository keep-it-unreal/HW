package ru.sbrf.edu;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class CustomArrayImplTest {

    /**
     * Этот тест проверяет работу метода .size() при добавлении в список 2-х объектов.
     */
    @Test
    public void sizeTest() {
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.add(1);
        array.add(2);
        Assert.assertEquals(2, array.size());
    }

    /**
     * Этот тест проверяет работу метода .isEmpty() при добавлении в список 2-х объектов.
     */
    @Test
    public void isEmptyTest() {
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.add(1);
        array.add(2);
        Assert.assertEquals(false, array.isEmpty());
    }

    /**
     * Этот тест проверяет работу метода .add(T item) при добавлении в список 3-х объектов.
     */
    @Test
    public void addTest() {
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.add(1);
        array.add(2);
        array.add(5);
        Assert.assertEquals(new Integer(5), array.get(2));
    }

    /**
     * Этот тест проверяет работу метода .addAll(T[] items) при добавлении в список массива из 3-х объектов.
     */
    @Test
    public void addAllFromArrayTest() {
        Integer[] array1 = new Integer[3];
        array1[0] = 5;
        array1[1] = 25;
        array1[2] = 50;
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.addAll(array1);
        Assert.assertEquals(3, array.size());
    }

    /**
     * Этот тест проверяет работу метода .addAll(Collection<T> items) при добавлении в список списка из 3-х объектов.
     */
    @Test
    public void addAllFromListTest() {
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(2);
        array1.add(5);
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.addAll(array1);
        Assert.assertEquals(new Integer(5), array.get(2));
    }

    /**
     * Этот тест проверяет работу метода .addAll(int index, T[] items) при добавлении в список массива из 3-х объектов на указанный
     * индекс.
     */
    @Test
    public void addAllWithIndexTest() {
        Integer[] array1 = new Integer[3];
        array1[0] = 600;
        array1[1] = 5000;
        array1[2] = 55;
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.addAll(3, array1);
        Assert.assertEquals(new Integer(55), array.get(5));
    }

    /**
     * Этот тест проверяет работу метода .addAll(int index, T[] items) при передаче в параметр метода в качестве
     * списка значения null.
     */
    @Test
    public void addAllWithIndexExTest() throws Exception {
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        try{
            array.addAll(3, null);
            throw new Exception("incorrect work");
        } catch (IllegalArgumentException e){}
    }

    /**
     * Этот unit-тест проверяет корректность метода .get(int index).
     */
    @Test
    public void getTest() {
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        Assert.assertEquals("HhHh", array.get(3));
    }

    /**
     * Этот unit-тест проверяет корректность метода .set(int index, T item).
     */
    @Test
    public void setTest() {
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        array.set(3, "Hi-hi");
        Assert.assertEquals("Hi-hi", array.get(3));
    }

    /**
     * Этот unit-тест проверяет корректность метода .set(int index, T item) если в качестве индекса указывается
     * несуществующий индекс.
     */
    @Test
    public void setWithExTest() throws Exception{
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        try{
            array.set(-3, "Hi-hi");
            throw new Exception("incorrect work");
        }catch (ArrayIndexOutOfBoundsException e){}

    }

    /**
     * Этот unit-тест проверяет корректность метода .remove(int index).
     */
    @Test
    public void removeTest() {
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        array.remove(3);
        Assert.assertEquals("HhHhH", array.get(3));
    }

    /**
     * Этот unit-тест проверяет корректность метода .remove(T item).
     */
    @Test
    public void removeWithItemTest() {
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        array.remove("Hh");
        Assert.assertEquals("HhH", array.get(1));
    }

    /**
     * Этот unit-тест проверяет корректность метода .contains(T item).
     */
    @Test
    public void containsTest() {
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        Assert.assertEquals(true, array.contains("HhHh"));
    }

    /**
     * Этот unit-тест проверяет корректность метода .indexOf(T item).
     */
    @Test
    public void indexOfTest() {
        CustomArrayImpl<String> array = new CustomArrayImpl();
        array.add("H");
        array.add("Hh");
        array.add("HhH");
        array.add("HhHh");
        array.add("HhHhH");
        Assert.assertEquals(-1, array.indexOf("Hh8Hh"));
    }

    /**
     * Этот тест проверяет работу метода .ensureCapacity(int newElementsCount).
     */
    @Test
    public void ensureCapacityTest(){
        CustomArrayImpl<Integer> array = new CustomArrayImpl(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        Assert.assertEquals(10, array.getCapacity());
    }

    /**
     * Этот unit-тест проверяет корректность метода getCapacity() при дефолтном размере списка.
     */
    @Test
    public void getCapacityTest1() {
        CustomArrayImpl<Integer> array = new CustomArrayImpl();
        Assert.assertEquals(10, array.getCapacity());
    }



    /**
     * Этот unit-тест проверяет корректность метода getCapacity() при заданном размере списка.
     */
    @Test
    public void getCapacityTest2() {
        CustomArrayImpl<Integer> array = new CustomArrayImpl(1);
        Assert.assertEquals(1, array.getCapacity());
    }

    /**
     * Этот unit-тест проверяет корректность метода getCapacity() при размере списка, равном отправленному
     * в конструктор списку.
     */
    @Test
    public void getCapacityTest3() {
        ArrayList<Integer> firstArray = new ArrayList();
        firstArray.add(1);
        firstArray.add(10);
        firstArray.add(100);
        firstArray.add(1000);
        CustomArrayImpl array = new CustomArrayImpl(firstArray);
        Assert.assertEquals(10, array.getCapacity());
    }

    /**
     * Этот тест проверяет работу метода .reverse().
     */
    @Test
    public void reverseTest(){
        CustomArrayImpl<Integer> array = new CustomArrayImpl(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.reverse();
        Assert.assertEquals(" 5 4 3 2 1 ", array.toString());
    }

    /**
     * Этот тест проверяет работу метода .toString().
     */
    @Test
    public void toStringTest(){
        CustomArrayImpl<Integer> array = new CustomArrayImpl(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        Assert.assertEquals(" 1 2 3 4 5 ", array.toString());
    }

    /**
     * Этот тест проверяет работу метода .toArray().
     */
    @Test
    public void toArrayTest(){
        CustomArrayImpl<Integer> array = new CustomArrayImpl(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        Object[] array1 = {1, 2, 3, 4, 5};
        Assert.assertEquals(array1, array.toArray());
    }

}