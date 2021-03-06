package com.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${ruta.imagenes}")
	private String rutaImagenes;
	@Value("${ruta.sonidos}")
	private String rutaSonidos;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("file:" + rutaImagenes);
		registry.addResourceHandler("/sounds/**").addResourceLocations("file:"+ rutaSonidos);
	}
}
