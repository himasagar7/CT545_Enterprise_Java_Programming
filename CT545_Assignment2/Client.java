package assignment2;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	public static void main(String args[]) throws IOException {
		//boolean flag = true;
		Socket clientSocket = new Socket("localhost", 80);
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("welcome, Type your option\n SUBMIT REMOVE QUIT");
		
		String userInput;
        while ((userInput = stdIn.readLine()) != null) {
        	if(userInput.contains("submit"))
        		System.out.println("Enter token which needs to be added");
            out.println(userInput);
            //System.out.println("User input " + in.readLine());
        }
        
        clientSocket.close();
        
    

	}
}