package common.random;

import java.security.SecureRandom;

public class Demo {
    public static void main(String[] args) {
        byte[] bytes="1".getBytes();
        SecureRandom random=new SecureRandom(bytes);
        SecureRandom random2=new SecureRandom(bytes);

        for (int i=0;i<10;i++){
            boolean b=random.nextBoolean();
            System.out.println(i+" "+b);
            boolean b2=random2.nextBoolean();
            System.out.println(i+" "+b2);
        }



    }
}
