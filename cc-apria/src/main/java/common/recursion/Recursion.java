package common.recursion;

public class Recursion {
    public static void main(String[] args) {
        //  hanio(2,'A','B','C');
        // System.out.println(  sumN(10));
        System.out.println(avgN(5));


    }

    private static double avgN(int n){
        if (n==1){
            return 1;
        }else {
            return (avgN(n-1)*(n-1)+n)/n;
        }
    }

    private static int sumN(int n){
        if (n==1){
            return 1;
        }else {
            return sumN(n-1)+n;
        }
    }

    private static int arraryMax(int[] ints,int length){
        if (length==1){
            return ints[0];
        }
        int max=ints[length-1]>arraryMax(ints,length-1)?ints[length-1]:arraryMax(ints,length-1);
        return max;
    }

    private static void hanio(int n,char origin,char destination,char assist){
        if (n<1){
            throw new IllegalArgumentException("n must >= 1");
        }
        int count=0;
        if (n==1){
            count=move(count,origin,destination);
        }else {
            /**
             * 将origin最上面的n-1个盘子，移动到assist杆，以destination作为辅助
             * 将origin的最底层的盘子移动到目标杆
             * 将除掉最大盘子的n-1个盘子，从assist杆移动到destination杆，以origin作为辅助
             * **/
            hanio(n-1,origin,assist,destination);
            count=move(count,origin,destination);
            hanio(n-1,assist,destination,origin);
        }
        System.out.println(count);
    }

    private static int move(int count,char origin,char destination){
        System.out.println("move "+origin+" to "+destination);
        count++;
        return count;
    }
}
