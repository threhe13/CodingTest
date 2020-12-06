package HeavenPassenger;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        int m = 3;
        int n = 3;
        int[][] cityMap = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int m1 = 3;
        int n1 = 6;
        int[][] cityMap1 = {
                {0,2,0,0,0,2},
                {0,0,2,0,1,0},
                {1,0,0,2,2,0}
        };

        Solution s = new Solution();
        int answer = s.solution(m, n, cityMap);
        //int answer = s.solution(m1, n1, cityMap1);
        System.out.println(answer);
    }
}

class Solution {
    int M;
    int N;
    int[][] City_Map;

    int[] dx = {0,1};
    int[] dy = {1,0};

    class location{
        int x;
        int y;

        public location(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return this.x +" "+ this.y;
        }
    }

    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        M = m;
        N = n;
        City_Map = cityMap;

        answer = bfs();

        return answer%MOD;
    }

    public int bfs(){
        Queue<location> que = new LinkedList<location>();

        int result = 0;
        que.offer(new location(0, 0));

        while(!que.isEmpty()){
            location loc = que.poll();

            if(loc.x == M-1 && loc.y == N-1){
                result++;
            }

            System.out.println(que);

            for(int i = 0; i < dx.length; i++){
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];

                if(nx < M && ny < N){
                    if(City_Map[nx][ny] == 0){
                        que.offer(new location(nx, ny));
                    }
                    else if(City_Map[nx][ny] == 2){
                        int temp1 = nx;
                        int temp2 = ny;

                        while(City_Map[temp1][temp2] == 2){
                            temp1 += dx[i];
                            temp2 += dy[i];

                            if(temp1 >= M || temp2 >= N){
                                break;
                            }
                        }

                        if(temp1 < M && temp2 < N){
                            que.offer(new location(temp1, temp2));
                        }
                    }
                }
            }

        }

        return result;
    }
}