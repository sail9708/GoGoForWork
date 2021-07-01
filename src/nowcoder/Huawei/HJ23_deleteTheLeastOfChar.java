package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class HJ23_deleteTheLeastOfChar {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine())!=null){
            char[] c = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            Map<Character,Integer> ts = new TreeMap<>();
            for(int i = 0; i< c.length; i++){
                if(ts.containsKey(c[i])){
                    ts.put(c[i], ts.get(c[i])+1);
                }else{
                    ts.put(c[i],1);
                }
            }
            int minTims = Integer.MAX_VALUE;
            for(char d:ts.keySet()){
                if(ts.get(d)<minTims){
                    minTims = ts.get(d);
                }else{
                    break;
                }
            }
            for(int i = 0; i<c.length;i++){
                if(ts.get(c[i]) > minTims){
                    sb.append(c[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
