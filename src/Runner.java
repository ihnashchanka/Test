import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Tatsiana on 25.11.2016.
 */
public class Runner {
    private static ArrayList<Declaration> list = new ArrayList<Declaration>();

    public static void main(String[] args) {
        try {
            getData();
            writeThird();
            writeFirst();
            writeSecond();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bytes.in"));
        while (br.ready()) {
            String buffer = br.readLine();
            list.add(new Declaration(buffer));
        }
    }

    private static void sortByName() {
        Collections.sort(list, (d1, d2) -> d1.getName().compareTo(d2.getName()));
    }

    private static void sortByType() {
        Collections.sort(list, (d1, d2) -> d1.typeSize() - d2.typeSize());
    }

    private static void writeFirst() {
        try {
            sortByName();
            FileWriter fw = new FileWriter("bytes1.out");
            for (Declaration item : list) {
                fw.write(item.getName() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeSecond() {
        try {
            sortByType();
            FileWriter fw = new FileWriter("bytes2.out");
            for (Declaration item : list) {
                fw.write(item.getName() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeThird() {
        try {
            FileWriter fw = new FileWriter("bytes3.out");
            for (Declaration item : list) {
                fw.write(item.getSize() + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

