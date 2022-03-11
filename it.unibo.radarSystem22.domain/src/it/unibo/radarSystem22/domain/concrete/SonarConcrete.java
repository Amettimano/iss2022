package it.unibo.radarSystem22.domain.concrete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.unibo.radarSystem22.domain.Distance;
import it.unibo.radarSystem22.domain.interfaces.ISonar;
import it.unibo.radarSystem22.domain.models.SonarModel;
import it.unibo.radarSystem22.domain.utils.DomainSystemConfig;

public class SonarConcrete extends SonarModel implements ISonar{
	private Runtime rt = Runtime.getRuntime();
	private BufferedReader reader;
	private Process process;
	
	@Override
	protected void sonarProduce() {
		try {
			String lastDistance=reader.readLine();
			
			if(lastDistance==null) return;
			
			int val= Integer.parseInt(lastDistance);
			
			if(val> DomainSystemConfig.sonarDistanceMax) { updateDistance(DomainSystemConfig.sonarDistanceMax); }
			else if(getDistance().getVal()!=val) { updateDistance(val); }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void sonarSetUp() {
		this.distance=new Distance(90);
		this.state=false;
	}
	@Override
	public void activate() {
		try {
			process=rt.exec("sudo ./SonarAlone");
			reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.activate();		
	}
	@Override
	public void deactivate() {
		this.distance=new Distance(90);
		
		if( process!= null) {
			process.destroy();
			process=null;
		}
		super.deactivate();
		
	}

}
