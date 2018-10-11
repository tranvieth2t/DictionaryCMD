package Main;

import Words.Dictionary;
import Words.DictionaryCommandLine;


public class Main {
    public static void  main(String[] args )
    {
        DictionaryCommandLine Dictionary = new DictionaryCommandLine();
        Dictionary.Start();
        Dictionary.Play();
        Dictionary.Exit();
        return;
    }

}
