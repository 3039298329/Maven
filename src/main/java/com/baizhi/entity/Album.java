package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wyx on 2018/7/6.
 */
public class Album implements Serializable{
    private Integer id;
    private String name; //名称
    private Double score;  //分数
    private String brodecast;  //播音人
    private String author;   //作者
    private String description;   //简介
    @JSONField(format = "yyyy-MM-dd")
    private Date publicTime;   //发布日期
    private Integer count;     //集数
    private String coverImg;  //封面
    private String status;    //状态
    private List<Chapter> children;  //关系属性，定义多一方的对象

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", brodecast='" + brodecast + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publicTime=" + publicTime +
                ", count=" + count +
                ", coverImg='" + coverImg + '\'' +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getBrodecast() {
        return brodecast;
    }

    public void setBrodecast(String brodecast) {
        this.brodecast = brodecast;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album() {
    }

    public Album(Integer id, String name, Double score, String brodecast, String author, String description, Date publicTime, Integer count, String coverImg, String status, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.brodecast = brodecast;
        this.author = author;
        this.description = description;
        this.publicTime = publicTime;
        this.count = count;
        this.coverImg = coverImg;
        this.status = status;
        this.children = children;
    }
}
