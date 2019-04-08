package AOP;

import java.io.InputStream;

public class TestAop {
    public static void main(String[] args) {
        //读取配置文件
       InputStream in= Thread.currentThread().getContextClassLoader().getResourceAsStream("AOP/bean.properties");
        //创建bean的工厂
        BeanFactory beanFactory=new BeanFactory(in);
        //生成 产生代理对象的类
         BeanProxyFactory beanProxyFactory=(BeanProxyFactory) beanFactory.getbean("bean");
        //获取代理对象(使用接口来接收)
         Imanager proxy=(Imanager) beanProxyFactory.getProxy();
         proxy.add("sssssssssssss");

    }
}
