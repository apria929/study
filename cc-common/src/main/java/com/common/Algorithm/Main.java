package com.common.Algorithm;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/15
 * To change this template use File | Settings | File Templates.
 **/
public class Main {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.demo41();

        int i, m, j = 0, k, count;
        for (i = 4; i < 10000; i += 4) {
            count = 0;
            m = i;
            for (k = 0; k < 5; k++) {
                j = i / 4 * 5 + 1;
                i = j;
                if (j % 4 == 0)
                    count++;
                else break;
            }
            i = m;
            if (count == 4) {
                System.out.println("原有桃子 " + j + " 个");
                break;
            }
        }


    }


}
