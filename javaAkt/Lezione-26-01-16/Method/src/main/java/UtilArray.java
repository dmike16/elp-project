import java.util.Scanner;

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
		if (arr[arr.length-1] != 'a' && arr[arr.length-1] != 'b'){
			return false;
		}

		for(int i = 0; i < arr.length - 1; i++){
			if (arr[i] != 'a' && arr[i] != 'b'){
				return false;
			} else if (arr[i] == 'a' && arr[i+1] != 'b'){
				return false;
			}else if (arr[i] == 'b' && arr[i + 1] != 'a'){
				return false;
			}
		}

		return true;
	}
	public static void stampaZipZag(int[] arr){
		int i = -1, j = arr.length;
		for(;++i < --j; System.out.print(arr[i] + " " + arr[j] + " "));

		if (i == j){
			System.out.println(arr[i]);
		}	else{
			System.out.println();
		}
	}
	public static void sommaPariDispari(int[] arr){
		int sumPari = 0, sumDispari = 0;
		int dim = 0;

		if ((arr.length & 1) != 0){
			sumPari += arr[arr.length-1];
			dim = arr.length-1;
		} else {
			dim = arr.length;
		}

		for(int i = 0; i < dim; i = i+2){
			sumPari += arr[i];
			sumDispari += arr[i+1];
		}

		System.out.println("Pari e Dispari" +
			((sumPari == sumDispari)? " uguali": " diversi"));
	}
	public static int[] unisciArray(int[] a, int[] b){
		int dimTotal = a.length + b.length;
		int min = a.length < b.length ? a.length : b.length;
		int[] union = new int[dimTotal];

		int i = 0;
		while(i < min){
			union[i] = a[i];
			union[i + a.length] = b[i];
			i++;
		}

		for (; i < a.length; i++)
			union[i] = a[i];
		for(; i < b.length; i++)
			union[i + a.length] = b[i];

		return union;
	}
	public static int[] unisciAlternado(int[] a,int[] b){
		if(a.length != b.length){
			return null;
		}

		int[] union = new int[a.length + b.length];

		for(int i = 0, len = 2*a.length; i < len; i = i +2 ){
			union[i] = a[i/2];
			union[i + 1] = b[i/2];
		}

		return union;

	}
	public static boolean ordinato(int[] a){
		for (int i = 0; i < a.length -1; i++){
			if (a[i] > a[i + 1]){
				return false;
			}
		}
		return true;
	}
	public static boolean caratteriConsecutivi(char[] seq){
		int count = 0;

		for(int i = 0, len = seq.length - 2; i < len && count < 3; i++){
			count = 0;
			for(int j = i; j < i + 3; j++){
				if (seq[j] == seq[i]){
					count++;
				}
			}
			if (count == 2){
				i++;
			}
		}
		return count == 3;
	}
	public static int[] secondoArray(){
		System.out.println("Inserisci 5 numeri interi");

		Scanner cin = new Scanner(System.in);
		int numPos = 0;
		int[] arr = new int[5];
		int i = 0;

		do{
			System.out.print("Dammi un numero ");
			arr[i] = cin.nextInt();

			if(arr[i] >= 0){
				numPos++;
			}
		}while(++i < 5);

		int secondo[] = new int[numPos];
		i = 0;
		for(int k = 0; i < 5 && k < numPos; i++){
			if(arr[i] >= 0){
				secondo[k++] = arr[i];
			}
		}
		return secondo;
	}
}
