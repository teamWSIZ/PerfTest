package offline;

import model.Rekord;
import model.RekordRe;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


public class PostgresTest {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
        RekordRe repo = ctx.getBean(RekordRe.class);
        long ss = repo.count();
        long st = System.currentTimeMillis();
        List<Rekord> lista = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Rekord r = new Rekord();
            r.setValue(UUID.randomUUID().toString());
            lista.add(r);
//            repo.save(r);
        }

//        int repeated = 0;
//        AtomicInteger aa = new AtomicInteger();
//        Random r = new SecureRandom();
//        IntStream.range(0,10000).parallel().forEach(
//                i -> {
//                    if (repo.findOne(r.nextInt(100000))!=null) aa.incrementAndGet();
//                }
//        );
//        for (int i = 0; i < 10000; i++) {
//            if (repo.findOne(r.nextInt(100000))!=null) ++repeated;
//        }
//        System.out.println(aa.get());



//        System.getProperties().put("java.util.concurrent.ForkJoinPool.common.parallelism", 4);
        System.out.println("Threads:" + ForkJoinPool.commonPool().getParallelism());
//        ForkJoinPool threadPool = new ForkJoinPool(1);
//        threadPool.submit(() -> lista.parallelStream().forEach(
//                r-> {
//                    repo.save(r);
////                    System.out.println(r);
//                })).get();
////        lista.parallelStream().forEach(r -> repo.save(r));
        long en = System.currentTimeMillis();
        System.out.println(repo.count());
        System.out.println("Time: " + (en-st) + "[ms]");
        ctx.close();
    }


}
