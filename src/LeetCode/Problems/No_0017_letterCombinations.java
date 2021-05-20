package LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;

public class No_0017_letterCombinations {

    /*****test case********/
    private static String digits = "23";
    /**********************/

    //final result
    List<String> result = new ArrayList<>();
    //建立数字字母映射表
    String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //建立临时
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        //考虑特殊情况，直接返回空
        if((digits == null) || (digits.equals("1")) || (digits.length() == 0)){
            return result;
        }

        huishu(digits,0);

        return result;

    }

    //回溯函数
    public void huishu(String digits, int time ){
        //如果time和数字的长度相等，则将字符串添加进结果列表
        if(time == digits.length()){
            result.add(temp.toString());
            return;
        }
        //获取当前轮次对应数字所对应的字符串
        String str = numString[digits.charAt(time)-'0'];
        //遍历添加
        for( int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            huishu(digits,time+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = new No_0017_letterCombinations().letterCombinations(digits);
        System.out.println(result);
    }
}
