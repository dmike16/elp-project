package dmike.javaprogramming;

final class SortMetrics implements Cloneable {
	public long probeCnt,
				compareCnt,
				swapCnt;
	public void init(){
		probeCnt =swapCnt =compareCnt =0;
	}
	public String toString (){
		return probeCnt+"-probes "+
				compareCnt+ "-compare "+
				swapCnt+ "-swaps ";
	}
	
	public SortMetrics clone (){
		try{
			return (SortMetrics)super.clone();
		} catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
}

abstract class SortDouble {
	public final SortMetrics sort(double[] data){
		if(!doneSort){
			values =data;
			curMetrics.init();
			doneSort = true;
			doSort();}
		else
			System.out.println("Sort already done on this Object");
		return getMetrics();
	}
	public final SortMetrics getMetrics(){
		return curMetrics.clone();
	}
	protected final int getDataLenght(){
		return values.length;
	}
	protected final double probe(int i){
		curMetrics.probeCnt++;
		return values[i];
	}
	protected final int compare(int i, int j){
		curMetrics.compareCnt++;
		double d1 =values[i];
		double d2 =values[j];
		if(d1 ==d2)
			return 0;
		else
			return (d1<d1 ? -1:1);
	}
	protected final void swap(int i,int j){
		curMetrics.swapCnt++;
		double tmp =values[i];
		values[i] =values[j];
		values[j] =tmp;
	}
	protected abstract void doSort();
	
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	private boolean doneSort = false;
}

class SimpleSortDouble extends SortDouble implements Cloneable{
	private static final double[] cheatValue = {1,3,4,5};
	private static int flag =0;
	protected void doSort(){
		flag++;
		if(flag == 1){
			for(int i=0; i<getDataLenght();i++){
				for(int j=i+1;j<getDataLenght(); j++)
					if(compare(i,j)>0)
						swap(i,j);
			}
			this.sort(cheatValue);
			}	
	}
}

public class testSort {
	static  double[] testData={0.3,1.3,7.9,3.17};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortDouble bsort = new SimpleSortDouble();
		SortMetrics metrics =bsort.sort(testData);
		System.out.println("Metrics: "+ metrics);

	}

}
