//package com.telegramBot.bank.BankService;
//import java.time.*;
//import java.util.concurrent.*;
//
//public class Timer {
//    public static void methodForTest() {
//
//        String string = "Привіт";
//
//        System.out.println(string);
//    }
//
//    public static void main(String[] args) {
//
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//
//        // Поточний час
//        LocalTime currentTime = LocalTime.now();
//
//        // Час до наступного запуску (21:00)
//        long initialDelay = LocalTime.of(18, 35).toNanoOfDay() - currentTime.toNanoOfDay();
//
//        if (initialDelay < 0) {
//            // Якщо поточний час вже пройшов 21:00, додаємо 1 день до initialDelay
//            initialDelay += TimeUnit.DAYS.toNanos(1);
//        }
//
//        // Період повтору в 24 години
//        long period = TimeUnit.DAYS.toNanos(1);
//
//        // Запуск задачі в заданий час з періодичністю в 24 години
//        executor.scheduleAtFixedRate(Timer::methodForTest, initialDelay, period, TimeUnit.NANOSECONDS);
//
//    }
//}
//
