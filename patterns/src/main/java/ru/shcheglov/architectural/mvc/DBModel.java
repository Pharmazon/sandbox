package ru.shcheglov.architectural.mvc;

import ru.shcheglov.architectural.data_mapper.Student;

public class DBModel implements Model {

    @Override
    public Student getStudent() {
        return new Student(1, "John Smith");
    }
}
