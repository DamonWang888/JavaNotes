package algorithm;
import java.util.ArrayList;
import java.util.Collections;

public class IntroductionToAlgorithm {

    private static int  Price[]={1,5,8,9,10,17,17,20,24,30};
    // 自顶向下递归,给定价格表,钢条长度,求最优切割方案
    // 不声明默认为private 访问权限

    int cut_steel_bar(int[] Price, int n){
        int max_price=-1;
        if (n==0)
            return 0;
        else {
            for(int j=1;j<=n;j++)
                max_price=Math.max(Price[j-1]+cut_steel_bar(Price,n-j),max_price);  //传递引用
        }
        return max_price;
    }



    // 自低向上
    int cut_steel_bar_(int []Price,int n){
        int r[]=new int[n+1];
        for(int j=1;j<=n;j++) {
            int max_price = -1;
            for (int i = 1; i <= j; i++) {
                max_price = Math.max(max_price, Price[i-1] + r[j - i]);
            }
            r[j]=max_price;
        }
    return r[n];
    }

    //保存最优切割方案
    ArrayList<ArrayList<Integer>> extended_bottom_up_cut_rod(int[] price,int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> s=new ArrayList<Integer>(Collections.nCopies(n+1,0));
        ArrayList<Integer> r=new ArrayList<Integer>(Collections.nCopies(n+1,0));

        for(int j=1;j<=n;j++){
            Integer i;
            Integer max_price = -1;
            for (i = 1; i <= j; i++) {
                // price 下标从0开始
                int Cur_Price=Price[i-1] + r.get(j - i);
                if(max_price<Cur_Price) {
                    max_price = Cur_Price;
                    s.set(j, i);
                }
            }
            r.set(j, max_price);

        }
        res.add(r);
        res.add(s);
        return res;
    }

    //打印最优切割方案
    void print_cut_rod_solution(ArrayList<ArrayList<Integer>> res){
        int n=res.get(0).size()-1;
        System.out.printf("n=%d\n",n);
        ArrayList<Integer> s=res.get(1);
        while (n>0){
            Integer cur_length=s.get(n);
            System.out.printf("cur_length %d\n",cur_length);
            //System.out.println(cur_length);
            n=n-cur_length;
        }
    }

    public static void  main(String[] args){
        IntroductionToAlgorithm intr=new IntroductionToAlgorithm();
        ArrayList<ArrayList<Integer>> res= intr.extended_bottom_up_cut_rod(Price,10);
        intr.print_cut_rod_solution(res);
        // int max_benefit=intr.cut_steel_bar_(Price,10);
        // System.out.printf("max benefit %d\n",max_benefit)
        // System.out.println(new IntroductionToAlgorithm().cut_steel_bar(Price,10));
    }

}
