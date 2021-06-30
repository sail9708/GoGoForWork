package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ17_CoordinateMovement {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String orderLine;
        try{
            while((orderLine = bf.readLine())!=null){
                movement(orderLine);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }



    static void movement(String orderLine){
        String[] orders = orderLine.split(";");
        int[] coordinate = new int[2];
        int num = orders.length;
        for(int i = 0; i < num; i++){
            if(!isValid(orders[i])){
                continue;
            }
            if(orders[i].charAt(0)=='A'){
                coordinate[0]-=Integer.valueOf(orders[i].substring(1,orders[i].length()));
            }else
            if(orders[i].charAt(0)=='D'){
                coordinate[0]+=Integer.valueOf(orders[i].substring(1,orders[i].length()));
            }
            else
            if(orders[i].charAt(0)=='W'){
                coordinate[1]+=Integer.valueOf(orders[i].substring(1,orders[i].length()));
            }
            else
            if(orders[i].charAt(0)=='S'){
                coordinate[1]-=Integer.valueOf(orders[i].substring(1,orders[i].length()));
            }
        }
        System.out.println(coordinate[0]+","+coordinate[1]);
    }

    static boolean isValid(String order){
        if(order.length()>3 || order.length()<=1 || order.isEmpty()){
            return false;
        }
        if(order.charAt(0)!='A' && order.charAt(0)!='W' && order.charAt(0)!='S' && order.charAt(0)!='D'){
            return false;
        }
        if(order.length()==2){
            if(order.charAt(1) < '0' || order.charAt(1)>'9'){
                return false;
            }
        }
        if(order.length()==3){
            if(order.charAt(1) <= '0' || order.charAt(1)>'9'){
                return false;
            }
            if(order.charAt(2) < '0' || order.charAt(2)>'9'){
                return false;
            }
        }
        return true;
    }
}
