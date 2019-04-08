package AOP;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import static java.lang.Class.*;

public class BeanFactory {
    Properties prop=new Properties();
    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getbean(String name){
        String classname=prop.getProperty(name);
        Object bean=null;

        try {
            //获取beanproxyFactory的类
            Class<?> aClass =Class.forName(classname);
            bean=aClass.newInstance();
            //通过内省为代理类的属性赋值
            Object target = Class.forName(prop.getProperty(name+ ".target") ).newInstance();
            Object advice = Class.forName(prop.getProperty(name+".advice")).newInstance();
            BeanInfo beanInfo=Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor pd:propertyDescriptors){
                String propertyName = pd.getName();
                Method writeMethod = pd.getWriteMethod();
                if("target".equals(propertyName)){
                    writeMethod.invoke(bean,target);
                }else  if("advice".equals(propertyName)){
                    writeMethod.invoke(bean,advice);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return  bean;
    }

}
