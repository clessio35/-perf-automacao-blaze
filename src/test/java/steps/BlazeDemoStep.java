package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import service.BlazeDemoService;

public class BlazeDemoStep {

    private BlazeDemoService blaze;
    private String flightId;

    public BlazeDemoStep() {
    	blaze = new BlazeDemoService();
    }

    @Dado("que acesso a API {string}")
    public void acessoAPI(String url) throws Exception {
    	blaze.getHomePage();
    }

    @Quando("realizo uma request POST para {string}")
    public void requestPOST(String endpoint) throws Exception {
    	blaze.findFlight("Paris", "London"); 
    }

    @Quando("escolho o voo com ID {string}")
    public void escolhoVoo(String flightId) throws Exception {
        this.flightId = flightId;
        blaze.chooseFlight(flightId, "200", "Test", "Paris", "London");
    }

    @Então("finalizo a compra com os dados do usuário")
    public void finalizoCompra() throws Exception {
    	blaze.purchaseTicket(
                "Teste", "Rua Teste", "SP", "SP", "00000",
                "visa", "4111111111111111", "12", "2026", "Teste"
        );
    }
}