package service;

import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpResponse;

public class BlazeDemoService {

    private static final String BASE_URL = "https://www.blazedemo.com";

    // get method
    public void getHomePage() throws Exception {
        System.out.println("homepage: " + BASE_URL);
        ClassicHttpResponse response = (ClassicHttpResponse) Request.get(BASE_URL)
                .execute()
                .returnResponse();
        validarResponse(response, "homePage");
    }

    // POST search flight
    public void findFlight(String fromPort, String toPort) throws Exception {
        System.out.println("Buscando voo de '" + fromPort + "' para '" + toPort + "'");
        ClassicHttpResponse response = (ClassicHttpResponse) Request.post(BASE_URL + "/reserve.php")
                .bodyForm(Form.form()
                        .add("fromPort", fromPort)
                        .add("toPort", toPort)
                        .build())
                .execute()
                .returnResponse();
        validarResponse(response, "FindFlight");
    }

    // POST choose
    public void chooseFlight(String flightId, String price, String airline, String fromPort, String toPort) throws Exception {
        System.out.println("Escolhendo voo ID '" + flightId + "', de '" + fromPort + "' para '" + toPort + "'");
        ClassicHttpResponse response = (ClassicHttpResponse) Request.post(BASE_URL + "/purchase.php")
                .bodyForm(Form.form()
                        .add("flight", flightId)
                        .add("price", price)
                        .add("airline", airline)
                        .add("fromPort", fromPort)
                        .add("toPort", toPort)
                        .build())
                .execute()
                .returnResponse();
        validarResponse(response, "ChooseFlight");
    }

    // POST finish
    public void purchaseTicket(String name, String address, String city, String state, String zip,
                               String cardType, String cardNumber, String month, String year, String nameOnCard) throws Exception {
        System.out.println("Finalizando compra para: " + name);
        ClassicHttpResponse response = (ClassicHttpResponse) Request.post(BASE_URL + "/confirmation.php")
                .bodyForm(Form.form()
                        .add("inputName", name)
                        .add("address", address)
                        .add("city", city)
                        .add("state", state)
                        .add("zipCode", zip)
                        .add("cardType", cardType)
                        .add("creditCardNumber", cardNumber)
                        .add("creditCardMonth", month)
                        .add("creditCardYear", year)
                        .add("nameOnCard", nameOnCard)
                        .build())
                .execute()
                .returnResponse();
        validarResponse(response, "PurchaseTicket");
    }

    // Validação de status code e log do corpo (resumido)
    private void validarResponse(HttpResponse response, String stepName) throws Exception {
        int statusCode = response.getCode();
        String body = "";

        if (response instanceof ClassicHttpResponse) {
            ClassicHttpResponse classic = (ClassicHttpResponse) response;
            if (classic.getEntity() != null) {
                body = new String(classic.getEntity().getContent().readAllBytes());
                if (body.length() > 500) body = body.substring(0, 500) + "..."; 
            }
        }

        if (statusCode != 200) {
            System.err.println("fail '" + stepName + "'.status code: " + statusCode);
            throw new Exception("fail: " + stepName + ", status code: " + statusCode);
        } else {
            System.out.println("steps '" + stepName + "' executado com sucesso. status code: " + statusCode);
            System.out.println("body: " + body);
        }
    }
}