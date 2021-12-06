import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateNewDirectory{
    public static void createDirectory(String path, String directory){
        Path newDirectory = Paths.get(path+"//"+directory);
        try {
            Files.createDirectory(newDirectory);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO");
        }
    }
}
