package edu.cpp.cs580;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.firebase.client.Firebase;

import edu.cpp.cs580.data.provider.EBayGPSItemProvider;
import edu.cpp.cs580.data.provider.FSUserManager;
import edu.cpp.cs580.data.provider.FirebaseUserManager;
import edu.cpp.cs580.data.provider.GPSDataProvider;
import edu.cpp.cs580.data.provider.UserManager;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class.getName());
    /**
     * This is a good example of how Spring instantiates
     * objects. The instances generated from this method
     * will be used in this project, where the Autowired
     * annotation is applied.
     */
    @Bean
    public UserManager userManager() {    	
        UserManager userManager =  new FirebaseUserManager(); //new FSUserManager();
        return userManager;
    }
    
    @Bean
    public GPSDataProvider gpsDataProvider() {
    		return new EBayGPSItemProvider();
    }
    
    /**
     * This is the running main method for the web application.
     * Please note that Spring requires that there is one and
     * ONLY one main method in your whole program. You can create
     * other main methods for testing or debugging purposes, but
     * you cannot put extra main method when building your project.
     */
    public static void main(String[] args) throws Exception {
        // Run Spring Boot
        SpringApplication.run(App.class, args);
    }
}
