package com.natal.beans;

import java.util.Calendar;

public class LayoutMB {

	private String copyRightYear;
	
	public static final String ANO_NASCIMENTO = "2013";
	
	public LayoutMB() {
		
		Calendar c = Calendar.getInstance();
		String ano = Integer.toString(c.get(Calendar.YEAR));
		this.copyRightYear = (Integer.parseInt(LayoutMB.ANO_NASCIMENTO) < Integer.parseInt(ano) ? LayoutMB.ANO_NASCIMENTO + "-" + ano : LayoutMB.ANO_NASCIMENTO);
		
	}

	public String getcopyRightYear() {
		return this.copyRightYear;
	}

	public void setcopyRightYear(String copyRightYear) {
		this.copyRightYear = copyRightYear;
	}
	
	public String copyRightYear(){
		
		return this.copyRightYear;
	}
	
}
