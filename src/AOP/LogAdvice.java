package AOP;

public class LogAdvice implements Advice {
 //切面的实现类
    @Override
    public void BeforeAdvide() {
        System.out.println(System.currentTimeMillis()+"start");
    }

    @Override
    public void AfterAdvice() {
        System.out.println(System.currentTimeMillis()+"end");
    }
}
