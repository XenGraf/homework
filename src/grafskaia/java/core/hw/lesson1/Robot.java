package grafskaia.java.core.hw.lesson1;

public class Robot implements Abilities {
    public String name;
    public double maxJumpHeight;
    public double maxRunDistance;

    Robot(){};

    public String getName() {
        return name;
    }

    public double getMaxJump() {
        return maxJumpHeight;
    }

    public double getMaxRun() {
        return maxRunDistance;
    }

    Robot(String name, double maxJumpHeight, double maxRunDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    public void jump(double jumpHeight, Courses course) {
        System.out.println("Robot " + name + " leaped over " + course.getMax() + " m.");
    }

    public void run(double runDistance, Courses course) {
        System.out.println("Robot " + name + " ran "  + course.getMax() + " km.");
    }
}
