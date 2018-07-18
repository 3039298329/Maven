package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wyx on 2018/7/6.
 */
public interface AlbumDao {
    //添加
    public void addAlbum(Album album);
    //查找所有专辑
    public List<Album> selectAll(@Param("beginNum") int beginNum, @Param("perNum") int perNum);//开始条数，每页显示的条数
    //查找一个专辑
    public Album selectOne(int id);
}
