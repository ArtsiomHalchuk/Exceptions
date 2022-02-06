package by.epam.training.exceptions.logic;

import by.epam.training.exceptions.entity.Expression;

public class Calculator {
	
	private Expression expression;
	private double a;
	private double b;
	private char oper;
	private double result;
	
	public Calculator() {
		this.expression=null;
	}
	
	
	public Calculator(Expression expression) {
		this.expression = expression;
		this.a = expression.getA();
		this.b = expression.getB();
		this.oper = expression.getOperation();
	}
	
	public Expression calculate() throws NullPointerException{
		switch (oper) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result= a / b;
		}
		return new Expression(expression.getExpression() + " = " + result);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
		this.a = expression.getA();
		this.b = expression.getB();
		this.oper = expression.getOperation();
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public char getOper() {
		return oper;
	}


	public double getResult() {
		return result;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + oper;
		temp = Double.doubleToLongBits(this.result);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (oper != other.oper)
			return false;
		if (Double.doubleToLongBits(result) != Double.doubleToLongBits(other.result))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calculator [expression=" + expression + ", a=" + a + ", b=" + b + ", oper=" + oper + ", result="
				+ result + "]";
	}
	
	

}
