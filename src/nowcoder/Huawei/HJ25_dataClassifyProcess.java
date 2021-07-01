package nowcoder.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class HJ25_dataClassifyProcess {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine())!=null){
            //处理I序列输入
            String[] input = str.split(" ");
            int numOfI = Integer.valueOf(input[0]);
            String[] I = new String[numOfI];
            for(int i = 0; i<numOfI; i++){
                I[i] = input[i+1];
            }
            //处理R序列的输入
            input = bf.readLine().split(" ");
            int numOfR = Integer.valueOf(input[0]);
            String[] R = new String[numOfR];
            for(int i = 0; i<numOfR; i++){
                R[i] = input[i+1];
            }
            //将R序列排序
//             Arrays.sort(R,new Comparator<String>(){
//                 @Override
//                 public int compare(String o1, String o2){
//                     if(Integer.valueOf(o1)>Integer.valueOf(o2)){
//                         return 1;
//                     }else
//                         if(Integer.valueOf(o1)<Integer.valueOf(o2)){
//                             return -1;
//                         }
//                     return 0;
//                 }
//             });
//             将R序列去重,并排序
            Set<String> set = new TreeSet<>(new Comparator<String>(){
                @Override
                public int compare(String o1, String o2){
                    if(Integer.valueOf(o1)>Integer.valueOf(o2)){
                        return 1;
                    }else
                    if(Integer.valueOf(o1)<Integer.valueOf(o2)){
                        return -1;
                    }
                    return 0;
                }
            });
            for(int i = 0; i< numOfR; i++){
                set.add(R[i]);
            }
            String[] newR = set.toArray(new String[set.size()]);

            //处理最后输出的结果
            StringBuilder res = new StringBuilder();
            int countAll = 0;

            for(int i = 0; i<newR.length; i++){
                StringBuilder temp = new StringBuilder();
                //判断R<i>是否被输出过
                boolean flag = false;
                //记录I匹配的个数
                int countI = 0;
                for(int j = 0; j<numOfI; j++){
                    if(I[j].matches(".*"+newR[i]+".*")){
                        if(!flag){
                            temp.append(" "+newR[i]);
                            flag = true;
                        }
                        temp.append(" "+j);
                        temp.append(" "+I[j]);
                        countI++;
                    }
                }
                if(countI>0){
                    temp.insert(newR[i].length()+1," "+countI);
                    countAll += countI*2+2;
                }

                res.append(temp);
            }
            res.insert(0,countAll);
            System.out.println(res.toString());
        }
    }
}
