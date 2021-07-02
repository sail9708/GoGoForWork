package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 */

public class HJ27_findBrotherWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine())!=null){
            String[] input = str.split(" ");
            //单词的个数n
            int wordNum = Integer.valueOf(input[0]);
            //n个单词
            String[] words = new String[wordNum];
            for(int i = 0; i<wordNum; i++){
                words[i] = input[i+1];
            }
            //待查找单词
            String tgtWord = input[wordNum+1];
            //k
            int k = Integer.valueOf(input[wordNum+2]);

            //存储兄弟单词
            List<String> list = new ArrayList<>();
            //找到所有的兄弟单词
            char[] tgtWord_char = tgtWord.toCharArray();
            //给目标单词排序
            charArraySort(tgtWord_char);
            for(int i = 0; i<wordNum; i++){
                if(words[i].length() == tgtWord.length()){
                    if(!words[i].equals(tgtWord)){
                        char[] word_i = words[i].toCharArray();
                        charArraySort(word_i);
                        if(String.valueOf(word_i).equals(String.valueOf(tgtWord_char))){
                            list.add(words[i]);
                        }
                    }
                }
            }

            System.out.println(list.size());
            if(k>list.size()){
                break;
            }

            list.sort(new Comparator<String>(){
                @Override
                public int compare(String o1, String o2){
                    for(int i = 0; i<o1.length(); i++){
                        if(o1.charAt(i)-o2.charAt(i)!=0){
                            return  o1.charAt(i)-o2.charAt(i);
                        }
                    }
                    return 0;
                }
            });
            System.out.println(list.get(k-1));
        }
    }

    static void charArraySort(char[] tgtWord_char){
        for(int i = 0; i<tgtWord_char.length-1; i++){
            for(int j = i+1; j<tgtWord_char.length; j++){
                if(tgtWord_char[i]>tgtWord_char[j]){
                    char temp = tgtWord_char[i];
                    tgtWord_char[i] = tgtWord_char[j];
                    tgtWord_char[j] = temp;
                }
            }
        }
    }
}
