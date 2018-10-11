package Words;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {


    public void dictionarySearcher(String t )
    {
        int i= 0;
        boolean bool = false;
        while( i< ListWord.size())
        {
            if (ListWord.get(i).getTA().indexOf(t) ==0)
            {
                System.out.println(ListWord.get(i).toString());
                bool= true;
            }
            i++;
        }
        if (bool != true)
        {
            System.out.println("Xin lỗi, từ của bạn không có trong từ điển!");
        }
    }
    public void ShowAllListWord()
    {
        System.out.println("No|\t|Englist\t\t|VietNamese");
        for (int i= 0; i< ListWord.size(); i++)
        {
            System.out.print(i+"|");
            System.out.println(ListWord.get(i).toString());
        }
    }
    public void insertWords()
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Mời nhập từ Tiếng Anh cần thêm: ");
        String word1, word2;
        word1 = sc.nextLine();
        System.out.println("Mời nhập nghĩa Tiếng Việt: " );
        word2 = sc.nextLine();
        Words t = new Words(word1, word2);


        // đoạn này cần thuật toán tìm kiếm vị trí chèn.
        ListWord.add(t);
        System.out.println("Từ mới đã được thêm !");
    }
    public void deleteWords()
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Mời nhập từ Tiếng Anh cần xóa: ");
        String word1;
        word1 = sc.nextLine();

        boolean  t = true;
        /// thuât toán tìm kiếm.
        for(int i= 0; i< ListWord.size(); i++)
        {
            if (ListWord.get(i).getTA().equalsIgnoreCase(word1) == true )
            {
                ListWord.remove(i);
                t= false;
                break;
            }
        }
        if (t)
        {
            System.out.println("Xin lỗi, từ bạn cần xóa không tồn tại!");
        }
        else
        {
            System.out.println("Đã xóa!");
        }


    }


}
