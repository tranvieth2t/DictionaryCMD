package  Words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Dictionary
{
    ArrayList<Words> ListWord;
    public ArrayList<Words> getListWord() {
        return ListWord;
    }

    public void setListWord(ArrayList<Words> listWord) {
        ListWord = listWord;
    }


    public  Dictionary()
    {
        ListWord = new ArrayList<Words>();
    }



}