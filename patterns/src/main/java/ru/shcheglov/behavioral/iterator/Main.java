package ru.shcheglov.behavioral.iterator;

public class Main {

    public static void main(String[] args) {
        Integer[] integers = new Integer[3];
        integers[0] = 1;
        integers[1] = 2;
        integers[2] = 3;

        SimpleIterator<Integer> s = new SimpleIterator<>(integers);
        while (s.hasNext()) {
            Integer i = s.next();
            System.out.println(i);
        }
    }
}


