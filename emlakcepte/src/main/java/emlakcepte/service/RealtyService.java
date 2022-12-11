package emlakcepte.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.Category;
import emlakcepte.model.Realty;
import emlakcepte.model.Housing;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class RealtyService {

	// Singleton pattern
	private RealtyDao realtyDao = RealtyDao.getInstance();
	
	private static RealtyService realtyService = new RealtyService();
	
	private RealtyService() {
		
	}
	
	public static RealtyService getInstance() {
		return realtyService;
	}
	
	// If userType is Indıvıdual, user can create maximum 3 housing
	//If userType is Corparete, user create limitless realty
	@SuppressWarnings("finally")
	public Realty createRealty(String realty,Long no, String title, LocalDateTime time, User user,
			RealtyType status, String province, String district, Category category) { 
		
		try {
			if(user.getType().equals(UserType.INDIVIDUAL)) {
				if (controlUser(user ,realty) == true) {
						return realtyDao.createRealty(realty, no, title, time, user, 
								status, province, district, category);
						}
				System.out.println(user.getName() + " can not create this type realty: "  + realty);
				
			}else if (user.getType().equals(UserType.CORPARETE)) {
				return realtyDao.createRealty(realty, no, title, time, user, 
						status, province, district, category);		
			
			}System.out.println("Cannot created realty!! "+ realty +" for " +user.getName());
				return null;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return null;
		}
	}
	
	// Check individual user adverts
	public boolean controlUser(User user, String realty) {
		long count = getAllByUserName(user).stream()
				.filter(c -> c.getClass().getClass().getSimpleName().equalsIgnoreCase(realty))
				.count(); 
		
		if (count <3 &&  realty.equalsIgnoreCase("Housing") ) {	
			return true;
		}
		return false;
	}
	// Gives all realty
	public List<Realty> getAll(){
		return realtyDao.findAll();
	}
	// Prints all realty
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}
	// Gives all realty by city
	public void getAllByProvince(String province) {
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		//.count();
		.forEach(realty -> System.out.println(realty));		
	}
	// Gives all realty by username
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}
	// Gives realty list for Adverts
	public List<Realty> getAllProvinceRealty(String province) {
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.toList();
	}
	// Gives number of housing on sale
	public long getNumberOfHousingOnSale(String province){
		return getAll().stream()
			.filter(realty -> realty.getProvince().equals(province))
			.filter(realty -> realty.getCategory().equals(Category.SALE))
			.filter(realty -> realty.getClass().equals(Housing.class))
			.count();
	}
	// Gives number of realty by province
	public long getNumberOfProvinceRealty(String province) {	
		return getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.count();
	}
	// All listings by city and county
	public void getAllByProvinceAndDistrict(String province, String district) {
		getAll().stream().filter(realty -> realty.getProvince().equals(province))
		.filter(realty -> realty.getDistrict().equalsIgnoreCase(district))
		.forEach(realty -> System.out.println(realty));
	}
	// User active realty
	public List<Realty> getActiveRealtyByUserName(User user) {
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}
}
