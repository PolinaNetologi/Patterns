package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator { // утилитный класс
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")); //shift is a static method of the ArrayUtils class that shifts the elements in an array in the clockwise or anti-clockwise direction by an offset.
    }

    public static String generateCity(String locale) {// статичные методы принадлежат 1 классу, нет смысла с ними прописывать доп.экз.классов
        var cities = new String[] {"Москва", "Ставрополь", "Тверь", "Владивосток"};// задаем массив самостоятельно
        return cities [new Random().nextInt(cities.length)]; //возвращает в рандомном порядке любой город из заданного массива/ Этот метод возвращает случайное целое число
    }

    public static String generateName(String locale) { // Класс Java java.util.Locale позволяет учесть особенности региональных представлений алфавита, символов, чисел и дат.
        var faker = new Faker (new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker (new Locale (locale));

        return faker.phoneNumber().phoneNumber(); // именно phoneNumber из faker
    }


    public static class Registration { // класс
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo (generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
