import by.company.testtask.main.TextEditor;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TextEditorTest {

    @Test
    public void replaceLetters() throws IOException {

        FileInputStream inFile = new FileInputStream("src/test/replaceLettersTest.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);

        TextEditor instance = new TextEditor();
        String answer = instance.replaceLetters(text).toString();

        boolean ok = answer.equals("u");
        assertTrue("Failed", ok);

    }

    @Test
    public void removeDouble() throws IOException {
        FileInputStream inFile = new FileInputStream("src/test/removeDoubleTest.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String[] text = new String(str).split(" ");

        TextEditor instance = new TextEditor();
        String [] answer = instance.removeDouble(text);

        boolean ok = answer.equals("c");
        assertTrue("Failed", ok);

    }
    @Test
    public void removeE () throws IOException {
        FileInputStream inFile = new FileInputStream("src/test/removeETest.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String[] text = new String(str).split(" ");

        TextEditor instance = new TextEditor();
        String answer = instance.removeE(text).toString();

        boolean ok = answer.equals("th");
        assertTrue("Failed", ok);

    }

    @Test
    public void removeArticles() throws IOException{
        FileInputStream inFile = new FileInputStream("src/test/removeETest.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String[] text = new String(str).split(" ");

        TextEditor instance = new TextEditor();
        String answer = instance.removeArticles(text).toString();

        boolean ok = answer.equals("word");
        assertTrue("Failed", ok);
    }

}