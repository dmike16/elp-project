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
}