package com.chuan.aspect;

import com.chuan.annotation.DataSource;
import com.chuan.config.MyDynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @类名:
 * @包名: com.chuan.aspect
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/7/20 15:04
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    //@Pointcut("execution( * com.chuan.service.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    @Pointcut("@annotation(com.chuan.annotation.DataSource)")
    public void dataSourcePointCut() {
    }

    @Before("dataSourcePointCut()")
    public void changeDataSource(JoinPoint joinPoint){
        //获取执行方法的类
        Class<?> serviceClass = joinPoint.getTarget().getClass();
        //获取方法类
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        try {
            Method methodImpl = serviceClass.getMethod(method.getName(), method.getParameterTypes());

            DataSource annotation = methodImpl.getAnnotation(DataSource.class);
            //设置数据源
            MyDynamicDataSource.setDataSource(annotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
    }

}
