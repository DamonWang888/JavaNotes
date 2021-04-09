package leetcode;
import java.util.Arrays;

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


        int[] elem_index=new int[2];
        //int[] copiedArray = Arrays.copyOfRange(numbers, 0,numbers.length);

        //Arrays.sort(copiedArray);

        int i,j,num1 = 0,num2 = 0;

        //int mid=copiedArray.length/2;

        //if(copiedArray[mid])

        //for(i=mid-1,j=mid+1;i>=0&&j<copiedArray.length;)

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
        return elem_index;

    }


    public static void main(String args[]){
        LeetCode leetcode=new LeetCode();
        int[] res;
        res=leetcode.twoSum(numbers,6);
    }
}


