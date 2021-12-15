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
import com.taller.dao.implementations.ProductDaoImp;
import com.taller.model.Document;
import com.taller.model.Product;
import com.taller.model.Productcategory;
import com.taller.model.Productsubcategory;
import com.taller.model.Unitmeasure;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = Taller1Application.class)
class DocumentDAOtest {

	@Autowired
	private DocumentDaoImp pd;
	
	@Test
	public void save() {
		Document d1 = new Document();
		d1.setFileextension("docx");
		d1.setFilename("salud2");
		d1.setModifieddate(LocalDate.of(2021, 11, 10));
		d1.setTitle("titulazo");
		
		pd.save(d1);
		assertTrue(pd.findAll().size() == 3);
	}
	
	@Test
	public void edit() {
		Document p = pd.findById(1);
		
		p.setFilename("cambiado");
		
		pd.update(p);
		
		assertTrue(pd.findById(1).getFilename().equals("cambiado"));
	}
	
	@Test
	public void find() {
		Document p = pd.findById(2);
		
		assertTrue(p.getFilename().equals("salud3"));
	}
	
	@Test
	public void findAll() {
		assertTrue(pd.findAll().size() == 2);
	}

}
