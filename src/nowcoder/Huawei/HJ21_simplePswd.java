package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ21_simplePswd {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fPswd;
        fPswd = bf.readLine();
        char[] temp = fPswd.toCharArray();
        for(int i = 0; i<temp.length; i++){
            //A-Z
            if(temp[i]>='A' && temp[i]<='Z'){
                if(temp[i]!='Z'){
                    temp[i] = (char)(temp[i]+'a'-'A'+1);
                }else{
                    temp[i] = 'a';
                }
            }else
            if(temp[i]>='a' && temp[i]<='z'){
                if(temp[i]>='a'&&temp[i]<='c'){
                    temp[i] = '2';
                }else
                if(temp[i]>='d'&&temp[i]<='f'){
                    temp[i] = '3';
                }else
                if(temp[i]>='g'&&temp[i]<='i'){
                    temp[i] = '4';
                }else
                if(temp[i]>='j'&&temp[i]<='l'){
                    temp[i] = '5';
                }else
                if(temp[i]>='m'&&temp[i]<='o'){
                    temp[i] = '6';
                }else
                if(temp[i]>='p'&&temp[i]<='s'){
                    temp[i] = '7';
                }else
                if(temp[i]>='t'&&temp[i]<='v'){
                    temp[i] = '8';
                }else
                if(temp[i]>='w'&&temp[i]<='z'){
                    temp[i] = '9';
                }

            }
        }
        System.out.println(temp);

    }
}
