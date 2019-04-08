package DynamicProxy;

import org.junit.Test;
//先生成代理对象，然后调用shopping()方法
public class Testproxy {
    @Test
    public void test(){
        CreateProxy cp=new CreateProxy();
        Subject p=new Person();
        Subject proxy=(Subject)cp.create(p);
       proxy.shopping();
//        proxy.reverse();
    }
}
