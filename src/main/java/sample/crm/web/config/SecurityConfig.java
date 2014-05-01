package sample.crm.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().
		withUser("dinger").password("123456").roles("ANONYMOUS").and().
		withUser("dingeruser").password("123456").roles("USER").and().
		withUser("dingeradmin").password("123456").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/user/**")
				.access("hasRole('ROLE_USER')").and().formLogin();

		http.authorizeRequests().antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN')").and().formLogin();

		http.authorizeRequests().antMatchers("/*").permitAll();

	}

}