package grafskaia.java.core.hw.lesson1;

public class Cat implements Abilities {

    public String name;
    public double maxJumpHeight;
    public double maxRunDistance;

    Cat() {};

    Cat(String name, double maxJumpHeight, double maxRunDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    public String getName() {
        return name;
    }

    public double getMaxJump() {
        return maxJumpHeight;
    }

    public double getMaxRun() {
        return maxRunDistance;
    }

    @Override
    public void jump(double jumpHeight, Courses course) {
        System.out.println("Cat " + name + " leaped over " + course.getMax() + " m.");
    }

    @Override
    public void run(double runDistance, Courses course) {
        System.out.println("Cat " + name + " ran "  + course.getMax() + " km.");
    }
}
