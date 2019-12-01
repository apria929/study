package common.algorithm;

public class Algorithm {
    public static void main(String[] args) {
        int[] A=new int[]{1,4,9};
        int[] B=new int[]{1,2,3};
        mergeArrary(A,B);

    }

    /**
     * 合并两个有序数组
     * */
    private static int[] mergeArrary(int[] A,int[] B){
        int[] C=new int[A.length+B.length];
        int i=0,j=0,k=0;
        while (i<A.length && j<B.length){
            if (A[i]<=B[j]){
                C[k]=A[i];
                i++;
            }else {
                C[k]=B[j];
                j++;
            }
            k++;
        }
        for (int i1=0;i1<A.length+B.length;i1++){
            System.out.println(C[i1]);
        }
        return null;


    }

}
