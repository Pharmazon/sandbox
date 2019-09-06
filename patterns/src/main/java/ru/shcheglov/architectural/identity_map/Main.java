package ru.shcheglov.architectural.identity_map;

import ru.shcheglov.architectural.data_mapper.Student;

public class Main {

    public static void main(String[] args) {
        Student student = new Student(1, "Ivan");
        Student selected = StudentDatabase.finder(student.getId());
        System.out.println(selected);
    }

}
