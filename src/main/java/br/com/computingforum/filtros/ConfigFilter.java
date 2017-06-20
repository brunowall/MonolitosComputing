package br.com.computingforum.filtros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ConfigFilter  extends WebMvcConfigurerAdapter{
@Autowired FilterLogin filtro;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(filtro).addPathPatterns("/logout","addquestion","/fazer-pergunta","/admin/*");
		
	}
}
