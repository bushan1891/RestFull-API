package Resturant.egen.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Resturant.egen.dao.ResturantDAO;
import Resturant.egen.exception.AppException;
import Resturant.egen.model.Resturant;

@Path("/resturant")
public class ResturantController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List findRes() throws AppException{
		
		ResturantDAO dao = new ResturantDAO();
	
	    System.out.println(dao.fetchAll());
		return dao.fetchAll();
	}
	
	@GET
	@Path("/{res}")
	@Produces(MediaType.APPLICATION_JSON)
	public Resturant findOne(@PathParam("res") int resNo){
         	 
 	ResturantDAO dao = new ResturantDAO();
 	        
		return dao.fetchOne(resNo) ;
	}
	
	@POST
	@Path("/JSON")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String makeRes(){
		
		
		return "I am POST  ";
	}
	

}
