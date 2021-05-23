package grafskaia.java.core.hw.lesson4;

import grafskaia.java.core.hw.lesson3.task1.MakeArray;

import java.util.*;

public class TestArrays {

    public static void main(String[] args) {
        List<String> wordsArray = new ArrayList<>();
        wordsArray.add("Monday");
        wordsArray.add("Monday");
        wordsArray.add("Tuesday");
        wordsArray.add("Wednesday");
        wordsArray.add("Wednesday");
        wordsArray.add("Tuesday");
        wordsArray.add("Thursday");
        wordsArray.add("Friday");
        wordsArray.add("Monday");
        wordsArray.add("Tuesday");
        wordsArray.add("Saturday");
        wordsArray.add("Monday");
        wordsArray.add("Wednesday");
        wordsArray.add("Monday");
        wordsArray.add("Sunday");
        wordsArray.add("Saturday");
        System.out.println("Исходный список слов: " + wordsArray);
        Set<String> uniqueWords = new HashSet<>(wordsArray);
        System.out.println("Уникальные слова из списка: " + uniqueWords);
        System.out.println("Вхождение слов в список: " + countWords(wordsArray));
        System.out.println("Вхождение слова Wonday в список: " + countWord(countWords(wordsArray), "Monday"));
        System.out.println("Вхождение слова Hello в список: " + countWord(countWords(wordsArray), "Hello"));


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "78430670456");
        phoneBook.add("Ivanov", "784303456");
        phoneBook.add("Ivanova", "7567890456");
        phoneBook.add("Ivanova", "123470456");
        phoneBook.add("Ivanov", "2345670456");
        phoneBook.add("Sidorov", "777430456");
        phoneBook.add("Petrov", "89789070456");
        phoneBook.add("Sergeev", "3457670456");
        phoneBook.add("Petrova", "01928370456");
        phoneBook.get("Ivanov");
        phoneBook.get("Sidorova");
    }

    public static Map countWords(List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        Set<String> uWords = new HashSet<>(words);
        int s = 1;
        for (String word: words) {
            if (counts.containsKey(word)){
                s = counts.get(word) + 1;
                counts.put(word, s);
            } else {
                counts.put(word, s);
            }
        }
        return counts;
    }

    public static Integer countWord(Map<String, Integer> map, String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        } else {
            return 0;
        }
    }

}
