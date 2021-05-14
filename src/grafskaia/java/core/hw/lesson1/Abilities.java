package grafskaia.java.core.hw.lesson1;

public interface Abilities {

    void jump(double jumpHeight,  Courses course);

    void run(double runDistance, Courses course);

    double getMaxJump();

    double getMaxRun();

    String getName();
}
