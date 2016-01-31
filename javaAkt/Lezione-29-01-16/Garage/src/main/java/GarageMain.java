public class GarageMain{
	public static void main(String[] args){
		Garage garage = new Garage();
		
		Automobile auto = new Automobile(2003, "Lancia Y", "Gasol",
		"1200",5);
		garage.inserisciVeicolo(auto);

		Furgone furgo = new Furgone(2010,"Fiat Doblo","Gasol",
			"2000",2000);
		garage.inserisciVeicolo(furgo);

		Motocicletta moto = new Motocicletta(2011,"Bmw","Benzina","500",
			"Strada",4);
		garage.inserisciVeicolo(moto);

		garage.stampa();
	}
}