package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ20_pswdVerify {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String pswd;
        Loop:while((pswd = bf.readLine())!=null){
            //密码长度小于8位，直接输出NG
            if(pswd.length()<=8){
                System.out.println("NG");
                continue;
            }
            //满足四种字符中的三种
            int charKinds = 0;
            if(pswd.matches(".*[0-9].*")){
                charKinds++;
            }
            if(pswd.matches(".*[a-z].*")){
                charKinds++;
            }
            if(pswd.matches(".*[A-Z].*")){
                charKinds++;
            }
            if(pswd.matches(".*[^0-9a-zA-Z].*")){
                charKinds++;
            }
            if(charKinds<3){
                System.out.println("NG");
                continue;
            }
            //不能有相同长度大于2的子串重复(只需要考虑是否有长度为3的子串重复就好)
            for(int i = 0; i<pswd.length()-6; i++){
                if(pswd.substring(i+3,pswd.length()).contains(pswd.substring(i,i+3))){
                    System.out.println("NG");
                    continue Loop;
                }
            }
            System.out.println("OK");
        }
    }
}
