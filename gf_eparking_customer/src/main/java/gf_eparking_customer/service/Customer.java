package gf_eparking_customer.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


import gf_eparking_customer.model.gf_Customer;

@Api(value="customer",description="E-Park customer")
@Path("customer")



public class Customer {

	
	gf_Customer customer_obj = new gf_Customer();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find all customer, Find customer in a range")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
    		@ApiResponse(code = 404, message = "No Content"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
	
	public List<gf_Customer> getCustomerPar(@QueryParam("von") int von, @QueryParam("bis") int bis)
	{
		if(von > 0 && bis > 0)
		{
			return customer_obj.getCustomerfromto(von, bis);
		}
				
		return customer_obj.get_all_Customer();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Add customer")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "CREATED"),
			@ApiResponse(code = 404, message = "Wrong Data"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
	
	public Response addCustomer(gf_Customer customer, @Context UriInfo uriInfo) throws URISyntaxException
	{
		gf_Customer newCustomer = customer_obj.customer_add(customer);
		String customerid = String.valueOf(newCustomer.getCustomerNr());
		URI uri = uriInfo.getAbsolutePathBuilder().path(customerid).build();
		
		return Response.created(uri).entity(newCustomer).build();
		
	}
	
	@DELETE
	@Path("/{customerNr}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Delete customer")
	@ApiResponses(value = {@ApiResponse(code = 202, message = "ACCEPTED"),
			@ApiResponse(code = 404, message = "No Content"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
	public void deleteCustomer(@PathParam("customerNr") int customerNr)
	{
		customer_obj.removeCustomer(customerNr);
	}
	
	
	@PUT
	@Path("/{customerNr}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation("Modify customer")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
	
	public gf_Customer modifyCustomer(@PathParam("customerNr") int customerNr, gf_Customer customer) {
	
	
	
		customer_obj.setCustomerNr(customerNr);
		
		return customer_obj.customer_modify(customer);
	      
				
		
		//return customer.customer_modify(customer);
	}
	
	@GET
	@Path("/{customerNr}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Find customer by id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "No Content"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
	
	public gf_Customer getCustomer(@PathParam("customerNr") int customerNr)
	{
		return customer_obj.getCustomer(customerNr);
	}
}
