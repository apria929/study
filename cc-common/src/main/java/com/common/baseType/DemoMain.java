package com.common.baseType;



import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/29
 * To change this template use File | Settings | File Templates.
 **/
public class DemoMain {
    public static void main(String[] args) {
        DemoMain demoMain=new DemoMain();
        demoMain.demo();
//        demoMain.demo2();

    }




    private void demo2(){
        A a1=new A("a1");
        A a2=new A("a2");
       boolean b1= a1.equals(a2);
       boolean b2=(a1==a2);
        System.out.println();



    }



    private void demo(){
        int q1=1;
        Integer integer=Integer.getInteger("1");

        A a1=new A();
        a1.setId("a1");
        A a2=new A();
        a2.setId("a1");

       int i1= a1.hashCode();
        int i2= a2.hashCode();
        Map map3=new HashMap();
        HashSet hashSet2=new HashSet();

      Object ob1=  map3.put(a1,"a1");
        Object ob2=  map3.put(a2,"a2");
       boolean b11= hashSet2.add(a1);
        boolean b21= hashSet2.add(a2);

        Map map=new HashMap();
        Object o1= map.put(1,2);
        Object o2= map.put(1,2);
        Object o3= map.put(2,3);
        Object o4= map.put(2,4);
        System.out.println();
        Collection collection=new ArrayList();

        List list=new ArrayList();
        List list1=new Vector();
        list1.add(null);
        HashSet hashSet=new HashSet();
       boolean b1= hashSet.add(1);
       boolean b2=hashSet.add(1);
        System.out.println();



        AbstractCollection abstractCollection=new ArrayList();
        Set set=new HashSet();
        for (int i=0;i<10;i++){
            set.add(i);
        }

        for (Iterator iterator=set.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }

        Iterator iterator=set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());


        Map map2=new HashMap();
        map.put(null,"aa");
        System.out.println(map.get(null));
    }


}
