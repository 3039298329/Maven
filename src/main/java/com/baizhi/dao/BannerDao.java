package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wyx on 2018/7/5.
 */
public interface BannerDao {
    //查一个
    public Banner selectOne(int id);
    //查所有
    public List<Banner> selectAll(@Param("beginNum") int beginNum, @Param("perNum") int perNum);//开始条数，每页显示的条数
    //查询总的条数
    public Integer count();
    //添加
    public void add(Banner banner);
    //删除
    public void delete(int id);
    //修改
    public void update(Banner banner);
}
