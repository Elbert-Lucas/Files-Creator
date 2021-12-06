import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    private JFormattedTextField fileTitle = createTitle();
    private JButton newFileButton = newFileButton();
    private JButton newDirectoryButton = newDirectoryButton();
    private JButton readFileButton = readFileButton();

    private JTextArea fileText = fileText();


    public JFrame createFrame() {
        JFrame frame = new JFrame("File Creator");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        Font font = new Font("Texto do Arquivo", Font.BOLD, 20);
        JLabel fileBody = new JLabel("Texto do arquivo: ");
        fileBody.setFont(font);
        fileBody.setBounds(315, 80, 300, 100);

        frame.add(newFileButton);
        frame.add(newDirectoryButton);
        frame.add(readFileButton);

        frame.add(fileTitle);
        frame.add(fileBody);
        frame.add(fileText);

        newFileListener();
        newDirectoryListener();
        readFileListener();
        frame.setVisible(true);


        return frame;
    }

    private static JButton newFileButton() {
        JButton newFile = new JButton("Criar Novo Arquivo");
        newFile.setBounds(100, 5, 180, 50);
        return newFile;
    }

    private static JButton newDirectoryButton() {
        JButton newdirectory = new JButton("Criar Novo diretorio");
        newdirectory.setBounds(300, 5, 180, 50);

        return newdirectory;
    }

    private static JButton readFileButton() {
        JButton readFile = new JButton("Ler Arquivo");
        readFile.setBounds(500, 5, 180, 50);

        return readFile;
    }

    private static JFormattedTextField createTitle() {
        String hintText = "Titulo do arquivo/Diretorio";
        JFormattedTextField titleBox = new JFormattedTextField();
        titleBox.setBounds(270, 65, 250, 50);
        titleBox.setText(hintText);

        titleBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (titleBox.getText().equals(hintText))
                    titleBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        String title = titleBox.getText();
        return titleBox;
    }

    private static JTextArea fileText() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setBounds(100, 140, 600, 400);
        return textArea;
    }


    private void newFileListener() {
        newFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);

                fileChooser.setDialogTitle("Escolha o diretorio");

                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                    String directory = fileChooser.getSelectedFile().getAbsolutePath();
                    CreateNewFile.writeFile(fileText.getText(), CreateNewFile.createFile(directory, fileTitle.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma Seleção");
                }
            }
        });
    }

    private void newDirectoryListener() {
        newDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);

                fileChooser.setDialogTitle("Escolha o diretorio");

                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    CreateNewDirectory.createDirectory(fileChooser.getSelectedFile().getAbsolutePath(), fileTitle.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma Seleção");
                }
            }
        });
    }

    private void readFileListener() {
        readFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecione o arquivo");
                fileChooser.showOpenDialog(null);

                fileText.setText(ReadFile.readFile(fileChooser.getSelectedFile().getAbsolutePath()));

            }
        });
    }
}
