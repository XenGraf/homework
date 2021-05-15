package grafskaia.java.core.hw.lesson2;

public class MyArraySizeException extends Exception {

    MyArraySizeException(String a) {
        System.out.println("Wrong array dimensions!!! The size of " + a + " is wrong");
    }

}
