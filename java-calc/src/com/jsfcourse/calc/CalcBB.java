package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private double x;
	private double y;
	private	double z;
	private Double result;

	@Inject
	FacesContext ctx;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double x = this.x;
			double y = this.y;
			double z = this.z/100;
			double q = (1+(z/12));
			double rata = x*(Math.pow(q, y)) * ((q-1)/(Math.pow(q,y)-1));
			double koszt = rata*y;
			
			result = koszt;
			return true;

		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "wystapil blad", null));
		}
		return false;
	}

	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	// Put result in messages on AJAX call
	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + result, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}

	
}
