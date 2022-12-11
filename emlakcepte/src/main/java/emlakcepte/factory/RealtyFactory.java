package emlakcepte.factory;

import emlakcepte.model.Housing;
import emlakcepte.model.Plot;
import emlakcepte.model.Realty;
import emlakcepte.model.WorkPlace;

public class RealtyFactory {
	// gives the desired type of realty
	public  Realty getRealty(String type) {
        if(type == null)  return null;   
		if("Housing".equalsIgnoreCase(type)) return new Housing();
		if("Plot".equalsIgnoreCase(type)) return new Plot();
		if("WorkPlace".equalsIgnoreCase(type)) return new WorkPlace();
		
		return null;
	}

}
