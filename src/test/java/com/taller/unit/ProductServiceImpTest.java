package com.taller.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taller.dao.implementations.DocumentDaoImp;
import com.taller.dao.implementations.ProductDaoImp;
import com.taller.dao.implementations.TransactionhistoryDaoImp;
import com.taller.model.Product;
import com.taller.model.Productcategory;
import com.taller.model.Productsubcategory;
import com.taller.model.Unitmeasure;
import com.taller.model.Vendor;
import com.taller.repository.interfaces.ProductdocumentRepository;
import com.taller.repository.interfaces.ProductsubcategoryRepository;
import com.taller.repository.interfaces.UnitmeasureRepository;
import com.taller.service.implementations.ProductServiceImp;

class ProductServiceImpTest {
	
	private ProductDaoImp pr;
	
	private Product p1;
	
	@Autowired
	public ProductServiceImpTest() {
		this.pr = new ProductDaoImp();
	}
	
	@BeforeEach
	public void beforeEach() {
		Productcategory pc1 = new Productcategory();
		pc1.setName("Comida");
		/*Productcategory pc2 = new Productcategory();
		pc2.setName("Drogas");*/
		
		Productsubcategory psc1 = new Productsubcategory();
		psc1.setName("Fruta");
		psc1.setProductcategory(pc1);
		/*Productsubcategory psc2 = new Productsubcategory();
		psc2.setName("Chatarra");
		psc2.setProductcategory(pc1);
		Productsubcategory psc3 = new Productsubcategory();
		psc3.setName("Coca");
		psc3.setProductcategory(pc2);
		Productsubcategory psc4 = new Productsubcategory();
		psc4.setName("Mari");
		psc4.setProductcategory(pc2);*/
		
		Unitmeasure um1 = new Unitmeasure();
		um1.setName("kg");
		Unitmeasure um2 = new Unitmeasure();
		um2.setName("pounds");
		Unitmeasure um3 = new Unitmeasure();
		um3.setName("m");
		Unitmeasure um4 = new Unitmeasure();
		um4.setName("inches");
		
		p1 = new Product();
		p1.setName("Piña");
		p1.setDaystomanufacture(360);
		p1.setProductnumber("123");
		p1.setProductsubcategory(psc1);
		p1.setUnitmeasure1(um3);
		p1.setUnitmeasure2(um1);
		/*Product p4 = new Product();
		p4.setName("anvorgesa");
		p4.setDaystomanufacture(1);
		p4.setProductnumber("937");
		p4.setProductsubcategory(psc2);
		p4.setUnitmeasure1(um3);
		p4.setUnitmeasure2(um2);
		Product p2 = new Product();
		p2.setName("perico");
		p2.setDaystomanufacture(30);
		p2.setProductnumber("666");
		p2.setProductsubcategory(psc3);
		p2.setUnitmeasure1(um4);
		p2.setUnitmeasure2(um2);
		Product p3 = new Product();
		p3.setName("guana");
		p3.setDaystomanufacture(90);
		p3.setProductnumber("420");
		p3.setProductsubcategory(psc4);
		p3.setUnitmeasure1(um4);
		p3.setUnitmeasure2(um1);*/
	}
	
	@Test
	public void saveTest() {
		pr.save(p1);
		assertNotNull(pr.findById(p1.getProductid()));
	}
	
	/*@Test
	public void editTest() {
		
	}
	
	@Test
	public void deleteTest() {
		
	}
	
	@Test
	public void consult1Test() {
		
	}
	
	@Test
	public void consult2Test() {
		
	}*/
	
	@AfterEach
	public void afterEach() {
		
	}

}
