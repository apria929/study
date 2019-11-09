package com.common.mysqlLuckNumber;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/7
 * To change this template use File | Settings | File Templates.
 **/
public class GoodsLuckNumber {
    private long total;// 库存
    private String goodId;// 商品代码
    private String name;
    private Date startTime;
    private Date endTime;

    public GoodsLuckNumber(){}

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
