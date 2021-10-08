package com.kuba.comp.library.task3;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StripeLibrary {
    private final String apiKey;
    private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

    public StripeLibrary(String apiKey) {
        this.apiKey = apiKey;
    }

    public void createInvoice(String customer) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.stripe.com/v1/invoices"))
                .POST(HttpRequest.BodyPublishers.ofString("customer=" + customer))
                .setHeader("Authorization", "Bearer " + apiKey)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            JSONObject data = (JSONObject) new JSONTokener(response.body()).nextValue();
            String id = data.getString("id");
            System.out.println("Succesfully created invoice with id: " + id);
        } else {
            JSONObject data = (JSONObject) new JSONTokener(response.body()).nextValue();
            String message = data.getJSONObject("error").getString("message");
            System.err.println("Encountered an error while creating invoice: " + message);
        }
    }

    public JSONObject getInvoice(String invoiceId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.stripe.com/v1/invoices/" + invoiceId))
                .GET()
                .setHeader("Authorization", "Bearer " + apiKey)
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject data = (JSONObject) new JSONTokener(response.body()).nextValue();
        if (response.statusCode() == 200) {
            return data;
        } else {
            String message = data.getJSONObject("error").getString("message");
            System.err.println("Encountered an error while creating invoice: " + message);
            return null;
        }
    }
}
