package sample;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sample.Annotations.Saver;
import sample.Annotations.SaveTo;
public class TextContainer {

    @SaveTo(path = "TestSave.txt")
    private String text = "";

    public TextContainer() {
    }

    public TextContainer(String text) {

        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }
    @Saver
    public void saveTo(String path){
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file) ){
            fileWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
