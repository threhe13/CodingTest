package ShoppingJewelry;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args){
        //String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        //String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        //String[] gems = {"XYZ", "XYZ", "XYZ"};
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        Solution s = new Solution();
        int[] result = s.solution(gems);
        for(int i = 0; i < result.length; i++){
            if(i == 0){
                System.out.print("[");
            }
            System.out.print(result[i]);
            if(i != result.length-1){
                System.out.print(", ");
            } else {System.out.print("]");}
        }
    }
}
/*
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }

        int numbers = set.size();
        //System.out.println(numbers);

        HashMap<String, Integer> map_string = new HashMap<String, Integer>();

        int list_number = 0;
        int length = Integer.MAX_VALUE;
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < gems.length; i++){
                map_string.put(gems[i], i + 1);
                if (map_string.size() == numbers) {
                    list.add(new ArrayList<>());
                    Iterator it = map_string.keySet().iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        list.get(list_number).add(str);
                    }

                    Collections.sort(list.get(list_number), new Comparator<String>() {
                        @Override
                        public int compare(String s, String t1) {
                            return map_string.get(s) - map_string.get(t1);
                        }
                    });

                    //Debugging
                    //System.out.println(list.get(list_number));

                    int first = map_string.get(list.get(list_number).get(0));
                    int last = map_string.get(list.get(list_number).get(list.get(list_number).size()-1));

                    int test = last - first + 1;
                    //System.out.println(first+" "+last+" "+test);
                    if(test < length){
                        answer[0] = first;
                        answer[1] = last;
                        length = test;
                    }

                    list_number++;
                }
        }

        return answer;
    }
}
 */

/*
class Solution{
    public int[] solution(String[] gems){
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        int numbers = set.size();
        //위에는 안건들여도 됨!

        HashMap<String, Integer> map_string = new HashMap<>();
        TreeMap<Integer, String> map_integer = new TreeMap<>();
        int min_value = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++){
            if(!map_string.containsKey(gems[i])){
                map_string.put(gems[i], i+1);
                map_integer.put(i+1, gems[i]);
            }
            else{
                map_integer.remove(map_string.remove(gems[i]));
                map_string.put(gems[i], i+1);
                map_integer.put(i+1, gems[i]);
            }
            System.out.println(map_integer);
            if(map_string.size() == numbers){
                ArrayList<Integer> list = new ArrayList<>(map_integer.keySet());
                int first = list.get(0);
                int last = list.get(map_integer.size()-1);
                int length = last-first+1;

                if(min_value > length){
                    min_value = length;
                    answer[0] = first;
                    answer[1] = last;
                }
            }
        }

        return answer;
    }
}
 */

class Solution{
    public int[] solution(String[] gems){
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        int numbers = set.size();

        Queue<String> que = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int start_point = 0;
        int min_value = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++){
            String str = gems[i];
            if(!map.containsKey(str)) map.put(str, 1);
            else map.put(str, map.get(str)+1);

            que.offer(str);

            while(true){
                String temp = que.peek();
                if(map.get(temp) > 1){
                    map.put(temp, map.get(temp)-1);
                    que.poll();
                    start_point++;
                }
                else{
                    break;
                }
            }

            if(map.size() == numbers) {
                int size = que.size();

                if(size < min_value){
                    min_value = size;
                    answer[0] = start_point+1;
                    answer[1] = start_point+size;
                }
            }
        }

        return answer;
    }
}