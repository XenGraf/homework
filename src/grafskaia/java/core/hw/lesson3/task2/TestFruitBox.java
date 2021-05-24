package grafskaia.java.core.hw.lesson3.task2;

public class TestFruitBox {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Apple> box1 = new Box<Apple>(apple1);
        Box<Orange> box2 = new Box<Orange>(orange1);
        box1.addFruit(apple1);
        box1.addFruit(apple2);
        box1.addFruit(apple3);
        box1.addFruit(apple4);
        box1.addFruit(apple4);
        System.out.println("Вес коробки с яблоками равен "+box1.getWeight()+" у.е.");
        box2.addFruit(orange2);
        System.out.println("Вес коробки с апельсинами равен " + box2.getWeight()+" у.е.");
        System.out.println("Сравнение массы коробок: " + box1.compare(box2));
        Box<Orange> box3 = new Box<Orange>(orange1);
        box3.addFruit(orange2);
        System.out.println("Вес новой коробки с апельсинами равен " + box3.getWeight()+" у.е.");
        System.out.println("Пересыпем апельсины в новую коробку");
        box1.addFruitsFromAnotherBox(box3);
        box2.addFruitsFromAnotherBox(box3);
        System.out.println("Вес старой коробки с апельсинами равен " + box2.getWeight()+" у.е.");
        System.out.println("Вес новой коробки с апельсинами равен " + box3.getWeight()+" у.е.");
    }

}
