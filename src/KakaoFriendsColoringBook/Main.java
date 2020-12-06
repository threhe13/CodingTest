package KakaoFriendsColoringBook;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};

        int[] result = s.solution(m, n, picture);
        for(int i : result){
            System.out.print(i+" ");
        }

        //result = {4, 5};
    }
}

class Solution {

    int[][] pictures;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    boolean[][] isVisit;
    int row;
    int column;

    int size;
    int numberOfArea;
    int maxSizeOfOneArea;

    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;

        row = m;
        column = n;

        pictures = picture;
        isVisit = new boolean[picture.length][picture[1].length];

        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[i].length; j++){
                if(picture[i][j] > 0 && isVisit[i][j] == false){
                    bfs(i, j);
                    numberOfArea++;

                    if(maxSizeOfOneArea < size){
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void bfs(int x, int y){
        Queue<Node> que = new LinkedList<Node>();
        que.offer(new Node(x, y));
        isVisit[x][y] = true;
        size = 1;

        while(!que.isEmpty()){
            Node node = que.poll();
            //System.out.println(node.x+" "+node.y);
            for(int i = 0; i < dx.length; i++){

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < column){
                    if(pictures[nx][ny] == pictures[node.x][node.y] && isVisit[nx][ny] == false){
                        isVisit[nx][ny] = true;
                        que.offer(new Node(nx, ny));

                        size++;
                    }
                }
            }
        }
    }
}