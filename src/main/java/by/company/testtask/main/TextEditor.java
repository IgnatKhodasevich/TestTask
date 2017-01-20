package by.company.testtask.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class TextEditor {

    public String getText (File file) throws IOException{

        FileInputStream inFile = new FileInputStream(file);
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        String text = new String(str);


        try {
            inFile.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return text;
    }

    public String[] replaceLetters(String text){
        String[] words = text.split(" ", text.length());

        for (int i = 0; i < words.length; i++){
            words[i] = words[i].replace("ci", "si");
            words[i] = words[i].replace("ce", "se");
            words[i] = words[i].replace("ck", "k");
            words[i] = words[i].replace("c", "k");
            words[i] = words[i].replace("ee", "i");
            words[i] = words[i].replace("oo", "u");
        }

        return words;
    }

    public String[] removeDouble (String[] words){



        for (int i = 0; i < words.length; i++){

            String doubleLetter = " ";
            String replacement = " ";

            for (int j = 1; j < words[i].length() - 1; j++){
                if (words[i].charAt(j) == words[i].charAt(j + 1) | words[i].charAt(j) == words[i].charAt(j - 1)){

                    replacement = String.valueOf(words[i].charAt(j));
                    doubleLetter = String.valueOf(replacement + replacement);
                    words[i] = words[i].replace(doubleLetter, replacement);

                }
            }

        }

        return words;
    }

    public String[] removeE(String[] words){

        for (int i = 0; i < words.length; i++) {

            if (words[i].endsWith("e") & words[i].length() > 1){
                int index = words[i].length() - 1;
                words[i] = words[i].replaceAll(String.valueOf(words[i].charAt(index)), "");
            }

        }
        return words;
    }

    public LinkedList<String> removeArticles (String[] words){

        LinkedList<String> list = new LinkedList<String>(Arrays.asList(words));

        Iterator iter = list.iterator();

        while(iter.hasNext()) {
            String tmp = (String) iter.next();

            if (tmp.equalsIgnoreCase("a") || tmp.equalsIgnoreCase("an") || tmp.equalsIgnoreCase("th")){
                iter.remove();
            }

        }

        return list;
    }

    public static String concat (LinkedList<String> stringList) {

        Iterator iterator = stringList.iterator();

        StringBuilder newString = new StringBuilder();

        while (iterator.hasNext()){

            newString = newString.append(iterator.next());
            newString = newString.append(" ");

        }

        return newString.toString();
    }


    public static void main(String[] args) throws IOException{

        TextEditor instance = new TextEditor();
        File file = new File("src/main/resources/file.txt");
        String words = instance.getText(file);

        String[] firstStep = instance.replaceLetters(words);
        String[] secondStep = instance.removeDouble(firstStep);
        String[] thirdStep = instance.removeE(secondStep);
        LinkedList fourthStep = instance.removeArticles(thirdStep);


        FileWriter writer = new FileWriter("src/output.txt");
        writer.write(concat(fourthStep));
        writer.flush();

    }

}
