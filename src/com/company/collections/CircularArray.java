package com.company.collections;

import java.util.Iterator;

/**
 * 循环数组
 * 只有定义了Iterable方法, 才能使用for each方式遍历数组
 * @param <T>
 */
public class CircularArray<T> implements Iterable<T> {

    private T[] items;
    private int head = 0;

    public CircularArray(int size) {

        // 我们不能新建一个泛类的数组，我们必须cast数组或者定义类型为List<T>.
        items = (T[]) new Object[size];
    }

    private int convert(int idx) {
        if (idx < 0) {
            idx += items.length;
        }
        return (head + idx) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    /**
     * 抛出运行时异常的方式可以更好地通知一些约定俗成的行为，需要养成这种习惯。
     * @param i
     * @return T object at index i in the abstract array
     */
    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new java.lang.IndexOutOfBoundsException("...");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public static void main(String[] args){
        CircularArray<Integer> circularIntegerList = new CircularArray<>(10);
        circularIntegerList.set(0, 10);
        circularIntegerList.get(20);
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator<T> (this);
    }

    /**
     *
     * @param <TI>
     */
    private class CircularArrayIterator<TI> implements Iterator<TI> {
        // iterator需要记忆当前的位置，初始值为-1。
        private int _current = -1;
        private TI[] _items;

        public CircularArrayIterator(CircularArray<TI> array) {
            // 内部iterator也要保存items
            _items = array.items;
        }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public TI next() {
            ++_current;
            TI item = (TI) _items[convert(_current)];
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("...");
        }
    }
}
