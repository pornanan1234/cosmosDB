package com.example.accessingdatamongodb;



import java.util.Optional;
import org.bson.Document;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.mongodb.client.MongoClients;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private AppsRepository appsRepository;

	@Autowired
	private SalesAreaRepository salesAreaRepository;

	@Autowired
	private CustomerGroupRepository customerGroupRepository;


	@Autowired
	private UserRepository userRepository;


	@Autowired
	private SoldtoRepository soldtoRepository;

	@Autowired
	private UserMetadataRepository userMetadataRepository;


	@Autowired
	private AppMetadataRepository appMetadataRepository;

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private  PersonaRepository personaRepository;

	@Autowired
	private  NonAdminRoleRepository nonAdminRoleRepository;

	@Autowired
	private PermissionRepository permissionRepository;


	@Autowired
	private AdminRoleRepository adminRoleRepository;

	private static final Log log = LogFactory.getLog(AccessingDataMongodbApplication.class);


	private NonAdminRole CTI_Carrier_Role; // = new NonAdminRole("CTI Carrier", Arrays.asList("UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN","UG_CTI_CARRIER"));
	private NonAdminRole Invoice_payment_Role; // = new NonAdminRole("Invoices & Payments", Arrays.asList("helloooo","UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN","UG_INVOICE_HISTORY","UG_Payment_View","UG_SERVICEREQUEST_USER"));
	private NonAdminRole Logistic_Role; // = new NonAdminRole("logistics", Arrays.asList("helloooo","UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN"));
	private NonAdminRole Order_without_Price_Role;// = new NonAdminRole("Order With Out Pricing", Arrays.asList("helloooo","UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN"));
	private NonAdminRole Order_with_price_Role; //= new NonAdminRole("Order With Pricing", Arrays.asList("helloooo","UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN","UG_SERVICEREQUEST_USER"));
	private NonAdminRole Service_Request_Role;// = new NonAdminRole("Service Request", Arrays.asList("UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN","UG_SERVICEREQUEST_USER","UG_SETTINGS"));
	private NonAdminRole Supply_Management_Role;// = new NonAdminRole("Supply Management", Arrays.asList("UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN","UG_SERVICEREQUEST_USER","UG_ALLOCATIONS","UG_ALLOCATIONS_ADDON_INCREASE_ALLOCATION","UG_FORECAST","UG_FORECAST_ADDON_REQUEST_CHANGE","UG_SETTINGS","UG_ALERTS","UG_LOADING_DATA"));
	private NonAdminRole Buyback_Role; // = new NonAdminRole("Buyback", Arrays.asList("UG_EXTERNAL_USER","b2bcustomergroup","UG_ACCOUNT_ADMIN","UG_SERVICEREQUEST_USER","UG_SETTINGS"));
	private NonAdminRole CTI_Customer_Role;// = new NonAdminRole("CTI Customer", Arrays.asList("UG_CTI_CUSTOMER"));
	private NonAdminRole ACE_EXPRESS;// = new NonAdminRole("Lubes Distributor ACE Express", Arrays.asList("UG_EXTERNAL_USER","b2bcustomergroup","UG_PRIMARY_USER_MANAGEMENT","UG_ACCOUNT_ADMIN","UG_ORDER_HISTORY","UG_ACE_EXPRESS_User"));

	private AdminRole CA_Retail_Fuels_Buyer_Admin_Role;
	private AdminRole US_Retail_Fuels_Buyer_Admin_Role;
	private AdminRole MX_Retail_Fuels_Buyer_Admin_Role;
	private AdminRole CA_Commercial_Fuels_Buyer_Admin_Role;
	private AdminRole US_Commercial_Fuels_Buyer_Admin_Role;
	private AdminRole MX_Non_Retail_Fuels_Admin_Role;
	private AdminRole CA_Commercial_Fuels_Logistics_Buyer_Admin_Role;
	private AdminRole CA_Fuels_Supply_And_Refining_Buyer_Admin_Role;
	private AdminRole US_Fuels_Supply_And_Refining_Buyer_Admin_Role;
	private AdminRole CA_Retail_Lubes_Buyer_Admin_Role;
	private AdminRole US_Retail_Lubes_Buyer_Admin_Role;
	private AdminRole Mexico_Lubes_Buyer_Admin_Role;
	private AdminRole CA_US_Base_Stocks_And_Specialties_Buyer_Admin_Role;
	private AdminRole CA_US_MX_Lubes_Logistics_Buyer_Admin_Role;
	private AdminRole CA_US_Asphalt_Buyer_Admin_Role;
	private AdminRole SA_Lubes_Non_Retail_Buyer_Admin_Role;
	private AdminRole Peru_Fuels_Non_Retail_Buyer_Admin_Role;
	private AdminRole EUP__Aviation_Fuels_Buyer_Admin_Role;

	private Persona CA_Retail_Fuels_Buyer_Admin_Persona;
	private Persona US_Retail_Fuels_Buyer_Admin_Persona;
	private Persona MX_Retail_Fuels_Buyer_Admin_Persona;
	private Persona CA_Commercial_Fuels_Buyer_Admin_Persona;
	private Persona US_Commercial_Fuels_Buyer_Admin_Persona;
	private Persona MX_Non_Retail_Fuels_Admin_Persona;
	private Persona CA_Commercial_Fuels_Logistics_Buyer_Admin_Persona;
	private Persona CA_Fuels_Supply_And_Refining_Buyer_Admin_Persona;
	private Persona US_Fuels_Supply_And_Refining_Buyer_Admin_Persona;
	private Persona CA_Retail_Lubes_Buyer_Admin_Persona;
	private Persona US_Retail_Lubes_Buyer_Admin_Persona;
	private Persona Mexico_Lubes_Buyer_Admin_Persona;
	private Persona CA_US_Base_Stocks_And_Specialties_Buyer_Admin_Persona;
	private Persona CA_US_MX_Lubes_Logistics_Buyer_Admin_Persona;
	private Persona CA_US_Asphalt_Buyer_Admin_Persona;
	private Persona SA_Lubes_Non_Retail_Buyer_Admin_Persona;
	private Persona Peru_Fuels_Non_Retail_Buyer_Admin_Persona;
	private Persona EUP__Aviation_Fuels_Buyer_Admin_Persona;



	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}


	public List<Payer> payers =new ArrayList<>();

	public List<Shipto> shiptos = new ArrayList<>();
	public List<Soldto> soldtos = new ArrayList<>();
	public List<UserToken> userTokens = new ArrayList<>();
	public List<Persona> personaList =new  ArrayList<>();

	@Override
	public void run(String... args) throws Exception {

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object



		System.out.println("Refresh All Record?");
		String del = myObj.nextLine();  // Read user input

		if(del.equals("YES")) {
			repository.deleteAll();
			appsRepository.deleteAll();
			salesAreaRepository.deleteAll();
			customerGroupRepository.deleteAll();
			userRepository.deleteAll();
			soldtoRepository.deleteAll();
			userMetadataRepository.deleteAll();
			appMetadataRepository.deleteAll();

			userTokenRepository.deleteAll();
			personaRepository.deleteAll();
			nonAdminRoleRepository.deleteAll();
			permissionRepository.deleteAll();
			personaRepository.deleteAll();
			adminRoleRepository.deleteAll();

		}



		System.out.println("PopulatePermission Records?");
		String perm = myObj.nextLine();  // Read user input

		if(perm.equals("YES")) {
			//create permissions
			populatePermission();
		}

		System.out.println("PopulateNonADMIN Role Records?");
		String roleP = myObj.nextLine();  // Read user input

		if(roleP.equals("YES")) {
			//create permissions
			populateNonAdminRole();
		}


		System.out.println("PopulateADMIN Role Records?");
		String adminroleP = myObj.nextLine();  // Read user input

		if(adminroleP.equals("YES")) {
			//create permissions
			populateAdminRole();
		}



		System.out.println("Populate Persona Records?");
		String personaP = myObj.nextLine();  // Read user input

		if(personaP.equals("YES")) {
			//create permissions
			populatePersona();
		}



		System.out.println("Populate UserToken Records?");
		String userTokenP = myObj.nextLine();  // Read user input

		if(userTokenP.equals("YES")) {

			populatePayers();

			populateShiptos();
			populateSoldtos();
			populateUserToken();



		}
	}

	public void populateUserToken(){
		// Get user profile
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String addMoreUser = "Y";  // Read user input


		while (addMoreUser.equals("Y")) {
			System.out.println("Enter username");
			String userName = myObj.nextLine();  // Read user input
			System.out.println("Enter Email");
			String email = myObj.nextLine();  // Read user input
			System.out.println("Enter Name");
			String name = myObj.nextLine();  // Read user input

			System.out.println("Enter Tel");
			String tel = myObj.nextLine();  // Read user input

			System.out.println("Enter RoleType");
			String roleType = myObj.nextLine();  // Read user input

			String language = "EN";
			String country = "TH";
			String userType = "EXTERNAL";
			String status = "new";

			String addMoreSoldto = "Y";
			List<Soldto> selectedSoldto = new ArrayList<>();

			while (addMoreSoldto.equals("Y")) {


				System.out.println("Enter SoldTO (100000-100100)");
				System.out.println("* SoldTO (100000-100010) 1552_03_04 F0");
				System.out.println("* SoldTO (100011-100020) 1552_03_04 F1 (no persona)" );
				System.out.println("* SoldTO (100021-100030) 2235_03_04 F0 (no persona)");
				System.out.println("* SoldTO (100031-100040) 2235_03_04 F1 (no persona)");
				System.out.println("* SoldTO (100041-100050) 1552_01_02 F0");
				System.out.println("* SoldTO (100051-100060) 1552_03_02 F1 (no persona)");
				System.out.println("* SoldTO (100061-100070) 1552_03_02 F0");
				System.out.println("* SoldTO (100071-100080) 3862_03_02 F0");
				System.out.println("* SoldTO (100081-100090) 3862_03_04 F0");
				System.out.println("* SoldTO (100091-100100) 3862_01_02 F0");
				String soldtoNumber = myObj.nextLine();  // Read user input

				for (int i = 0; i < soldtos.size(); i++) {
					if (soldtos.get(i).getStripeNumber().equals(soldtoNumber)) {
						selectedSoldto.add(new Soldto(soldtos.get(i)));
					}

				}

				System.out.println("Want to add more SoldTO? (Y/N)");
				addMoreSoldto = myObj.nextLine();  // Read user input

			}
			System.out.println(selectedSoldto);


			List<String> notification = new ArrayList<>();
			notification.add(new String("OrderAck"));
			notification.add(new String("Shipment"));

			List<String> otherNotification = new ArrayList<>();
			otherNotification.add(new String("SMS"));
			otherNotification.add(new String("EMAIL"));


			UserPreference userPreference = new UserPreference(notification, otherNotification);


			User userprofile = new User(userName, email, name, userType, roleType, status, tel, language, country, userPreference);

			UserMetadata userMetadata = new UserMetadata(selectedSoldto);

// update to get persona



			List<Persona> selectedPersona = getPersonaList(selectedSoldto, roleType);
			System.out.println(selectedPersona);

			List<String> roleList = getRoleList(selectedPersona, roleType);



			if(!roleType.equals("ADMIN")){

				System.out.println("Please Select Role ");
				for(int i=0; i< roleList.size();i++) {
					System.out.print(i);
					System.out.print(" ");
					System.out.println(roleList.get(i));
				}
				// TBD add logic to get role input to the list

			}



			List<String> permissionList = getPermissionList(selectedPersona, roleType,roleList);
			List<String> appsList = getAppsList(selectedPersona);

			AppMetadata appMetadata = new AppMetadata(roleList, permissionList, appsList);
/*
		AppMetadata appMetadata = new AppMetadata(Arrays.asList(personaList.get(randomNum).getAdminRole().getName())
				, personaList.get(randomNum).getAdminRole().getPermissions()
				, personaList.get(randomNum).getAdminRole().getAppList());

*/
			userTokenRepository.save(new UserToken(userprofile, userMetadata, appMetadata));

			System.out.println("Add more User? (Y/N)");
			addMoreUser = myObj.nextLine();  // Read user input

		}


	}


	public List<String> getAppsList(List<Persona>  selectedPersona){
		List<String> returnApps = new ArrayList<>();
		for(int i=0;i < selectedPersona.size();i++){


		AdminRole tempAdminRole = adminRoleRepository.findById(selectedPersona.get(i).getAdminRole()).get();




			returnApps.addAll( tempAdminRole.getAppList());
		}

		List<String> listWithoutDuplicates = returnApps.stream()
				.distinct()
				.collect(Collectors.toList());
		return listWithoutDuplicates;
	}
	public List<String> getPermissionList(List<Persona>  selectedPersona,String roleType,List<String> roleList) {

		List<String> returnPermission =new ArrayList<>();

		if(roleType.equals("ADMIN")){
			for(int i=0;i < selectedPersona.size();i++){


				AdminRole tempAdminRole = adminRoleRepository.findById(selectedPersona.get(i).getAdminRole()).get();

				returnPermission.addAll( tempAdminRole.getPermissions());

			}
		}
		else { // Non-admin
			for(int i=0;i < selectedPersona.size();i++){

				List<String> nonAdminroleList = selectedPersona.get(i).getNonAdminList();

				for(int j=0; j< nonAdminroleList.size();j++) {

					NonAdminRole tempNonAdminRole = nonAdminRoleRepository.findById(selectedPersona.get(i).getNonAdminList().get(j)).get();

					if(roleList.contains(tempNonAdminRole.getName())) {
						returnPermission.addAll(tempNonAdminRole.getPermissions());
					}
				}


			}

		}

		List<String> listWithoutDuplicates = returnPermission.stream()
				.distinct()
				.collect(Collectors.toList());

		return listWithoutDuplicates;


	}


	public List<String> getRoleList(List<Persona>  selectedPersona,String roleType){
		List<String> retrunRole = new ArrayList<>();

		if(roleType.equals("ADMIN")){
			for(int i=0;i < selectedPersona.size();i++){

		//		AdminRole tempAdminRole = adminRoleRepository.findById(selectedPersona.get(i).getAdminRole()).get();


				retrunRole.add(selectedPersona.get(i).getAdminRole());


			}
		}
		else { // Non-admin
			for(int i=0;i < selectedPersona.size();i++){

				List<String> nonAdminroleList = selectedPersona.get(i).getNonAdminList();

				for(int j=0; j< nonAdminroleList.size();j++) {

					retrunRole.add(new String(nonAdminroleList.get(j)));


				}
			}

		}

		List<String> listWithoutDuplicates = retrunRole.stream()
				.distinct()
				.collect(Collectors.toList());

		return  listWithoutDuplicates;


	}

	public List<Persona> getPersonaList(List<Soldto> selectedSoldto,String roleType){
		List<Persona> returnPersona = new ArrayList<>();

		Persona tempP = new Persona();

		for (int i = 0; i < selectedSoldto.size(); i++) {
			tempP =personaRepository.findBySalesareasAndCustomerGroups(selectedSoldto.get(i).getSalesArea(),selectedSoldto.get(i).getCustomerGroup());

			if (tempP != null ) {
				returnPersona.add(tempP);
			}
		}


/*
		for(int j=0;j<personaList.size();j++) {
			for (int i = 0; i < selectedSoldto.size(); i++) {
				if(personaList.get(j).getSalesareas().contains( selectedSoldto.get(i).getSalesArea())&&
						personaList.get(j).getCustomerGroups().contains( selectedSoldto.get(i).getCustomerGroup())
				){
					returnPersona.add(new Persona(personaList.get(j)));
				}

			}
		}
*/

		return returnPersona;

	}


	public void populateSoldtos(){




		for(int i=1; i<=10;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "1552", "03", "04","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}

		for(int i=11; i<=20;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "1552", "03", "04","F1", true,
					Arrays.asList(shiptos.get(0))
					,Arrays.asList( payers.get(i))));
		}

		for(int i=21; i<=30;i++){
			soldtos.add(new Soldto("EU", String.valueOf(100000+i), "2235", "03", "04","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}
		for(int i=31; i<=40;i++){
			soldtos.add(new Soldto("EU", String.valueOf(100000+i), "2235", "03", "04","F1", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}
		for(int i=41; i<=50;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "1552", "01", "02","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}

		for(int i=51; i<=60;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "1552", "03", "02","F1", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}
		for(int i=61; i<=70;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "1552", "03", "02","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}
		for(int i=71; i<=80;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "3862", "03", "02","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}
		for(int i=81; i<=90;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "3862", "03", "04","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}
		for(int i=91; i<=100;i++){
			soldtos.add(new Soldto("NA", String.valueOf(100000+i), "3862", "01", "02","F0", true,
					Arrays.asList(shiptos.get(i),shiptos.get(100+i),shiptos.get(200+i),shiptos.get(300+i),shiptos.get(400+i),
							shiptos.get(500+i),shiptos.get(600+i),shiptos.get(700+i),shiptos.get(800+i),shiptos.get(900+i))
					,Arrays.asList( payers.get(i))));
		}


	}
	public void populatePayers(){

		payers.add(new Payer("*"));
		for(int i=1;i<=3000;i++){
			payers.add(new Payer(String.valueOf(100000 +i) ));
		}

	}

	public void populateShiptos(){

		shiptos.add(new Shipto("*"));

		for(int i=1;i<=800;i++){
			shiptos.add(new Shipto(String.valueOf(100000 +i) ));
		}
		for(int i=801;i<=2000;i++){
			shiptos.add(new Shipto(String.valueOf(100000 +i),payers.get(i) ));
		}


	}
	public void populateSalesarea(){

		salesAreaRepository.save(new SalesArea("0735_03_04","Thailand Retail Lubes"));
		salesAreaRepository.save(new SalesArea("0735_03_02","Thailand Retail Fuels"));
		salesAreaRepository.save(new SalesArea("1552_01_02","Cananda xx Fuels"));

	}

	public void populatePersona(){

		 Persona CA_Retail_Fuels_Buyer_Admin_Persona =new Persona(
		 		 "CA_Retail_Fuels_Buyer_Admin_Persona",
				 Arrays.asList("1552_01_02","1552_01_09"),
				 Arrays.asList("F0"),
				 adminRoleRepository.findByName("CA_Retail_Fuels_Buyer_Admin_Role"),
				 Arrays.asList( nonAdminRoleRepository.findByName("Supply_Management_Role"),
						 nonAdminRoleRepository.findByName("CTI_Customer_Role"),
						 nonAdminRoleRepository.findByName("Invoice_payment_Role"))
				 );

		personaRepository.save(CA_Retail_Fuels_Buyer_Admin_Persona);


		System.out.println( personaRepository.findBySalesareasAndCustomerGroups("1552_01_02","F0"));


		/*
		 Persona US_Retail_Fuels_Buyer_Admin_Persona;
		 Persona MX_Retail_Fuels_Buyer_Admin_Persona;
		 Persona CA_Commercial_Fuels_Buyer_Admin_Persona;
		 Persona US_Commercial_Fuels_Buyer_Admin_Persona;
		 Persona MX_Non_Retail_Fuels_Admin_Persona;
		 Persona CA_Commercial_Fuels_Logistics_Buyer_Admin_Persona;
		 Persona CA_Fuels_Supply_And_Refining_Buyer_Admin_Persona;
		 Persona US_Fuels_Supply_And_Refining_Buyer_Admin_Persona;
		 Persona CA_Retail_Lubes_Buyer_Admin_Persona;
		 Persona US_Retail_Lubes_Buyer_Admin_Persona;
		 Persona Mexico_Lubes_Buyer_Admin_Persona;
		 Persona CA_US_Base_Stocks_And_Specialties_Buyer_Admin_Persona;
		 Persona CA_US_MX_Lubes_Logistics_Buyer_Admin_Persona;
		 Persona CA_US_Asphalt_Buyer_Admin_Persona;
		 Persona SA_Lubes_Non_Retail_Buyer_Admin_Persona;
		 Persona Peru_Fuels_Non_Retail_Buyer_Admin_Persona;
		 Persona EUP__Aviation_Fuels_Buyer_Admin_Persona;

	*/

	}
	
	public void populateAdminRole(){


		 CA_Retail_Fuels_Buyer_Admin_Role = new AdminRole("CA_Retail_Fuels_Buyer_Admin_Role",
				 Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						 		permissionRepository.findByName("b2bcustomergroup").getId(),
						 permissionRepository.findByName("UG_PRIMARY_USER_MANAGEMENT").getId(),
						 permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						 permissionRepository.findByName("Tied to Order").getId(),
						 permissionRepository.findByName("UG_INVOICE_HISTORY").getId(),
						 permissionRepository.findByName("UG_Payment_View").getId(),
						 permissionRepository.findByName("UG_CTP_ADMIN").getId(),
						 permissionRepository.findByName("UG_SERVICEREQUEST_USER").getId(),
						 permissionRepository.findByName("UG_ALLOCATIONS").getId(),
						 permissionRepository.findByName("UG_ALLOCATIONS_ADDON_VIEW_CREDIT").getId(),
						 permissionRepository.findByName("UG_ALLOCATIONS_ADDON_INCREASE_ALLOCATION").getId(),
						 permissionRepository.findByName("UG_FORECAST_ADDON_REQUEST_CHANGE").getId(),
						 permissionRepository.findByName("UG_FORECAST").getId(),
						 permissionRepository.findByName("UG_SETTINGS").getId(),
						 permissionRepository.findByName("UG_ALERTS").getId(),
						 permissionRepository.findByName("UG_LOADING_DATA").getId(),
						 permissionRepository.findByName("UG_DTN_CANADA_BW").getId(),
						 permissionRepository.findByName("UG_GCAM_CUSTOMER_GROUP").getId(),
						 permissionRepository.findByName("UG_ESI_USER").getId(),
						 permissionRepository.findByName("UG_CTI_CUSTOMER").getId(),
						 permissionRepository.findByName("UG_BIP_USER").getId()),
				 Arrays.asList("SSP","ACE","BIP","MRC","SiteExperience","Midallia")
		 );
		adminRoleRepository.save(CA_Retail_Fuels_Buyer_Admin_Role);


		 /*
,Arrays.asList( nonAdminRoleRepository.findByName("Supply_Management_Role"),
						 nonAdminRoleRepository.findByName("CTI_Customer_Role"),
						 nonAdminRoleRepository.findByName("Invoice_payment_Role")),
						 


						 nonAdminRoleRepository.findByName("CTI_Customer_Role"),
						 nonAdminRoleRepository.findByName("Invoice_payment_Role")

		 US_Retail_Fuels_Buyer_Admin_Role;
		 MX_Retail_Fuels_Buyer_Admin_Role;
		 CA_Commercial_Fuels_Buyer_Admin_Role;
		 US_Commercial_Fuels_Buyer_Admin_Role;
		 MX_Non-Retail_Fuels_Admin_Role;
		 CA_Commercial_Fuels_Logistics_Buyer_Admin_Role;
		 CA_Fuels_Supply_And_Refining_Buyer_Admin_Role;
		 US_Fuels_Supply_And_Refining_Buyer_Admin_Role;
		 CA_Retail_Lubes_Buyer_Admin_Role;
		 US_Retail_Lubes_Buyer_Admin_Role;
		 Mexico_Lubes_Buyer_Admin_Role;
		 CA_US_Base_Stocks_And_Specialties_Buyer_Admin_Role;
		 CA_US_MX_Lubes_Logistics_Buyer_Admin_Role;
		 CA_US_Asphalt_Buyer_Admin_Role;
		 SA_Lubes_Non_Retail_Buyer_Admin_Role;
		 Peru_Fuels_Non-Retail_Buyer_Admin_Role;
		 EUP__Aviation_Fuels_Buyer_Admin_Role;
*/
	}


	public void populateNonAdminRole(){


		NonAdminRole CTI_Carrier_Role =new NonAdminRole("CTI_Carrier_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_CTI_CARRIER").getId()));
		nonAdminRoleRepository.save(CTI_Carrier_Role);



		NonAdminRole Invoice_payment_Role =new NonAdminRole("Invoice_payment_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_INVOICE_HISTORY").getId(),
						permissionRepository.findByName("UG_Payment_View").getId(),
						permissionRepository.findByName("UG_SERVICEREQUEST_USER").getId()
						));
		nonAdminRoleRepository.save(Invoice_payment_Role);

		NonAdminRole Logistic_Role =new NonAdminRole("Logistic_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_BUYBACK").getId()));
		nonAdminRoleRepository.save(Logistic_Role);

		NonAdminRole Order_without_Price_Role =new NonAdminRole("Order_without_Price_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId()));
		nonAdminRoleRepository.save(Order_without_Price_Role);

		NonAdminRole Order_with_price_Role =new NonAdminRole("Order_with_price_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_SERVICEREQUEST_USER").getId(),
						permissionRepository.findByName("UG_PRICING").getId()));
		nonAdminRoleRepository.save(Order_with_price_Role);

		NonAdminRole Service_Request_Role =new NonAdminRole("Service_Request_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_SERVICEREQUEST_USER").getId(),
						permissionRepository.findByName("UG_SETTINGS").getId()));
		nonAdminRoleRepository.save(Service_Request_Role);

		NonAdminRole Supply_Management_Role =new NonAdminRole("Supply_Management_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_SERVICEREQUEST_USER").getId(),
						permissionRepository.findByName("UG_ALLOCATIONS").getId(),
						permissionRepository.findByName("UG_ALLOCATIONS_ADDON_INCREASE_ALLOCATION").getId(),
						permissionRepository.findByName("UG_FORECAST").getId(),
						permissionRepository.findByName("UG_FORECAST_ADDON_REQUEST_CHANGE").getId(),
						permissionRepository.findByName("UG_SETTINGS").getId(),
						permissionRepository.findByName("UG_ALERTS").getId(),
						permissionRepository.findByName("UG_LOADING_DATA").getId()));
		nonAdminRoleRepository.save(Supply_Management_Role);

		NonAdminRole Buyback_Role =new NonAdminRole("Buyback_Role",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_SERVICEREQUEST_USER").getId(),
						permissionRepository.findByName("UG_SETTINGS").getId()
					));
		nonAdminRoleRepository.save(Buyback_Role);

		NonAdminRole CTI_Customer_Role =new NonAdminRole("CTI_Customer_Role",
				Arrays.asList( permissionRepository.findByName("UG_CTI_CUSTOMER").getId()
				));
		nonAdminRoleRepository.save(CTI_Customer_Role);

		NonAdminRole ACE_EXPRESS =new NonAdminRole("ACE_EXPRESS",
				Arrays.asList( permissionRepository.findByName("UG_EXTERNAL_USER").getId(),
						permissionRepository.findByName("b2bcustomergroup").getId(),
						permissionRepository.findByName("UG_PRIMARY_USER_MANAGEMENT").getId(),
						permissionRepository.findByName("UG_ACCOUNT_ADMIN").getId(),
						permissionRepository.findByName("UG_ORDER_HISTORY").getId(),
						permissionRepository.findByName("UG_ACE_EXPRESS_User").getId()
				));
		nonAdminRoleRepository.save(ACE_EXPRESS);


	}

	public void populatePermission(){
		permissionRepository.save(new Permission("UG_EXTERNAL_USER"));
		permissionRepository.save(new Permission("b2bcustomergroup"));
		permissionRepository.save(new Permission("UG_PRIMARY_USER_MANAGEMENT"));
		permissionRepository.save(new Permission("UG_ACCOUNT_ADMIN"));
		permissionRepository.save(new Permission("Tied to Order"));
		permissionRepository.save(new Permission("UG_INVOICE_HISTORY"));
		permissionRepository.save(new Permission("UG_Payment_View"));
		permissionRepository.save(new Permission("UG_CTP_ADMIN"));
		permissionRepository.save(new Permission("UG_LOGISTICS_CREDITCARD_USER"));
		permissionRepository.save(new Permission("UG_SERVICEREQUEST_USER"));
		permissionRepository.save(new Permission("UG_ALLOCATIONS"));
		permissionRepository.save(new Permission("UG_ALLOCATIONS_ADDON_VIEW_CREDIT"));
		permissionRepository.save(new Permission("UG_ALLOCATIONS_ADDON_INCREASE_ALLOCATION"));
		permissionRepository.save(new Permission("UG_FORECAST"));
		permissionRepository.save(new Permission("UG_FORECAST_ADDON_REQUEST_CHANGE"));
		permissionRepository.save(new Permission("UG_SETTINGS"));
		permissionRepository.save(new Permission("UG_ALERTS"));
		permissionRepository.save(new Permission("UG_LOADING_DATA"));
		permissionRepository.save(new Permission("UG_DTN_US_BW"));
		permissionRepository.save(new Permission("UG_DTN_US_WF"));
		permissionRepository.save(new Permission("UG_DTN_CANADA_BW"));
		permissionRepository.save(new Permission("UG_CARDSERVICES_USER"));
		permissionRepository.save(new Permission("UG_GCAM_CUSTOMER_GROUP"));
		permissionRepository.save(new Permission("UG_ORDER_ADMIN"));
		permissionRepository.save(new Permission("UG_ORDER_HISTORY"));
		permissionRepository.save(new Permission("UG_MEXICAN_FUELS_ORDER_ADMIN"));
		permissionRepository.save(new Permission("UG_MEXICAN_FUELS_ORDER_HISTORY"));
		permissionRepository.save(new Permission("UG_PRICING"));
		permissionRepository.save(new Permission("UG_LOGISTICS_USER"));
		permissionRepository.save(new Permission("UG_ACE_EXPRESS_User"));
		permissionRepository.save(new Permission("UG_ESI_USER"));
		permissionRepository.save(new Permission("UG_MEA_USER"));
		permissionRepository.save(new Permission("UG_CTI_CUSTOMER"));
		permissionRepository.save(new Permission("UG_CTI_CARRIER"));
		permissionRepository.save(new Permission("UG_BIP_USER"));
		permissionRepository.save(new Permission("UG_BUYBACK"));


	}
	public void buildnonAdminRolesList (List<NonAdminRole> nonAdminlist ){

		nonAdminlist.add(CTI_Carrier_Role);
		nonAdminlist.add(Invoice_payment_Role);
		nonAdminlist.add(Logistic_Role);
		nonAdminlist.add(Order_without_Price_Role);
		nonAdminlist.add(Order_with_price_Role);
		nonAdminlist.add(Service_Request_Role);
		nonAdminlist.add(Supply_Management_Role);
		nonAdminlist.add(Buyback_Role);
		nonAdminlist.add(CTI_Customer_Role);
		nonAdminlist.add(ACE_EXPRESS);


		nonAdminlist.forEach((temp) -> {
		//	nonAdminRoleRepository.save(temp);
		});


	}

}
