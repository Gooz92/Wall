package wall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@ComponentScan(basePackages = "wall")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver getVelocityViewResolver() {
		VelocityViewResolver viewResolver = new VelocityViewResolver();
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".vm");
		viewResolver.setCache(true);
		return viewResolver;
	}
	
/*	@Bean
	public ViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	
	@Bean 
	public VelocityConfig getVelocityConfig() {
		VelocityConfigurer config = new VelocityConfigurer();
		config.setResourceLoaderPath("/WEB-INF/velocity/");
		return config;
	}
}
