package IntroSpect;

public class BeanTest {
    public static void main(String[] args) {
       Config bean = (Config) BeanFactory.getBean("bean.name");
        System.out.println(bean);
    }
}
