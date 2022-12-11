package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.AdvertDao;
import emlakcepte.model.Advert;
import emlakcepte.model.Realty;

public class AdvertService {
	
	// Singleton pattern
	private AdvertDao advertDao = AdvertDao.getInstance();
	
	private  RealtyService realtyService = RealtyService.getInstance();
	
	private static AdvertService advertService = new AdvertService();
	
	private AdvertService() {
		
	}
	
	public static AdvertService getInstance() {
		return advertService;
	}
	// Creates city adverts
	public void createAdvert(String province) {
		if (checkAdvertStatus(province) == true) {
			List <Realty> realty= realtyService.getAllProvinceRealty(province);
			advertDao.createAdvert(province, realty);
		}
	}
	// Checks number of province by cities
	public boolean checkAdvertStatus(String province) {
		if (realtyService.getNumberOfProvinceRealty(province) >= 10)
			return true;
		return false;
	}
	// Gives all adverts
	public List<Advert> getAll(){
		return advertDao.getAdvert();
	}
	// Prints all adverts
	public void printAll(List<Advert> advertList) {
		advertList.forEach(advert -> System.out.println(
				"Advert City: " + advert.getName() + 
				"\nadvert: " + advert.getAdvertList() + 
				"\nRealty number: "+ advert.getAdvertList().size()));
	}
	
	
	
}
