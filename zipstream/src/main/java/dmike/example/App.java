package dmike.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
	public static int BUFF_SIZE=2024;
	public static void main( String[] args ) throws IOException
	{
		if(args.length == 0){
			System.out.println("Givi me a file name");
			System.exit(1);
		}else if(args[0].equals("GZIP")){
			System.out.println("[INFO] GZIP format");
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(args[1]));
			BufferedOutputStream out = new BufferedOutputStream(
					new GZIPOutputStream(
							new FileOutputStream("test.gz")),BUFF_SIZE);
			System.out.println("[INFO] Writing File !!!");
			byte[] b = new byte[BUFF_SIZE];
			while((in.read(b))!=-1)
				out.write(b);
			in.close();
			out.close();
			System.out.println("[INFO] Reading file !!!");
			BufferedReader in2 = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(
							new FileInputStream("test.gz"))));
			String s;
			while((s = in2.readLine())!= null)
				System.out.println(s);
			in2.close();
		}else if(args[0].equals("ZIP")){
			System.out.println("[INFO] ZIP format");
			FileOutputStream f = new FileOutputStream("test.zip");
			CheckedOutputStream csum = new CheckedOutputStream(f,new Adler32());
			ZipOutputStream zos = new ZipOutputStream(csum);
			BufferedOutputStream out = new BufferedOutputStream(zos,BUFF_SIZE);
			zos.setComment("A test of Java ZIP");
			for(int i = 1; i < args.length; i++){
				System.out.println("[INFO] Writing file " +args[i]);
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[i]),
						BUFF_SIZE);
				zos.putNextEntry(new ZipEntry(args[i]));
				byte[] buf = new byte[BUFF_SIZE];
				while(in.read(buf) != -1){
					out.write(buf);
				}
				in.close();
				out.flush();
			}
			out.close();
			System.out.println("[INFO] Checksum "+csum.getChecksum().getValue());
		}
	}
}
