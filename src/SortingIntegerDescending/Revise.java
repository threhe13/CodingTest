package SortingIntegerDescending;

import java.util.ArrayList;
import java.util.Collections;

public class Revise {
    public static void main(String[] args){
        long input = 118372;
        Converter c = new Converter();

        long result = c.Converter(input);
        System.out.println(result);
    }

    static class Converter{
        public long Converter(long n){
            long answer = 0;
            String[] str = Long.toString(n).split("");

            ArrayList<Long> list = new ArrayList<>();
            for(int i = 0; i < str.length; i++){
                list.add(Long.parseLong(str[i]));
            }

            Collections.sort(list, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                sb.append(list.get(i));
            }
            answer = Long.parseLong(sb.toString());
            return answer;
        }

    }
}
