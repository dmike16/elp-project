public class UtilArray{
	public static void stampa(int[] arr){
	
		/*for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}*/
		for (int p : arr){
			System.out.print(p + " ");
		}
		System.out.println();
	}
	public static void stampa(int[][] matr){
		System.out.println("[");
		for(int i = 0, rows = matr.length; i < rows; i++, System.out.println()){
			System.out.print(" ");
			for(int j = 0; j < matr[i].length; j++){
				System.out.print(matr[i][j] + " ");
			}
		}
		System.out.println("]");
	}
	public static int contaOccorrenze(int[] arr, int x){
		int occ = 0;

		for(int i = 0; i < arr.length; i++){
			if (arr[i]  == x)
				occ++;
		}
		return occ;
	}
	public static int contaPari(int[] arr){
		int count = 0;

		for(int ele: arr){
			if ((ele & 1) == 0)
				count++;
		}
		return count;
	}
	public static int[] numeriPari(int[] arr){
		int[] pari = new int[contaPari(arr)];
		int tmp = 0;

		for(int i = 0; i < arr.length; i++){
			if ((arr[i] & 1) == 0){
				pari[tmp++] = arr[i];
			}
		}
		return pari;
	}
	public static double[] mediaMatrice(int[][] matr){
		double[] media = new double[matr.length];

		for(int i = 0, rows = matr.length; i < rows; i++){
			double tmp = 0;
			for(int j = 0; j < matr[i].length; j++){
				tmp += matr[i][j];
			}
			media[i] = tmp / matr[i].length;
		}

		return media;
	}
	public static void riempiRandom(int[] arr, int min, int max){
		for (int i = 0, len = arr.length; i < len; i++){
			arr[i] = (int) (Math.random()*(max - min +1)) + min; // side-Effetc
		}
	}
	public static void swap(int[] arr, int i, int j){
		if (i < 0 || j < 0 || i >= arr.length || j >= arr.length){
			System.out.println("Index out of bound");
			return;
		}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}