package com.javarush.task.pro.task13.task1326;

import java.util.*;

public class MyQueue extends AbstractQueue<String> {

    private final List<String> values = new ArrayList<>();

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = values.listIterator();
        return it;
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean offer(String o) {
        return values.add(o);
    }

    @Override
    public String poll() {
        if (values.size() == 0) {
            return null;
        } else {
            String firstElement = values.get(0);
            values.remove(firstElement);
            return firstElement;
        }

    }

    @Override
    public String peek() {

        if (values.size() == 0) {
            return null;
        } else {
            return values.get(0);
        }
    }
}
