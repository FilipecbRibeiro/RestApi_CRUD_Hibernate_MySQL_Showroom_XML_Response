package org.light.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.light.showroom.hibernate.entities.BrandEntity;

public class BrandsDAOImplementation implements BrandsDAO{
	
	SessionFactory factory  = new Configuration()
							      .configure("hibernate.cfg.xml")
							      .addAnnotatedClass(BrandEntity.class)
							      .buildSessionFactory();

	@Override
	public List<BrandEntity> getListBrandsEntities() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<BrandEntity> listofBrands = (List<BrandEntity>)session.createQuery("from brandentity").getResultList();//
		//"from brandentity " ----> brandEntity because on org.light.showroom.hibernate.entities @Entity(name="brandentity")
		session.getTransaction().commit();
		session.close();
		return listofBrands;
	}

	@Override
	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public void updateBrand(BrandEntity updateBrand) {
	
		Session session= factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brandToUpdate = session.get(BrandEntity.class, updateBrand.getBrandId());//old version of brand to update
		brandToUpdate.setBrandName(updateBrand.getBrandName());
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brandtoDelete = session.get(BrandEntity.class, brandId);
		session.delete(brandtoDelete);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
