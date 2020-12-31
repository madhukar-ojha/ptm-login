package com.ptm.login.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
//import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
public class ViewResolverConfig implements WebMvcConfigurer {
//	@Autowired private RequestInterceptor requestInterceptor;
	
	/*
	 * @Override public void addFormatters(FormatterRegistry registry) {
	 * registry.addFormatter(new GenderStringConverter()); }
	 */

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:application_en_US");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	/*
	 * @Bean public MappingJackson2HttpMessageConverter conveters() { return new
	 * MappingJackson2HttpMessageConverter(); }
	 */
	
	public feign.codec.Decoder feignDecoder(@Autowired ObjectFactory<HttpMessageConverters> messageConverters) {
		  return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
		}
	
}
