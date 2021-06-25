package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ6_PrimFactor {
    public static void main(String[] args) {
        HJ6_PrimFactor solution = new HJ6_PrimFactor();
        solution.primeFactor_BufferedReader();


    }

    //使用scanner    30ms
    public void primeFactor_Scanner(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLong()){
            Long num = in.nextLong();
            for(int i = 2; i<=Math.sqrt(num); i++){
                if(num % i == 0){
                    num/=i;
                    System.out.print(i+" ");
                    i--;
                }
            }
            System.out.print(num+" ");
        }
    }

    //使用bufferedReader    8ms
    public void primeFactor_BufferedReader(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Long num = Long.parseLong(in.readLine());
            for(int i = 2; i<=Math.sqrt(num); i++){
                if(num % i == 0){
                    num/=i;
                    System.out.print(i+" ");
                    i--;
                }
            }
            System.out.print(num+" ");
        }catch (Exception e){

        }

    }

}
