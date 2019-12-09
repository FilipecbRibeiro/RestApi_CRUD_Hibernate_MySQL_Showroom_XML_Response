package org.light.showroom.hibernate.DAO;

import java.util.List;

import org.light.showroom.hibernate.entities.BrandEntity;

public interface BrandsDAO {
	
	public List<BrandEntity> getListBrandsEntities();
	public void addBrand(BrandEntity brand);
	public void updateBrand(BrandEntity updateBrand);
	public void deleteBrand(int brandId);
	
	}

