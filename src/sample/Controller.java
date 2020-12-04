package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller {

    @FXML
    TextArea textFelt2;

    public void visNoget() {
        // System.out.println("Knap er klikket.");
        textFelt2.appendText("HUrra! Det virker!\n");

    }
    public void papier() {
        textFelt2.appendText("Papier\n");
    }
    public void saks() {
        textFelt2.appendText("Saks\n");
    }
    public void sten() {
        textFelt2.appendText("Sten\n");
    }
    public void gemData() {
        textFelt2.appendText("Data blev Gemt!\n");
        try { saveFile();
        }
        catch (IOException e){
            createFile();
        }

    }

        public void createFile(){

            try {
                File myObj = new File("filename.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    public void saveFile() throws IOException
    {
        Path fileName = Path.of("filename.txt");
        String content  = textFelt2.getText();
        Files.writeString(fileName, content);

        String actual = Files.readString(fileName);
        System.out.println(actual);
    }
    }
