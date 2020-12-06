package NormalQuadrangle;

public class Answer {
    public static void main(String[] args){
        Solution s = new Solution();
        int w = 8;
        int h = 12;
        long result = s.solution(w, h);
        System.out.println(result);
    }
}

class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        for(int i = 0; i < w; i++){
            answer += (Long.valueOf(h)*i)/(Long.valueOf(w));
        }

        return answer*2;
    }
}
