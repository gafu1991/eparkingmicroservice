package gf_eparking_registration_customer.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import gf_eparking_registration_customer.model.gf_Customer;


@Path("/hello")
public class gf_interface_customer {


		  // This method is called if XML is request
		  @GET
		  @Produces(MediaType.APPLICATION_XML)
		  public gf_Customer customer() {
			gf_Customer cust = new gf_Customer(); 
			cust.setCity("Studenzen");
		    return cust;
		  }
		  
	
}
