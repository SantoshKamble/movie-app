package com.santosh.moviesapp;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


@SpringBootApplication
public class MoviesAppApplication {
	
	 private static final Logger LOGGER=LoggerFactory.getLogger(MoviesAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviesAppApplication.class, args);
		 LOGGER.info("MoviesAppApplication");
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	
	
	/*

	@Bean
	CommandLineRunner runner(CustomerService customerService,MovieService movieService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("C://Projects//ovies-app//src//main//resourcesjson/profiles.json");
			InputStream inputStream = new FileInputStream(new File("C:/Projects/movies-app/src/main/resources/profiles.json"));
			//read json file data to String
		//	byte[] jsonData = Files.readAllBytes(Paths.get("profiles.json"));
			
			
			
			//convert json string to object
			//Employee emp = objectMapper.readValue(jsonData, Employee.class);
			
			
			
			try {
				List<Customer> customers = mapper.readValue(inputStream,typeReference);
				customerService.save(customers);
				System.out.println("Users Saved!");
				System.out.println("Employee Object\n"+customers);
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
			
			File file = new File("C:/Projects/movies-app/src/main/resources/movies.xml");
		    XmlMapper xmlMapper = new XmlMapper();
		    String xml = inputStreamToString(new FileInputStream(file));
		    TypeReference<List<Movie>> typeReference1 = new TypeReference<List<Movie>>(){};
		    List<Movie> movies= xmlMapper.readValue(xml, typeReference1);
		    
		    movieService.save(movies);
		};
	}
	
	public String inputStreamToString(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    String line;
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    while ((line = br.readLine()) != null) {
	        sb.append(line);
	    }
	    br.close();
	    return sb.toString();
	} */
}
