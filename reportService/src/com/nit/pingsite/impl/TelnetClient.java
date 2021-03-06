package com.nit.pingsite.impl;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class TelnetClient
{
    public static void main(String args[]) throws Exception
    {
        //Create object of Socket
        Socket soc=new Socket("localhost",3306);
        String Command;
        //Create object of Input Stream to read from socket
        DataInputStream din=new DataInputStream(soc.getInputStream());    
        //Create object of Output Stream  to write on socket 	
        DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
        // Object of Buffered Reader to read command from terminal
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Telnet Client");
        System.out.println("< Telnet Prompt >");
        Command=br.readLine();//reads the command 
        dout.writeUTF(Command);//sends command to server
        System.out.println(din.readLine()); //gets the response of server        
        soc.close();  //close port  
        din.close();  //close input stream      
        dout.close(); //close output stream      
        br.close();  //close buffered Reader    
    }
}