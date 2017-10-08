package edu.eci.cosw.pancomido;

import edu.eci.cosw.pancomido.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableJpaRepositories("edu.eci.cosw.examples.productorders.repositories")
@EntityScan("edu.eci.cosw.pancomido.model")
public class PancomidoApplication {

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(PancomidoApplication.class, args);
	}
}
