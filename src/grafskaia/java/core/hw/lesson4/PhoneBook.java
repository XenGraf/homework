package grafskaia.java.core.hw.lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        Set<String> phones = new HashSet<>();
        if (this.phoneBook.containsKey(name)) {
            phones = this.phoneBook.get(name);
            phones.add(phone);
            this.phoneBook.put(name, phones);
        } else {
            phones.add(phone);
            this.phoneBook.put(name, phones);
        }
    }

    public void get(String name) {
        if (this.phoneBook.containsKey(name)) {
            System.out.println("Телефоны для фамилии " + name + " : " + this.phoneBook.get(name));
        } else {
            System.out.println("Фамилии " + name + " нет в телефоном справочнике");
        }
    }

}
