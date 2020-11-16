import java.io.*;

/**
 * Created by CCNE on 16/11/2020.
 */
public class Utils {
    public static String readContentFromFile(String path) {
        String str = "";
        String temp;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while ((temp = in.readLine()) != null) {
                str += temp + '\n';
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /*public static void writeContentToFile(String path) {
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(path));
            String data="123";
            out.write(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    public static void writeContentToFile(String path) {
        String old = readContentFromFile(path);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            String data = "456";
            out.write(old + data);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File file = new File(folderPath);
        File[] list = file.listFiles();
        if (list != null) {
            for (File f : list) {
                if (f.isDirectory()) {
                    findFileByName(f.getAbsolutePath(), fileName);
                } else if (f.getName().equalsIgnoreCase(fileName)) {
                    return f.getAbsoluteFile();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //readContentFromFile("a.txt");
        writeContentToFile("a.txt");
        System.out.println(readContentFromFile("a.txt"));
        File f = findFileByName("C:\\Users\\CCNE\\IdeaProjects\\untitled", "a.txt");
        System.out.println(f.getAbsolutePath());
    }
}
