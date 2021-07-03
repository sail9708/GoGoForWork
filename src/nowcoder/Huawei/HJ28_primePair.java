package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * https://www.nowcoder.com/practice/b9eae162e02f4f928eac37d7699b352e?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1
 * 本题重点：匈牙利算法
 */

public class HJ28_primePair {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = bf.readLine())!=null){
            //输入的自然数的个数
            int num = Integer.valueOf(input);
            //读取输入的自然数数据
            String[] strData = bf.readLine().split(" ");
            //转存为int类型
            int[] intData = new int[strData.length];
            for(int i = 0; i < strData.length; i++){
                intData[i] = Integer.parseInt(strData[i]);
            }
            //偶数和偶数相加；奇数与奇数相加 必不可能 和为素数
            //所以将其中的偶数和奇数分类
            List<Integer> evenNumber = new ArrayList<>();
            List<Integer> oddNumber = new ArrayList<>();
            for(int i = 0; i < intData.length; i++){
                if(intData[i]%2==0){
                    evenNumber.add(intData[i]);
                }else{
                    oddNumber.add(intData[i]);
                }
            }
            //尝试使用动态规划，失败
            //使用匈牙利算法，进行二部图最大匹配
            //邻接矩阵，true表是i j相连
            int[] matching = new int[evenNumber.size()]; // 记录匹配了偶数的奇数
            int count = 0;
            for (int i = 0; i < oddNumber.size(); i++) {
                int[] bematched = new int[evenNumber.size()]; // 记录偶数是否被匹配了，0没匹配，1匹配了
                if (match(evenNumber, oddNumber.get(i), matching, bematched)) {
                    count++;
                }
            }
            System.out.println(count);

        }
    }

    static boolean match(List<Integer> evens, int odd, int[] matching, int[] bematched){
        for (int i = 0; i < evens.size(); i++) {
            //遍历偶数组，与当前奇数相加是否是素数，即能否匹配成功，同时该偶数还没有被匹配过
            if(sumIsPrimeNum(evens.get(i), odd) && bematched[i] == 0){
                // 能匹配成功，那这个偶数就要记录下被匹配了
                bematched[i] = 1;
                // 当这个奇数还没有匹配过偶数，这是第一次，那就把这个奇数也记录下来，与当前偶数配对
                // 或者这个奇数已经匹配过偶数了，但是还能找到新的偶数和他匹配，那就去找新的偶数，记录在新偶数的名下吧
                if(matching[i] == 0 || match(evens, matching[i], matching, bematched)){
                    matching[i] = odd;
                    return true;
                }
            }
        }
        return false;
    }


    //判断和是否为素数
    static boolean sumIsPrimeNum(int a, int b){
        int sum = a+b;
        for(int i = 2; i <= Math.sqrt(sum); i++){
            if(sum%i == 0){
                return false;
            }
        }
        return true;
    }
}
