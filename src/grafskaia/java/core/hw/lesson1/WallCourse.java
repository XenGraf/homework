package grafskaia.java.core.hw.lesson1;

public class WallCourse extends Courses {
    public double wallHeight;

    WallCourse(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public double getMax() {
        return wallHeight;
    }

    public void overcomeCourse(double wallHeight, double wall, Abilities participant) {
        if (wall >= wallHeight) {
            System.out.printf("The wall is overcome! ");
        } else {
            System.out.printf("The insuperable height! ");
        }
    }

    @Override
    public String toString() {
        return "jump";
    }

}
