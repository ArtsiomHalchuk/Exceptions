package by.epam.training.exceptions.logic;

import by.epam.training.exceptions.entity.Expression;
import by.epam.training.exceptions.entity.ExpressionsList;
import by.epam.training.exceptions.entity.Sign;

public class Calculator {
	
	private ExpressionsList list;
	
	
	public Calculator(ExpressionsList list) {
		this.list=list;
	}
	public Calculator() {
		this.list=new ExpressionsList();
	}
	
	
	
	public ExpressionsList getList() {
		return list;
	}
	public void setList(ExpressionsList list) {
		this.list = list;
	}
	
	
	public ExpressionsList calculateList() {
		for (Expression n:list.getExpressions()) {
			calculate(n);
		}
		return list;
	}
	
	public void calculate(Expression expression) throws NullPointerException{
		double result;
		double a = expression.getArgA();
		double b = expression.getArgB();
		Sign operation = expression.getOperation();
		switch (operation) {
		case PLUS:
			result = a + b;
			break;
		case MINUS:
			result = a - b;
			break;
		case MULTIPLY:
			result = a * b;
			break;
		case DEVIDE:
			result= a / b;
		default:
			result = a + b;
			
		}
		expression.setResult (result);
	}
	@Override
	public String toString() {
		return "Calculator [list=" + list + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
	
	

	
	
	
	
}

	

