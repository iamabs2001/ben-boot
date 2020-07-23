package bencyle.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
	
	@Bean
	protected UserDetailsService userDetailsService() {		
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("sigma").password("hero").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("iamabs2001").password("hero").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("admin").password("hero").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("user").password("hero").roles("USER").build());
		return new InMemoryUserDetailsManager(users);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
	}
	

}
				