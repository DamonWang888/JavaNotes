package ThinkInJava;


class Letter{
    char c;
}


class PassObject{
     static void f(Letter y){
        y.c='z';
    }
    public static void g(){
        Letter x=new Letter();
        x.c='a';
        System.out.print("1:x.c: "+x.c+"\n");
        f(x);  //静态方法不需要创建对象就可以调用
        System.out.print("2:x.c: "+x.c);
    }
}

public class ThinkInJava {
    public static void main(String[] args) {
        PassObject passObject=new PassObject();
        passObject.g();
    }
}
