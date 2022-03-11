package it.unibo.radarSystem22.domain.models;

import it.unibo.radarSystem22.domain.Distance;
import it.unibo.radarSystem22.domain.concrete.SonarConcrete;
import it.unibo.radarSystem22.domain.interfaces.IDistance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.mock.SonarMock;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public abstract class SonarModel implements ISonar {
	protected boolean state;
	protected IDistance distance;
	
	// ISonar factory, choose the implementation of Isonar based of simulation value
	public static ISonar create() {
		ISonar sonar;
		
		if( DomainSystemConfig.simulation ) sonar= createSonarMock();
		else sonar = createSonarConcrete();

		return sonar;
	}
	// SonarMOck factory
	public static ISonar createSonarMock() {return new SonarMock();}
	// SonarConcrete factory
	public static ISonar createSonarConcrete() {return new SonarConcrete();}

	protected SonarModel() {
		sonarSetUp();
	}
	
	
	protected void setState(boolean val) { // if state=true ->active sonar; if state=false -> sonar stopped
		this.state=val;
	}
	
	protected abstract void sonarProduce();
	protected abstract void sonarSetUp();
	
	
	public int getVal() {
		return this.distance.getVal();
	}
	
	@Override
	public void activate() {
		
		distance=new Distance(90);
		setState(true);
		
		new Thread (){
			public void run() {
				
				while(state) {
					
					sonarProduce();
					
				}
			}
		}.start();
		
	}

	@Override
	public void deactivate() {
		setState(false);
	}

	@Override
	public IDistance getDistance() {
		 return this.distance;
	}
	
	protected void updateDistance(int val) {
		this.distance=new Distance(val);
	}

	@Override
	public boolean isActive() {
		return this.state;
	}

}
