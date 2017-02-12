package gf_eparking_customer.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import gf_eparking_customer.model.gf_ErrorCustomer;

@Provider
public class gf_CustomerDeleteExceptionMapper implements ExceptionMapper<gf_CustomerDeleteException> {

	@Override
	public Response toResponse(gf_CustomerDeleteException ex) {
		// TODO Auto-generated method stub
		
		gf_ErrorCustomer error_customer = new gf_ErrorCustomer(ex.getMessage(), 202, "http://109.73.158.173:8081/gf_eparking_customer/registration_customer.jsp");
		return Response.status(Status.ACCEPTED).
				entity(error_customer).type(MediaType.APPLICATION_JSON).build();
	}

}
