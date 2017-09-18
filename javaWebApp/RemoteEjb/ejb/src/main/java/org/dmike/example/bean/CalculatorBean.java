package org.dmike.example.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.dmike.example.api.RemoteCalculator;

@Stateless
@Remote(RemoteCalculator.class)
public class CalculatorBean implements RemoteCalculator{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}
