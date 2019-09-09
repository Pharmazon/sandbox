package ru.shcheglov.structural.adapter_wrapper;

public class TotalTimeAdapter implements Time {

    private TotalTime totalTime;

    public TotalTimeAdapter(TotalTime totalTime) {
        this.totalTime = totalTime;
    }

    public int getSeconds() {
        return totalTime.getTotalSeconds() % 60; //секунды
    }

    public int getMinutes() {
        return totalTime.getTotalSeconds() / 60; //минуты
    }

    public int getHours() {
        return totalTime.getTotalSeconds() / (60*60); //часы
    }
}
