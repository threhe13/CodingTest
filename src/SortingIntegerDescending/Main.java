package SortingIntegerDescending;

/*
문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        long input = 118372;
        //long input = 1000000;
        Solution s = new Solution();

        long result = s.solution(input);
        System.out.println(result);
    }
}

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();

        long temp = 1000000000;
        long remember = 0;

        while(n > 9){
            if(n >= temp){
                if(list.size() == 0){
                    remember = temp;
                }
                list.add(n/temp);
                //System.out.println(n/temp);
                n = n%temp;
                //System.out.println(n);
            }
            else{
                temp = temp/10;
            }
        }

        list.add(n);

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }

        answer = Long.parseLong(sb.toString());
        while(answer < remember){
            answer *= 10;
        }

        return answer;
    }

}
