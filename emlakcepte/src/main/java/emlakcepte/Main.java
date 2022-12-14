package emlakcepte;

import java.time.LocalDateTime;
import java.util.List;
import emlakcepte.model.Category;
/*
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
*/
import emlakcepte.model.Message;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;
import emlakcepte.model.UserType;
import emlakcepte.service.AdvertService;
import emlakcepte.service.RealtyService;
import emlakcepte.service.SearchService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {

		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		//UserService userService = new UserService();
		// UserService Singleton pattern
		UserService userService = UserService.getInstance();

		//UserService userService = applicationContext.getBean(UserService.class);	
		User userPelin = userService.createUser("Pelin", "pelin@gmail.com", "Pelin123",UserType.INDIVIDUAL);
		User userSemih = userService.createUser("Semih", "semih@gmail.com", "123", UserType.CORPARETE);
		// Semih your password is too short try again
		
		User userCem =  userService.createUser("Cem", "cem@gmail.com", "Cem12345", UserType.CORPARETE);
		User userGizem = userService.createUser("Gizem", "gizem@gmail.com", "Gizem123", UserType.CORPARETE);
		User userSami = userService.createUser("Sami", "sami@gmail.com", "Sami12345", UserType.CORPARETE);

		//Change password operation
		System.out.println("User: " + userSami.getName() +
				" old password: " + userSami.getPassword());
		
		userService.updatePassword(userSami, "Sami6789");
		
		System.out.println("User: " + userSami.getName() +
				" new password: " +userSami.getPassword());
		
		/* Output:User: Sami old password: Sami12345
				User: Sami new password: Sami6789
		 */
		
		System.out.println("-----");

		// Get all users
		userService.printAllUser();
		System.out.println("-----");
		
		/* Output:
			User: Pelin
			User: Cem
			User: Gizem
			User: Sami
		*/

		//RealtyService realtyService = new RealtyService();		
		// RealtyService Singleton pattern
		RealtyService realtyService = RealtyService.getInstance();

		realtyService.createRealty(
				"Housing", 123L, "ZEKER??YAK??Y ' de 1200 M2 Sat??l??k V??LLA",
				LocalDateTime.now(), userPelin, RealtyType.ACTIVE, "??stanbul", "Sar??yer",Category.SALE);
		
		realtyService.createRealty(
				"WorkPlace", 124L, "B??y??kdere kapal?? alanl?? PLAZA",
				LocalDateTime.now(), userPelin, RealtyType.ACTIVE, "??stanbul", "Sar??yer",Category.SALE);
		
		// Pelin can not create this type realty: WorkPlace
		// Cannot created realty!! WorkPlace for Pelin

		realtyService.createRealty(
				"Housing", 125L, "KAVAKPINAR MAHALLES??NDE 2+1 80 M2 ARAKAT ??SKANLI",
				LocalDateTime.now(), userPelin, RealtyType.ACTIVE, "Ankara", "??ankaya",Category.SALE);
		
		realtyService.createRealty(
				"Housing", 126L, "KARTALTEPE MAHALLES??NDE 2+1 DA??RE",
				LocalDateTime.now(), userCem, RealtyType.PASSIVE, "??stanbul", "Bayrampa??a",Category.RENT);

		realtyService.createRealty(
				"Housing", 127L, "Beyo??lu berk emlaktan istiklalde dubleks",
				LocalDateTime.now(), userCem, RealtyType.ACTIVE, "??stanbul", "BEYO??LU",Category.SALE);
		
		realtyService.createRealty(
				"WorkPlace", 128L, "Ni??anta???? Abdi ??pek??i de Showroom",
				LocalDateTime.now(), userCem, RealtyType.ACTIVE, "??stanbul", "??i??li",Category.SALE);

		realtyService.createRealty(
				"Plot", 129L, "Sancaktepe 408 m?? Sat??l??k Arsa",
				LocalDateTime.now(), userCem, RealtyType.ACTIVE, "??stanbul", "Sancaktepe",Category.SALE);
		
		realtyService.createRealty(
				"Plot", 130L, "Tuzla Tepe??rende 3252 m2 Villa ??marl?? Arsa",
				LocalDateTime.now(), userSami, RealtyType.ACTIVE, "??stanbul", "Tuzla",Category.SALE);

		realtyService.createRealty(
				"Plot", 131L, "S??L??VR?? BALABAN 204 m2 Kat ittifak Tapulu",
				LocalDateTime.now(), userSami, RealtyType.ACTIVE, "??stanbul", "Silivri",Category.SALE);
		
		realtyService.createRealty(
				"Housing", 132L, "MASLAK 1453 DE TEM??Z FERAH CADDE CEPHEL??",
				LocalDateTime.now(), userGizem, RealtyType.ACTIVE, "??stanbul", "Sar??yer",Category.RENT);

		realtyService.createRealty(
				"Housing", 133L, "??????L??'DE  E??YALI TEM??Z DA??RE",
				LocalDateTime.now(), userGizem, RealtyType.ACTIVE, "??stanbul", "??i??li",Category.SALE);
		
		realtyService.createRealty(
				"Housing", 134L, "K??RALIK B??Y??K BAH??E DUBLEKS?? 495 m2",
				LocalDateTime.now(), userGizem, RealtyType.ACTIVE, "??stanbul", "Be??ikta??",Category.RENT);
		
		// All adverts in the system
		System.out.println("Adverts: ");
		realtyService.printAll(realtyService.getAll());
		System.out.println("-----");
		
		// Adverts in Istanbul
		System.out.println("Adverts in Istanbul: ");
		realtyService.getAllByProvince("??stanbul");
		System.out.println("-----");

		// City, District search
		System.out.println("Istanbul Sar??yer Adverts: ");
		realtyService.getAllByProvinceAndDistrict("??stanbul","Sar??yer");
		
		/* Output: Istanbul Sar???yer Adverts: 
		Realty [no=123, title=ZEKER???YAK???Y ' de 1200 M2 Sat???l???k V???LLA, publishedDate=2022-12-09T20:02:28.291829900, user=User [name=Pelin], status=ACTIVE, category=SALE, province=???stanbul, district=Sar???yer]
		Realty [no=132, title=MASLAK 1453 DE TEM???Z FERAH CADDE CEPHEL???, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Gizem], status=ACTIVE, category=RENT, province=???stanbul, district=Sar???yer]
		*/
		
		System.out.println("-----");
		
		// Number of adverts in cities
		System.out.println("Number of realty in Istanbul: "
				+ realtyService.getNumberOfProvinceRealty("??stanbul"));
		
		System.out.println("Number of realty in Ankara: "
				+ realtyService.getNumberOfProvinceRealty("Ankara"));
		
		System.out.println("Number of realty in ??zmir: "
		+ realtyService.getNumberOfProvinceRealty("??zmir"));
		
		/* Output
		Number of realty in Istanbul: 10
		Number of realty in Ankara: 1
		Number of realty in ???zmir: 0
		 */
		
		System.out.println("-----");

		// On sale housing in cities 
		System.out.println("Number of houses for sale in Istanbul: "
				+ realtyService.getNumberOfHousingOnSale("??stanbul"));
		
		System.out.println("Number of houses for sale in Ankara "
				+ realtyService.getNumberOfHousingOnSale("Ankara"));
		
		System.out.println("Number of houses for sale in ??zmir "
				+ realtyService.getNumberOfHousingOnSale("??zmir"));
		
		/*Output
		Number of realty in Istanbul: 10
		Number of realty in Ankara: 1
		Number of realty in ???zmir: 0
		 */

		System.out.println("-----");
		
		// City adverts reqiured minimum 10 realty
		AdvertService advertService = AdvertService.getInstance();
		advertService.createAdvert("??stanbul");
		advertService.printAll(advertService.getAll());
		
		/*Output
		 Advert City: ???stanbul
			advert: [Realty [no=123, title=ZEKER???YAK???Y ' de 1200 M2 Sat???l???k V???LLA, publishedDate=2022-12-09T20:02:28.291829900, user=User [name=Pelin], status=ACTIVE, category=SALE, province=???stanbul, district=Sar???yer], Realty [no=126, title=KARTALTEPE MAHALLES???NDE 2+1 DA???RE, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Cem], status=PASSIVE, category=RENT, province=???stanbul, district=Bayrampa???a], Realty [no=127, title=Beyo???lu berk emlaktan istiklalde dubleks, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Cem], status=ACTIVE, category=SALE, province=???stanbul, district=BEYO???LU], Realty [no=128, title=Ni???anta?????? Abdi ???pek???i de Showroom, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Cem], status=ACTIVE, category=SALE, province=???stanbul, district=???i???li], Realty [no=129, title=Sancaktepe 408 m??? Sat???l???k Arsa, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Cem], status=ACTIVE, category=SALE, province=???stanbul, district=Sancaktepe], Realty [no=130, title=Tuzla Tepe???rende 3252 m2 Villa ???marl??? Arsa, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Sami], status=ACTIVE, category=SALE, province=???stanbul, district=Tuzla], Realty [no=131, title=S???L???VR??? BALABAN 204 m2 Kat ittifak Tapulu, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Sami], status=ACTIVE, category=SALE, province=???stanbul, district=Silivri], Realty [no=132, title=MASLAK 1453 DE TEM???Z FERAH CADDE CEPHEL???, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Gizem], status=ACTIVE, category=RENT, province=???stanbul, district=Sar???yer], Realty [no=133, title=?????????L???'DE  E???YALI TEM???Z DA???RE, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Gizem], status=ACTIVE, category=SALE, province=???stanbul, district=???i???li], Realty [no=134, title=K???RALIK B???Y???K BAH???E DUBLEKS??? 495 m2, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Gizem], status=ACTIVE, category=RENT, province=???stanbul, district=Be???ikta???]]
			Realty number: 10
		 */
		
		System.out.println("-----");

		System.out.println("Pelin adverts");
		// Get all adverts of user
		realtyService.printAll(realtyService.getAllByUserName(userPelin));
		
		/*Output
		Pelin adverts
		Realty [no=123, title=ZEKER???YAK???Y ' de 1200 M2 Sat???l???k V???LLA, publishedDate=2022-12-09T20:02:28.291829900, user=User [name=Pelin], status=ACTIVE, category=SALE, province=???stanbul, district=Sar???yer]
		Realty [no=125, title=KAVAKPINAR MAHALLES???NDE 2+1 80 M2 ARAKAT ???SKANLI, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Pelin], status=ACTIVE, category=SALE, province=Ankara, district=???ankaya]
		*/
		System.out.println("-----");
		

		// Get active adverts for user
		System.out.println("Sami's active adverts");
		realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));
		/*Output
		Sami's active adverts
		Realty [no=130, title=Tuzla Tepe???rende 3252 m2 Villa ???marl??? Arsa, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Sami], status=ACTIVE, category=SALE, province=???stanbul, district=Tuzla]
		Realty [no=131, title=S???L???VR??? BALABAN 204 m2 Kat ittifak Tapulu, publishedDate=2022-12-09T20:02:28.304796200, user=User [name=Sami], status=ACTIVE, category=SALE, province=???stanbul, district=Silivri]
		*/
		System.out.println("-----");

		// SearchService Singleton pattern
		SearchService searchService = SearchService.getInstance();
		
		// Search objects
		searchService.createSearch(userPelin, "??stanbul Maltepe");
		searchService.createSearch(userSami, "Zekeriyak??y kiral??k ev");
		searchService.createSearch(userSami, "Ankara");
		searchService.createSearch(userCem, "Zekeriyak??y sat??l??k ev");
		searchService.createSearch(userCem, "??zmir kiral??k ev");
		searchService.createSearch(userGizem, "??zmir Bornova sat??l??k ev");

		// Specific searches by user
		searchService.printAll(searchService.getAllByUserName(userCem));
		/* Output: 
		 Search: Cem: Zekeriyak???y sat???l???k ev
		Search: Cem: ???zmir kiral???k ev
		 */

		System.out.println("-----");


		Message message = new Message("acil d??n????", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
				userSami);
		userSami.setMessages(List.of(message));
		userPelin.setMessages(List.of(message));
		userSami.getMessages();


	}


}