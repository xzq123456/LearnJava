package StaticProxy;

public class RealObject implements Action {

    @Override
    public void dosomething() {
        System.out.println("do Something");
    }
}
