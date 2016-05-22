package offline;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * offline-owy tester repozytoriów.
 */
public class TestStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("spring-config.xml");

        ctx.close();
    }


}
