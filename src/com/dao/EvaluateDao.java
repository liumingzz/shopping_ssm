package com.dao;

import com.entity.Evaluates;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvaluateDao {
    public List<Evaluates> selectByGid(@Param("gid") int gid);

    public int insert(Evaluates evaluates);

    public Evaluates selectByOidAndGid(@Param("oid")int oid,@Param("gid")int gid);

    public int figureEvaluate(@Param("oid")int oid);

    public List<Evaluates> selectAll(@Param("username")String username, @Param("goodname")String goodname, @Param("begin") int begin, @Param("size") int size);

    public int selectTotal(@Param("username")String username, @Param("goodname")String goodname);

    public int update(Evaluates evaluates);

    public int delete(Evaluates evaluates);
}
