package com.common.mysqlLuckNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/7
 * To change this template use File | Settings | File Templates.
 **/
public class GoodsMysqlInit {
    public static void main(String[] args) {
        GoodsLuckNumber number = new GoodsLuckNumber();
        number.setTotal(19);
        goodsInit(number);
    }

    /**
     * @apiNote 生成幸运码
     */
    private static void goodsInit(GoodsLuckNumber goodsLuckNumber) {
        long total = goodsLuckNumber.getTotal();
        Connection con = null;
        try {
            /**
             * 连接池代码省略
             * */
            con.setAutoCommit(false);
            PreparedStatement pst = con.prepareStatement("");
            for (int i = 0; i < total; i = i + 5) {
                ArrayList<Integer> list = new ArrayList<>();

                for (int j = 0; j < 5 && i + j < total; j++) {
                    list.add(1000000 + i + j);
                }
                Collections.shuffle(list);
                /**
                 *  把生成的数字作为幸运码的id，执行dbinsert操作
                 * */
            }
            con.commit();
            con.setAutoCommit(true);
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //事物回滚
                con.rollback();
                con.setAutoCommit(true);
                con.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }


    /**
     * 通过商品issue_id（每期每个商品有唯一issue_id）来随机获取购买码(使用的购买码会设为失效状态)
     *
     * @param issueId
     * @param amount  需要获取的购买码的数量
     * @param userId
     * @return LotteryNumber对象列表
     * @author Nifury 2016-7-22
     */
    public List<GoodsLuckNumber> queryByNewIssueId2(Long issueId, Long amount, Long userId) {
        List<GoodsLuckNumber> numberList = new ArrayList<GoodsLuckNumber>();
        try {
            long currentTime = System.currentTimeMillis();
            String updateUserId = "UPDATE `lottery_number` SET `status` = 0,`user_id` = ?,`current_time`= ?  WHERE `issue_id` = ? AND `status`=1 LIMIT ? ";
            /**
             * sql update 更新幸运码
             * */
            int rownum = 0;
            if (rownum > 0) {//还有剩余有效购买码
                /**
                 * 抢到了、逻辑处理
                 * */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberList;
    }


}
