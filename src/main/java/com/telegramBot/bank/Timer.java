package com.telegramBot.bank;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class Timer {
    public static void methodForTest() {
//        Clock clock = Clock.systemUTC();
//        LocalDate date = LocalDate.now(clock);
//        LocalDateTime time = LocalDateTime.now(clock);
//        OffsetDateTime offsetTime = OffsetDateTime.now(clock);
//        //time.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));

        //LocalTime currentTime = LocalTime.now();
        String string = "Привіт";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//        String time = dtf.format(currentTime);
        System.out.println(string);
    }
//    public static String getInfo() {
//
//        //      Фіксує час входу (Вставити в команду телеграму)
//
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//        LocalTime localTime = LocalTime.now();
//        String time = dtf.format(localTime);
//
//
//            if (time.equals("12:42")) {
//                return "Hello world";
//            }
//            return time;
//        }
public static void main(String[] args) {

//    Timer timer = new Timer();
//
//    // Поточний час і дата
//    Calendar currentDate = Calendar.getInstance();
//
//    // Перший запуск (21:00)
//    Calendar scheduledTime = Calendar.getInstance();
//
//    scheduledTime.set(Calendar.HOUR_OF_DAY, 21);
//    scheduledTime.set(Calendar.MINUTE, 0);
//    scheduledTime.set(Calendar.SECOND, 0);
//
//    // Перехід на іншу дату якщо минуло 21:00
//    if (currentDate.after(scheduledTime)) {
//        scheduledTime.add(Calendar.DATE, 1);
//    }
//
//    // Вычисляем разницу между текущим временем и запланированным временем
//    long initialDelay = scheduledTime.getTimeInMillis() - currentDate.getTimeInMillis();
//
//    // Період повтору розсилки
//
//    long period = 24 * 60 * 60 * 1000;
//
//    // Запуск задачі з періодом повтору
//    timer.schedule(new TimerTask() {
//
//        @Override
//        public void run() {
//            // Виконання методу в 21:00
//            methodForTest();
//        }
//    }, initialDelay, period);
//}
//
//    private void schedule(TimerTask timerTask, long initialDelay, long period) {
//    }
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    // Поточний час
    LocalTime currentTime = LocalTime.now();

    // Час до наступного запуску (21:00)
    long initialDelay = LocalTime.of(21, 27).toNanoOfDay() - currentTime.toNanoOfDay();

    if (initialDelay < 0) {
        // Якщо поточний час вже пройшов 21:00, додаємо 1 день до initialDelay
        initialDelay += TimeUnit.DAYS.toNanos(1);
    }

    // Період повтору в 24 години
    long period = TimeUnit.DAYS.toNanos(1);

    // Запуск задачі в заданий час з періодичністю в 24 години

    executor.scheduleAtFixedRate(Timer::methodForTest, initialDelay, period, TimeUnit.NANOSECONDS);
    //executor.scheduleAtFixedRate(methodForTest(), initialDelay, period, TimeUnit.NANOSECONDS);
}
    }


