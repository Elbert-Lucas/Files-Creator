import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadFile {
    public static String readFile(String path){
        File file = new File(path);
        StringBuilder text = new StringBuilder();

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()){
                text.append(scan.nextLine()).append("\n");
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
