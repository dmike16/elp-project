package dmike.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class PrimaryType {
	public static void dataStream()
		throws IOException,ClassNotFoundException
	{
		ObjectOutputStream out = null;
		
		try{
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data")));
			
			for(int i = 0; i < prices.length; i++){
				out.writeObject(prices[i]);
				out.writeInt(units[i]);
				out.writeUTF(de[i]);
			}
		}finally{
			if (out != null)
				out.close();
		}
		
		ObjectInputStream in = null;
		BigDecimal p;
		int u;
		String d;
		double tot = 0;
		
		try{
			in = new ObjectInputStream(new 
					BufferedInputStream(new FileInputStream("data")));
			try{
				while(true){
					p = (BigDecimal)in.readObject();
					u = in.readInt();
					d = in.readUTF();
					System.out.format("You order %d "+ 
					"units of %s  at $%.2f\n", u,d,p);
					tot += p.multiply(new BigDecimal(u)).floatValue();
				}
			}catch(EOFException e){
					
				}
			} finally{
				if (in != null)
					in.close();
		}
		System.out.println("Total = " + tot);
	}
	private static final BigDecimal[] prices = {
			new BigDecimal(19.99),
			new BigDecimal(5.00),
			new BigDecimal(9.00)};
	private static final int[] units = {12,8,13};
	private static final String[] de = {
			"Java",
			"Java Mug",
			"Duke"
	};

}
