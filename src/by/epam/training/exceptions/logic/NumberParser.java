package by.epam.training.exceptions.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.training.exceptions.entity.Expression;
import by.epam.training.exceptions.entity.Sign;

public class NumberParser {
	private static final Pattern p = Pattern.compile("([-]?[\\d]+[.]?[\\d]*) ([-]?[\\d]+[.]?[\\d]*) ([-\\+\\/\\*]$)");
	
	
	
	public NumberParser() {
		super();
	}

	public Expression parse(String data) throws DataParserException {
		if(!validate(data)) {
			throw new DataParserException("validation exception");
		}else {
			Matcher m = p.matcher(data);
			double a = Double.parseDouble(m.group(1));
			double b = Double.parseDouble(m.group(2));
			Sign sign = null;
			switch (m.group(3).charAt(0)) {
			
			case ('+'):
				sign = Sign.PLUS;
				break;
			
			case ('-'):
				sign = Sign.MINUS;
				break;
				
			case ('/'):
				sign = Sign.DEVIDE;
				break;
				
			case ('*'):
				sign = Sign.MULTIPLY;
				break;
				
			default:
				throw new DataParserException("Sign parsing exception");
			}
			
						
			return new Expression(a, b, sign);	
		}
		
		
		
	}
	
	private boolean validate(String data) {
		Matcher m = p.matcher(data);
		if(m.matches()) {
			return true;
		}else {
			return false;
		}
		
	}
}
