package dio.gof.facade;

import subsystemone.CrmService;
import subsystemtwo.CepApi;

public class Facade {
    public void migrateClient(String name, String cep) {
        CepApi cepApi = CepApi.getInstance();
        String city = cepApi.getCity(cep);
        String state = cepApi.getState(cep);

        CrmService.saveClient(name, cep, city, state);
    }
}
