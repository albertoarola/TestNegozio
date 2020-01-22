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
	public void test1NessunClienteNumeroSpeseMinoriDiNUnProdotto() {
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		gestione.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.APRIL, 01), StatoSpesa.ORDINATA);
		
		c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		gestione.effettuaPagamento(c2,2, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
		
		int l = 0;
		l = gestione.generaReport();
		assertEquals(0,l);
	}
	
	@Test
	 public void test2UnClienteUnProdUnaQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  gestione.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.APRIL, 01), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c1,2, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	  
	 }
	 
	 @Test
	 public void test3UnClienteSpeseMaggaioriDiNUnProdUnaQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  gestione.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c1,2, LocalDate.of(2020, Month.APRIL, 03), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2),1);
	  gestione.effettuaPagamento(c1,2, LocalDate.of(2020, Month.APRIL, 04), StatoSpesa.ORDINATA);
	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	  
	 }
	 
	 
	 @Test
	 public void test4UnClientePiuProdUnaQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c1,2, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  gestione.effettuaPagamento(c1,0, LocalDate.of(2020, Month.APRIL, 03), StatoSpesa.ORDINATA);
	  
	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	  
	 }
	 
	 @Test
	 public void test5UnClientePiuProdPiuQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 2);
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 2);
	  gestione.effettuaPagamento(c1,2, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 2);
	  gestione.effettuaPagamento(c1,0, LocalDate.of(2020, Month.APRIL, 03), StatoSpesa.ORDINATA);
	  
	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	  
	 }
	 
	 @Test
	 public void test6UnClienteUnProdPiuQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 2);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,8), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.AUGUST,23), StatoSpesa.ORDINATA);
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	  
	 }
	 
	 @Test
	 public void test7PiuClientiUnProdUnaQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JANUARY,15), StatoSpesa.ORDINATA);
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.JANUARY,12), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2), 1);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.OCTOBER,21), StatoSpesa.ORDINATA);
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(3), 1);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.MARCH,1), StatoSpesa.ORDINATA);
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(2,l); // output atteso,output programma
	  
	 }
	 
	 @Test
	 public void test8PiuClientePiuProdUnaQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.SEPTEMBER,15), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2), 1);
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(3), 1);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.MARCH,2), StatoSpesa.ORDINATA);
	  
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.JUNE,9), StatoSpesa.ORDINATA);
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(2), 1);
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(3), 1);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.MARCH,11), StatoSpesa.ORDINATA);
	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(2,l); // output atteso,output programma
	  
	 }
	 
	 @Test
	 public void test9PiuClienteUnProdPiuQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 2);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,2), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2), 2);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.NOVEMBER,30), StatoSpesa.ORDINATA);
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 2);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.MARCH,5), StatoSpesa.ORDINATA);
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(2), 2);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.JANUARY,15), StatoSpesa.ORDINATA);
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(2,l); // output atteso,output programma
	  
	 }
	 

	 @Test
	 public void test10PiuClientePiuProdPiuQuant() {
	  
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 2);
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 2);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.AUGUST,5), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2), 2);
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(3), 2);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.DECEMBER,12), StatoSpesa.ORDINATA);
	  
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 2);
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(1), 2);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.SEPTEMBER,28), StatoSpesa.ORDINATA);
	  
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(2), 2);
	  c2.aggiungiAlCarrello(gestione.getCatalogo().get(3), 2);
	  gestione.effettuaPagamento(c2,2,LocalDate.of(2020,Month.NOVEMBER,25), StatoSpesa.ORDINATA);
	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(2,l); // output atteso,output programma
	 }
	 
	 @Test
	 public void test11UnClienteNessunProdUnaQuant() {
	  
	  
	 
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.MARCH,15), StatoSpesa.ORDINATA);
	  gestione.effettuaPagamento(c1,8,LocalDate.of(2020,Month.MAY,18), StatoSpesa.ORDINATA);
	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	 }
	 
	 
	 @Test
	 public void test12UnClienteUnProdNessunaQuant() {
	  
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2), 0);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.JULY,15), StatoSpesa.ORDINATA);
	  
	  c1.aggiungiAlCarrello(gestione.getCatalogo().get(2), 0);
	  gestione.effettuaPagamento(c1,2,LocalDate.of(2020,Month.APRIL,15), StatoSpesa.ORDINATA);
	  

	  
	  
	  int l;
	  l = gestione.generaReport(); //output del programma
	  assertEquals(1,l); // output atteso,output programma
	 }
	 
	

}
