package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
    商品评论表
 */
public class Evaluates {
    private Integer gid;
    private Integer uid;
    private Integer oid;
    private String goodName;
    private String content;
    private Date systime;
    private Users user;

    public Evaluates() {
    }

//    public Evaluates(int gid, int uid, int oid, String goodName, String content, Date systime, Users user) {
//        this.gid = gid;
//        this.uid = uid;
//        this.oid = oid;
//        this.goodName = goodName;
//        this.content = content;
//        this.systime = systime;
//        this.user = user;
//    }

    public Evaluates(int gid, int uid, int oid, String goodName, String content, Date systime, Users user) {
        this.gid = gid;
        this.uid = uid;
        this.oid = oid;
        this.goodName = goodName;
        this.content = content;
        this.systime = systime;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSystime() {
        return systime;
    }
    public String getDateString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(systime);
        return dateString;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    @Override
    public String toString() {
        return "Evaluates{" +
                "gid=" + gid +
                ", uid=" + uid +
                ", oid=" + oid +
                ", goodName='" + goodName + '\'' +
                ", content='" + content + '\'' +
                ", systime=" + systime +
                ", user=" + user +
                '}';
    }
}
