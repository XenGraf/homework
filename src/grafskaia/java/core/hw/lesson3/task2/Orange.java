package grafskaia.java.core.hw.lesson3.task2;

public class Orange extends Fruit {
    public float weight;
    public String fruitType;

    public Orange() {
        super.weight = 2.5f;
        super.fruitType = "Orange";
    }

    public float getFWeight() {
        return super.weight;
    }
}
