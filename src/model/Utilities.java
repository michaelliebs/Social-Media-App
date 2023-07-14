package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedList;

public class Utilities {

    public static HashSet<String> dictionary;

    public static void backupDataCenter() {
        try {
            FileOutputStream fos = new FileOutputStream("dataFolder/DataCenter.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(DataCenter.getInstance());
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataCenter restoreDataCenter() {
        try {
            FileInputStream fis = new FileInputStream("dataFolder/DataCenter.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            DataCenter data = (DataCenter) ois.readObject();
            ois.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashSet<String> dictionary() {
        dictionary = new HashSet<String>(99181); // second prime number above 99171 (first was 99173)
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/words/dictionary.txt"));
            String word = "";
            while (word != null) {
                word = reader.readLine();
                dictionary.add(word);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public static boolean spellCheck(String txt) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dictionary().toString()));
            String word;
            while ((word = br.readLine()) != null) {
                dictionary.add(word);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = txt.split("\\s+");
        LinkedList<String> misspelledWords = new LinkedList<String>();
        for (String w : words) {
            if (!dictionary.contains(w)) {
                misspelledWords.add(w);
            }
            return true;
        }

        return false;
    }

}