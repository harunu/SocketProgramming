
import java.net.*;
import java.io.*;

 
public class Socket_Programming {
    
public static void main(String args[]) {
	
	int port;
	ServerSocket server_socket;
	BufferedReader input;
	
	try { 
	    port = Integer.parseInt(args[0]);
	}
	catch (Exception e) {
	    System.out.println("port = 1500 ");
	    port = 1500;
	}

	try {
	    
	    server_socket = new ServerSocket(port);
	    System.out.println("Server waiting for client on port " + 
			       server_socket.getLocalPort());
	    
	    // server infinite loop
	    while(true) {
		Socket socket = server_socket.accept();
		System.out.println("New connection accepted " +
				   socket.getInetAddress() +
				   ":" + socket.getPort());
		input = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		// print received data 
		try {
		    while(true) {
			String message = input.readLine();
			if (message==null) break;
			System.out.println(message);
		    }
		}
		catch (IOException e) {
		    System.out.println(e);
		}
		
		// connection closed by client
		try {
		    socket.close();
		    System.out.println("Connection closed by Client");
		}
		catch (IOException e) {
		    System.out.println(e);
		}
		
	    }  
	}
	
	catch (IOException e) {
	    System.out.println(e);
	}
    }
}
		
