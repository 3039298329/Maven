package com.baizhi.aop;

import com.baizhi.dao.AopDao;
import com.baizhi.entity.Aop;
import com.baizhi.service.AopService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by wyx on 2018/7/9.
 */
@Configuration
@Aspect
public class LogAspect {
    @Autowired
    private AopDao aopDao;

    @Pointcut(value = "@annotation(LogAnnotation)")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //是谁，什么时间，干了什么事，得到的结果
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        //从session中取出管理员的姓名
        String name = (String) session.getAttribute("name");  //是谁
        //什么时间
        Date date = new Date();
        //方法名
        String objName = proceedingJoinPoint.getSignature().getName();

        //取注解的名字，干了什么事
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String s = null;
        if(annotation!=null){
            s = annotation.name();
        }
        //flag表示得到的结果
        String flag = "false";
        Object proceed = null;
        try {
            //获取方法的返回值
            proceed = proceedingJoinPoint.proceed();
            flag = "true";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //创建aop对象，将得到的数据存入实体
        Aop aop = new Aop();
        aop.setName(name);
        aop.setTime(date);
        aop.setThing(s);
        aop.setResult(flag);
        //调用dao层方法，将数据插入数据库中
        aopDao.add(aop);
        return proceed;
    }
}
