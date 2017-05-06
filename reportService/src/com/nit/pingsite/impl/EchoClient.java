package com.nit.pingsite.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) throws IOException {

		Socket pingSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {	
			pingSocket = new Socket("localhost", 3306);
			out = new PrintWriter(pingSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					pingSocket.getInputStream()));
		} catch (IOException e) {
			return;
		}

		out.println("ping");
		System.out.println(in.readLine());
		out.close();
		in.close();
		pingSocket.close();
	}
}