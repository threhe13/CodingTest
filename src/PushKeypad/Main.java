package PushKeypad;

//[카카오 인턴] 키패드 누르기

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        //int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        //int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        //String hand = "left";
        Solution s = new Solution();
        String result = s.solution(numbers, hand);
        System.out.println(result);
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 3); map.put("L", 3);//초기값
        HashMap<String, Integer> mid = new HashMap<>();
        mid.put("R", 2); mid.put("L", 0);
        for(int i = 0; i < numbers.length; i++){
            int temp = numbers[i];
            if(temp == 3 || temp == 6 || temp == 9){
                map.put("R", (temp/3)-1);
                mid.put("R", 2);
                answer += "R";
            }
            else if(temp%3 == 1){
                map.put("L", temp/3);
                mid.put("L", 0);
                answer += "L";
            }
            else{
                int count = temp/3;
                int location = 1;//세로축 값

                if(temp == 0){
                    count = 3;
                    int right = Math.abs(count-map.get("R")) + Math.abs(location-mid.get("R"));
                    int left = Math.abs(count-map.get("L")) + Math.abs(location-mid.get("L"));

                    if(right < left){
                        answer += "R";
                        map.put("R", count);
                        mid.put("R", 1);
                    }
                    else if(right > left){
                        answer += "L";
                        map.put("L", count);
                        mid.put("L", 1);
                    }
                    else{
                        if(hand.equals("right")){
                            answer += "R";
                            map.put("R", count);
                            mid.put("R", 1);
                        }
                        else{
                            answer += "L";
                            map.put("L", count);
                            mid.put("L", 1);
                        }
                    }
                }
                else {
                    int right = Math.abs(count - map.get("R")) + Math.abs(location-mid.get("R"));
                    int left = Math.abs(count - map.get("L")) + Math.abs(location-mid.get("L"));

                    if(right < left){
                        answer += "R";
                        map.put("R", count);
                        mid.put("R", 1);
                    }
                    else if(right > left){
                        answer += "L";
                        map.put("L", count);
                        mid.put("L", 1);
                    }
                    else{
                        if(hand.equals("right")){
                            answer += "R";
                            map.put("R", count);
                            mid.put("R", 1);
                        }
                        else{
                            answer += "L";
                            map.put("L", count);
                            mid.put("L", 1);
                        }
                    }
                }
            }
            System.out.println(map +" "+ answer);
        }

        return answer;
    }
}
