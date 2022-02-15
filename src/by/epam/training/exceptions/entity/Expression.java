package by.epam.training.exceptions.entity;

public class Expression {
//	private String expression;
	private double argA;
	private double argB;
	private Sign operation;
	private double result;
	
	public Expression(double a, double b, Sign operation, double result) {
		this.argA = a;
		this.argB = b;
		this.operation = operation;
		this.result=result;
		
	}
	public Expression(double a, double b, Sign operation) {
		this.argA = a;
		this.argB = b;
		this.operation = operation;
		
	}
	
	
	
	public double getArgA() {
		return argA;
	}
	public void setArgA(double argA) {
		this.argA = argA;
	}
	public double getArgB() {
		return argB;
	}
	public void setArgB(double argB) {
		this.argB = argB;
	}
	public Sign getOperation() {
		return operation;
	}
	public void setOperation(Sign operation) {
		this.operation = operation;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Expression [argA=" + argA + ", argB=" + argB + ", sign=" + operation + ", result=" + result + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(argA);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(argB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
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
		Expression other = (Expression) obj;
		if (Double.doubleToLongBits(argA) != Double.doubleToLongBits(other.argA))
			return false;
		if (Double.doubleToLongBits(argB) != Double.doubleToLongBits(other.argB))
			return false;
		if (operation != other.operation)
			return false;
		if (Double.doubleToLongBits(result) != Double.doubleToLongBits(other.result))
			return false;
		return true;
	}
	
	
	
	

	}

