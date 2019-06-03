package ar.edu.iua.soa.banco.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ar.edu.iua.soa.banco.model.dto.TransaccionDTO;

@RestController
@Component
public class TransaccionRestController {

	public TransaccionDTO sentDataToTx(TransaccionDTO tx) {
		
		Gson gson = new Gson();
		String json = gson.toJson(tx);
		HttpClient httpClient = HttpClientBuilder.create().build();
		String responseString = "";

		try {
			System.out.println("\n\nIntenta ir al servicio herokuapp...\n\n");

			HttpPost request = new HttpPost("https://iua-service.herokuapp.com/transferir");
			StringEntity params = new StringEntity(json);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			responseString = new BasicResponseHandler().handleResponse(response);
			// ResponseString: {"estado":"OK","codigo":"8"}
			System.out.println("ResponseString: " + responseString);
			boolean flag = true;
			for( int i = 0; i < responseString.length(); i++) {
				String value = "";
				if(responseString.charAt(i) == ':') {
					int j = i + 2;
					while(responseString.charAt(j) != '"') {
						value = value + responseString.charAt(j);
						j++;
					}
					if(flag) {
						tx.setEstado(value);
						flag = false;
					} else {
						tx.setCodigo(value);
					}
				}
			}
			
			System.out.println("TRANSACCION: " + tx.toString());

		} catch (Exception ex) {
			System.out.println(ex);

		}
		return tx;
		
	}
}
