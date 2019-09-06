package ru.shcheglov.architectural.mvc;

import ru.shcheglov.architectural.data_mapper.Student;

public class ConsoleView implements View {

    @Override
    public void showStudent(final Student student) {
        System.out.println(student);
    }
}
