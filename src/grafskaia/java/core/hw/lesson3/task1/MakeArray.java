package grafskaia.java.core.hw.lesson3.task1;

public class MakeArray<T extends Object> {

    private T[] array;

    public MakeArray(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void getArrayPrint() {
        for (T element: array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void setArrayElement(int i, T newValue) {
        this.array[i] = newValue;
    }

    public int getArrayLength() {
        return array.length;
    }

}
