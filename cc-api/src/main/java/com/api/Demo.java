package com.api;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/28
 * To change this template use File | Settings | File Templates.
 **/
public class Demo {
    public static void main(String[] args) {
     int[] a=new int[]{1,2,3};
        int[] b=new int[]{1,2,3};
        int[] c=concat(a,b);
        System.out.println(c);
    }


    private static <T> T[] concat(T[] a, T[] b) {
        final int alen = a.length;
        final int blen = b.length;
        if (alen == 0) {
            return b;
        }
        if (blen == 0) {
            return a;
        }
        final T[] result = (T[]) java.lang.reflect.Array.
                newInstance(a.getClass().getComponentType(), alen + blen);
        System.arraycopy(a, 0, result, 0, alen);
        System.arraycopy(b, 0, result, alen, blen);
        return result;
    }


    private static int[] concat(int[] a, int[] b) {
        int[] c=new int[a.length+b.length];
       int i=0,j=0,k=0;
       while (i<a.length && j<b.length){
           if (a[i]<b[j])
               c[k++]=a[i++];
           else
               c[k++]=b[j++];
       }
       while (i<a.length){
           c[k++]=a[i++];
       }
       while (j<b.length){
           c[k++]=b[j++];
       }
       return c;
    }


}
