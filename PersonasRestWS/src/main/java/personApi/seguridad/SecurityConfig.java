package personApi.seguridad;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception{
		authenticationMgr.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery(
			"select nombre_usuario,hashed_pwd,enabled from mydb.usuarios where nombre_usuario=?")
		.authoritiesByUsernameQuery(
				"select nombre_usuario, rol from mydb.roles_usuario where nombre_usuario=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/persona*").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/persona*").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/persona*").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/persona*").hasRole("ADMIN")
		.and()
		.httpBasic();
		
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/provincia*").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/provincia*").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/provincia*").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/provincia*").hasRole("ADMIN")
		.and()
		.httpBasic();
		
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/localidad*").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/localidad*").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/localidad*").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/localidad*").hasRole("ADMIN")
		.and()
		.httpBasic();
		
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/tipoDocumento*").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/tipoDocumento*").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/tipoDocumento*").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/tipoDocumento*").hasRole("ADMIN")
		.and()
		.httpBasic();
	}
}