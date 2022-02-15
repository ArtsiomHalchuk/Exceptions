package by.epam.training.exceptions.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import by.epam.training.exceptions.entity.Expression;
import by.epam.training.exceptions.entity.ExpressionsList;

public class Writer {
	private String path;
	private ExpressionsList list;
	
	public Writer(String path, ExpressionsList list) {
		this.path = path;
		this.list = list;
	}
	
	public Writer() {
		this.path=null;
		this.list=new ExpressionsList();
	}
	
	public Writer(String path) {
		this.path = path;
		this.list = new ExpressionsList();
	}
	
	public Writer (ExpressionsList list) {
		this.path = null;
		this.list = list;
	}
	
	public boolean save() throws NumberParserException {
		File outputFile = new File(path);
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile, true);
			for(Expression n:list.getExpressions()) {
				fw.write(format(n));
			}
			
		}catch(IOException e) {
			throw new NumberParserException(e);
			
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				throw new NumberParserException(e);
			}
		}
		
		return true;
	}
	
	
	
	private String format(Expression exp) {
		return exp.getArgA()+" "+exp.getOperation()+" "+exp.getArgB()+" = "+exp.getResult();
	}

}
