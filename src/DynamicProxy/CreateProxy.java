package DynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateProxy implements InvocationHandler {
    private Object target;
    public Object create(Object target){
        this.target=target;
        Proxy proxy;
        proxy = (Proxy) Proxy.newProxyInstance(CreateProxy.class.getClassLoader(),target.getClass().getInterfaces(),this);
        return proxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("lalal");
        System.out.println("sss");
        method.invoke(target,args);
        System.out.println("complte");
        return null;
    }
}
