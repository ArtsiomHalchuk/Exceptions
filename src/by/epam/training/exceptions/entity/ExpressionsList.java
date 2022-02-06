package by.epam.training.exceptions.entity;

import java.util.ArrayList;
import java.util.List;

public class ExpressionsList {
	private List<Expression> expressions;
	
	public ExpressionsList() {
		expressions = new ArrayList<Expression>();
	}
	
	public void addExpression(Expression obj) {
		expressions.add(obj);
	}
	
	public Expression getExpression(int i){
		return expressions.get(i);
	}
	
	public List<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(List<Expression> expressions) {
		this.expressions = expressions;
	}

	@Override
	public String toString() {
		return "ExpressionsList [expressions=" + expressions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expressions == null) ? 0 : expressions.hashCode());
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
		ExpressionsList other = (ExpressionsList) obj;
		if (expressions == null) {
			if (other.expressions != null)
				return false;
		} else if (!expressions.equals(other.expressions))
			return false;
		return true;
	}


	
	

}
