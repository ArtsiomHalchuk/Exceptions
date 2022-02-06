package by.epam.training.exceptions.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.epam.training.exceptions.entity.Expression;
import by.epam.training.exceptions.entity.ExpressionsList;
import by.epam.training.exceptions.logic.Calculator;

public class Main {

	public static void main(String[] args) {
		ExpressionsList input = new ExpressionsList();
		ExpressionsList output = new ExpressionsList();
		Calculator calc = new Calculator();
		
	//Читаем файл и сохраняем коллекцию	
		try {
			File inputFile = new File("src/by/epam/training/exceptions/files/input.txt");
			FileReader fr = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			input.addExpression(new Expression(line));
			
			while(line != null) {
				line = reader.readLine();
				input.addExpression(new Expression(line));
				}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	//Обрабатываем коллекцию, считаем, сохраняем презультат в отдельную коллекцию	
		
		try {
			for (Expression n:input.getExpressions()) {
				calc.setExpression(n);
				output.addExpression(calc.calculate());
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		//Сохраняем коллекцию в файл		
		File outputFile = new File("src/by/epam/training/exceptions/files/files/output.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile, true);
			for(Expression n:output.getExpressions()) {
				fw.write(n.getExpression());
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}
