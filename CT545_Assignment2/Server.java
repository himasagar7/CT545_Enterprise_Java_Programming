package assignment2;

import java.net.*;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.*;

 
public class Server {
	public enum messageType
    {
        submit, remove;
    }
	SortedSet<String> tokenList = 	new TreeSet<String>();
    public static void main(String[] args) throws IOException {
         
             int portNumber = 80;
             StringTokenizer userInput;
             Server s = new Server();
         
        try {
            ServerSocket serverSocket =
                new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
         
                 userInput = new StringTokenizer(in.readLine());
                	 switch (messageType.valueOf(userInput.nextToken())){
                	 case submit: System.out.println("Submit found");break;
                	 case remove: System.out.println("Remove found");break;
                		default: System.out.println("nothing found");break;
    			
            	
                //out.println(inputLine);
            }
            
            
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}