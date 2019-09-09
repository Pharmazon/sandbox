package ru.shcheglov.structural.adapter_wrapper;

public class TimeAdapter implements TotalTime {

    private Time time;

    public TimeAdapter(Time time) {
        this.time = time;
    }

    public int getTotalSeconds() {
        return time.getHours() * 60 * 60 + time.getMinutes() * 60 + time.getSeconds();
    }
}