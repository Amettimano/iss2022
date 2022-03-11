package it.unibo.radarSystem22.domain.mock;

import it.unibo.radarSystem22.domain.Distance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.SonarModel;
import it.unibo.radarSystem22.domain.utils.BasicUtils;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public class SonarMock extends SonarModel implements ISonar {
	private int delta = 1;
	@Override
	protected void sonarProduce() {
		
		if(DomainSystemConfig.testing) {updateDistance(DomainSystemConfig.testingDistance);}
		
		else {
			
			int newVal = getDistance().getVal() - delta;
			updateDistance(newVal);
			if( newVal<=0) setState(false);
		
		}
		BasicUtils.delay(DomainSystemConfig.sonarDelay);
	}
	@Override
	protected void sonarSetUp() {
		this.distance=new Distance(90);
		this.state=false;
	}

	
}
