package it.unibo.radarSystem22.domain;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.utils.BasicUtils;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public class TestSonarMock {
	@Before
	  public void up(){ System.out.println("up On"); }
	  @After
	  public void down(){ System.out.println("down On"); }
	  @Test
	  public void testSonarMock() {
		  DomainSystemConfig.simulation=true;
		  DomainSystemConfig.sonarDelay=10;
		  
		  int delta=1;
		  int espectedDistance=90;
		  
		  ISonar sonar = DeviceFactory.createSonar();
		  assertTrue(sonar.getDistance().getVal()==espectedDistance);
		  
		  sonar.activate();
		  
		  assertTrue(sonar.isActive()==true);
		  
		  while(sonar.isActive()) {
			  espectedDistance-=delta;
			  
			  assertTrue(sonar.getDistance().getVal()<=espectedDistance+delta && sonar.getDistance().getVal()>= espectedDistance-delta);
			  
			  BasicUtils.delay(10);
			  
		  }
		  
		  
		  
	  }
}
