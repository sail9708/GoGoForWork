package nowcoder.Huawei;

import java.util.*;

public class HJ18_classify_IP_mask {
    public static void main(String[] args){
        HJ18_classify_IP_mask main = new HJ18_classify_IP_mask();
        main.classify();
    }

    public void classify(){
        //接受输入
        Scanner sc = new Scanner(System.in);
        int[] res = new int[7];
        while(sc.hasNextLine()){
            String ipAndMask = sc.nextLine();
            if (ipAndMask.isEmpty()){
                break;
            }
            //将ip和mask提取出来
            String ip = ipAndMask.split("~")[0];
            String mask = ipAndMask.split("~")[1];

            if(!isValid_mask(mask)){
                res[5]++;
                continue;
            }
            if(!isValid_ip(ip)){
                res[5]++;
                continue;
            }
            String[] ip_split = ip.split("\\.");
            //类似于【0.*.*.*】和【127.*.*.*】的IP地址直接跳过
            if(ip_split[0].equals("0") ||ip_split[0].equals("127")){
                continue;
            }
            //A类
            if(Integer.valueOf(ip_split[0])>=1 && Integer.valueOf(ip_split[0])<=126){
                res[0]++;
            }
            //B类
            else if(Integer.valueOf(ip_split[0])>=128 && Integer.valueOf(ip_split[0])<=191){
                res[1]++;
            }
            //C类
            else if(Integer.valueOf(ip_split[0])>=192 && Integer.valueOf(ip_split[0])<=223){
                res[2]++;
            }
            //D类
            else if(Integer.valueOf(ip_split[0])>=224 && Integer.valueOf(ip_split[0])<=239){
                res[3]++;
            }
            //E类
            else if(Integer.valueOf(ip_split[0])>=240 && Integer.valueOf(ip_split[0])<=255){
                res[4]++;
            }
            //私网ip
            if(Integer.valueOf(ip_split[0]) == 10){
                res[6]++;
            }
            else if(Integer.valueOf(ip_split[0]) == 172){
                if(Integer.valueOf(ip_split[1])>=16 && Integer.valueOf(ip_split[1])<=31){
                    res[6]++;
                }
            }
            else if(Integer.valueOf(ip_split[0])==192 && Integer.valueOf(ip_split[1])==168){
                res[6]++;
            }
        }
        for (int i = 0; i<7;i++){
            if (i!=6) {
                System.out.print(res[i]+" ");
            }else {
                System.out.print(res[i]);
            }
        }
    }
    //判断IP是否合法
    public boolean isValid_ip(String ip){
        String[] str = ip.split("\\.");
        if(str.length!=4){
            return false;
        }
        for(int i = 0; i < 4; i++){
            if(str[i].isEmpty()){
                return false;
            }
            if(Integer.valueOf(str[i])>255 ||Integer.valueOf(str[i])<0){
                return false;
            }
        }
        return true;
    }

    //判断子网掩码是否合法
    public boolean isValid_mask(String mask){
        String[] str = mask.split("\\.");
        if(str.length!=4){
            return false;
        }
        for(int i = 0; i < 4; i++){
            if(str[i].isEmpty()){
                return false;
            }
        }
        ArrayList<String> exam = new ArrayList<>(Arrays.asList("255","254","252","248","240","224","192","128","0"));

        for(int i = 0; i<4;i++){
            if(exam.contains(str[i])){
                continue;
            }
            return false;
        }
        for(int i = 0; i<3;i++){
            if(!str[i].equals("255") && !str[i+1].equals("0")){
                return false;
            }
        }
        if(str[3].equals("255") || str[0].equals("0")){
            return false;
        }
        return true;
    }
}
