package com.yunqi.heap;

import com.yunqi.array.Array;

/**
 * @author: yunqi
 * @createdTime: 2019-10-03
 * 描述
 */
public class MaxHeap<E extends Comparable> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }
    public MaxHeap() {
        this.data = new Array<>();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public int getParent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("索引为0， 其没有父节点");
        return (index - 1)/2;
    }
    public int getLeftChild(int index) {
        return 2 * index + 1;
    }
    public int getRightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1 );
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(getParent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, getParent(k));
            k = getParent(k);
        }
    }
}
