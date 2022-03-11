package it.unibo.radarSystem22.domain.models;

import it.unibo.radarSystem22.domain.concrete.LedConcrete;
import it.unibo.radarSystem22.domain.interfaces.ILed;
import it.unibo.radarSystem22.domain.mock.LedMock;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public abstract class LedModel implements ILed{
	private boolean state=false;

	//general factory, decides the implementation of ILed based of what's the value of simulation
	public static ILed create() {
		ILed led;
		if(DomainSystemConfig.simulation) led = createLedMock();
		else led=createLedConcrete();
		return led;
	}
	// factory used to create LedMock
	public static ILed createLedMock(){return new LedMock();  }
	// factory used to create LedConcrete
	public static ILed createLedConcrete(){return new LedConcrete();}

	// abstract methods
	protected abstract void ledActivate( boolean val);
	
	protected void setState(boolean val) {  state=val; }

	@Override
	public void turnOn(){ setState( true ); }
	@Override
	public void turnOff() { setState( false ); }
	@Override
	public boolean getState(){  return state;  }


}
