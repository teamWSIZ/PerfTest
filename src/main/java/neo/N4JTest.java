package neo;

import org.neo4j.driver.v1.*;

import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

class MyNeo4j {
    private Driver db = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "password" ) );


    public MyNeo4j() {
    }


    public void close() {
        db.close();
    }

    void fastCreate(int nnn) {
        Session ss = db.session();
        Transaction tx = ss.beginTransaction();
        for (int i = 0; i < nnn; i++) {
            tx.run( "CREATE (a:Rekord {value:'" + UUID.randomUUID().toString() + "'"
                    + ", name:'" + UUID.randomUUID().toString() + "'"
                    + ", address:'" + UUID.randomUUID().toString() + "'" +
                    "})" );
        }
        tx.success();
        ss.close();
    }

    void findAllP() {
//        StatementResult result = session.run( "MATCH (a:P) RETURN a.name AS name" );
//        while ( result.hasNext() )
//        {
//            Record record = result.next();
//            System.out.println(record.get("name").asString());
//        }

//        StatementResult res = session.run("MATCH (n:Rekord) where n.value contains '' RETURN count(n) as cnt");
//        Integer cnt = res.next().get("cnt").asInt();
//        System.out.println("Rekord's: " + cnt);
    }
}


public class N4JTest {
    public static void main(String[] args) throws Exception {
        int batches = 10000;
        int nodesAbatch = 100;
        long st = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(16);

        MyNeo4j db = new MyNeo4j();

        //create 10k nodes
        for (int i = 0; i < batches; i++) {
            pool.execute(()->{
                db.fastCreate(nodesAbatch);
            });
            System.out.println("B" + i);
        }
        pool.shutdown();
        pool.awaitTermination(120, TimeUnit.MINUTES);

        db.close();
        long en = System.currentTimeMillis();
        System.out.println("Writing " + batches * nodesAbatch + " nodes took " + (en-st) + "[ms]");
    }
}
