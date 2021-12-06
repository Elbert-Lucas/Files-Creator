import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateNewFile {
    public static File createFile (String directory, String fileName){
        Path newFile = Paths.get(directory +"/"+fileName+".txt");

        try {
            Files.createFile(newFile);
            System.out.println(newFile.toAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"ERRO!");
            System.out.println(newFile.toAbsolutePath());
        }
        return newFile.toFile();
    }
    public static void writeFile (String text, File file){

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))){
            outputStream.write(text.getBytes(StandardCharsets.UTF_8));

        }catch (IOException e) {
            e.printStackTrace();

        }


    }
}
