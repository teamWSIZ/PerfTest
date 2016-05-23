package neo;

import org.neo4j.driver.v1.*;

import java.util.UUID;


public class N4JTest {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver( "bolt://192.168.0.101", AuthTokens.basic( "neo4j", "...." ) );
        Session session = driver.session();
        int nnn = 1000;
        long st = System.currentTimeMillis();
        //CREATE

        for (int i = 0; i < nnn; i++) {
            session.run( "CREATE (a:Rekord {value:'" + UUID.randomUUID().toString() + "'})" );
        }

//        StatementResult result = session.run( "MATCH (a:P) RETURN a.name AS name" );
//        while ( result.hasNext() )
//        {
//            Record record = result.next();
//            System.out.println(record.get("name").asString());
//        }

        StatementResult res = session.run("MATCH (n:Rekord) where n.value contains '' RETURN count(n) as cnt");
        Integer cnt = res.next().get("cnt").asInt();
        System.out.println("Rekord's: " + cnt);

        session.close();
        driver.close();
        long en = System.currentTimeMillis();
        System.out.println("Writing " + nnn + " nodes took " + (en-st) + "[ms]");
    }
}
