package NumberOfPaper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
문제
N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다. 우리는 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

    input
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1

    output
10
12
11

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[][] array = new int[length][length];

        StringTokenizer st;
        for(int i = 0; i < length; i++){
            st = new StringTokenizer(br.readLine());
            int st_length = st.countTokens();
            for(int j = 0; j < st_length; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solution solution = new Solution();
        solution.solution(array, 0, 0, length);
        int[] result = solution.result;

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}

class Solution{

    int[] result = new int[3];

    public void solution(int[][] array, int row, int col, int length){
        if(checkArray(array, row, col, length)){
            result[array[row][col]+1] += 1;
        }
        else{
            int n = length/3;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    solution(array, row+n*i, col+n*j, n);
                }
            }
        }
    }

    boolean checkArray(int[][] a, int row, int col, int n){
        int check = a[row][col];
        for(int i = row; i < row+n; i++){
            for(int j = col; j < col+n; j++){
                if(check != a[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
