package gf_eparking_customer_client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import gf_eparking_customer.model.gf_AuthentificationCustomer;
import gf_eparking_customer.model.gf_NetworkCustomer;



public class gf_customer_social_client {

	public static void accessClient(gf_customer_social_customer customer_client)
	{
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.
			target("http://socialnetworkusers.azurewebsites.net/api").path("Users");
		
		Invocation.Builder invocationBuilder =  webTarget.
				request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.
				post(Entity.entity(customer_client, MediaType.APPLICATION_JSON));
		
		gf_NetworkCustomer networkCustomer = new gf_NetworkCustomer();
		

		networkCustomer = response.readEntity(gf_NetworkCustomer.class);
		
		
		
		gf_AuthentificationCustomer authentificationCustomer = 
	    new gf_AuthentificationCustomer(networkCustomer.getUser().getId(),
									networkCustomer.getAuthentificationToken());
		
		accessClientAuthentification(authentificationCustomer);
	}
	
	
	public static void accessClientAuthentification(gf_AuthentificationCustomer 
			authentificationCustomer)
	{
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client
			.target("http://socialnetworkusers.azurewebsites.net/api")
			.path("Users/ActivateUser")
			.queryParam("id", authentificationCustomer.getId())
			.queryParam("authenticationToken", authentificationCustomer.
					getAuthenticationToken());
		
		Invocation.Builder invocationBuilder =  webTarget.
				request(MediaType.APPLICATION_JSON);
		
		
		Response response = invocationBuilder.
				post(Entity.entity(Entity.json(null), MediaType.APPLICATION_JSON));
	
	}
	
	
	
	
	
}
