package by.epam.training.exceptions.main;

import by.epam.training.exceptions.entity.ExpressionsList;
import by.epam.training.exceptions.logic.Calculator;
import by.epam.training.exceptions.logic.NumberParserException;
import by.epam.training.exceptions.logic.Reader;
import by.epam.training.exceptions.logic.Writer;

public class Main {

	public static void main(String[] args) {
		String inputfile = "resources/input.txt";
		String outputfile = "resources/output.txt";
		
		ExpressionsList list = null;
		Calculator calc = null;
		
		Reader reader = null;
		Writer writer = null;
		
		try {
			reader = new Reader(inputfile);
			list = reader.read();
			calc = new Calculator(list);
			list = calc.calculateList();
			writer = new Writer(outputfile, list);
			writer.save();
		}catch (NumberParserException e) {
			System.out.println("NumberParserException");
			e.printStackTrace();
		}
		
	}
}