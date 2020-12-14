package JewelleryThief;

/*
문제
세계적인 도둑 상덕이는 보석점을 털기로 결심했다.

상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.

상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)

다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)

다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)

모든 숫자는 양의 정수이다.

출력
첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int jewelleries = Integer.parseInt(st.nextToken());
        int bags = Integer.parseInt(st.nextToken());

        jewellery[] j = new jewellery[jewelleries];
        for(int i = 0; i < jewelleries; i++){
            st = new StringTokenizer(br.readLine());
            j[i] = new jewellery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] b = new int[bags];
        for(int i = 0; i < bags; i++){
            b[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(j);// 1 2 5
        Arrays.sort(b);//2 10 -오름차순

        //print(j);
        //print(b);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        long answer = 0;

        int index = 0;
        for(int i = 0; i < bags; i++){
            System.out.println(answer);
            while(index < jewelleries && j[index].w <= b[i]){
                que.offer(-j[index].p);
                index++;
                System.out.println(que);
            }

            if(!que.isEmpty()){
                answer += Math.abs(que.poll());
            }
            System.out.println(index +" "+answer);

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
    public static void print(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
