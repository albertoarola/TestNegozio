import gestionenegozio.entity.*;

import java.time.LocalDate;
import java.time.Month;

import gestionenegozio.control.*;

public class Main {

	public static void main(String[] args) {

		
		Cliente c1 = new Cliente("alberto","pass","081","5333");
		Cliente c2 = new Cliente("ele","es","0812","1710");
		
		GestioneNegozio gestione = new GestioneNegozio ();
		
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
		c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		
		gestione.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.APRIL, 01), StatoSpesa.ORDINATA);
		gestione.effettuaPagamento(c2,2, LocalDate.of(2020, Month.APRIL, 02), StatoSpesa.ORDINATA);
		
		
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		
		gestione.effettuaPagamento(c1, 3, LocalDate.of(2020, Month.APRIL, 03), StatoSpesa.ORDINATA);
		gestione.generaReport(); 
		 
 
	}

}
