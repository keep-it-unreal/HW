package ru.sbrf.edu;

import java.util.Collection;

public class CustomArrayImpl <T> implements CustomArray<T> {
    private int head;
    private T[] array;

    CustomArrayImpl(){
        array = (T[])new Object[10];
    }
    CustomArrayImpl(int capacity){
        array = (T[])new Object[capacity];
    }
    CustomArrayImpl(Collection<T> c){
        this();
        addAll(c);
    }

    public int size(){
        return head;
    }

    public boolean isEmpty(){
        if(head == 0){
            return true;
        } else{
            return false;
        }
    }

    public boolean add(T item){
        if(head == array.length) {
            ensureCapacity(array.length * 2);
        }
        array[head] = item;
        ++head;
        return true;
        }

    public boolean addAll(T[] items){
        if(items == null){
            throw new IllegalArgumentException("parameter items is null");
        }

        if(head + items.length > array.length){
            ensureCapacity((head + items.length) * 2);
        }
        for (T e: items) {
            array[head] = e;
            ++head;
        }
        return true;
    }

    public boolean addAll(Collection<T> items){
        if(items == null){
            throw new IllegalArgumentException("parameter items is null");
        }

        if(head + items.size() > array.length){
            ensureCapacity((head + items.size()) * 2);
        }
        for (T e: items) {
            array[head] = e;
            ++head;
        }
        return true;
    }

    public boolean addAll(int index, T[] items){
        if(items == null){
            throw new IllegalArgumentException("parameter items is null");
        }
        if(index > head || index < 0){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        if(head - index < items.length){
            ensureCapacity((head + items.length) * 2);
        }

        if(head < index + items.length){
            head = index + items.length;
        }
        for (T e: items) {
            array[index] = e;
            ++index;
        }
        return true;
    }

    public T get(int index){
        if(index > head || index < 0){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        return array[index];
    }

    public T set(int index, T item){
        if(index > head || index < 0){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }
        T oldItem = array[index];
        array[index] = item;
        return oldItem;
    }

    public void remove(int index){
        if(index > head || index < 0){
            throw new ArrayIndexOutOfBoundsException("index is out of bounds");
        }

        while(head > index){
            array[index] = array[index + 1];
            ++index;
        }
        array[index] = null;
        head = --index;
    }

    public boolean remove(T item){
        for(int index = 0; index < array.length; ++ index) {
            if(array[index].equals(item)){
                this.remove(index);
                return true;
            }
        }
        throw new RuntimeException("item not found");
    }

    public boolean contains(T item){
        for(int index = 0; index < head; ++ index) {
            if (array[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T item){
        for(int index = 0; index < head; ++ index) {
            if (array[index].equals(item)) {
                return index;
            }
        }
        return -1;
    }

    public void ensureCapacity(int newElementsCount) {
        T[] newArray = (T[]) new Object[newElementsCount];
        for (int i = 0; i < array.length; ++i) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getCapacity(){
        return array.length;
    }

    public void reverse(){
        if(head > 0){
            T firstItem;
            for(int i = 0; i < head / 2; ++i){
                firstItem = array[i];
                array[i] = array[head - 1 - i];
                array[head - 1 - i] = firstItem;
            }
        }
    }

    public String toString(){
        if (head == 0){
            return "[ ]";
        }
        String arrayStr = " ";
        for(int i = 0; i < head; ++i){
            arrayStr += array[i] + " ";
        }
        return arrayStr;
    }

    public Object[] toArray(){
        Object[] newArray = new Object[head];
        for(int i = 0; i < head; ++i){
            newArray[i] = array[i];
        }
        return newArray;
    }

}
