package bean;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

//javaBean 就是符合命名规范的类 getXxx setXxx  bean的普通方法不必遵守规则，但他们必须是public
public class Beantest {
    @Test
    public void test(){
        Employee e=new Employee();
        //接收用户注册的信息  全是以字符串的形式
        String name="ss";
        String age="12";
        String salary="4500";

        try {
            //不需要判断属性,只有属性为public才能设置进去
            BeanUtils.setProperty(e,"name",name);
            BeanUtils.setProperty(e,"age",age);
            BeanUtils.setProperty(e,"salary",salary);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        System.out.println(e);
//        Employee{name='ss', age=12, salary=4500.0}
    }
}
