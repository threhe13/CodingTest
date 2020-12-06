package PresentingNumber;

/*
문제 설명
Finn은 요즘 수학공부에 빠져 있습니다.
수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15

자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

제한사항
n은 10,000 이하의 자연수 입니다.

input : 15
result : 4
 */

public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        int input = 15;
        int result = s.solution(input);
        System.out.println(result);
    }
}

class Solution {

    public int solution(int n) {
        int answer = 1;//항상 자기 자신을 포함하므로 1이 존재
        int length = n/2+1;//반 이상 올라가면 더이상 더하는 게 의미가 없어짐 -> 연속하는 자연수이므로

        int[] array = new int[length];//8
        for(int i = 0; i < length; i++){//0 1 2 3 4 5 6 7
            array[i] = i+1;//1 2 3 4 5 6 7 8
        }

        int left = 0;//좌측
        int right = 0;//우측
        int sum = array[left];//초기값 입력
        while(true){
            if(sum < n){//입력받는 자연수보다 작다면 우측 한단계 상승
                right++;
                if(right == length){//우측이 입력받은 자연수/2 보다 크게 되면
                    break;//반복문 종료
                }
                sum += array[right];
            }
            else if(sum >= n){//입력받은 자연수보다 크다면 좌측 한단계 상승
                if(sum == n){
                    answer++;
                }
                sum -= array[left];
                left++;
            }
            //Debugging
            //System.out.println(left+" "+right+" "+sum);
        }

        return answer;
    }
}
