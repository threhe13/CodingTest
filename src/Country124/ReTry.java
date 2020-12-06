package Country124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReTry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution s = new Solution();
        System.out.println("숫자를 입력해주세요.(종료하시려면 exit를 쳐주세요.)");
        while(true){
            String input = br.readLine();
            if(input.equals("exit")){
                System.out.println("시스템을 종료합니다.");
                break;
            }
            else{
                int temp = Integer.parseInt(input);
                String output = s.solution(temp);
                System.out.println(output);
            }
        }
    }
}

class Solution {
    public String solution(int n) {
        String answer = "";

        while(n > 0){
            int temp = n%3;
            n = n/3;

            if(temp == 0){
                answer = "4"+answer;
                n -= 1;
            }
            else{
                answer = temp + answer;
            }

        }
        return answer;
    }
}