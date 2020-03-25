package chapter06;
import net.sf.ehcache.pool.sizeof.AgentSizeOf;
import net.sf.ehcache.pool.sizeof.SizeOf;

/**
 * @author: yunqi
 * @createdTime: 2020-03-22
 * 描述
 */
public class Father {
    // private byte age;
}

class Son extends Father {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        SizeOf sizeOf = new AgentSizeOf();
        System.out.println("father size :" + sizeOf.sizeOf(father));
        System.out.println("son size :" + sizeOf.sizeOf(son));
    }
}