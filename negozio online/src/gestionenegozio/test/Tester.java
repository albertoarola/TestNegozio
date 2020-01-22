package gestionenegozio.test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gestionenegozio.control.GestioneNegozio;
import gestionenegozio.entity.Cliente;
import gestionenegozio.entity.StatoSpesa;

public class Tester {
	
	GestioneNegozio gestione;
	Cliente c1;
	Cliente c2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		gestione = new GestioneNegozio();
		 c1 = new Cliente("alberto","pass","081","533");
		 c2 = new Cliente("ele","pass","0212","1710");
		
	}

	@After
	public void tearDown() throws Exception {
		
		gestione = null;
		c1 = null;
		c2 = null;
	}

	@Test
	public void test1NessunClienteUnProdotto() {
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		
		gestione.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.APRIL, 01), StatoSpesa.ORDINATA);
		gestione.effettuaPagamento(c2,2, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
		
		int n = 0;
		n = gestione.generaReport();
		assertEquals(0,n);
	}

}
