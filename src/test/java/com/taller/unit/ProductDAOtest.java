package com.taller.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller.boot.Taller1Application;
import com.taller.dao.implementations.ProductDaoImp;
import com.taller.model.Product;
import com.taller.model.Productcategory;
import com.taller.model.Productsubcategory;
import com.taller.model.Unitmeasure;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = Taller1Application.class)
class ProductDAOtest {

	@Autowired
	private ProductDaoImp pd;
	
	@Test
	public void save() {
		Productcategory pc1 = new Productcategory();
		pc1.setName("Comida");
		
		Productsubcategory psc1 = new Productsubcategory();
		psc1.setName("Fruta");
		psc1.setProductcategory(pc1);
		
		Unitmeasure um1 = new Unitmeasure();
		um1.setName("kg");
		Unitmeasure um2 = new Unitmeasure();
		um2.setName("pounds");
		
		Product p1 = new Product();
		p1.setName("Piña");
		p1.setDaystomanufacture(360);
		p1.setProductnumber("123");
		p1.setProductsubcategory(psc1);
		p1.setUnitmeasure1(um1);
		p1.setUnitmeasure2(um2);
		
		pd.save(p1);
		assertTrue(pd.findAll().size() == 5);
	}
	
	@Test
	public void edit() {
		Product p = pd.findById(1);
		
		p.setName("cambiado");
		
		pd.update(p);
		
		assertTrue(pd.findById(1).getName().equals("cambiado"));
	}
	
	@Test
	public void find() {
		Product p = pd.findById(3);
		
		assertTrue(p.getName().equals("perico"));
	}
	
	@Test
	public void findAll() {
		assertTrue(pd.findAll().size() == 4);
	}

}
