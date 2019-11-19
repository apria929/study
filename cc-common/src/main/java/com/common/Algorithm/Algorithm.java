package com.common.Algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/13
 * To change this template use File | Settings | File Templates.
 **/
public class Algorithm {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.demo5();
    }


    /**
     * 【程序1】
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     */
    private static int demo1(int month) {
        if (month == -2 || month == -1 || month == 0 || month == 1 || month == 2) {
            return 1;
        } else {
            return demo1(month - 1) + demo1(month - 2);
        }
    }


    /**
     * 【程序2】
     * 题目：判断101-200之间有多少个素数，并输出所有素数。
     * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
     */
    private static void demo2() {
        int count = 0;
        for (int i = 101; i < 200; i += 2) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }


    /**
     * 【程序3】
     * 题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
     */
    private static void demo3() {
        int a, b, c;
        for (int i = 101; i < 1000; i++) {
            a = i % 10;
            b = i / 10 % 10;
            c = i / 100;
            if (a * a * a + b * b * b + c * c * c == i)
                System.out.println(i);
        }

    }

    /**
     * 【程序4】   
     * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。   
     * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：   
     * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。   
     * (2)如果n > k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。   
     * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。  
     */
    private static void demo4() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = 2;
        while (n >= k) {
            if (n == k) {
                System.out.println(k);
                break;
            } else if (n % k == 0) {
                System.out.println(k);
                n = n / k;
            } else {
                k++;
            }
        }
    }


    /**
     * 【程序5】
     * 题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
     */

    @Test
    private void demo5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char a = n >= 90 ? 'A' : n >= 60 ? 'B' : 'C';
        System.out.println(a);

    }

    /**
     * 【程序6】
     * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
     */
    @Test
    public void demo6() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int gys = 0;
        int gbs = m * n;
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }
        while (n != 0) {
            if (m == n) {
                gys = m;
            }
            int t = n;
            n = m % n;
            m = t;
        }
        gys = m;
        gbs = gbs / gys;
        System.out.println("gys" + gys);
        System.out.println("gbs" + gbs);

    }

    /**
     * 【程序7】
     * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     */
    @Test
    public void demo7() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int en = 0, blank = 0, num = 0, othor = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                en++;
            } else if (Character.isSpaceChar(chars[i])) {
                blank++;
            } else if (Character.isDigit(chars[i])) {
                num++;
            } else {
                othor++;
            }
        }
        System.out.println(en);
        System.out.println(blank);
        System.out.println(num);
        System.out.println(othor);

    }


    /**
     * 【程序8】
     * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
     */
    @Test
    public void demo8() {
        Scanner scanner = new Scanner(System.in);
        int in1 = scanner.nextInt();
        int in2 = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <= in2; i++) {
            sum = sum + in1;
            in1 = in1 * 10 + in1;
        }
        System.out.println(sum);
    }

    /**
     * 【程序9】
     * 题目：一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程     找出1000以内的所有完数。
     */
    @Test
    public void demo9() {
        for (int a = 1; a <= 1000; a++) {
            int sum = 0;
            for (int i = 1; i <= a / 2; i++) {
                if (a % i == 0) {
                    sum = sum + i;
                }
            }
            if (sum == a) {
                System.out.println(a);
            }
        }
    }

    /**
     * 【程序10】
     * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
     */
    @Test
    public void demo10() {
        double h = 100;
        double all = 0;
        double h10 = 0;
        for (int i = 0; i < 10; i++) {
            all = all + h;
            h = h / 2;
            all = all + h;
        }
        System.out.println(h);
        System.out.println(all - h);
    }

    /**
     * 【程序11】
     * 题目：有1、2、3、4四个数字，能组成多少个互不相同且一个数字中无重复数字的三位数？并把他们都输入。
     */
    @Test
    public void demo11() {
        for (int a = 1; a < 5; a++) {
            for (int b = 1; b < 5; b++) {
                for (int c = 1; c < 5; c++) {
                    if (a != b && a != c && b != c) {
                        System.out.println(a * 100 + b * 10 + c);
                    }
                }
            }

        }

    }


    /**
     * 【程序12】   
     * 题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润，求应发放奖金总数？ 
     */
    @Test
    public void demo12() {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double y = 0;
        if (x > 0 && x <= 10) {
            y = x * 0.1;
        } else if (x > 10 && x <= 20) {
            y = 10 * 0.1 + (x - 10) * 0.075;
        } else if (x > 20 && x <= 40) {
            y = 10 * 0.1 + 10 * 0.075 + (x - 20) * 0.05;
        } else if (x > 40 && x <= 60) {
            y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (x - 40) * 0.03;
        } else if (x > 60 && x <= 100) {
            y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (x - 60) * 0.015;
        } else if (x > 100) {
            y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (x - 100) * 0.01;
        }
        System.out.println(y);

    }

    /**
     * 【程序13】
     * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
     */
    @Test
    public void demo13() {
        int i = 1;
        while (true) {
            if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 168100) % 1 == 0) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }

    /**
     * 【程序14】
     * 题目：输入某年某月某日，判断这一天是这一年的第几天？
     */
    @Test
    public void demo14() {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int no = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                    no = 31;
                    break;
                case 2:
                    if (year % 4 == 0) {
                        no = no + 28;
                    } else {
                        no = no + 27;
                    }
                    ;
                    break;
                case 3:
                    no = 31;
                    break;
                case 4:
                    no = no + 31;
                    break;
                case 5:
                    no = no + 30;
                    break;
                case 6:
                    no = no + 31;
                    break;
                case 7:
                    no = no + 30;
                    break;
                case 8:
                    no = no + 31;
                    break;
                case 9:
                    no = no + 31;
                    break;
                case 10:
                    no = no + 30;
                    break;
                case 11:
                    no = no + 31;
                    break;
                case 12:
                    no = no + 30;
            }
            System.out.println(no + day);
        }
    }

    /**
     * 【程序15】
     * 题目：输入三个整数x,y,z，请把这三个数由小到大输出
     */
    @Test
    public void demo15() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b > c) {
            int t = c;
            c = b;
            b = t;
        }
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        System.out.println(a + " " + " " + b + " " + c);
    }

    /**
     * 【程序16】
     * 题目：输出9*9口诀。
     */
    @Test
    public void demo16() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "x" + j + "=" + i * j);
            }
            System.out.println();
        }
    }

    /**
     * 【程序17】
     * 题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个     第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下     的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
     */
    @Test
    public void demo17() {
        int n = 1;
        while (true) {
            int left = n;
            for (int i = 1; i < 10; i++) {
                left = left / 2 - 1;
                if (left < 1) {
                    break;
                }
            }
            if (left == 1) {
                break;
            } else {
                n++;
            }
        }
        System.out.println(n);
    }

    /**
     * 【程序18】
     * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
     * *
     */
    @Test
    public void demo18() {
        char[] xyz = "xyz".toCharArray();
        for (char x1 : xyz) {
            for (char x2 : xyz) {
                for (char x3 : xyz) {
                    if (x1 != x2 && x1 != x3 && x2 != x3 && x1 != 'x' && x3 != 'x' && x3 != 'z') {
                        System.out.println("a" + x1 + "b" + x2 + "c" + x3);
                    }
                }
            }

        }
    }

    /**
     * 【程序19】
     * 题目：打印出如下图案（菱形）
     * * *
     */
    @Test
    public void demo19() {
        int n = 19;
        for (int i = 0; i <= n / 2; i++) {
            for (int i1 = 0; i1 < (n - i * 2) / 2; i1++) {
                System.out.print(" ");
            }
            for (int i2 = 0; i2 < 2 * i + 1; i2++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n / 2 + 1; i++) {
            for (int i2 = 0; i2 < i; i2++) {
                System.out.print(" ");
            }
            for (int i2 = 0; i2 < n - 2 * i; i2++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * 【程序20】
     * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
     */
    @Test
    public void demo20() {
        double sum = 0.0;
        double t1 = 2.0, t2 = 1.0;
        for (int i = 0; i < 20; i++) {
            t1 = t1 + i;
            t2 = t2 + i;
            sum = sum + t1 / t2;
        }
        System.out.println(sum);
    }

    /**
     * 【程序21】
     * 题目：求1+2!+3!+...+20!的和
     */
    @Test
    public void demo21() {
        int sum = 0;
        int n = 1;
        for (int i = 1; i <= 20; i++) {
            n = n * i;
            sum = sum + n;
        }
        System.out.println(sum);

    }


    /**
     * 【程序22】
     * 题目：利用递归方法求5!。
     */
    @Test
    public void demo22() {
        int n = 1;
        for (int i = 1; i <= 5; i++) {
            n = n * i;
        }
        System.out.println(n);

        int sum2 = demo22_1(5);
        System.out.println(sum2);
    }

    public int demo22_1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return demo22_1(n - 1) * n;
        }
    }


    /**
     * 【程序23】
     * 题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？
     */
    @Test
    public void demo23() {
        int n = 10;
        for (int i = 1; i <= 4; i++) {
            n = n + 2;
        }
        System.out.println(n);
    }

    /**
     * 【【程序24】
     * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。     *
     */
    @Test
    public void demo24() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }


    /**
     * 【程序25】
     * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
     */
    @Test
    public void demo25() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        for (int i = 0; i <= chars.length / 2; i++) {
            if (chars[i] == chars[chars.length - i - 1]) {
                continue;
            } else {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");

    }


    /**
     * 【程序26】
     * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续   判断第二个字母。
     */
    @Test
    public void demo26() {
        // monday  Wednesday  Friday Tuesday Thursday Sunday Saturday
        System.out.println("请输入星期的第一个大写字母：");
        char ch = getChar();
        switch (ch) {
            case 'M':
                System.out.println("Monday");
                break;
            case 'W':
                System.out.println("Wednesday");
                break;
            case 'F':
                System.out.println("Friday");
                break;
            case 'T': {
                System.out.println("请输入星期的第二个字母：");
                char ch2 = getChar();
                if (ch2 == 'U') {
                    System.out.println("Tuesday");
                } else if (ch2 == 'H') {
                    System.out.println("Thursday");
                } else {
                    System.out.println("无此写法！");
                }
            }
            ;
            break;
            case 'S': {
                System.out.println("请输入星期的第二个字母：");
                char ch2 = getChar();
                if (ch2 == 'U') {
                    System.out.println("Sunday");
                } else if (ch2 == 'A') {
                    System.out.println("Saturday");
                } else {
                    System.out.println("无此写法！");
                }
            }
            ;
            break;
            default:
                System.out.println("无此写法！");
        }
    }


    public char getChar() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char ch = str.charAt(0);
        if (ch < 'A' || ch > 'Z') {
            System.out.println("输入错误，请重新输入");
            ch = getChar();
        }
        return ch;
    }


    /**
     * 【程序27】
     * 题目：求100之内的素数
     */
    @Test
    public void demo27() {
        for (int i = 1; i <= 100; i++) {
            boolean flog = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flog = false;
                }
            }
            if (flog) {
                System.out.println(i);
            }
        }
    }


    /**
     * 【程序28】
     * 题目：对10个数进行排序
     */
    @Test
    public void demo28() {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = scanner.nextInt();
        }
        ints = paixu(ints);
        for (int i = 0; i < 10; i++) {
            System.out.println(ints[i]);
        }
    }

    private int[] paixu(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    int t = ints[i];
                    ints[i] = ints[j];
                    ints[j] = t;
                }
            }
        }
        return ints;
    }


    /**
     * 【程序29】
     * 题目：求一个3*3矩阵对角线元素之和
     */
    @Test
    public void demo29() {
        Scanner scanner = new Scanner(System.in);
        int[][] ints = new int[3][3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ints[i][j] = scanner.nextInt();
                if (i == j) {
                    sum += ints[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    /**
     * 【程序30】
     * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
     */
    @Test
    public void demo30() {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[10];
        int[] ints2 = new int[11];
        for (int i = 0; i < 10; i++) {
            ints[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        Arrays.sort(ints);
        for (int i = 0; i < 10; i++) {
            System.out.println(ints[i]);
        }

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (flag) {
                ints2[i + 1] = ints[i];
            } else if (ints[i] > x) {
                ints2[i] = ints[i];
            } else {
                flag = true;
                ints2[i] = x;
            }
        }
        System.out.print("res : ");
        for (int i = 0; i < 11; i++) {
            System.out.print(ints2[i] + " ");
        }
    }

    /**
     * 【程序33】
     * 题目：打印出杨辉三角形（要求打印出10行如下图）
     */
    @Test
    public void demo33() {
        int[][] ints = new int[10][10];
        for (int i = 0; i < 10; i++) {
            ints[i][0] = 1;
            ints[i][i] = 1;
        }

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < i; j++) {
                ints[i][j] = ints[i - 1][j - 1] + ints[i - 1][j];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < (10 - i) / 2; i1++) {
                System.out.print("  ");
            }
            for (int i2 = 0; i2 <= i; i2++) {
                System.out.print(ints[i][i2] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 【程序37】
     * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
     */
    @Test
    public void demo37() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] booleans = new boolean[n];
        for (int i = 0; i < n; i++) {
            booleans[i] = true;
        }
        int left = n;
        int count = 0;
        int index = 0;
        while (left > 1) {
            if (booleans[index] == true) {
                count++;
                if (count == 3) {
                    booleans[index] = false;
                    left--;
                    count = 0;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (booleans[i] == true) {
                System.out.println(n + ":" + (i + 1));
            }
        }
    }

    /**
     * 【程序39】
     * 题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)
     */
    @Test
    public void demo39() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i = i + 2) {
                sum = sum + 1 / i;
            }
        } else {
            for (int i = 1; i <= n; i = i + 2) {
                sum = sum + 1 / i;
            }
        }
        System.out.println(sum);
    }

    /**
     * 【程序41】   
     * 题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
     * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，
     * 问海滩上原来最少有多少个桃子？ 
     */
    @Test
    public void demo41() {
        int start = 0;
        while (true) {
            boolean flag = false;
            start++;
            int n = start;

            for (int i = 0; i < 5; i++) {
                if ((n - 1) % 5 == 0) {
                    flag = true;
                    n = (n - 1) * 4 / 5;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                System.out.println("res : " + (start));
                break;
            }

        }
    }


}
