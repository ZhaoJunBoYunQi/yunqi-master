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
    public int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("索引为0， 其没有父节点");
        return (index - 1)/2;
    }
    public int leftChild(int index) {
        return 2 * index + 1;
    }
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1 );
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    public E getMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("array is empty");
        return data.get(0);
    }
    //取出堆中的最大元素
    public E extractMax() {
        E res = getMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int i = leftChild(k);
            int j = i+ 1;
            if (j < data.getSize() && data.get(j).compareTo(data.get(i)) <0) {
                //data[j - 1]是leftChild 和 rightChild的最大值
                i = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(i)) >= 0)
                break;;
            data.swap(i, k);
            k = j;
        }

    }


}
