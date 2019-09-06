package ru.shcheglov.behavioral.iterator;

import java.util.Iterator;

public class SimpleIterator<T> implements Iterator<T> {

    private T[] objects;
    private int index = 0;

    SimpleIterator(T[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public T next() {
        return objects[index++];
    }
}
