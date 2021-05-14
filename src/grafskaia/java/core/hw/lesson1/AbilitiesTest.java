package grafskaia.java.core.hw.lesson1;

public class AbilitiesTest {

    public static void main(String[] args) {

        Abilities[] participants = {new Cat("Pushok",0.9, 0.3), new Human("Sportsman", 1.8, 10.2), new Robot("Droid", 3.0, 25.0)};
        Courses[] courses = {new RaceTrack(0.20), new WallCourse(0.5), new RaceTrack(1.0), new WallCourse(1.0),new RaceTrack(2.0), new WallCourse(2.0)};

        for (Abilities participant: participants) {
            for (int i = 0; i < courses.length; i++) {
                if (courses[i].toString().equals("run")) {
                    if (courses[i].getMax() <= participant.getMaxRun()) {
                    courses[i].overcomeCourse(courses[i].getMax(), participant.getMaxRun(), participant);
                    participant.run(participant.getMaxRun(), courses[0]);
                    } else {
                        System.out.println("The remain courses are too complicated for " + participant.getName());
                        break;}
                } else {
                    if (courses[i].getMax() <= participant.getMaxJump()) {
                        courses[i].overcomeCourse(courses[i].getMax(), participant.getMaxJump(), participant);
                        participant.jump(participant.getMaxRun(), courses[0]);
                    } else {
                        System.out.println("The remain courses are too complicated for " + participant.getName());
                        break;}
                }
            }
        }
    }

}
