package org.light.showroom.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity(name = "brandentity")
@Table(name="brands")
public class BrandEntity {
		
		@Id
		@Column(name ="brandId" )
		private int brandId; 
		@Column(name ="brandName" )
		private String brandName;
		public BrandEntity() {
		
		}
		public BrandEntity(int brandId, String brandName) {
		
			this.brandId = brandId;
			this.brandName = brandName;
		}
		public int getBrandId() {
			return brandId;
		}
		public void setBrandId(int brandId) {
			this.brandId = brandId;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		@Override
		public String toString() {
			return "BrandEntity [brandId=" + brandId + ", brandName=" + brandName + "]";
		}
		
		
}
