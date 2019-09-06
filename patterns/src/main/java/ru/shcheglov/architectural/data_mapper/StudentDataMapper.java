package ru.shcheglov.architectural.data_mapper;

import java.util.Optional;

public interface StudentDataMapper {

    void insert(Student student) throws DataMapperException;

    void update(Student student) throws DataMapperException;

    void delete(Student student) throws DataMapperException;

    Optional<Student> read(int id);
}
