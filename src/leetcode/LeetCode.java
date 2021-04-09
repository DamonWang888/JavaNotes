package leetcode;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode {

    /**
    *   求两数之和
    * */

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */


    private static int[] numbers=new int[]{2,3,4};

    public int[] twoSum (int[] numbers, int target) {

        // write code here
        /*
        int[] elem_index=new int[2];
        int i,j,num1 = 0,num2 = 0;

        for(i=0;i<numbers.length;i++){
            num1=numbers[i];
            for(j=i+1;j<numbers.length;j++){
                num2=numbers[j];
                if(num1+num2==target){
                    elem_index[0]=i+1;
                    elem_index[1]=j+1;
                }
            }
        }
        */

        /**
         * 哈希方法
        * */

        int i;
        HashMap<Integer, Integer> array_map=new HashMap<Integer, Integer>();

        for(i=0;i<numbers.length;i++){
            if(array_map.containsKey(numbers[i])){
                return new int[]{array_map.get(numbers[i])+1,i+1};
            }
            array_map.put(target-numbers[i],i);
        }
        return null;

    }


    public static void main(String args[]){
        LeetCode leetcode=new LeetCode();
        int[] res;
        res=leetcode.twoSum(numbers,6);
    }
}


