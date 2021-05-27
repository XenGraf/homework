package grafskaia.java.core.hw.lesson3.task2;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    ArrayList<F> fruitBox;
    float fruitCount = 0;
    public float fruitWeight;
    public String fruitType;

    public Box() {}

    public Box(F fruit) {
        ArrayList<F> f = new ArrayList<F>(1);
        f.add(fruit);
        this.fruitBox = f;
        this.fruitCount ++;
        this.fruitWeight = fruit.weight;
        this.fruitType = fruit.fruitType;
    }

    public void addFruit(F fruit) {
        fruitBox.add(fruit);
        this.fruitCount ++;
        this.fruitWeight = fruit.weight;
        this.fruitType = fruit.fruitType;
    }

    public float getWeight() {
        return fruitBox.size()*fruitWeight;
    }

    public boolean compare(Box<?> newBox) {
        return Math.abs(this.getWeight() - newBox.getWeight()) < 0.00001;
    }

    public void addFruitsFromAnotherBox(Box<?> obj2) {
        if (obj2.fruitType == this.fruitType) {
            ((Box<F>)obj2).fruitCount += this.fruitCount;
            ((Box<F>)obj2).fruitBox.addAll(this.fruitBox);
            this.fruitCount = 0;
            this.fruitBox.removeAll(this.fruitBox);

            System.out.println("Подходящие коробки, фрукты пересыпаны!");
        } else {
            System.out.println("Несовместимые коробки. Нельзя смешивать разные фрукты!");
        }
    }
}
