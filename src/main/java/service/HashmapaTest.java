package service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by pm on 5/21/16.
 */
public class HashmapaTest {
    public static void main(String[] args) {
        Map<String, String> baza = new HashMap<>();
        long st = System.currentTimeMillis();
        int nCreate = ((int) 1e6);
        for (int i = 0; i < nCreate; i++) {
            String uid = UUID.randomUUID().toString();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                sb.append(uid);
            }
            baza.put(uid, sb.toString());
        }
        long en = System.currentTimeMillis();
//        System.out.println((en-st) + "[ms]");
        st += 2800; //offset fori uuid creation
        System.out.println("Creation: " + (en-st) + "[ms]");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int nSearch = ((int) 1e6);
//        int rr = 0;
//        st = System.currentTimeMillis();
//        for (int i = 0; i < nSearch; i++) {
//            String uid = UUID.randomUUID().toString();
//            if (baza.containsKey(uid)) ++rr;
//        }
//        st += 2500;  //offset 1e5 uuid creation
//        System.out.println(rr);
//        en = System.currentTimeMillis();
//        System.out.println((en - st) + "[ms]");

    }
}
