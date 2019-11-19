package com.mybatis.douban.dao;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class Test {
    static final String DB_URL = "jdbc:mysql://apria.cn:3306/ccl";
    // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称
    static final String USER = "ccl";
    static final String PASS = "Chenyahui&929";

    public static void main(String[] args) throws Exception {
        // insert(null);
        //   select(null);
        sellMore();
//        sync4(0);
    }


    public static void sellMore() {


        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    sync4(finalI);
                }
            }.start();
        }


    }


    private static void sync3(int i) {
        try {
            String sql_select = "select amount from t_amount for update";

            String sql_update = " update t_amount set amount=" + i + " where AID='1'";
            update(sql_update);
            System.out.println(Thread.currentThread().getName() + " 下单成功 " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void sync4(int i) {
        try {
            String sql_select = "update    ccl.t_demo set dname='p100001'  where dname='p100002' limit 1";

            int res = update(sql_select);
            if (res >= 1) {
                System.out.println(Thread.currentThread().getName() + " 下单成功 " + i);
            } else {
                System.out.println(Thread.currentThread().getName() + " 下单失败 " + i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void sync() {
        try {
            String sql_select = "select amount from t_amount ";

            int i = select(sql_select);
            System.out.println(Thread.currentThread().getName() + " 当前库存 " + i);
            if (i >= 1) {
                String sql_update = " update t_amount set amount=" + (i - 1) + " where AID='1'";
                update(sql_update);
                System.out.println(Thread.currentThread().getName() + " 下单成功 ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void sync2() {
        try {

            System.out.println(Thread.currentThread().getName() + " 当前库存 ");
            if (true) {
                String sql_update = "explain update t_amount set amount= amount-1 where AID='1' ";
                update(sql_update);
                System.out.println(Thread.currentThread().getName() + " 下单成功 ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int select(String sql) throws SQLException, Exception {
        Connection conn = null;
        Statement statement = null;
        int res = 0;

        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建链接
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        long start = System.currentTimeMillis();
        // like '%为了确保数据库的安全性和正常运转%'

        statement = conn.prepareStatement(sql);

        ResultSet rs = statement.executeQuery(sql);

        // 输出查询结果
        int count = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            //遍历行，next()方法返回值为Boolean，当存在数据行返回true,反之false
            for (int i = 1; i <= count; i++) {//遍历列
                System.out.print(rs.getString(i));
                res = Integer.parseInt(rs.getString(i));
                if (i < count) {
                    System.out.print("---");//为数据隔开美观，没实际意义
                }
            }
            System.out.println();
        }


        long end = System.currentTimeMillis();
        //    System.out.println("timeAll mm "+(end-start));
        //   System.out.println();
        // 关闭
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }


    public static void select(String[] args) throws SQLException, Exception {
        Connection conn = null;
        Statement statement = null;

        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建链接
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        long start = System.currentTimeMillis();
        // like '%为了确保数据库的安全性和正常运转%'

        String sql = "SELECT * FROM t_order where ocount  like '%为了确保数据库的安全性和正常运转%' ";
        statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery(sql);
        // 输出查询结果
        while (rs.next()) {
            System.out.println(rs.next());
        }
        long end = System.currentTimeMillis();
        System.out.println("timeAll mm " + (end - start));
        // 关闭
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void insert(String[] args) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建链接
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

        long start = System.currentTimeMillis();
        //执行插入更新
        for (int i = 0; i < 10; i++) {

            String sql = "insert into t_demo(ID,dname,centen) values(?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, (i + 10000) + "");
            preparedStatement.setString(2, "p" + 100000);
            preparedStatement.setString(3, "接下来，为了确保数据库的安全性和正常运转，对数据库进行初始化操作。这个初始化操作涉及下面5个步骤。\n" +
                    "\n" +
                    "（1）安装验证密码插件。\n" +
                    "\n" +
                    "（2）设置root管理员在数据库中的专有密码。\n" +
                    "\n" +
                    "（3）随后删除匿名账户，并使用root管理员从远程登录数据库，以确保数据库上运行的业务的安全性。\n" +
                    "\n" +
                    "（4）删除默认的测试数据库，取消测试数据库的一系列访问权限。\n" +
                    "\n" +
                    "（5）刷新授权列表，让初始化的设定立即生效。\n" +
                    "\n" +
                    "对于上述数据库初始化的操作步骤，在下面的输出信息旁边我做了简单注释。\n" +
                    "\n" +
                    "root@ubuntu-virtual-machine:~# mysql_secure_installation\n" +
                    "\n" +
                    "Securing the MySQL server deployment.\n" +
                    "\n" +
                    "Connecting to MySQL using a blank password.\n" +
                    "————————————————\n" +
                    "版权声明：本文为CSDN博主「apriaaaa」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\n" +
                    "原文链接：https://blog.csdn.net/apriaaaa/article/details/98957385");

            preparedStatement.executeUpdate();

        }
        long end = System.currentTimeMillis();
        System.out.println("allTime mm " + (end - start));

    }


    public static int update(String sql) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int res = 0;

        // 注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 创建链接
        try {
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        //执行插入更新
        //  for (int i = 0; i < 10; i++) {

        try {
            preparedStatement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            res = preparedStatement.executeUpdate();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //   }
        long end = System.currentTimeMillis();
        //    System.out.println("allTime mm "+(end-start));


        return res;

    }
}