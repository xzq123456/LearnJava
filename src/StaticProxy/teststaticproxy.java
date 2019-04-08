package StaticProxy;

import org.junit.Test;

public class teststaticproxy {
    @Test
    public void test(){
        Proxy proxy=new Proxy(new RealObject());
        proxy.dosomething();
    }
}
