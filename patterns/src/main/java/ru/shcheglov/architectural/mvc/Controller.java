package ru.shcheglov.architectural.mvc;

import ru.shcheglov.architectural.data_mapper.Student;

class Controller {

    private Model model = new DBModel();

    private View view = new ConsoleView();

    void execute() {
        final Student student = model.getStudent();
        view.showStudent(student);
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void setModel(final Model model) {
        this.model = model;
    }

    public void setView(final View view) {
        this.view = view;
    }
}
