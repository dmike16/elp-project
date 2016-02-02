package dmike.utils.inout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.Closeable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import dmike.utils.date.*;

public final class StdIO implements View, Closeable{
	@Override
	public String getStringNotNull(String mesg){
		String input = null;

		while(true){
			try{
				cout.println(mesg);
				input = cin.readLine();

				if(input.length() > 0 && input != null){
					break;
				}
				cout.println("Inserisci un valore non nullo");
			}catch(IOException e){
				io.close();
				throw new RuntimeException(e);
			}
		}
		return input;
	}
	@Override
	public int getIntNotNull(String mesg){
		int n;
		while(true){
			try{
				cout.println(mesg);
				String tmp = cin.readLine();

				try{
					n = Integer.parseInt(tmp);
					break;
				}catch(NumberFormatException e){
					cout.println("Inserisci un valore numerico");
				}
			}catch(IOException e){
				io.close();
				throw new RuntimeException(e);
			}
		}
		return n;
	}
	@Override
	public double getDoubleNotNull(String mesg){
		double d;
		while(true){
			try{
				cout.println(mesg);
				String tmp = cin.readLine();

				try{
					d = Double.parseDouble(tmp);
					break;
				}catch(NumberFormatException e){
					cout.println("Inserisci un valore numerico");
				}
			}catch(IOException e){
				io.close();
				throw new RuntimeException(e);
			}
		}
		return d;
	}
	@Override
	public long getLongNotNull(String mesg){
		Long l;
		while(true){
			try{
				cout.println(mesg);
				String tmp = cin.readLine();

				try{
					l = Long.parseLong(tmp);
					break;
				}catch(NumberFormatException e){
					cout.println("Inserisci un valore numerico");
				}
			}catch(IOException e){
				io.close();
				throw new RuntimeException(e);
			}
		}
		return l;
	}
	@Override
	public Date getDateNotNull(String mesg)
		throws NotValidDateException
	{
		Scanner stream = null;
		Date date = null;
		while(true){
			try{
				cout.println(mesg);
				cout.println("Secondo in formato dd/mm/yy");
				String ddMMYY = cin.readLine();
				stream = new Scanner(ddMMYY);
				stream.useDelimiter("\\s*[/-]\\s*");
				try{
					date = validateDate(stream,FormatDate.DDMMYY);
					break;
				} catch(NumberFormatException e){
					cout.println("Inserire date numerici interi");
				}
			}catch(IOException e){
				io.close();
				throw new RuntimeException(e);
			}
		}
		return date;
	}
	public static StdIO getStdIOReference(){
		if (StdIO.io == null){
			io = new StdIO();
		}
		return StdIO.io;
	}
	@Override
	public void close(){
		if (io != null){
			try{
				cin.close();
			}catch(IOException e){
				cout.println("Error in Close the Input Stream");
				e.printStackTrace();
			}
			finally{
				cout.close();
				io = null;
			}
		}
	}
	private Date validateDate(Scanner ss,FormatDate ff)
		throws NotValidDateException, NumberFormatException
	{
		int[] tmp = new int[3];
		int k = 0;

		while(ss.hasNext() && k < 3){
			tmp[k++]=Integer.parseInt(ss.next());
		}
		if (k != 3){
			throw new NotValidDateException("Date format non valido");
		}
		switch (ff) {
			case DDMMYY:
				return (new GregorianCalendar(tmp[2],tmp[1]-1,tmp[0])).getTime();
			case MMDDYY:
				return (new GregorianCalendar(tmp[2],tmp[0]-1,tmp[1])).getTime();
			case YYMMDD:
				return (new GregorianCalendar(tmp[0],tmp[1]-1,tmp[2])).getTime();
			default:
				throw new NotValidDateException("Data not in correct format");
		}
	}
	private final BufferedReader cin = new BufferedReader(
		new InputStreamReader(System.in));
	private final PrintWriter cout = new PrintWriter(System.out,true);
	private static StdIO io = null;
	private StdIO(){} 
}