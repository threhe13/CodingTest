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

        int[][] array = new int[size][size];

        Solution solution = new Solution();
        solution.setArray(array, size);

        int result = solution.printArray(row-1, col-1);
        System.out.println(result);

    }
}

class Solution{

    int count = 0;
    int[][] array;

    public void setArray(int[][] array, int size){
        this.array = array;

        solution(0, 0, size);
    }

    public int printArray(int row, int col){
        return array[row][col];
    }


    public void solution(int row, int col, int size){
        if(size == 2){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    array[i][j] = count++;
                }
            }
        }
        else{
            int length = size/2;
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    solution(row+length*i, col+length*j, length);
                }
            }

        }
    }

}

