package algorithm;

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

    public static void  main(String[] args){
        IntroductionToAlgorithm intr=new IntroductionToAlgorithm();
        int max_benefit=intr.cut_steel_bar_(Price,10);
        System.out.printf("max benefit %d\n",max_benefit);
//       System.out.println(new IntroductionToAlgorithm().cut_steel_bar(Price,10));
    }








}
