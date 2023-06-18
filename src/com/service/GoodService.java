package com.service;

import java.util.List;
import java.util.Objects;

import com.dao.EvaluateDao;
import com.entity.Evaluates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GoodsDao;
import com.entity.Goods;

/**
 * 商品服务
 */
@Service
public class GoodService {

    @Autowired
    private GoodsDao goodDao;

    @Autowired
    private TypeService typeService;
    @Autowired
    private EvaluateDao evaluateDao;


    /**
     * 获取总数
     *
     * @return
     */
    public int getCount(Integer gid,String goodname) {
        return goodDao.selectCount(gid,goodname);
    }

    /**
     * 获取列表
     *
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getList(int page, int size,Integer gid,String goodname) {
        return packGood(goodDao.selectList(size * (page - 1), size,gid,goodname));
    }

    /**
     * 获取列表
     *
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListOrderSales(int page, int size) {
        return packGood(goodDao.selectListOrderSales(size * (page - 1), size));
    }

    /**
     * 获取总数
     *
     * @return
     */
    public int getCountByIds(String ids) {
        return Objects.nonNull(ids) ? goodDao.selectCountByIds(ids) : 0;
    }

    public int queryCountByIds(String ids,Integer gid,String goodname) {
        return Objects.nonNull(ids) ? goodDao.queryCountByIds(ids,gid,goodname) : 0;
    }

    /**
     * 获取列表
     *
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByIds(String ids, int page, int size) {
        return Objects.nonNull(ids) ? packGood(goodDao.selectListByIds(ids, size * (page - 1), size)) : null;
    }

    public List<Goods> queryListByIds(String ids, int page, int size,Integer gid,String goodname) {
        return Objects.nonNull(ids) ? packGood(goodDao.queryListByIds(ids,size * (page - 1), size,gid,goodname)) : null;
    }

    /**
     * 通过名称获取产品总数
     *
     * @return
     */
    public long getTotalByName(String name) {
        return goodDao.selectCountByName(name);
    }

    /**
     * 通过名称获取产品列表
     *
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByName(String name, int page, int size) {
        return packGood(goodDao.selectListByName(name, size * (page - 1), size));
    }

    /**
     * 获取数量
     *
     * @param typeid
     * @return
     */
    public long getCountByType(int typeId) {
        return typeId > 0 ? goodDao.selectCountByTypeId(typeId) : this.getCount(null,null);
    }

    /**
     * 通过分类搜索
     *
     * @param typeid
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByType(int typeId, int page, int size,Integer gid,String goodname) {
        return typeId > 0 ? packGood(goodDao.selectListByTypeId(typeId, size * (page - 1), size)) : this.getList(page, size,gid,goodname);
    }

    /**
     * 获取数量
     *
     * @param typeid
     * @return
     */
    public long getCountByTopType(byte type) {
        return goodDao.selectCountByTopType(type);
    }

    /**
     * 通过推荐搜索
     *
     * @param typeid
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByTopType(byte type, int page, int size) {
        return packGood(goodDao.selectListByTopType(type, size * (page - 1), size));
    }

    /**
     * 通过id获取
     *
     * @param id
     * @return
     */
    public Goods get(int id) {
        return packGood(goodDao.select(id));
    }

    /**
     * 添加
     *
     * @param good
     */
    public boolean add(Goods good) {
        return goodDao.insert(good);
    }

    /**
     * 修改
     *
     * @param good
     * @return
     */
    public boolean update(Goods good) {
        return goodDao.update(good);
    }

    /**
     * 修改库存
     *
     * @return
     */
    public boolean updateStock(int id, int stock) {
        return goodDao.updateStock(id, stock);
    }

    /**
     * 修改销量
     *
     * @return
     */
    public boolean updateSales(int id, int sales) {
        return goodDao.updateSales(id, sales);
    }

    /**
     * 删除商品
     *
     */
    @Transactional // 开启事务
    public boolean delete(int id) {
        // 先删除此商品的推荐信息
        return goodDao.delete(id);
    }


    /**
     * 封装商品
     *
     * @param list
     * @return
     */
    private List<Goods> packGood(List<Goods> list) {
        for (Goods good : list) {
            good = packGood(good);
        }
        return list;
    }


    /**
     * 封装商品
     *
     * @param good
     * @return
     */
    private Goods packGood(Goods good) {
        if (good != null) {
            good.setType(typeService.get(good.getTypeId())); // 类目信息
        }
        return good;
    }

    /*
        获取所有用户评论
     */
    public List<Evaluates> getAllEvaluates(String username,String goodname,int page,int rows){
        return evaluateDao.selectAll(username,goodname,rows * (page - 1), rows);
    }

    public int getTotal(String username,String goodname){
        return evaluateDao.selectTotal(username,goodname);
    }
    /*
        获取指定商品的所有评论
     */
    public List<Evaluates> getEvaluates(int gid){
        return evaluateDao.selectByGid(gid);
    }

    /*
        添加商品评论
     */
    public boolean addComment(Evaluates evaluates){
        return evaluateDao.insert(evaluates)>0?true:false;
    }

    /*
        根据商品ID和订单ID查询评论
     */
    public Evaluates getCommentByOidAndGid(int gid,int oid){
        return evaluateDao.selectByOidAndGid(oid,gid);
    }


    /*
        判断订单是否全部评论子商品
     */
    public boolean judgeIsAllEvaluate(int oid){
        return evaluateDao.figureEvaluate(oid)==0?true:false;
    }

    /*
        修改评论
     */
    public boolean updateComment(Evaluates evaluates){
        return evaluateDao.update(evaluates)>0?true:false;
    }

    /*
        删除评论
     */
    public boolean deleteComment(Evaluates evaluates){
        return evaluateDao.delete(evaluates)>0?true:false;
    }

}