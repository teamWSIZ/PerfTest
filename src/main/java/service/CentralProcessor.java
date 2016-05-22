package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CentralProcessor {


    // `/hosts GET`
//    public Iterable<Host> getAllHosts() {
//        return hostRe.findAll();
//    }


    // `/hosts POST`
    public Rest createNewHost(String name, String comment) {
        Rest odp = new Rest();
        return odp;
    }

    public Rest getHostsStatus() {
        return new Rest();
    }

    // `/groups/:id: GET
    public Rest listHostsOfGroup(Integer hostGroupId) {
        Rest odp = new Rest();
//        System.out.println("!!!!!(test transakcji)!!!!!! -->" + TransactionSynchronizationManager.isActualTransactionActive());
        return  odp;
    }

    // `/actions/:actionid: GET (endpoint_id)
    public Rest executeAction(Integer hostGroupId) {
        Rest odp = new Rest();
//        List<Host> list = hostGroupRe.findHostsOfGroup(hostGroupId);
//        odp.setResult(list);
        return  odp;
    }





}
