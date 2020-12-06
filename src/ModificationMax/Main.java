package ModificationMax;

//[카카오 인턴] 수식 최대화
/*
IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며,
참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다.
즉, + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,-처럼
2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다. 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며,
연산자가 3개라면 3! = 6가지 조합이 가능합니다.
만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며,
우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.
예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.
"100-200*300-500+20"
일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,- 처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만,
규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.
참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때,
우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.

[제한사항]
expression은 길이가 3 이상 100 이하인 문자열입니다.
expression은 공백문자, 괄호문자 없이 오로지 숫자와 3가지의 연산자(+, -, *) 만으로 이루어진 올바른 중위표기법(연산의 두 대상 사이에 연산기호를 사용하는 방식)으로 표현된 연산식입니다. 잘못된 연산식은 입력으로 주어지지 않습니다.
즉, "402+-561*"처럼 잘못된 수식은 올바른 중위표기법이 아니므로 주어지지 않습니다.
expression의 피연산자(operand)는 0 이상 999 이하의 숫자입니다.
즉, "100-2145*458+12"처럼 999를 초과하는 피연산자가 포함된 수식은 입력으로 주어지지 않습니다.
"-56+100"처럼 피연산자가 음수인 수식도 입력으로 주어지지 않습니다.
expression은 적어도 1개 이상의 연산자를 포함하고 있습니다.
연산자 우선순위를 어떻게 적용하더라도, expression의 중간 계산값과 최종 결괏값은 절댓값이 2^63 - 1 이하가 되도록 입력이 주어집니다.
같은 연산자끼리는 앞에 있는 것의 우선순위가 더 높습니다.
 */

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        //String str = "50*6-3*2";
        String str = "100-200*300-500+20";
        Solution s = new Solution();
        long result = s.solution(str);
        System.out.println(result);
    }
}

class Solution {
    public long solution(String expression) {
        ArrayList<String> list = new ArrayList<String>();
        String[] numbers = expression.split("[\\W_]");//특수문자 제외
        String[] characters = convert(expression);
        for(int i = 0; i < numbers.length; i++){
            list.add(numbers[i]);
            if(i < characters.length){
                list.add(characters[i]);
            }
        }
        //System.out.println("바꿔야 하는 문자열 :"+list);
        //Debugging
        /*
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        */
        ArrayList<Long> result = new ArrayList<Long>();
        int[] operation = new int[3];
        int n = 1;
        while(n < 4){
            int temp = n++;
            for(int k = 0; k < operation.length; k++){
                if(temp > 3){
                    temp = 1;
                }
                //System.out.println(temp);
                operation[k] = temp;
                temp++;
            }

            String convertor = postfix(list, operation);
            //result.add(Math.abs(value));
            //System.out.println(convertor);
            String[] array1 = convertor.split(" ");
            result.add(Math.abs(calculator(array1)));

            swap(operation, 1, 2);
            convertor = postfix(list, operation);
            //result.add(Math.abs(value));
            //System.out.println(convertor);
            String[] array2 = convertor.split(" ");
            result.add(Math.abs(calculator(array2)));
        }

        //System.out.println(result);
        long answer = 0;
        for(int i = 0; i < result.size(); i++){
            if(answer < result.get(i)){
                answer = result.get(i);
            }
        }

        return answer;
    }

    public long calculator(String[] array){
        long answer = 0;
        int length = array.length;
        Stack<Long> stack = new Stack<>();
        for(int i = 0; i < length; i++){
            if(array[i].equals("+") || array[i].equals("-") || array[i].equals("*")){
                calc(stack, stack.pop(), stack.pop(), array[i]);
            }
            else{
                stack.push(Long.parseLong(array[i]));
            }
        }

        //System.out.println(stack);
        answer = stack.peek();

        return answer;
    }

    public void calc(Stack<Long> stack, long a, long b, String str){
        switch (str){
            case "*":
                stack.push(b*a);
                break;
            case"+":
                stack.push(b+a);
                break;
            case "-":
                stack.push(b-a);
                break;
        }
    }

    public String postfix(ArrayList<String> list, int[] prior){
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            int check = prior(str, prior[0], prior[1], prior[2]);
            //System.out.println(stack);
            switch(check){
                case 1:
                case 2:
                case 3:
                    while(!stack.isEmpty() && prior(stack.peek(), prior[0], prior[1], prior[2]) >= check){
                        sb.append(stack.pop()+" ");
                    }
                    stack.push(str);
                    break;
                default:
                    sb.append(str+" ");
                    break;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        return sb.toString();
    }

    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public String[] convert(String str){
        String temp = str.replaceAll("[0-9]", "");
        String[] characters = temp.split("");
        return characters;
    }

    //후위표기식으로 변환하는 문제인가? 6개의 경우의 수를 어떻게 효율적으로 이끌어내지..?
    public int prior(String str, int i, int j, int k){
        switch (str){
            case"*":
                return i;
            case"+":
                return j;
            case"-":
                return k;
            default:
                return 0;
        }
    }

}