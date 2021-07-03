package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.nowcoder.com/practice/3cd4621963e8454594f00199f4536bb1?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 */

public class HJ32_pswdInterception {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=bf.readLine())!=null){

            System.out.println(function2(input));
        }
    }

    //方法1：
    //进行两次遍历，从中间为两边发散
    //两次遍历分别考虑，回文子串长度是奇数 和 是偶数的情况
    public static int function1(String input){
        char[] strArr = input.toCharArray();
        //双指针法，从中间向两侧扩展
        int len = 1;
        //所有回文子串长度为偶数的情况
        for(int i = 0; i < strArr.length-1; i++){
            int temp = i;
            for(int j = i+1; j < strArr.length; j++){
                if(strArr[temp] == strArr[j]){
                    if(temp == 0 || j == strArr.length-1){
                        len = Math.max(len, j-temp+1);
                        break;
                    }
                    temp--;
                }else{
                    len = Math.max(len,j-temp-1);
                    break;
                }
            }
        }
        //所有回文子串长度为奇数的情况
        for(int i = 0; i<strArr.length; i++){
            for(int j = 1; j<=strArr.length/2; j++){
                if(i-j<0 || i+j>strArr.length-1){
                    len = Math.max(len, 2*j-1);
                    break;
                }
                if(strArr[i-j] != strArr[i+j]){
                    len = Math.max(len, 2*j-1);
                    break;
                }
            }
        }
        return len;
    }

    //方法2：
    //向字符串中间插入*号，这样就只需要考虑奇数长度子串就行
    //只需遍历一遍
    public static int function2(String input){
        //处理一下字符串数组，向字符之间插入*号
        char[] strArr = new char[input.length()*2-1];
        for(int i = 0; i<strArr.length; i++){
            //插入字符
            if(i%2==0){
                strArr[i] = input.charAt(i/2);
            }else{
                //插入*
                strArr[i] = '*';
            }
        }

        //这样就只需要考虑是奇数的情况就好
        int len = 1;
        for(int i = 0; i<strArr.length; i++){
            for(int j = 1; j<=strArr.length/2; j++){
                if(i-j<0 || i+j>strArr.length-1){
                    len = Math.max(len, j-1);
                    break;
                }
                if(strArr[i-j] != strArr[i+j]){
                    len = Math.max(len, j-1);
                    break;
                }
            }
        }
        return len;
    }
}
