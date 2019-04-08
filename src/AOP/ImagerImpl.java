package AOP;

import java.util.ArrayList;
import java.util.List;

public class ImagerImpl implements Imanager {
    private List<String> list =new ArrayList<>();
    @Override
    public void add(String item) {
        //不属于真正的核心代码 （切面）
//        System.out.println(System.currentTimeMillis()+"start");
        list.add(item);
        System.out.println(list);
//        System.out.println(System.currentTimeMillis()+"end");
    }
}
