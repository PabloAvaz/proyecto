package com.conf;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, estatus from usuario where username=?")
			.authoritiesByUsernameQuery("select u.username, p.perfil from perfilusuario up "
					+ "inner join usuario u on u.id = up.idUsuario "
					+ "inner join perfil p on p.idPerfil = up.idPerfil "
					+ "where u.username = ?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//Estatico
		.antMatchers(
				"/images/**",
				"/img/**",
				"/css/**",
				"/bootstrap/**"
				).permitAll()
		//Vistas publicas
		.antMatchers(
				"/",
				"/play",
				"/signup",
				"/bcript/**",
				"/logout/**",
				"/usuarios/list/"
				).permitAll()
		
		//Permisos por roles
		.antMatchers("/usuarios/**").hasAnyAuthority("ADMIN")
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/tienda/**").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/perfil/**").hasAnyAuthority("ADMIN","USER")
		.antMatchers("/enviar").hasAnyAuthority("ADMIN","USER")

		//El resto autenticarse
		.anyRequest().authenticated()
		
		//permitir login
		.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/", true)
			.failureUrl("/login/error")
			.permitAll();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
