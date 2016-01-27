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
	public static int sommaMultipli2e3(int[] arr){
		int summ = 0;
		for(int x: arr){
			if (x%2 == 0 && x%3 == 0){
				summ += x;
			}
		}
		return summ;
	}
	public static int contaDispari(int[] arr){
		int count = 0;
		for(int x: arr){
			if ((x & 1) != 0)count++;
		}
		return count;
	}
	public static int max(int[] arr){
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}

		return max;
	}
	public static boolean tuttiPari(int[] arr){
		for(int x : arr){
			if ((x & 1) != 0){
				return false;
			}
		}
		return true;
	}
	public static boolean tuttiMinoriDik(int[] arr, int k){
		for(int x : arr){
			if (x >= k)return false;
		}

		return true;
	}
	public static boolean maggioreDik(int[] arr, int k){
		for(int x : arr){
			if (x > k)return true;
		}

		return false;
	}
	public static boolean elementi3k(int[] arr, int k){
		int count = 0;
		for(int i = 0; i < arr.length && count < 3; i++){
			if (arr[i] == k){
				count++;
			}
		}
		return count == 3;
	}
	public static boolean elementi3kConsecutivi(int[] arr, int k){
		int count = 0;
		for(int i = 0; i < arr.length -2 && count < 3; i++){
			if (arr[i] == k){
				count++;
			}else {
				count = 0;
			}
		}
		if (count < 3 && arr[arr.length-2] == k){
			count++;
			if(count < 3 && arr[arr.length-1] == k){
				count++;
			}
		}
		return count == 3;
	}

	public static boolean alternanzaAeB(char[] arr){
		int alter = 0;

		for(int i = 1; i < arr.length && alter < 2;){
			if (arr[i - 1] == 'a' && arr[i] == 'b'){
				alter++;
				i += 2;
			} else{
				i++;
			}
		}

		return alter == 2;
	}
}