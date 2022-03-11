package it.unibo.radarSystem22.domain;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unibo.radarSystem22.domain.interfaces.ILed;

public class TestLedMockOff{

	@Before
	  public void up(){ System.out.println("up Off"); }
	  @After
	  public void down(){ System.out.println("down Off"); }
	  @Test
	  public void testLedMock() {
		  
	    ILed led = DeviceFactory.createLed();
	    assertTrue( ! led.getState() );

	    led.turnOn();
	    assertTrue(  led.getState() );
	    
	    led.turnOff();
	    assertTrue( ! led.getState() );

	  }

}
