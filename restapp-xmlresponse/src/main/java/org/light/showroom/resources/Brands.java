package org.light.showroom.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.light.showroom.hibernate.entities.BrandEntity;
import org.light.showroom.services.BrandsService;

@Path("/showroom")

public class Brands {
	
	private BrandsService brandsService = new BrandsService();//responsive for the service layer!!!
	//which will contain  an object of the type BrandsDAO;
	@GET
	@Path("/brands")
	@Produces(MediaType.APPLICATION_XML)//If we use text_plain jax-rs wont know how to convert it!!! 
	// we should use Application_XML but when we produce a XML Response jersey jax-rs definitely will 
	//require aditional info based on the list type in this case BrandEntity and we must 
	//specify on that BrandEntity with @XmlRootElement and jax  -rs will be able to convert the list into XML
	public List<BrandEntity> getBrands() {
		List<BrandEntity> listofBrands = brandsService.getBrands();
		
		for(BrandEntity run : listofBrands) {
			System.out.println(run);
		}
		return listofBrands;
	}
	
	
	
	@POST
	@Path("/brands")
	@Consumes(MediaType.APPLICATION_XML)
	//because it's void it won't produce anything so we will use the Annotation @Consume! 
	public void postBrands(BrandEntity brand) {
		
		brandsService.addBrand(brand);
	}
	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_XML)
	public void putBrands(@PathParam("brandId")int brandId, BrandEntity updateBrand) {
		
		
		updateBrand.setBrandId(brandId);
		//IN ORDER TO ADD AN ADDITIONAL LAYER OF CONSISTENCY WE SHOULD UPDATE BRAND OBJECT ID
		brandsService.updateBrand(updateBrand);
	}
	@DELETE
	@Path("/brands/{brandId}")
	
	public void deleteBrands(@PathParam("brandId")int brandId) {
		
		brandsService.delete(brandId);
	}

}
//If we add simply like this the post method wont work complaining about "method not allowed" because its a post method 
	//and we cant reach it by URI so what is the solution ? 
	//NOTE : browsers are limited so by default they are limited to the get request! 
	//		WE CAN EITHER USE EXTENSIONS ON THE WEB BROWSER OR PROGRAMS
	