package common;

public class Demo {
    public static void main(String[] args) {
        int i=0;
        int j=i++>0?i:10;
        System.out.println(i);
        if (i++>1){
            System.out.println(i);
        }
        System.out.println();
    }

}
