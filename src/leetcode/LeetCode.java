package leetcode;
import java.util.Arrays;
import java.util.HashMap;


class TreeNode {
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            this.val=x;
        }
};


class ListNode {
    int val;
    ListNode next = null;
};



public class LeetCode {


    /**
     *  链表排序
     * **/
    public ListNode sortInList (ListNode head) {
        // write code here

        //头插法排序
        if(head==null)
            return null;
        ListNode pWork=head.next;
        ListNode pPre=head;
        //ListNode pWorkNext=pWork.next;
        ListNode pPreWork;
        ListNode pPrePreWork;

        while (pWork!=null){
            if (pWork.val<pPre.val){
                pPrePreWork=head;
                pPreWork=pPrePreWork;
                while (pPreWork.val<pWork.val){
                    pPrePreWork=pPreWork;
                    pPreWork=pPreWork.next;
                }
                if(pPreWork.next==pWork){
                    int temp=pPreWork.val;
                    pPreWork.val=pWork.val;
                    pWork.val=temp;
                    pPre=pWork;
                    pWork=pWork.next;
                }
                else{
                    pPrePreWork.next=pWork;
                    pPre.next=pWork.next;
                    pWork.next=pPreWork;
                    pWork=pPre.next;
                }
            }
            else{
                pPre=pWork;
                pWork=pWork.next;
            }
        }
        return head;
    }






    /**
     *  返回排序的数组
     * **/
    public int[] MySort (int[] arr) {
        // write code here
        //Arrays.sort(arr);
        //return  arr;

        //BubbleSort
        /*
        for(int i=1;i<arr.length;i++){
            boolean flag=true;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=false;
                }
            }
            if(false)
                break;
        }*/

        //QuickSort
        quciksort(arr,0,arr.length-1);
        return arr;
    }

    void quciksort(int[] arr,int low,int high){
        if(low>=high)
            return;
        int pos=partion(arr,low,high);
        quciksort(arr,low,pos-1);
        quciksort(arr,pos+1,high);
    }

    int partion(int[] arr,int low,int high){
        int compare=arr[high];
        int i=low-1;
        int temp;
        for(int j=low;j<=high-1;j++){
            if(arr[j]<=compare){
                i=i+1;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp=arr[i+1];
        arr[i+1]=compare;
        arr[high]=temp;
        return i+1;
    }



    /**
    *   求两数之和
    * */

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */


    private static int[] numbers=new int[]{2,3,4,1};

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

        /**
         *  数组排序
         * **/
        res=leetcode.MySort(numbers);
        Print print=new Print();
        print.own_print(res);

        /**
         *  求两个数的和
         * **/
        //res=leetcode.twoSum(numbers,6);



    }

}


