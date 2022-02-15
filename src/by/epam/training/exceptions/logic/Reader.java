package by.epam.training.exceptions.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epam.training.exceptions.entity.ExpressionsList;

public class Reader {
	private String path;
	private NumberParser parser;
	
	
	public Reader(String path, NumberParser parser) {
		this.path = path;
		this.parser = parser;
	}
	public Reader(String path) {
		this.path = path;
		this.parser = new NumberParser();
	}
	public Reader(NumberParser parser) {
		this.path = null;
		this.parser = parser;
	}
	public Reader() {
		this.path = null;
		this.parser = new NumberParser();
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public NumberParser getParser() {
		return parser;
	}


	public void setParser(NumberParser parser) {
		this.parser = parser;
	}
	
	public ExpressionsList read() throws NumberParserException {
		BufferedReader fr = null;
		ExpressionsList result = new ExpressionsList();
		
		try {
			fr = new BufferedReader(new FileReader(path));
			String line = fr.readLine();
			
			while(line != null) {
				line = fr.readLine();
				result.addExpression(parser.parse(line));
				}
		}catch(FileNotFoundException e) {
			throw new NumberParserException(e);
		}catch(IOException e) {
			throw new NumberParserException(e);
		}catch(DataParserException e) {
			throw new NumberParserException(e);
		}finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					throw new NumberParserException(e);
				}
			}			
		}
		
		return result;
	}
		
		
		
	}
	
	
	

