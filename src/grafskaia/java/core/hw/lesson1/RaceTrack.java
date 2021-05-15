package grafskaia.java.core.hw.lesson1;

public class RaceTrack extends Courses {
    public double runDistance;

    RaceTrack(double runDistance) {
        this.runDistance = runDistance;
    }

    public double getMax() {
        return runDistance;
    }

    public void overcomeCourse(double runDistance, double run, Abilities participant) {
        if (run >= runDistance) {
            System.out.printf("The race track is overcome! ");
        } else {
            System.out.printf("The insuperable distance! ");
        }
    }

    @Override
    public String toString() {
        return "run";
    }
}
