package br.com.simples.api_movies.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.simples.api_movies.repositorys.UserRepository;

//ESSA ANOTAÇÃO HABILITA O SPRING SECURITY (MÓDULO DE SEGURANÇA).
@EnableWebSecurity
//DIZ PARA O COMPILADOR DO SPRING QUE VÃO SER APLICADAS CONFIGURAÇÕES NESSA CLASSE.
@Configuration

public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// SERVE PARA CONFIGURAR AS OPÇÕES DE AUTENTICAÇÃO (CONTROLE DE ACESSO/LOGIN E
	// ETC)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// chama um método que receberá o serviço que ensina o spring a se autenticar.
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// CONFIGURAÇÃO DE AUTORIZAÇÃO (URL, USUÁRIOS QUE PODEM ACESSAR CADA URL, PERFIL
	// DE ACESSO)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// servirá pra indicar os requests
		http.authorizeRequests()
				// define qual url(e também o método que desejamos(opcional)) filtraremos e
				// passaremos a permissão
				.antMatchers(HttpMethod.GET, "/home").permitAll().antMatchers(HttpMethod.POST, "/login").permitAll()
				// diz que todas as outras requisições precisarão de autenticação.
				.anyRequest().permitAll()
				// desabilita o cros
				.and().csrf().disable()
				// estamos dizendo abaixo a politica de criação será stateless, ou seja,via
				// token
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(new AutenticacaoTokenFilter(tokenService, userRepository),
						UsernamePasswordAuthenticationFilter.class);
	}

	// CONFIGURAÇÃO DE RECURSOS ESTÁTICOS -> REQUISIÇÕES PARA (JS, CSS, IMAGENS).
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
