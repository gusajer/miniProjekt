package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;

public class Controller {

    @FXML
    TextArea textFelt2;
    String[] SSP = {"Sten", "Saks", "Papir"};

    public void visNoget() {
        // System.out.println("Knap er klikket.");
        textFelt2.appendText("HUrra! Det virker!\n");

    }

    public void papier() {
        textFelt2.appendText("Papir\n");
        compere("Papir");
    }

    public void saks() {
        textFelt2.appendText("Saks\n");
        compere("Saks");
    }

    public void sten() {
        textFelt2.appendText("Sten\n");
        compere("Sten");
    }

    public void clearData() {
        textFelt2.clear();
    }

    public void gemData() {
        textFelt2.appendText("Data blev Gemt!\n");
        try {
            saveFile();
        } catch (IOException e) {
            createFile();
        }

    }

    public void createFile() {

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

    public void saveFile() throws IOException {
        Path fileName = Path.of("filename.txt");
        String content = textFelt2.getText();
        Files.writeString(fileName, content);

        String actual = Files.readString(fileName);
        System.out.println(actual);
    }

    public void compere(String valg) {
        String PCVALG = SSP[(int)(Math.random() * 3)];
        textFelt2.appendText("PC: " + PCVALG +"\n");

            if (valg.equals("Sten") & PCVALG.equals("Saks")) {
                textFelt2.appendText("you win\n");
            } else if (valg.equals("Saks") & PCVALG.equals("Papir")) {
                textFelt2.appendText("You win\n");
            } else if (valg.equals("Papir") & PCVALG.equals("Sten")) {
                textFelt2.appendText("You win\n");
            } else if (valg.equals("Sten") & PCVALG.equals("Papir")) {
                textFelt2.appendText("You lose\n");
            } else if (valg.equals("Papir") & PCVALG.equals("Saks")) {
                textFelt2.appendText("You lose\n");
            } else if (valg.equals("Saks") & PCVALG.equals("Sten")) {
                textFelt2.appendText("You lose\n");
            } else if(valg.equals(PCVALG)) {
                textFelt2.appendText("TIE\n");
            }
        }
    }
