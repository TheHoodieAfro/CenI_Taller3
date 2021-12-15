package com.taller.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taller.boot.Taller1Application;
import com.taller.dao.implementations.DocumentDaoImp;
import com.taller.dao.implementations.VendorDaoImp;
import com.taller.model.Document;
import com.taller.model.Vendor;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = Taller1Application.class)
class VendorDAOtest {

	@Autowired
	private VendorDaoImp pd;
	
	@Test
	public void save() {
		Vendor v1 = new Vendor();
		v1.setName("Cristian Sanchez");
		
		pd.save(v1);
		assertTrue(pd.findAll().size() == 3);
	}
	
	@Test
	public void edit() {
		Vendor p = pd.findById(1);
		
		p.setName("cambiado");
		
		pd.update(p);
		
		assertTrue(pd.findById(1).getName().equals("cambiado"));
	}
	
	@Test
	public void find() {
		Vendor p = pd.findById(2);
		
		assertTrue(p.getName().equals("dotor uribito"));
	}
	
	@Test
	public void findAll() {
		assertTrue(pd.findAll().size() == 2);
	}

}
