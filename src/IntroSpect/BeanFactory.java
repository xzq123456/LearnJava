package IntroSpect;

import javafx.beans.binding.ObjectExpression;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    private static Properties prop=new Properties();
    //使用静态代码块读取配置文件
    static {
       InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("IntroSpect/config.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  Object getBean(String name){
        Object bean=null;
        String beanName=prop.getProperty(name);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean=aClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor pd:propertyDescriptors){
                //获取属性名
                String propertyName=pd.getName();
//                System.out.println(propertyName);
                //获取写方法  其实就是set方法
                Method writeMethod = pd.getWriteMethod();
                if("name".equals(propertyName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                }else if("password".equals(propertyName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                }else if("url".equals(propertyName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.url"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  bean;
    }
}
