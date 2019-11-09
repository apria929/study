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
        GoodsLuckNumber number=new GoodsLuckNumber();
        number.setTotal(19);
        goodsInit(number);
    }

    /**
     * @apiNote 生成幸运码
     * */
    private static void goodsInit(GoodsLuckNumber goodsLuckNumber){
        long total=goodsLuckNumber.getTotal();
        Connection con = null;
        try {
            /**
             * 连接池代码省略
             * */
            con.setAutoCommit(false);
            PreparedStatement pst = con.prepareStatement("");
            for (int i=0;i<total;i=i+5){
                ArrayList<Integer> list=new ArrayList<>();

                for (int j=0;j<5&& i+j<total;j++){
                    list.add(1000000+i+j);
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
        }catch (Exception e){
            e.printStackTrace();
            try {
                //事物回滚
                con.rollback();
                con.setAutoCommit(true);
                con.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }

    }


//    public List<String> getLuckCode(String goodsId,String userid,Long amount){
//        String updateUserId = "UPDATE `lottery_number` SET `status` = 0,`user_id` = ?,`current_time`= ?  WHERE `issue_id` = ? AND `status`=1 LIMIT ? ";
//        int rownum=jdbcTemplate.update(updateUserId, userId, currentTime, issueId, amount );
//        if(rownum>0){//还有剩余有效购买码
//            Object[] buyargs={issueId, userId ,currentTime};
//            numberList = jdbcTemplate.query(QUERY + " WHERE `issue_id` = ? AND `status` = 0 AND `user_id` = ? AND `current_time`= ?",
//                    buyargs, LotteryNumberMapper);
//        }
//
//
//    }




}
