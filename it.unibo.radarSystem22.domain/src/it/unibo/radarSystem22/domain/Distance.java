package it.unibo.radarSystem22.domain;

import it.unibo.radarSystem22.domain.interfaces.IDistance;

public class Distance implements IDistance {
	private int val;
	
	public Distance(int d) {
		this.val=d;
	}
	
	@Override
	public int getVal() {
		return this.val;
	}
	@Override
	public String toString() {
		return ""+val;
	}

}
