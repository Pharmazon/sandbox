package ru.shcheglov.architectural.data_mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDataMapperImpl implements StudentDataMapper {

    private List<Student> students = new ArrayList<>();

    @Override
    public void insert(Student student) {
        if (!this.getStudents().contains(student)) {
            this.getStudents().add(student);
        } else {
            throw new DataMapperException("Student already [" + student + "] exists");
        }
    }

    @Override
    public void update(Student student) {
        if (this.getStudents().contains(student)) {
            final int index = this.getStudents().indexOf(student);
            this.getStudents().set(index, student);
        } else {
            throw new DataMapperException("Student [" + student + "] is not found");
        }
    }

    @Override
    public void delete(Student student) {
        if (this.getStudents().contains(student)) {
            this.getStudents().remove(student);
        } else {
            throw new DataMapperException("Student [" + student + "] is not found");
        }
    }

    @Override
    public Optional<Student> read(int id) {
        for (final Student student : students) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    private List<Student> getStudents() {
        return students;
    }
}
