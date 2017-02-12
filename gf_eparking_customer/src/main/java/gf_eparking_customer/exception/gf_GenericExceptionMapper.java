package gf_eparking_customer.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import gf_eparking_customer.model.gf_ErrorCustomer;

public class gf_GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		
		gf_ErrorCustomer errorcustomer = new gf_ErrorCustomer(ex.getMessage(),500,"http://109.73.158.173:8081/gf_eparking_customer/registration_customer.jsp");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorcustomer).build();
	}

}
