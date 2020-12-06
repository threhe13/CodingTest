package MiddleCharater;

/*
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
 */

public class Main {
    public static void main(String[] args){
        String input1 = "abcde";
        String input2 = "qwer";

        Solution s = new Solution();
        String result1 = s.solution(input1);
        String result2 = s.solution(input2);
        System.out.println(result1 +" "+ result2);
    }
}

class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        if(length%2 == 0){
            for(int i = length/2-1; i <= length/2; i++){
                sb.append(s.charAt(i));
            }
            answer = sb.toString();
        }
        else{
            sb.append(s.charAt(length/2));
            answer = sb.toString();
        }

        return answer;
    }
}