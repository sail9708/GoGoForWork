package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584?tpId=37&&tqId=21249&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */

public class HJ26_strSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=bf.readLine())!=null){
            //获取所有的英文字母
            List<Character> letters = new ArrayList<>();
            for(char c:input.toCharArray()){
                if(Character.isLetter(c)){
                    letters.add(c);
                }
            }

            //给英文字母按规则1 2 排序
            letters.sort(new Comparator<Character>(){
                @Override
                public int compare(Character o1, Character o2){
                    return Character.toLowerCase(o1)-Character.toLowerCase(o2);
                }
            });

            StringBuilder sb = new StringBuilder();
            int j = 0;
            for(int i = 0; i < input.length(); i++){
                if(Character.isLetter(input.charAt(i))){
                    sb.append(letters.get(j++));
                }else{
                    sb.append(input.charAt(i));
                }
            }

            System.out.println(sb.toString());
        }
    }
}
