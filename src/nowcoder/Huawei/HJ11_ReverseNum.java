package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ11_ReverseNum {
    public static void main(String[] args){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine();
            for(int i = 0; i<str.length(); i++){
                System.out.print(str.charAt(str.length()-i-1));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
