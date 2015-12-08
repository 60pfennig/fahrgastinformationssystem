package fis;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.railml.schemas._2009.ECategory;
import org.railml.schemas._2009.EOcp;
import org.railml.schemas._2009.EOcpTT;
import org.railml.schemas._2009.ETrainPart;
import org.railml.schemas._2009.Infrastructure;
import org.railml.schemas._2009.Railml;
import org.railml.schemas._2009.TOcpOperationalType;
import org.railml.schemas._2009.TUsageType;
import org.railml.schemas._2009.Timetable;

import fis.data.Station;
import fis.data.Stop;
import fis.data.StopType;
import fis.data.TimetableData;
import fis.data.TrainCategory;
import fis.data.TrainRoute;
import fis.railmlparser.RailMLParser;

public class RailML2Data {
	private static final Logger LOGGER = Logger.getLogger(RailML2Data.class);
	
	public static TimetableData loadML(String path) throws Exception{
		
		TimetableData data=new TimetableData();
		
		RailMLParser parser=new RailMLParser();
		
			LOGGER.info("Parsing "+path);
			Railml railml=parser.parseRailML(path);
			System.out.println("Parsed "+path);
			
			Infrastructure infra=railml.getInfrastructure();
			LOGGER.info("Got Infrastrucure");
			for(EOcp ocp:infra.getOperationControlPoints().getOcp()){
				TOcpOperationalType ocptype=ocp.getPropOperational().getOperationalType();
				if(ocptype==TOcpOperationalType.STATION || ocptype==null){ //Entweder Bahnhof oder unbestimmt (da manche Halte unbestimmt sind!)
					data.addStation(new Station(ocp.getId(),ocp.getName()));
				}
			}
			
			
			
			Timetable timetable=railml.getTimetable();
			LOGGER.info("Got Timetable");
			for(ECategory cat:timetable.getCategories().getCategory()){
				//Categories auslesen
				
				//Achtung! UsageType kann null sein --> aufpassen bei usageType.name()!
				TUsageType usageType=cat.getTrainUsage();		
				String trainUsage="";
				if(usageType!=null){
					trainUsage=usageType.name();
				}
				
				String catId=cat.getId();
				String catName=cat.getName();
				String catDesc=cat.getDescription();
				if(catId==null) catId="";
				if(catName==null) catName="";
				if(catDesc==null) catDesc="";
				
				data.addTrainCategory(new TrainCategory(catId,catName,catDesc,trainUsage));
			}
			
			for(ETrainPart trainPart:timetable.getTrainParts().getTrainPart()){
				List<Stop> stops=new ArrayList<Stop>();
				
				LOGGER.info("..");
				LOGGER.info("Zuglauf "+trainPart.getId());
				
				for(EOcpTT ocptt:trainPart.getOcpsTT().getOcpTT()){
					String ocpttID=((EOcp)ocptt.getOcpRef()).getId();
					Station station=data.getStationById(ocpttID);

					if(station!=null){
						if(!ocptt.getOcpType().equals("pass")){ //auch hier gibts Stopsignale etc; zudem sollen Passes sollen nicht angezeigt werden
							StopType stopType;
										
							//nur zur Initialisierung
							LocalTime arrival=null;
							LocalTime departure=null;
		
							String type=ocptt.getOcpType();
							switch(type){
								case "begin": stopType=StopType.BEGIN; break;
								case "pass": stopType=StopType.PASS; break;
								case "stop": stopType=StopType.STOP; break;
								default: stopType=StopType.END;
							}			
					
							LOGGER.info("StopType: "+stopType.toString());
					
					
						//TODO: Hier wird's etwas hässlich, unbedingt überprüfen, ob das funktioniert!
						if(stopType==StopType.STOP || stopType==StopType.END){	
							XMLGregorianCalendar calArrival=ocptt.getTimes().get(0).getArrival();		
							arrival=LocalTime.of(calArrival.getHour(), calArrival.getMinute(), calArrival.getSecond());
							LOGGER.info("Ankunft: "+arrival.toString());
						}
					
						if(stopType!=StopType.END){			
							XMLGregorianCalendar calDeparture=ocptt.getTimes().get(0).getDeparture();		
							departure=LocalTime.of(calDeparture.getHour(), calDeparture.getMinute(), calDeparture.getSecond());				
							LOGGER.info("Abfahrt: "+departure.toString());
						}
							
					
					
					
						String track="";
						if(ocptt.getTrackInfo()!=null){
							//track=Byte.parseByte(ocptt.getTrackInfo()); 
							track=ocptt.getTrackInfo();
							LOGGER.info("Gleis: "+track);
						} else {
							track="";
							LOGGER.info("Gleis: Keine Angabe [0]");} //warum auch immer manchmal kein Gleis dabei steht...
					
							Stop stop=new Stop(station, stopType, arrival, departure, track);
					
							if(stop.getStation()==null){
								LOGGER.info("Station ist NULL!");
							}
					
							stops.add(stop);
						}
					}
				}
				
				int trainNumber=Integer.parseInt(trainPart.getTrainNumber());
				
				//evtl. gehen die Categories eleganter, dasselbe gilt für die Ocp's weiter oben
				if(stops.size()>0){
					data.addTrainRoute(new TrainRoute(trainPart.getId(),trainNumber,data.getTrainCategoryById(((ECategory)trainPart.getCategoryRef()).getId()),stops));
				}
			}
		
		
		
		return data;
	}
}