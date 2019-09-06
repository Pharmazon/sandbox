package ru.shcheglov.architectural.identity_map;

import ru.shcheglov.architectural.data_mapper.Student;

import java.util.HashMap;
import java.util.Map;

public class IdentityMap {

    private static Map<Integer, Student> students = new HashMap<>();

    static void add(Student student) {
        students.put(student.getId(), student);
    }

    static Student get(Integer key) {
        return students.get(key);
    }
}
