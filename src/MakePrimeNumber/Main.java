package MakePrimeNumber;

public class Main {
    public static void main(String[] args){
        int[] example1 = {1, 2, 3, 4};
        int[] example2 = {1, 2, 7, 6, 4};

        int result = Solution(example1);
        System.out.println(result);
    }

    public static int Solution(int[] example){
        int length = example.length;
        int answer = 0;

        for(int i = 0; i < length; i++){
            for(int j = i+1; j < length; j++){
                int sum = example[i] + example[j];

                if(sum == 1){
                    answer++;
                }

                if(sum == 2){
                    answer++;
                }

                boolean check = true;
                int n = 3;
                while(n < sum){
                    if(sum%n == 0){
                        check = false;
                    }
                    n++;
                }

                if(check == true){
                    answer++;
                }

            }
        }

        return answer;
    }
}
