package ru.shcheglov.structural.adapter_wrapper;

public class Main {

    public static void main(String[] args) {
        TotalTime totalTime1 = new TotalTimeImpl() ; // программа получает объект, который реализует интерфейс TotalTime
        Time time1 = new TotalTimeAdapter(totalTime1);
        System.out.println(time1.getHours() + ":" + time1.getMinutes() + ":" + time1.getSeconds());

        Time time2 = new TimeImpl() ; // программа получает объект, который реализует интерфейс Time
        TotalTime totalTime2 = new TimeAdapter(time2);
        System.out.println(totalTime2.getTotalSeconds());
    }
}
