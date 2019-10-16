package com.baizhi.cat;

/*
  通过此类获取工厂对象
* ApplicationContextAware  关心容器
*
* */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class aaa implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String name) {
        Object bean = applicationContext.getBean(name);
        return bean;
    }
    public static Object getBeanByClass(Class clazz) {
        Object bean = applicationContext.getBean(clazz);
        return bean;
    }

}
