package Words;

import java.io.*;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {
    public void Play()
    {
        String words;
        Scanner sc  = new Scanner(System.in);
        while(true) {
            System.out.print("Nhập từ cần tìm kiếm :  ");
            words = sc.nextLine();
            if (words.equalsIgnoreCase("_exit")) {
                return;
            } else {
                if (words.indexOf("_push") == 0) {
                    insertWords();
                } else {
                    if (words.indexOf("_delete") == 0) {
                        deleteWords();
                    } else {
                        dictionarySearcher(words);
                    }
                }
            }
        }
    }



    public void Start()
    {
        insertFromFile();// nạp từ điển
        System.out.println("Muốn thoát hãy nhập   : "+ "_exit" );
        System.out.println("Muốn thêm từ hãy nhập : "+ "_pust");
        System.out.println("Muốn xóa từ hãy nhập  : "+ "_delete");

    }
    public void Exit() {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("E:\\Java\\DictionaryCMD\\src\\Words\\dictionaries.txt");
            FileWriter fw = new FileWriter(f);

            for (int i =0 ; i<ListWord.size(); i++)
            {
             fw.write(ListWord.get(i).getTA()+"\r\n"+ListWord.get(i).getTV()+"\r\n") ;
            }


            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }
    public void  insertFromFile()
    {
        try {

            File f = new File("E:\\Java\\DictionaryCMD\\src\\Words\\dictionaries.txt");
            FileReader fr = new FileReader(f);


            BufferedReader br = new BufferedReader(fr);
            String line;
            String lina;
            while ((line = br.readLine()) != null & (lina = br.readLine())!=null ){
                Words t = new Words(line, lina);
                ListWord.add(t);
            }

            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Loi doc file: "+ex);
        }
    }
}
