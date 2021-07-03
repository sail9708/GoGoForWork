package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.nowcoder.com/practice/d3d8e23870584782b3dd48f26cb39c8f?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 */

public class HJ30_strMergeProcess {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine()) != null) {
            String[] arr = str.split(" ");
            str = arr[0] + arr[1];
            char[] array = sort(str);
//             System.out.println(String.valueOf(array));
            System.out.println(transform(array));
        }
    }

    public static char[] sort(String s) {
        char[] array = s.toCharArray();
        int i,j;
        for(i=2;i<array.length;i+=2) {
            if(array[i] < array[i-2]) {
                char tmp = array[i];
                for(j=i;j>0 && array[j-2] > tmp;j-=2) {
                    array[j] = array[j-2];
                }
                array[j] = tmp;
            }
        }
//         System.out.println(String.valueOf(array));
        for(i=3;i<array.length;i+=2) {
            if(array[i] < array[i-2]) {
                char tmp = array[i];
                for(j=i;j>1 && array[j-2]>tmp;j-=2) {
                    array[j] = array[j-2];
                }
                array[j] = tmp;
            }
        }
        return array;
    }

    public static String transform(char[] array) {
        for(int i=0;i<array.length;i++) {
            int num = -1;
            if(array[i] >= 'A' && array[i] <= 'F') {
                num = array[i]-'A'+10;
            } else if(array[i] >= 'a' && array[i] <= 'f') {
                num = array[i]-'a'+10;
            } else if(array[i] >= '0' && array[i] <= '9') {
                num = array[i]-'0';
            }
//             System.out.println("num 0000 = " + num);
            if(num != -1) {
                num =(num&1)*8 + (num&2)*2 + (num&4)/2 + (num&8)/8;
//                 System.out.println("num 1111 = " + num);
                if(num<10) {
                    array[i] = (char)(num + '0');
                }else if(num<16) {
                    array[i] = (char)(num-10+'A');
                }
            }
        }
        return new String(array);
    }
}
