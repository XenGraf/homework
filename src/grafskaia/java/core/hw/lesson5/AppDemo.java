package grafskaia.java.core.hw.lesson5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AppDemo {
    public static void main(String[] args) {
        String[] header1 = {"Value 1","Value 2","Value 3"};
        String[] header2 = {"Value 1","Value 2","Value 3","Value 4"};
        int[][] data1 = new int[][] {{123,243,300},{132,233,367}};
        int[][] data2 = new int[][] {{304,253,34,4543},{104,153,245,334},{30,1534,23,354}};

        AppData data_1 = new AppData(header1,data1);
        AppData data_2 = new AppData(header2,data2);
        makeCSV(data_1,"data1.csv");
        makeCSV(data_2,"data2.csv");
        AppData data_3 = new AppData();
        readCSV("data1.csv", data_3);
        data_3.info();

    }

    public static void makeCSV(AppData appData, String fileName) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
            String header_data = "";
            for (String value: appData.getHeader() ) {
                header_data += value+";";
            }
            out.write(header_data.substring(0,header_data.length()-1)+"\n");
            for (int[] datum : appData.getData()) {
                String d = "";
                for ( int element:datum ) {
                    d += Integer.toString(element) + ";";
                }
                out.write(d.substring(0,d.length()-1)+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCSV(String fileName, AppData appData) {

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            String[] line = in.readLine().split(";");
            appData.setHeader(line);
            int len_header= line.length;
            int[][] data = new int[lines.size()-1][len_header];
            for (int i = 0; i < lines.size()-1; i++) {
                String[] value = in.readLine().split(";");
                for (int j = 0; j < value.length; j++) {
                    data[i][j] = Integer.parseInt(value[j]);
                }
            }
            appData.setData(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
