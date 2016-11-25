import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Tatsiana on 25.11.2016.
 */
public class Declaration {
    private String type;
    private String name;
    private ArrayList<Integer> sizes = new ArrayList<Integer>();

    public Declaration(String line) {
        line = line.replaceAll("\\[", " ");
        line = line.replaceAll("\\]", " ");
        line = line.replaceAll("\\;", " ");
        Scanner sc = new Scanner(line);
        if (sc.hasNext()) type = sc.next();
        if (sc.hasNext()) name = sc.next();
        while (sc.hasNextInt()) {
            sizes.add(sc.nextInt());
        }
    }

    @Override
    public String toString() {
        String result = type + " " + name + " ";
        for (int item : sizes) {
            result += item + " ";
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public int typeSize() {
        int size = 0;
        switch (type) {
            case "byte":
                size = 1;
                break;
            case "boolean":
                size = 1;
                break;
            case "char":
                size = 2;
                break;
            case "short":
                size = 2;
                break;
            case "int":
                size = 4;
                break;
            case "float":
                size = 4;
                break;
            case "double":
                size = 8;
                break;
            case "long":
                size = 8;
                break;

        }
        return size;
    }
    public int getSize() {
        int result = 0;
        int elementSize = this.typeSize();
        for(int i = sizes.size() - 1; i >=0; i-- ){
            result =  sizes.get(i) * elementSize + 24;
            elementSize = result;
        }
        return result;
    }
}