package subsystemone;

public class CrmService {
    private CrmService() {
        super();
    }

    public static void saveClient(String name, String cep, String city, String state) {
        System.out.println("Cliente salvo no sistema do CRM.");

        System.out.println(name);
        System.out.println(cep);
        System.out.println(city);
        System.out.println(state);
    }
}
