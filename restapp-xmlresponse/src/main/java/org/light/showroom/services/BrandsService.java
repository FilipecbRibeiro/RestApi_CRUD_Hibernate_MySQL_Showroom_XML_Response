package org.light.showroom.services;

import java.util.List;

import org.light.showroom.hibernate.DAO.BrandsDAO;
import org.light.showroom.hibernate.DAO.BrandsDAOImplementation;
import org.light.showroom.hibernate.entities.BrandEntity;


public class BrandsService {

	private BrandsDAO DAO= new BrandsDAOImplementation();
	
	
	
	public List<BrandEntity> getBrands() {
		//Calling Data Object Access method to add brand
		List<BrandEntity> listofBrandsEntity = DAO.getListBrandsEntities();
		return listofBrandsEntity;
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
		//Calling Data Object Access method to add brand
	}

	public void updateBrand(BrandEntity updateBrand) {
		//Calling Data Object Access method to update brand
		
		DAO.updateBrand(updateBrand);
	}

	public void delete(int brandId) {
		//Calling Data Object Access method to delete brand
		DAO.deleteBrand(brandId);
	}


}
