package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ9_ExtractNonRepeatingIntegers {
    /**
     * 使用hashset 12ms
     * 使用String.indexof或者String.lastIndexOf 7ms
     * @param args
     */
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try{
            while((str = bf.readLine())!=null){
                char[] a = str.toCharArray();
//                 Set<Integer> set = new LinkedHashSet<>();
                String str2 = "";
                for(int i = 0; i < a.length; i++){
//                     if(!set.contains(a[a.length-i-1])){
//                         set.add(a[a.length-i-1]-48);
//                     }
                    if(str2.lastIndexOf(a[a.length-i-1])!=-1){
                        continue;
                    }
                    str2+=a[a.length-i-1];
                }
                System.out.print(str2);
//                 for(int i:set){
//                     System.out.print(i);
//                 }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
