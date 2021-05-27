package grafskaia.java.core.hw.lesson5;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {
        super();
    }
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void info() {
        System.out.println("Header:");
        for (String line: this.header) {
            System.out.print(line + ';');
        }
        System.out.print('\n');
        System.out.println("Values: ");
        for (int[] data: this.data) {
            for (int element: data) {
                System.out.print(Integer.toString(element)+' ');
            }
            System.out.print('\n');
        }
    }
}
