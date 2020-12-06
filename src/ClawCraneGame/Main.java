package ClawCraneGame;

import java.util.Stack;

public class Main {
    public static void main(String[] args){
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};

        Solution s = new Solution();
        int result = s.solution(board, moves);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for(int i = 0; i < moves.length; i++){
            int column = moves[i]-1;
            //System.out.println(column);
            int get = 0;

            for(int j = 0; j < board.length; j++){
                if(board[j][column] != 0){
                    get = board[j][column];
                    board[j][column] = 0;
                    break;
                }
            }

            if(get != 0){

                if(basket.isEmpty()){
                    basket.push(get);
                }
                else{
                    if(basket.peek() != get){
                        basket.push(get);
                    }
                    else{
                        basket.pop();
                        answer += 2;
                    }
                }
            }
            //System.out.println(basket);
        }

        return answer;
    }
}