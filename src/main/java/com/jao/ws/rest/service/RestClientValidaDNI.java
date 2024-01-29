package com.jao.ws.rest.service;

import com.jao.ws.rest.vo.VODocumentoDNI;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestClientValidaDNI {
	public static void main(String arg[]){
		String endPoint="http://localhost:8080/jaodni/services/jaoRest/validarDNI";
		VODocumentoDNI vo = new VODocumentoDNI();
		vo.setNombre("Gorka.");
		vo.setApellidos("De Goñi");
		//vo.setDni("Y2894141L");
		vo.setDni("37966238T");
		vo.setSexo("Masculino");
		vo.setValido(false);
		System.out.println("###################################################");
		System.out.println("INI INVOKE REST SERVICE [SW Rest] "+endPoint);
		System.out.println("###################################################");
		ClientConfig clientConfig = new DefaultClientConfig(); 
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		//ENDPOINT
		WebResource webResource= client.resource(endPoint);
		//podriamos hacer una peticion gets xml
		//ClientResponse response = webResource.type("application/xml").get(ClientResponse.class,vo);
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,vo);
		
		vo = response.getEntity(VODocumentoDNI.class);
		System.out.println("Response: [El DNI] "+vo.getDni());
		System.out.println("Response: [RES DNI valido] "+vo.isValido());
		System.out.println("###################################################");
		System.out.println("FIN INVOKE REST SERVICE [SW Rest] "+endPoint);
		System.out.println("###################################################");
		
	}
}
