package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ24_chorus {
    public static void main(String[] args) throws IOException {
        //本题思路：分别用动态规划得到，某一个位置，其左边最长的升序子序列和右边最长的降序子序列长度
        //        然后将二者相加，就可以得到，以改位置为中心，可以形成的最长合唱队长度，总人数减去最长长度，得到最少需要处列的人数
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String strNo;
        while((strNo = bf.readLine())!=null){
            int intNo = Integer.parseInt(strNo);
            //leftLen[i]表示第i个人，左边的最大升序子序列长度
            //rightLen[i]同理
            int[] leftLen = new int[intNo];
            int[] rightLen = new int[intNo];
            //高度表
            String[] strheight = bf.readLine().split(" ");
            int[] height = new int[intNo];
            for(int i = 0; i<intNo; i++){
                height[i] = Integer.valueOf(strheight[i]);
            }

            for(int i = 1; i<intNo; i++){
                for(int j = i-1; j>=0; j--){
                    if(height[i]>height[j]){
                        leftLen[i] = Math.max(leftLen[j]+1,leftLen[i]);
                    }
                }
            }

            for(int i = intNo-2; i>=0; i--){
                for(int j = i +1; j<intNo; j++){
                    if(height[i]>height[j]){
                        rightLen[i] = Math.max(rightLen[j]+1,rightLen[i]);
                    }
                }
            }
            int maxLen = 0;
            for(int i = 0; i < intNo; i++){
                //因为左右两边的子序列长度都没加上中间位置的人，所以总长度为左右长度相加再加一
                maxLen = Math.max(maxLen, leftLen[i]+rightLen[i]+1);
            }
            System.out.println(intNo-maxLen);
        }
    }
}
