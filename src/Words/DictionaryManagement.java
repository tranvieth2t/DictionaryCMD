package Words;

import jdk.nashorn.internal.ir.LiteralNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    // hàm tìm kiếm

    public void dictionarySearcher(String t )
    {
       int left =0;
       int right = ListWord.size();
       int mid;
       while(true)
       {
            if (right < left)
            {
                System.out.println("Xin lỗi, từ của bạn không có trong từ điển!");
                return;
            }
            mid = (left+ right)/2;
            if(ListWord.get(mid).getTA().indexOf(t)==0)
            {
                break;
            }
            else
            {
                if (ListWord.get(mid).getTA().compareToIgnoreCase(t)< 0)
                {
                    left = mid+1;
                }
                else
                {
                    if (ListWord.get(mid).getTA().compareToIgnoreCase(t)>0 )
                    {
                        right = mid-1;
                    }
                }
            }

       }
       left = mid;
       right = mid;
       // tim kiem tat ca nhung tu cung gia tri voi mid
       while(left >= 0)
       {
           if (ListWord.get(left).getTA().indexOf(t) == 0) left--;
           else break;

       }
       while (right <ListWord.size())
       {
           if(ListWord.get(right).getTA().indexOf(t)== 0) right++;
            else break;
       }
       for (mid= left+1; mid <right; mid++)
       {
           System.out.println(ListWord.get(mid));
       }



    }

    // hàm show ra hết tất cả
    public void ShowAllListWord()
    {
        System.out.println("No|\t|Englist\t\t|VietNamese");
        for (int i= 0; i< ListWord.size(); i++)
        {
            System.out.print(i+"|");
            System.out.println(ListWord.get(i).toString());
        }
    }
    // thêm từ mới
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
        for(int i =0; i< ListWord.size(); i++)
        {
            if(t.getTA().compareToIgnoreCase(ListWord.get(i).getTA()) < 0)
            {
                ListWord.add(i,t);
                System.out.println("Từ mới đã được thêm !");
                break;
            }
        }

    }



    public void deleteWords()
    {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Mời nhập từ Tiếng Anh cần xóa: ");
        String word1;
        word1 = sc.nextLine();

        /// thuât toán tìm kiếm.
        int left =0;
        int right = ListWord.size();
        int mid;
        while(true)
        {
            if (right < left)
            {
                System.out.println("Xin lỗi, từ bạn cần xóa không tồn tại!");
                return;
            }
            mid = (left+ right)/2;
            if (ListWord.get(mid).getTA().compareToIgnoreCase(word1)< 0)
                {
                    left = mid+1;
                }
                else
                {
                    if (ListWord.get(mid).getTA().compareToIgnoreCase(word1)>0 )
                    {
                        right = mid-1;
                    }
                    else
                    {
                        ListWord.remove(mid);
                        System.out.println("Đã xóa!");
                        break;
                    }
                }



        }
    }
}
