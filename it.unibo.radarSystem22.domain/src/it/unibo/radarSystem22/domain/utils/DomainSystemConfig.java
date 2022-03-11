package it.unibo.radarSystem22.domain.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DomainSystemConfig {
	public static boolean simulation;
	public static boolean tracing;
	public static int DLIMIT;
	public static boolean testing;
	public static int testingDistance;
	public static int sonarDelay;
	public static int sonarDistanceMax;


	public static void setTheConfiguration() {
		setTheConfiguration("../DomainSystemConfig.json");
	}
	
	public static void setTheConfiguration(String resourceName){
		
		Reader fin;
		JSONTokener tokener;
		JSONObject object;
		
		try {
	
			fin= new InputStreamReader(new FileInputStream(new File(resourceName)));
			tokener= new JSONTokener(fin);
			object= new JSONObject(tokener);
			//
			simulation=object.getBoolean("simulation");
			tracing=object.getBoolean("tracing");
			DLIMIT=object.getInt("DLIMIT");
			testing=object.getBoolean("testing");
			testingDistance=object.getInt("testingDistance");
			sonarDelay=object.getInt("sonarDelay");
			sonarDistanceMax=object.getInt("sonarDistanceMax");
			//
			fin.close();	
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
