package offline;

import service.CentralProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pm on 4/30/16.
 */
public class ServerStart {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-config.xml");

        CentralProcessor processor = ctx.getBean(CentralProcessor.class);

//        processor.createNewHost("Baza", "Baza postgres");

//        System.out.println(processor.getAllHosts());
//
//        System.out.println(processor.listHostsOfGroup(1));

        ctx.close();
    }

}
