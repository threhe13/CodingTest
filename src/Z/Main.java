package Z;


/*
input
2 3 1
output
11

input
3 7 7
output
63
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int size = 1;

        for(int i = 0; i < count; i++){
            size *= 2;
        }
        //System.out.println(size); //4

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        Solution solution = new Solution(row, col);

        solution.solution(0, 0, size);
    }
}

class Solution{

    int count = 0;
    int r; int c;

    public Solution(int row, int col){
        this.r = row;
        this.c = col;
    }

    public void solution(int row, int col, int size) {
        if (size == 1) {
            if (row == r && col == c) {
                System.out.println(count);
            }
            count++;
            return;
        }
        else {
            int length = size / 2;

            solution(row, col, length);
            solution(row, col+length, length);
            solution(row+length, col, length);
            solution(row+length, col+length, length);
        }
    }
}

