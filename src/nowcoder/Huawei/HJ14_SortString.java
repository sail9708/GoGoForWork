package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HJ14_SortString {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
            String strNum;
            while((strNum = bf.readLine())!=null){
                int num = Integer.valueOf(strNum);
                ArrayList<String> nstr = new ArrayList<>();
                while(num-- > 0){
                    nstr.add(bf.readLine());
                }
                //重写一个比较器，来进行排序
                Collections.sort(nstr,new Comparator<String>(){
                    @Override
                    public int compare(String o1, String o2){
                        for(int i = 0; i < o1.length() && i < o2.length(); i++){
                            if(o1.charAt(i)>o2.charAt(i)){
                                return 1;
                            }
                            else if(o1.charAt(i)<o2.charAt(i)){
                                return -1;
                            }
                        }
                        if(o1.length()>o2.length()){
                            return 1;
                        }
                        if(o1.length()<o2.length()){
                            return -1;
                        }
                        return 0;
                    }
                });

                for(String res:nstr){
                    System.out.println(res);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
