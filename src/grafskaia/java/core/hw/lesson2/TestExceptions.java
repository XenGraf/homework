package grafskaia.java.core.hw.lesson2;

public class TestExceptions {

    public static void main(String[] args) {
        String[][] arr = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        try {
            int result = acceptArray(arr);
            System.out.println("The total sum of array is " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Problem with array dimensions.");
        } catch (MyArrayDataException e1) {
            System.out.println("Wrong symbol in array's cell with indexes " + e1.i + " and "+ e1.j);
        }
    }

    public static int acceptArray (String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int a = 0;

        if (array.length != 4) {
            throw new MyArraySizeException("columns");
        }

        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("rows");
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    a = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                } finally {
                    sum = sum + a;
                }
            }
        }

        return sum;

    }
}
