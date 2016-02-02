package attivita;

import dominio.Agenzia;
import dominio.*;
import java.util.List;
import java.util.Date;

public class AttivitaIO{

	public static Agenzia leggiAgenzia(){
		// Far Inserire i Date dell agenzia 
		String nome = View.getStringNoNull("Inserisci nome azienda");
		String localita = View.getStringNoNull("Inserisci localita azienda");
		double bilancio = View.getDoubleNonNull("Inserisci nome azienda");

		return  new Agenzia(nome,localita,bilancio);
	}

	public static Auto leggiAuto(){
		return null;
	}
	public static Bicicletta leggiBici(){
		return null;
	}
	public static Camion leggiCamion(){
		return null;
	}
	public static Cliente leggiCliente(){
		return null;
	}
	public static Veicolo leggiVeicolo(){
		boolean indietro = false;
		while(!indietro){
			int scelta = View.getIntNonNull(
				"[1] Auto\n" +
				"[2] Camion\n"+
				"[3] Bicicletta\n"+
				"[0] Indietro\n");

			switch(scelta){
				case 1:
					return leggiAuto();
				case 2:
					return leggiCamion();
				case 3:
					return leggiBici();
				case 0:
					indietro = true;
					break;
				default:
					System.out.println("Scenta non ammessa");
					break;
			}
		}
		return null;
	}

	public static void menuPrincipale(Agenzia agenzia){
		
		while(true){
			int scelta = View.getIntNonNull(
				agenzia.getNome() + " " + agenzia.getLocalita() + " " +
				"Bilancio " + agenzia.getBilancio() +"\n" +
				"[1] Gestione Agenzia\n" +
				"[2] Nuovo Noleggio\n"+
				"[3] Termina Noleggio\n"+
				"[4] Visualizza Noleggio non Terminati\n"+
				"[5] Visualizza noleggi terminti\n"+
				"[0] Esci\n");

			switch(scelta){
				case 1:
					menuGestione(agenzia);
					break;
				case 2:
					nuovoNoleggio(agenzia);
					break;
				case 3:
					terminaNoleggio(agenzia);
					break;
				case 4:
					visualizzaNoleggiNonTerminati(agenzia);
					break;
				case 5:
					visualizzaNoleggiTerminati(agenzia);
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Scelta non ammessa");
					break;
			}
		}
	}
	public static void menuGestione(Agenzia agenzia){
		boolean indietro = false;
		while(!indietro){
			int scelta = View.getIntNonNull(
				"[1] Nuovo Cliente\n" +
				"[2] Nuovo Veicolo\n"+
				"[3] Visualizza Clienti\n"+
				"[4] Visualizza Veicoli\n"+
				"[0] Indietro\n");

			switch(scelta){
				case 1:
					Cliente nuovoC = leggiCliente();
					if (nuovoC != null){
						agenzia.inserisciCliente(nuovoC);
						System.out.println("Cliente Inserito Con successo "+ 
							nuovoC); 
					}
					break;
				case 2:
					Veicolo nuovoV = leggiVeicolo();
					if (nuovoV != null){
						agenzia.inserisciVeicolo(nuovoV);
						System.out.println("Veicolo Inserito Con Successo " +
							nuovoV);
					}
					break;
				case 3:
					visualizzaClienti(agenzia);
					break;
				case 4:
					visualizzaVeicoli(agenzia,false);
					break;
				case 0:
					indietro = true;
					break;
				default:
					System.out.println("Scelta non ammessa");
					break;
			}
		}
	}
	public static void visualizzaVeicoli(Agenzia agenzia, boolean disp){
		List<Veicolo> veicoli = agenzia.getVeicoli();
		if (veicoli.isEmpty()){
			System.out.println("Non ci sono veicoli registrati");
			return;
		}
		System.out.println("Lista Veicoli:");
		for(int i = 0, len = veicoli.size(); i < len; i++){
			if (disp && veicoli.get(i).isDisponibile()){
				System.out.println("Indice: [" + i + "]\n" 
				+ veicoli.get(i).getClass().getSimpleName()+ " " +
				veicoli.get(i) + "\n");	
			} else if(!disp){
				System.out.println("Indice: [" + i + "]\n" 
					+ veicoli.get(i).getClass().getSimpleName()+ " " +
					veicoli.get(i) + "\n");
			}
		}
	}
	public static void visualizzaClienti(Agenzia agenzia){
		List<Cliente> clienti = agenzia.getClienti();
		if (clienti.isEmpty()) {
			System.out.println("Non ci sono Clienti");
			return;
		}
		System.out.println("Lista Clienti:");
		for(int i = 0, len = clienti.size(); i < len; i++){
			System.out.println("Indice: [" + i + "]\n" +
				" " + clienti.get(i)  + "\n");
		}
	}
	public static void nuovoNoleggio(Agenzia agenzia){
		visualizzaClienti(agenzia);
		int idCliente = View.getIntNonNull("Inserisce indice cliente");

		Cliente clienteSel = agenzia.getClienti().get(idCliente);
		if(clienteSel == null){
			System.out.println("Cliente non valido");
			return;
		}

		visualizzaVeicoli(agenzia,true);
		int idVeicolo = View.getIntNonNull("Inserisce Veicolo da noleggiare");
		Veicolo veicoloSel = agenzia.getVeicoli().get(idVeicolo);
		if(veicoloSel == null){
			System.out.println("Veicolo non valido");
			return;
		}

		Date data = View.getDate("Inserisci data inizio noleggio");
		Noleggio nuovoN = new Noleggio(clienteSel,veicoloSel,data);
		agenzia.inserisciNoleggio(nuovoN);
		System.out.println("Noleggio aggiunto con success " + nuovoN);
	}
	public static void terminaNoleggio(Agenzia agenzia){
		visualizzaNoleggiNonTerminati(agenzia);
		int idNoleggio = View.getIntNonNull("Inserisci noleggio");
		Noleggio noleggioSel = agenzia.getNoleggiNonTerminati().get(idNoleggio);
		if (noleggioSel != null){
			System.out.println("Selizione non andata a buon fine");
		}
		double costo = agenzia.terminaNoleggio(noleggioSel);
		if(costo != -1){
			System.out.println("Noleggio terminto:\n" +
				noleggioSel + "\n" +
				"Costo Manutenzione: " + costo);
		}
	}
	public static void visualizzaNoleggiTerminati(Agenzia agenzia){
		
	}
	public static void visualizzaNoleggiNonTerminati(Agenzia agenzia){
		List<Noleggio> noleggi = agenzia.getNoleggiNonTerminati();
		if(noleggi == null){
			System.out.println("Non ci sono noleggi non terminati");
			return;
		}
		for(int i = 0,len = noleggi.size(); i < len; i++){
				System.out.println("Indice: [" + i + "]\n" +
				" " + noleggi.get(i)  + " non terminati\n");		
		}
	}
}