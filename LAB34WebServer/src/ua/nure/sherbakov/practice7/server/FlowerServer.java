package ua.nure.sherbakov.practice7.server;

import java.util.Scanner;

import javax.xml.ws.Endpoint;

public class FlowerServer {
	public static final Object implementor = new ua.nure.sherbakov.practice7.server.service.FlowerServiceImpl();
	public static final String address = "http://localhost:9090/flowers";

	public FlowerServer() {
		System.out.println("Starting Server");
		Endpoint.publish(address, implementor);
		/*Scanner sc = new Scanner(System.in);
		
		sc.close();*/
	}

	public static void main(String[] args) throws InterruptedException {
		new FlowerServer();

		System.out.println("Server ready... at " + address);

		System.err.println("Press <enter> to stop service... ");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();
		System.out.println("Server exit");
		System.exit(0);
	}
}
