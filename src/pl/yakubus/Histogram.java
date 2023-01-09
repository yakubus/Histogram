package pl.yakubus;

import java.io.File;

import java.util.HashMap;
import java.util.Scanner;

public class Histogram {
    private String url;
    private int[] wordSize = new int[40];
    private int[] uniquwWordSize = new int[40];
    private int wordCounter = 0;
    private int uniqueWordCounter = 0;
    private int maxLenghtWord = 0;
    HashMap <String, Integer > individualWordsCounter = new HashMap<>();

   // private HashMap <String, Integer > individualWordsCounter = new HashMap<>();



    public Histogram(){
        //zerowanie tablicy założyłem, że w tekście nie ma słów dłuższych niż 40 znaków;
        for(int i = 0; i < 40; i++){
            this.wordSize[i]=0;
            this.uniquwWordSize[i]=0;
        }
    }

    //setter do ustawienia url pliku
    public void setUrl(String url) {
        this.url = url;
        AnalizeFile();
    }

    public int[] iloscSlow(int [] przedzialy){
        int[] result = new int[przedzialy.length+1];
        for(int r : result){
            r=0;
        }
        result[0]= this.wordCounter;
        for(int i = 0; i < przedzialy.length; i++) {
            for(int j=1; j<=przedzialy[i];j++) {
                result[i+1] += this.wordSize[j];
            }
        }
    return result;
    }

    public int[] iloscRoznychSlow(int [] przedzialy){
        int[] result = new int[przedzialy.length+1];
        for(int r : result){
            r=0;
        }
        result[0] = this.uniqueWordCounter;
        for(int i = 0; i < przedzialy.length; i++) {
            for(int j=1; j<=przedzialy[i];j++) {
                result[i+1] += this.uniquwWordSize[j];
            }
        }
        return result;
    }

    public int [] histogram(){
        int[] result = new int [this.maxLenghtWord+1];
        result[0] = this.wordCounter;
        for(int i = 1; i<= this.maxLenghtWord; i++){
            result[i]=this.wordSize[i];
        }
        return result;
    }
    public int [] histogramRozne(){
        int[] result = new int [this.maxLenghtWord+1];
        result[0] = this.uniqueWordCounter;
        for(int i = 1; i<= this.maxLenghtWord; i++){
            result[i]=this.uniquwWordSize[i];
        }
        return result;
    }




    // Analizowanie wczytanego pliku
    public void AnalizeFile()
    {
        File file = null;
        Scanner reader = null;
        HashMap <String, Integer > individualWordsCounter = new HashMap<>();
        try
        {
            // otwarcie pliku
            file = new File(this.url);
            reader = new Scanner(file);
            String word = null;

            word = reader.next();
            // jezeli brak slow w pliku, rzuc wyjatek
            if (word == null) {
                throw new Exception("Empty file!");
            }else {
                individualWordsCounter.put(word, 1);
                // wczytuj kolejne slowa z pliku
                while (reader.hasNext()) {
                    analizeSingleWord(word);
                    word = reader.next();
                }
                analizeSingleWord(word);
            }
        }
        catch (Exception e)
        {
            System.out.println("File error");
        }
        finally
        {
            // zamknięcie pliku
            reader.close();
        }

    }

    //Analizowanie pojedynczego słowa
    private void analizeSingleWord(String word) {

        this.maxLenghtWord =Math.max(this.maxLenghtWord, word.length());

        this.wordSize[word.length()] += 1;
        this.wordCounter++;
        if (this.individualWordsCounter.get(word) == null) {
            this.individualWordsCounter.put(word, 1);
            this.uniqueWordCounter++;
            this.uniquwWordSize[word.length()] += 1;

        } else {
            this.individualWordsCounter.replace(word, this.individualWordsCounter.get(word) + 1);
        }

    }

}
