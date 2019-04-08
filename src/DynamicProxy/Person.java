package DynamicProxy;

public class Person implements Subject {
    @Override
    public void shopping() {
        System.out.println("付qian");
    }

    @Override
    public void reverse() {
        System.out.println("jiudian");
    }
}
