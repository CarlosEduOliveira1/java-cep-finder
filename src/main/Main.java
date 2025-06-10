import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Address;
import model.AddressViaCep;

public class Main {
   public static void main(String[] args) throws IOException, InterruptedException {
      Scanner input = new Scanner(System.in);

      System.out.println("Digite um CEP para fazer a pesquisa: ");
      String postalCode = input.nextLine();

      String viaCepUrl = "https://viacep.com.br/ws/" + postalCode + "/json";

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(viaCepUrl))
            .build();

      HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body();
      int statusCode = response.statusCode();

      Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();

      AddressViaCep newAddressViaCep = gson
            .fromJson(json, AddressViaCep.class);
      Address newAddress = new Address(newAddressViaCep);
      

      System.out.println("Status code: " + statusCode);
      newAddress.getAddressData();

      input.close();
   }

}