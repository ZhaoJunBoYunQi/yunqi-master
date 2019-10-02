package com.yunqi.array;



/**
 * @author: yunqi
 * @createdTime: 2019-10-02
 * 描述
 */
public class Array<E> {
    private E[] data;
    private int size;
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array() {
        this(10);
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addFirst(E e) {
        add(0, e);
    }
    public void addLast(E e) {
      /*  if (size == data.length) {
            throw new IllegalArgumentException("failed");
        }
        //data[size++] = e 和下面的语义相同
        data[size] = e;
        size++;*/
      add(size, e);
    }
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed");
        return data[index];
    }

    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("add failed");
        }
        if (index < 0 || index > size)
            throw new IllegalArgumentException("array failed");
        //把数组从index位置往后后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    public E remove(int index) {
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return ret;
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }

}