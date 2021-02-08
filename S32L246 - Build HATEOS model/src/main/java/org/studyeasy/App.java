package org.studyeasy;

//import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.studyeasy.model.Brand;


//@Path("app")
public class App {
	
	static Client client = ClientBuilder.newClient();
	static WebTarget baseBrandURL = client.target("http://localhost:8080/S30L227/showroom/brands");
	static WebTarget brandURL = baseBrandURL.path("{brandId}");
	
	public static void main(String[] args) {
		
	
		/*Brand[] response = baseBrandURL.request(MediaType.APPLICATION_JSON)		
				.get(Brand[].class); //get array of brand object
		
		for (Brand brand : response){
			System.out.println(brand.displayBrand());
		}*/
		
		
		/*Brand specificBrand = brandURL
				.resolveTemplate("brandId", "1")
				.request()
				.get(Brand.class);
		System.out.println(specificBrand);*/
		
		//posting the information		
		Response response = baseBrandURL.request()		
				.post(Entity.json(new Brand("New Brand1")));
		System.out.println(response.readEntity(Brand.class).displayBrand());
	}
}

// Open the project S30L227 - HATEOAS
// Run both the application with the below link
// http://localhost:8080/S32L246

// Run as Java application