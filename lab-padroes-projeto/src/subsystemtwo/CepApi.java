package subsystemtwo;

public class CepApi {
    private static CepApi instance = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance() {
        return instance;
    }

    public String getState(String cep) {
        return "SP";
    }

    public String getCity(String cep) {
        return "Araraquara";
    }
}
