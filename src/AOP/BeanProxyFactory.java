package AOP;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanProxyFactory  implements InvocationHandler {
    Object  target;
    Advice advice;
    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
    public Object getProxy(){
        Object proxy=Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return proxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        advice.BeforeAdvide();
        Object obj=method.invoke(target,args);
        advice.AfterAdvice();
        return obj;
    }
}
