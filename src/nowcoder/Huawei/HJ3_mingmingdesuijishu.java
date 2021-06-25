package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HJ3_mingmingdesuijishu {

    //57ms
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int i = sc.nextInt();
            Set<Integer> set = new LinkedHashSet<Integer>();
            for(int j = 0; j < i; j++){
                int data = sc.nextInt();
                if(!set.contains(data)){
                    set.add(data);
                }
            }

            TreeSet<Integer> ts = new TreeSet(set);
            ts.comparator();
            for(int res:ts){
                System.out.println(res);
            }
        }
    }

    //8ms
    public void optimizedFunction() throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null)
        {

            boolean[] stu=new boolean[1001];
            StringBuilder sb=new StringBuilder();
            int n=Integer.parseInt(str);
            for(int i=0;i<n;i++) {
                stu[Integer.parseInt(bf.readLine())] = true;
            }
            for(int i=0;i<1001;i++) {
                if (stu[i]) {
                    sb.append(i).append("\n");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
