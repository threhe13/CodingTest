package TargetNumber;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = s.solution(numbers, target);
        System.out.println(result);
    }
}

class Solution {
    class calc{
        int number;
        int order;

        public calc(int number, int order){
            this.number = number;
            this.order = order;
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        int length = numbers.length-1;

        Queue<calc> que = new LinkedList<calc>();

        que.offer(new calc(numbers[0], 0));
        que.offer(new calc(-numbers[0], 0));

        while(!que.isEmpty()){
            calc calc = que.poll();

            if(calc.order != length) {
                int a = calc.number + numbers[calc.order + 1];
                int b = calc.number - numbers[calc.order + 1];

                que.offer(new calc(a, calc.order + 1));
                que.offer(new calc(b, calc.order + 1));
            }
            else{
                if(calc.number == target){
                    answer++;
                }
            }
        }


        return answer;
    }
}