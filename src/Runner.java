import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Tatsiana on 25.11.2016.
 */
public class Runner {
    private static ArrayList<Declaration> list = new ArrayList<Declaration>();

    public static void main(String[] args) {
        getData();
        writeThird();
        writeFirst();
        writeSecond();
    }

    private static void getData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("bytes.in"));
            while (br.ready()) {
                String buffer = br.readLine();
                list.add(new Declaration(buffer));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sortByName() {
        Collections.sort(list, new Comparator<Declaration>() {
            public int compare(Declaration d1, Declaration d2) {
                return d1.getName().compareTo(d2.getName());
            }
        });
    }

    public static void sortByType() {
        Collections.sort(list, new Comparator<Declaration>() {
            public int compare(Declaration d1, Declaration d2) {
                return d1.typeSize() - d2.typeSize();
            }
        });
    }

    public static void writeFirst() {
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

    public static void writeSecond() {
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

    public static void writeThird() {
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

