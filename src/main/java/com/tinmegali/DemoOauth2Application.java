package com.tinmegali;

import com.tinmegali.models.Account;
import com.tinmegali.repositories.AccountRepo;
import com.tinmegali.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.security.auth.login.AccountException;
import java.util.Arrays;

@SpringBootApplication
public class DemoOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoOauth2Application.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner init(
			AccountService accountService
	) {
		return (evt) -> Arrays.asList(
				"user,admin,john,robert,ana".split(",")).forEach(
						username -> {
							Account acct = new Account();
							acct.setUsername(username);
							acct.setPassword(passwordEncoder().encode("password"));
							acct.setFirstName(username);
							acct.setLastName("LastName");
							acct.grantAuthority("USER");
							if ( username.equals("admin") )
								acct.grantAuthority("ADMIN");
							try {
								accountService.register(acct);
							} catch (AccountException e) {
								e.printStackTrace();
							}
						}
		);
	}
}
