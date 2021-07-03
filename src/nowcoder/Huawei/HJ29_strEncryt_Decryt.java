package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.nowcoder.com/practice/2aa32b378a024755a3f251e75cbf233a?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 */

public class HJ29_strEncryt_Decryt {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int flag = 0; //判断读取的字符串是需要加密，还是解密。 0为加密，1为解密
        while((input=bf.readLine())!=null){
            if(flag == 0){
                System.out.println(encryption(input));
                flag = (flag+1)%2;
            }else{
                System.out.println(decryption(input));
                flag = (flag+1)%2;
            }
        }
    }

    //加密方法
    static String encryption(String str){
        char[] temp = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<temp.length; i++){
            if(temp[i]>='a' && temp[i]<='z'){
                if(temp[i]=='z'){
                    sb.append('A');
                    continue;
                }
                sb.append((char)(Character.toUpperCase(temp[i]+1)));
            }else
            if(temp[i]>='A' && temp[i]<='Z'){
                if(temp[i]=='Z'){
                    sb.append('a');
                    continue;
                }
                sb.append((char)(Character.toLowerCase(temp[i]+1)));
            }else
            if(temp[i]>='0' && temp[i]<='9'){
                if(temp[i] == '9'){
                    sb.append('0');
                    continue;
                }
                sb.append((char)(temp[i]+1));
            }else{
                sb.append((char)temp[i]);
            }
        }
        return sb.toString();
    }

    //解密方法
    static String decryption(String str){
        char[] temp = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<temp.length; i++){
            if(temp[i]>='a' && temp[i]<='z'){
                if(temp[i]=='a'){
                    sb.append('Z');
                    continue;
                }
                sb.append((char)(Character.toUpperCase(temp[i]-1)));
            }else
            if(temp[i]>='A' && temp[i]<='Z'){
                if(temp[i]=='A'){
                    sb.append('z');
                    continue;
                }
                sb.append((char)(Character.toLowerCase(temp[i]-1)));
            }else
            if(temp[i]>='0' && temp[i]<='9'){
                if(temp[i] == '0'){
                    sb.append('9');
                    continue;
                }
                sb.append((char)(temp[i]-1));
            }else{
                sb.append((char)temp[i]);
            }
        }
        return sb.toString();
    }
}
