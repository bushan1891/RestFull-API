package Resturant.egen.RESTApp;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class ResturantApp extends ResourceConfig {

 public	ResturantApp(){
	 // once  /API is parsed it launches the constructor and forwards to package
		packages("Resturant.egen.rest");
	
 }
	
}
