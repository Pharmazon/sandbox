package ru.shcheglov.architectural.data_mapper;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        final StudentDataMapper mapper = new StudentDataMapperImpl();

        Student student = new Student(1, "Vasya");
        mapper.insert(student);

        final Optional<Student> studentFound = mapper.read(student.getId());

        student.setName("Petya");
        mapper.update(student);

        mapper.delete(student);
    }

}
