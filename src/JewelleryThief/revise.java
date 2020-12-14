package JewelleryThief;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
input
3 2
1 65
5 23
2 99
10
2

output
164
 */

//폐기 - 런타임 에러 못잡음...
//TODO 해야할 일,, 배열 개념으로는 자체가 줄어들면서 계속적으로 큰 값을 구하는 것..
// 근데 Main보다 좋은 방법은 찾기 힘들듯...

public class revise {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jewelleries = Integer.parseInt(st.nextToken());
        int bags = Integer.parseInt(st.nextToken());

        PriorityQueue<jewellery> que = new PriorityQueue<>();
        for(int i = 0; i < jewelleries; i++){
            st = new StringTokenizer(br.readLine());
            que.offer(new jewellery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] b = new int[bags];
        for(int i = 0; i < bags; i++){
            b[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(b);//2 10 -오름차순
        jewellery result = null;

        //System.out.println(que);

        long answer = 0;
        int i = 0;
        int count = 0;
        while(i < bags){
            int size = que.size();
            jewellery jj = que.poll();
            //System.out.println(jj);

            if(jj.w <= b[i] && result == null){
                result = jj;
            }
            else if(jj.w <= b[i] && result != null){
                if(result.p < jj.p){
                    que.offer(result);
                    result = jj;
                }
            }

            count++;
            if(count >= size){
                count = 0;
                i++;
                answer += result.p;
                result = null;
            }
        }


        System.out.println(answer);
    }

    static class jewellery implements Comparable<jewellery>{
        int w;
        int p;

        public jewellery(int w, int p){
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(jewellery j) {//오름차순 정렬!
            if(this.w > j.w){
                return 1;
            }
            else if(this.w < j.w){
                return -1;
            }
            else return 0;
        }

        public String toString(){
            return this.w+" "+this.p;
        }
    }

    public static void print(jewellery[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
