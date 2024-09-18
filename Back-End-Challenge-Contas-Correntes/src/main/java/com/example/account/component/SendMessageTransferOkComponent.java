package com.example.account.component;


import com.example.account.record.MessageTransferDto;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class SendMessageTransferOkComponent {

    public ResponseEntity sendMessage() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://run.mocky.io/v3/fc2b4c52-0365-45b2-9005-4cd3a7d989a0"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            MessageTransferDto messageTransferDto = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create().fromJson(response.body(), MessageTransferDto.class);
            return ResponseEntity.ok().body(messageTransferDto);
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


}
