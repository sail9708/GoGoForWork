package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ13_ReverseSentence {

    //本题同leetcode 151题，但是输入的情况比lc的少，lc比本题对输入的要求更松

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            char[] strArr = str.toCharArray();
            recerseString(strArr,0,strArr.length - 1);
            reverseWord(strArr);
            System.out.println(new String(strArr));
        }
    }
    private static void recerseString (char[] str, int start, int end){
        int i = start;
        int j = end;
        while(i < j){
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
            i++;
            j--;
        }
    }
    private static void reverseWord(char[] str){
        int i = 0;
        int j = 0;
        while(j < str.length){
            while( j < str.length && str[j] != ' '){
                j++;
            }
            if(j != 0){
                recerseString(str, i, j - 1);
            }
            while(j < str.length && str[j] == ' '){
                j++;
            }
            i = j;
        }

    }
}
