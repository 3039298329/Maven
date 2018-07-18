package com.baizhi;

import com.baizhi.dao.*;
import com.baizhi.entity.*;

import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import org.h2.engine.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= CmfzApplication.class)
public class CmfzApplicationTests {
    @Resource(name = "userChinaDao")
    private UserChinaDao userChinaDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
    private AdminService adminService;
	@Test
	public void contextLoads() {
	}
	@Test
    public void testUserChainDao(){
        List<UserChina> list = userChinaDao.selectAllWomenman();
        for (UserChina userChina : list) {
            System.out.println(userChina);
        }
    }
	//管理员测试
	@Test
	public void testSelectOne(){
        Admin one = adminDao.selectOne("大黄");
        System.out.println(one);
    }
    @Test
    public void testQueryOne(){
        Admin queryOne = adminService.queryOne("大黄");
        System.out.println(queryOne);
    }

    //菜单项测试
    @Autowired
    private MenuDao menuDao;

    //查找全部
    @Test
    public void testSelectAll(){
        List<Menu> list = menuDao.selectAll();
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }
    //删除菜单
    @Test
    public void testDelete(){

        menuDao.delete(1);
    }

    //轮播图测试
    @Autowired
    private BannerDao bannerDao;
    //查一个
    @Test
    public void selectOne(){
        Banner selectOne = bannerDao.selectOne(1);
        System.out.println(selectOne);
    }
    //查所有
    @Test
    public void selectAll(){
        List<Banner> selectAll = bannerDao.selectAll(0,1);
        for (Banner banner : selectAll) {
            System.out.println(banner);
        }
    }
    //添加
    @Test
    public void add() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate=sdf.parse("1992-09-03");
        Banner banner = new Banner(1,"这只是","qq","啦啦啦啦啦","y",utilDate,"gdft");
        bannerDao.add(banner);
    }
    //删除
    @Test
    public void delete(){
        bannerDao.delete(1);
    }
    //修改
    @Test
    public void update() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate=sdf.parse("1992-02-03");
        Banner banner = new Banner(1,"这只2是","q2q","啦啦2啦啦啦","n",utilDate,"g2dft");
        bannerDao.update(banner);
    }

    //章节测试
    @Autowired
    private ChapterDao chapterDao;
    @Test
    public void testAddChapter()  {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate= null;
        try {
            utilDate = sdf.parse("1992-09-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Chapter chapter = new Chapter(1,"张三","ee",12.3,12.0,1,utilDate,2);
        chapterDao.addChapter(chapter);
        System.out.println("in add");
    }

    //专辑测试
    @Autowired
    private AlbumDao albumDao;
    //添加
    @Test
    public void testAddAlbum(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate= null;
        try {
            utilDate = sdf.parse("1992-09-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Album album = new Album(3,"dsd",12.3,"ss","ss0","swwq",utilDate,12,"das","s",null);
        albumDao.addAlbum(album);
    }
    //查找所有专辑
    @Test
    public void testSelectAllAlbum(){
        List<Album> list = albumDao.selectAll(0,1);
        for (Album album : list) {
            System.out.println(album);
        }
    }
    //查找一个专辑
    @Test
    public void testSelectOneAlbum(){
        Album one = albumDao.selectOne(3);
        System.out.println(one);
    }

    //用户测试
    @Autowired
    private UserDao userDao;
    @Test
    public void testSelectOneUser(){
        System.out.println(userDao.selectOne(1));
    }
    @Test
    public void testInsert(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate= null;
        try {
            utilDate = sdf.parse("1992-09-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(5,null,"sdf","fd",null,null,null,"dfs",null,null,null,utilDate,null);

        userDao.addUser(user);
    }
}
