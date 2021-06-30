package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class HJ8_mergeTableRecords {
    public static void main(String[] agrs){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try{
            while((str = bf.readLine())!=null){
                int num = Integer.valueOf(str);
                Map<Integer, Integer> map = new TreeMap<>();
                String str2;
                while(num-- != 0){
                    if((str2 = bf.readLine())!=null){
                        String[] str3 = str2.split(" ");
                        if(map.containsKey(Integer.valueOf(str3[0]))){
                            map.put(Integer.valueOf(str3[0]), map.get(Integer.valueOf(str3[0]))+Integer.valueOf(str3[1]));
                        }else{
                            map.put(Integer.valueOf(str3[0]), Integer.valueOf(str3[1]));
                        }
                    }
                }
                for(int key:map.keySet()){
                    System.out.println(key+" "+map.get(key));
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
