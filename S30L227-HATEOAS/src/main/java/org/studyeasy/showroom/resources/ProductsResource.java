package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.model.Product;
import org.studyeasy.showroom.services.ProductsService;

@Path("/showroom/brands")
public class ProductsResource {

	ProductsService productsService = new ProductsService();
	
	@GET //retrieve information	from 2 tables (brands,products)
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category, @QueryParam("start") int start,
			@QueryParam("end") int end){
		
		List<Product> productList;
		
		if(category != null){
			productList = productsService.getProductsByBrandAndCategory(brandId, category);
		}else{
		productList = productsService.getProductsByBrand(brandId);
		}
		if(end > 0){
			productList = productList.subList(start, end);
		}
		return productList;
	}
}
