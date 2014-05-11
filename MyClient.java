import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MyClient {
	public static void main(String[] args){
		try{
			//make connection to server socket
			Socket sock = new Socket("127.0.0.1", 6013);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			Scanner scan = new Scanner(System.in);
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			
			while(true){
				//read from socket
				String text = bin.readLine();
				System.out.println(text);
				
				//writes to server
				System.out.print("Enter a line or bye to quit for the client: ");
				out.println(scan.nextLine());
			}
		}
		catch(IOException ioe){
			//nothing
		}
	}
}
