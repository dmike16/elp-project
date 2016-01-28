public class UtilFigure{
	public static double sommaAree(Figura[] figure){
		double som = 0;
		for(Figura ele: figure){
			if(ele instanceof FiguraPiana){
				som += ((FiguraPiana)ele).getArea();
			}
		}

		return som;
	}
}