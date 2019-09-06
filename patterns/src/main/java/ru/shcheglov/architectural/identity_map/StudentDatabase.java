package ru.shcheglov.architectural.identity_map;

import ru.shcheglov.architectural.data_mapper.Student;

public class StudentDatabase {

    static Student finder(int key) {
        Student student = IdentityMap.get(key);
        if (student == null) {

            //SELECT STUDENT FROM DB
            Student selected = null; //SELECT * FROM students WHERE ID = key;
            IdentityMap.add(selected);
        }
        return student;
    }
}
