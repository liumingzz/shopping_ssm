/*
 * 订单关联封装
 * 用户订单商品信息关联
 * */


package com.entity;

public class Items {
    private int id;

    private int price;

    private int amount;

    private int orderId;

    private int goodId;

    private float total;

    private Goods good;

    private boolean evaluateFlag; //是否已经评论

    private Evaluates evaluates;


    public Evaluates getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(Evaluates evaluates) {
        this.evaluates = evaluates;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public boolean isEvaluateFlag() {
        return evaluateFlag;
    }

    public void setEvaluateFlag(boolean evaluateFlag) {
        this.evaluateFlag = evaluateFlag;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", price=" + price +
                ", amount=" + amount +
                ", orderId=" + orderId +
                ", goodId=" + goodId +
                ", total=" + total +
                ", good=" + good +
                ", evaluateFlag=" + evaluateFlag +
                ", evaluates=" + evaluates +
                '}';
    }
}