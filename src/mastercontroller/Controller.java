package mastercontroller;

import logic.TitleInput;

import java.util.Scanner;

import logic.Shifter;
import logic.Sorter;
import logic.Output;

public class Controller {

	Scanner sc = new Scanner(System.in);

	private TitleInput input;
	private Shifter shifter;
	private Sorter sorter;
	private Output output;

	public Controller() {
		input = new TitleInput();
		shifter = new Shifter();
		sorter = new Sorter();
		output = new Output();
	}

	public void run() {
		input.processInput();
		shifter.shiftAndStore();
		sorter.sort();
		output.processOutput();
	}

}
