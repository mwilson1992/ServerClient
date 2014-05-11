import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MyServer {
	public static void main(String[] args){
		try{
			ServerSocket sock = new ServerSocket(6013);
			
			//listens for connections
			Socket client = sock.accept();
			PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			Scanner scan = new Scanner(System.in);
					
			//say hello to client
			pout.println("Hello !!");
					
			while(true){
				String text = in.readLine();
						
				if(text.equals("bye")){
					System.exit(0);
				}else{
					//read from client
					System.out.println(text);
							
					//Enter msg back to client
					System.out.print("Enter a line for the server: ");
					pout.println(scan.nextLine());
				}
			}
		}
		catch (IOException ioe){
			System.exit(0);
		}
	}
}
