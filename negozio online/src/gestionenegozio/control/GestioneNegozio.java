

package gestionenegozio.control;

import java.time.LocalDate;
//import java.time.LocalDate; 
import java.util.ArrayList;

import gestionenegozio.entity.*;

public class GestioneNegozio {
	
	private ArrayList<Cliente> clienti = new ArrayList<Cliente>();
	private ArrayList<Prodotto> catalogo = new ArrayList<Prodotto>();

	
	public GestioneNegozio() {
		catalogo.add(new Prodotto(1,"detersivo",2,10));
		catalogo.add(new Prodotto(2,"shampoo",1,10));
		catalogo.add(new Prodotto(3,"bagnoschiuma",2,10));
		catalogo.add(new Prodotto(4,"candegina",3,10));
		catalogo.add(new Prodotto(5,"balsamo",4,10));
		catalogo.add(new Prodotto(6,"doccia-shampoo",2,10));
		catalogo.add(new Prodotto(7,"crema",1,10));
		catalogo.add(new Prodotto(8,"smalto",3,10));
	}
	
	public ArrayList<Prodotto> getCatalogo() {
		return catalogo;
		
	}
	
	public void registraCliente(Cliente c) {
		clienti.add(c);
	}
	
	 public void effettuaPagamento(Cliente c,int id, LocalDate data, StatoSpesa s) {
		  
		  Spesa spesa = new Spesa(id,data,s,c.getCarrelli());  // sto prendendo il carrello che � un array di prodotti ch eha anche la quantit�
		  if(clienti.contains(c)){
		   c.aggiungiSpesa(spesa);
		   c.count();
		   /*for (int i=0 ; i<clienti.size() ; i++) {
		    for (int j=0 ; j<clienti.get(i).getSpesa().size(); j++) {
		     for (int n=0; n<clienti.get(i).getSpesa().get(j).getPro().size(); n++) {
		      for (int k=0; k<catalogo.size();k++) {
		       if(catalogo.get(k).getCodice() == clienti.get(i).getSpesa().get(j).getPro().get(n).getProdotto().getCodice()) {
		        catalogo.get(k).riduciQuantita(clienti.get(i).getSpesa().get(j).getPro().get(n).getQta());
		       }
		       else
		        return;
		      }
		     }
		    }
		   } */
		   c.getCarrelli().clear();
		  }
		  else {
		  
		  c.aggiungiSpesa(spesa);
		  c.count();
		  /*for (int i=0 ; i<clienti.size() ; i++) {
		   for (int j=0 ; j<clienti.get(i).getSpesa().size(); j++) {
		    for (int n=0; n<clienti.get(i).getSpesa().get(j).getPro().size(); n++) {
		     for (int k=0; k<catalogo.size();k++) {
		      if(catalogo.get(k).getCodice() == clienti.get(i).getSpesa().get(j).getPro().get(n).getProdotto().getCodice()) {
		       catalogo.get(k).riduciQuantita(clienti.get(i).getSpesa().get(j).getPro().get(n).getQta());
		      }
		      else
		       return;
		     }
		    }
		   }
		  } */
		  c.getCarrelli().clear();
		  clienti.add(c);
		  }
		  
		  
		 }
	
	public int generaReport() {
		
		int k = 0;
		for(int i = 0; i < clienti.size(); i++) {
			
			int costo = 0;
			
			for(int j = 0; j < clienti.get(i).getSpesa().size();j++) {
				
				Spesa s = clienti.get(i).getSpesa().get(j);
				costo += s.calcolaPrezzo();
			}
			
			int n = clienti.get(i).getNumeroSpese();
			
			if(n >= 2) {
			System.out.println("il cliente " + clienti.get(i).getNome() + " ha fatto  " + n + " spese e ha pagato in totale " + costo + " euro");
			k++;
			}		
	}
		if(k == 0)
			System.out.println("non ci sono clienti abituali");
		
		System.out.println("");
		
		return k;

}
}



