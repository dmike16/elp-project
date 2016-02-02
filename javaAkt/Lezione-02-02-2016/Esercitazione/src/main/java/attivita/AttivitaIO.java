package attivita;

import dominio.Agenzia;
import dominio.*;
import java.util.List;
import java.util.Date;
import dmike.utils.inout.StdIO;
import dmike.utils.inout.NotValidDateException;

public class AttivitaIO{

	public static Agenzia leggiAgenzia(){
		// Far Inserire i Date dell agenzia
		String nome = StdIO.getStdIO().getStringNotNull("Inserisci nome azienda");
		String localita = StdIO.getStdIO().getStringNotNull("Inserisci localita azienda");
		double bilancio = StdIO.getStdIO().getDoubleNotNull("Inserisci nome azienda");

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
			int scelta = StdIO.getStdIO().getIntNotNull(
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
					StdIO.getStdIO().coutln("Scenta non ammessa");
					break;
			}
		}
		return null;
	}

	public static void menuPrincipale(Agenzia agenzia){

		while(true){
			int scelta = StdIO.getStdIO().getIntNotNull(
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
				  StdIO.getStdIO().close();
					System.exit(0);
				default:
					StdIO.getStdIO().coutln("Scelta non ammessa");
					break;
			}
		}
	}
	public static void menuGestione(Agenzia agenzia){
		boolean indietro = false;
		while(!indietro){
			int scelta = StdIO.getStdIO().getIntNotNull(
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
						StdIO.getStdIO().coutln("Cliente Inserito Con successo "+
							nuovoC);
					}
					break;
				case 2:
					Veicolo nuovoV = leggiVeicolo();
					if (nuovoV != null){
						agenzia.inserisciVeicolo(nuovoV);
						StdIO.getStdIO().coutln("Veicolo Inserito Con Successo " +
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
					StdIO.getStdIO().coutln("Scelta non ammessa");
					break;
			}
		}
	}
	public static void visualizzaVeicoli(Agenzia agenzia, boolean disp){
		List<Veicolo> veicoli = agenzia.getVeicoli();
		if (veicoli.isEmpty()){
			StdIO.getStdIO().coutln("Non ci sono veicoli registrati");
			return;
		}
		StdIO.getStdIO().coutln("Lista Veicoli:");
		for(int i = 0, len = veicoli.size(); i < len; i++){
			if (disp && veicoli.get(i).isDisponibile()){
				StdIO.getStdIO().coutln("Indice: [" + i + "]\n"
				+ veicoli.get(i).getClass().getSimpleName()+ " " +
				veicoli.get(i) + "\n");
			} else if(!disp){
				StdIO.getStdIO().coutln("Indice: [" + i + "]\n"
					+ veicoli.get(i).getClass().getSimpleName()+ " " +
					veicoli.get(i) + "\n");
			}
		}
	}
	public static void visualizzaClienti(Agenzia agenzia){
		List<Cliente> clienti = agenzia.getClienti();
		if (clienti.isEmpty()) {
			StdIO.getStdIO().coutln("Non ci sono Clienti");
			return;
		}
		StdIO.getStdIO().coutln("Lista Clienti:");
		for(int i = 0, len = clienti.size(); i < len; i++){
			StdIO.getStdIO().coutln("Indice: [" + i + "]\n" +
				" " + clienti.get(i)  + "\n");
		}
	}
	public static void nuovoNoleggio(Agenzia agenzia){
		visualizzaClienti(agenzia);
		int idCliente = StdIO.getStdIO().getIntNotNull("Inserisce indice cliente");

		Cliente clienteSel = agenzia.getClienti().get(idCliente);
		if(clienteSel == null){
			StdIO.getStdIO().coutln("Cliente non valido");
			return;
		}

		visualizzaVeicoli(agenzia,true);
		int idVeicolo = StdIO.getStdIO().getIntNotNull("Inserisce Veicolo da noleggiare");
		Veicolo veicoloSel = agenzia.getVeicoli().get(idVeicolo);
		if(veicoloSel == null){
			StdIO.getStdIO().coutln("Veicolo non valido");
			return;
		}

		Date data = null;
		try{
			data = StdIO.getStdIO().getDateNotNull("Inserisci data inizio noleggio");
		} catch(NotValidDateException e){
			StdIO.getStdIO().coutln("Data non valida presa la data di oggi");
			data = new Date();
		}
		Noleggio nuovoN = new Noleggio(clienteSel,veicoloSel,data);
		agenzia.inserisciNoleggio(nuovoN);
		StdIO.getStdIO().coutln("Noleggio aggiunto con success " + nuovoN);
	}
	public static void terminaNoleggio(Agenzia agenzia){
		visualizzaNoleggiNonTerminati(agenzia);
		int idNoleggio = StdIO.getStdIO().getIntNotNull("Inserisci noleggio");
		Noleggio noleggioSel = agenzia.getNoleggiNonTerminati().get(idNoleggio);
		if (noleggioSel != null){
			StdIO.getStdIO().coutln("Selizione non andata a buon fine");
		}
		double costo = agenzia.terminaNoleggio(noleggioSel);
		if(costo != -1){
			StdIO.getStdIO().coutln("Noleggio terminto:\n" +
				noleggioSel + "\n" +
				"Costo Manutenzione: " + costo);
		}
	}
	public static void visualizzaNoleggiTerminati(Agenzia agenzia){

	}
	public static void visualizzaNoleggiNonTerminati(Agenzia agenzia){
		List<Noleggio> noleggi = agenzia.getNoleggiNonTerminati();
		if(noleggi == null){
			StdIO.getStdIO().coutln("Non ci sono noleggi non terminati");
			return;
		}
		for(int i = 0,len = noleggi.size(); i < len; i++){
				StdIO.getStdIO().coutln("Indice: [" + i + "]\n" +
				" " + noleggi.get(i)  + " non terminati\n");
		}
	}
}
