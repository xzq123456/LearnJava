package StaticProxy;

public class Proxy implements Action {
    private Action realObject;
    public Proxy(Action realObject){
        this.realObject=realObject;
    }
    @Override
    public void dosomething() {
        System.out.println("lallalala");
        realObject.dosomething();
        System.out.println("hahhahah");
    }
}
