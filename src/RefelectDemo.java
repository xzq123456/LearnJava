import org.junit.Test;

import java.lang.reflect.*;

public class RefelectDemo {
    @Test
    public void test1(){
        Dog dog=new Dog("wagngwang",11,"red");
        System.out.println(dog.getClass());//class Dog

        Class aclass=Dog.class;
        System.out.println(aclass);//CLass Dog
//        通过反射来生成dog对象
        Class aclass2 = null;
        try {
            aclass2 = Class.forName("Dog");
            System.out.println(aclass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Dog d= null;
        try {
            d = (Dog)aclass2.newInstance();
            System.out.println(d);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Constructor[] constructors = aclass2.getConstructors();
        System.out.println(constructors.length);//2
        for(int i=0;i<constructors.length;i++){
            System.out.println(constructors[i].getName());//Dog Dog
            System.out.println(constructors[i].getParameterCount());//0 3
            System.out.println(constructors[i].getTypeParameters());
        }

//        Dog{name='xiaobai', age=2, color='red'} 调用有参数的构造方法
        try {
            Constructor<Dog> constructor = aclass2.getConstructor(String.class, int.class, String.class);
            d = constructor.newInstance("xiaobai",2,"red");
            System.out.println(d);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException |NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        Class dog = null;
        try {
            dog = Class.forName("Dog");
            System.out.println(dog.getName());
//            //获取所有的共有属性
//            Field[] fields = dog.getFields();
//            System.out.println(fields.length);//0
            Field[] declaredFields = dog.getDeclaredFields();
            System.out.println(declaredFields.length);//3
            for(int i=0;i<declaredFields.length;i++){
                int modifiers = declaredFields[i].getModifiers();
                System.out.println(Modifier.toString(modifiers)+" "+declaredFields[i].getName()+" "+declaredFields[i].getType());
//                private name class java.lang.String
//                private age int
//                private color class java.lang.String
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test3() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class dogclass = Class.forName("Dog");
        System.out.println(dogclass.getName());
        Dog d=new Dog("huahua",11,"red");
        //所有的共有方法，包括继承
//        Method[] methods = dogclass.getMethods();
//        for(int i=0;i<methods.length;i++){
////            System.out.println(methods[i]);
//            if (methods[i].getName().equals("toString")) {
//                String s = null;
//                try {
//                    //调用Dog类的toString方法
//                    s = (String) methods[i].invoke(d);
//                    System.out.println(s);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
         //获取本类定义的所有方法（不包括父类）
        Method[] declaredMethods = dogclass.getDeclaredMethods();
        for(int i=0;i<declaredMethods.length;i++){
//            System.out.println(declaredMethods[i]);
            //设置私有的方法可以被访问
            declaredMethods[i].setAccessible(true);
        if(declaredMethods[i].getName().equals("testPrivate")){
           String s= (String) declaredMethods[i].invoke(d);
            System.out.println(s);
        }
        }


    }

}
