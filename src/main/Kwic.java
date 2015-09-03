package main;

import java.util.Scanner;

import mastercontroller.Controller;
import pipeandfilter.PipeAndFilter;

public class Kwic {
	Scanner sc = new Scanner(System.in);

	public Kwic() {

	}

	public void run() {
		System.out.println("Which architecture do you want to use?");
		System.out.println("1. Shared Memory Architecture");
		System.out.println("2. Pipe and Filter Architecture");

		System.out.print("Enter choice (1/2): ");
		int choice = sc.nextInt();

		if (choice == 1) {
			System.out.println("\nYou have chosen the Shared Memory Architecture\n");
			Controller c = new Controller();
			c.run();
		} else {
			PipeAndFilter pipeandfilter = new PipeAndFilter();
			pipeandfilter.run();
		}
	}

	public static void main(String[] args) {
		Kwic kwic = new Kwic();
		kwic.run();
	}
}
