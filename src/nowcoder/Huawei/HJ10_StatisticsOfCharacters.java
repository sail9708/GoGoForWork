package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ10_StatisticsOfCharacters {
    public static void main(String[] args){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = in.readLine();
            int[] chars = new int[128];
            int count = 0;
            for(int i = 0; i<input.length();i++){
                if(chars[input.charAt(i)] == 0){
                    chars[input.charAt(i)]=1;
                    count++;
                }
            }
            System.out.print(count);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
