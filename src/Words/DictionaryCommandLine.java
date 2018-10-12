package Words;

import java.io.*;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {
    public void Play()
    {
        String words;
        Scanner sc  = new Scanner(System.in);
        while(true) {
            System.out.println("Nhập từ cần tìm kiếm :  ");
            words = sc.nextLine();
            if (words.equalsIgnoreCase("_exit")) {
                return;
            } else {
                if (words.indexOf("_push") == 0) {
                    insertWords();
                } else {
                    if (words.indexOf("_delete") == 0) {
                        deleteWords();
                    }
                    else
                    {
                        if(words.indexOf("_showall")== 0)
                        {
                            ShowAllListWord();
                        }
                        else
                        {
                            dictionarySearcher(words);
                        }
                    }
                }
            }
        }
    }



    public void Start() {

        System.out.println("Muốn thoát hãy nhập   : " + "\t\t_exit");
        System.out.println("Muốn thêm từ hãy nhập : " + "\t\t_push");
        System.out.println("Muốn xóa từ hãy nhập  : " + "\t\t_delete");
        System.out.println("Muốn show toàn bộ hãy nhập : "+"\t_showall");
        insertFromFile();// nạp từ điển
    }
        public void Exit () {
            try {
                //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                File f = new File("E:\\Java\\DictionaryCMD\\src\\Words\\dictionaries.txt");
                FileWriter fw = new FileWriter(f);

                for (int i = 0; i < ListWord.size(); i++) {
                    fw.write(ListWord.get(i).getTA() + "\r\n" + ListWord.get(i).getTV() + "\r\n");
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


        // sắp xếp tăng dần
        for (int i = 0; i < ListWord.size() - 1; i++) {
            for (int j = i + 1; j < ListWord.size(); j++) {
                if (ListWord.get(i).getTA().compareTo(ListWord.get(j).getTA()) > 0) {
                    ListWord.get(i).swap(ListWord.get(j));
                }
            }
        }


        // xóa các phần tử trùng nhau.
        for (int i = 0; i < ListWord.size() - 1; i++) {
            for (int j = i + 1; j < ListWord.size(); j++) {
                if (ListWord.get(i).getTA().compareToIgnoreCase(ListWord.get(j).getTA()) == 0)
                {
                    ListWord.remove(i);
                    i--;
                }
            }
        }
    }

}
