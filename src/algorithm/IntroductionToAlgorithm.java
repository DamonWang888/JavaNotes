package algorithm;
import java.util.ArrayList;
import java.util.Collections;

public class IntroductionToAlgorithm {

    private static int  Price[]={1,5,8,9,10,17,17,20,24,30};

    //矩阵链横纵坐标序列
    private static int matrix_order_size[]={30,35,15,5,10,20,25};
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

    //矩阵链乘法 自顶向下
    ArrayList<int[][]> matrix_chain_order(int[] matrix_order_size){

        ArrayList<int[][]> res = new ArrayList<>();
        int n= matrix_order_size.length-1; //总矩阵数为n个，保证下标范围唯一指定某个矩阵。
        int m[][]=new int[n+1][n+1]; //保存矩阵链中两个范围内矩阵相乘所需的标量乘法次数。m[1][6] 表示矩阵链(A1A2A3A4A5A6)所需的最少标量乘法次数。
        int s[][]=new int[n+1][n+1];  //要求保存的范围为横坐标1~n-1,纵坐标2~n。s[1][6]表示划分矩阵链(A1A2A3A4A5A6)的矩阵下标数。
        int i,j,k,l;

        //查看系统初始值
        //for(i=0;i<n;i++)
        //    for(j=0;j<n;j++)
        //    System.out.printf("m[%d][%d]: %d\n",i,j,m[i][j]);

        for(l=2;l<=n;l++){ //l:矩阵链长度
            for(i=1;i<=n-l+1;i++) {  //相应矩阵链长度的起始矩阵下标范围
                j=i+l-1; //结束矩阵下标
                m[i][j]=Integer.MAX_VALUE;
                for(k=i;k<j;k++) { //遍历分割点
                    int multi_num=m[i][k]+m[k+1][j]+matrix_order_size[i-1]*matrix_order_size[k]*matrix_order_size[j];
                    if(multi_num<m[i][j]){
                        m[i][j]=multi_num;
                        s[i][j]=k;
                    }
                }
            }
        }
        res.add(m);
        res.add(s);
        return res;
    }


    void print_matrix(int[][] arry){
        int i,j;
        int rows=arry[0].length;
        int colmns=rows;
        for(i=0;i<rows;i++){
            for(j=colmns-1;j>=0;j--)
                System.out.printf("%d ",arry[i][j]);
            System.out.printf("\n");
        }
    }

    public static void  main(String[] args){
        IntroductionToAlgorithm intr=new IntroductionToAlgorithm();
        ArrayList<int[][]> res =intr.matrix_chain_order(matrix_order_size);
        intr.print_matrix(res.get(0));
        intr.print_matrix(res.get(1));

        //ArrayList<ArrayList<Integer>> res= intr.extended_bottom_up_cut_rod(Price,10);
        //intr.print_cut_rod_solution(res);
        // int max_benefit=intr.cut_steel_bar_(Price,10);
        // System.out.printf("max benefit %d\n",max_benefit)
        // System.out.println(new IntroductionToAlgorithm().cut_steel_bar(Price,10));


    }

}
