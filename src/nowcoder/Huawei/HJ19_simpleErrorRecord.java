package nowcoder.Huawei;


import java.util.LinkedHashMap;
import java.util.Scanner;

public class HJ19_simpleErrorRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> record = new LinkedHashMap<>();

        while (sc.hasNextLine()){
            String errInfo = sc.nextLine();
//            String errInfo = "F:\\yay\\jc\\ywzqaop 631";
            String[] errInfo_split = errInfo.split("\\\\");
            String str = errInfo_split[errInfo_split.length-1];
            String[] str2 = str.split("\\s+");
            if (str2[0].length() > 16){
                str2[0] = str2[0].substring(str2[0].length()-16);
            }
            String str3 = str2[0]+" "+str2[1];

            if (record.containsKey(str3)){
                record.put(str3, record.get(str3)+1);
            }
            else {
                record.put(str3, 1);
            }
        }

        int count = 0;
        for (String file:record.keySet()){
            if (count++ >= record.size()-8){
                System.out.println(file+" "+record.get(file));
            }
        }


    }
}
