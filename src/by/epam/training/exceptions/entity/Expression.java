package by.epam.training.exceptions.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
	private String expression;
	
	public Expression(String line) {
		this.expression=line;
	}
	
	public double getA() {
		Pattern p = Pattern.compile("[-]?[\\d]+[.]?[\\d]*");
		Matcher m = p.matcher(expression);
		return Double.parseDouble(m.group(0));
	}
	
	public double getB() {
		Pattern p = Pattern.compile("[-]?[\\d]+[.]?[\\d]*");
		Matcher m = p.matcher(expression);
		return Double.parseDouble(m.group(1));
	}
	
	public char getOperation() {
		Pattern p = Pattern.compile("[-\\+\\/\\*]$");
		Matcher m = p.matcher(expression);
		return m.group(0).charAt(0);
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "Expression [expression=" + expression + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
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
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		return true;
	}
	

}
