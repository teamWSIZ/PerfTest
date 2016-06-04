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

/**
 * Summary:
 * Conditions: N=1e6 key-UUID pairs in local VM database
 *
 * 100 searches --> 4000ms      (no index O(N)=40ms)
 *
 * with index
 *
 * 10000 searches --> 2000ms    (with index seach 0.2ms)
 *
 */


public class PostgresTest {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("spring-config.xml");
        RekordRe repo = ctx.getBean(RekordRe.class);

        List<Rekord> lista = new ArrayList<>();
        int NQUERIES = 10000;
        for (int i = 0; i < NQUERIES; i++) {
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
//        System.out.println("Threads:" + ForkJoinPool.commonPool().getParallelism());
//        ForkJoinPool threadPool = new ForkJoinPool(200);
//        threadPool.submit(() -> lista.parallelStream().forEach(
//                r-> {
//                    repo.save(r);
////                    System.out.println(r);
//                })).get();
//        lista.parallelStream().forEach(r -> repo.save(r));

        long st = System.currentTimeMillis();
        AtomicInteger found = new AtomicInteger();
        lista.parallelStream().forEach(r->{
            if (repo.findNumberOfMatchingValues(r.getValue())>0) found.intValue();
        });
        System.out.println(found);
        long en = System.currentTimeMillis();
//        System.out.println(repo.count());
        System.out.println("Time: " + (en-st) + "[ms]");
        ctx.close();
    }


}
