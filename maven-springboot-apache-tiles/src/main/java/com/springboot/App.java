package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

// Auto creates beans depending on the configuration
// @EnableAutoConfiguration
// @ComponentScan
// When it starts the main application, it searches for other classes with
// annotations like @Controller and many more and it shld create objects
// from those classes
//

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		System.out.println("First Springboot application");
		// Starts the embedded Tomcat server
		SpringApplication.run(App.class, args);

	}

	// //////////////////////////////////////////////////////////////////////////////
	//
	// @Bean
	// use @Bean when spring has to create beans for the returned object
	// this should be considered as a bean
	//
	// UrlBasedViewResolver
	// resolves view for the tiles
	//
	// TilesView
	// {@link org.springframework.web.servlet.View} implementation that renders
	// through the Tiles Request API. The "url" property is interpreted as name
	// of a Tiles definition
	//
	// ////////////////////////////////////////////////////////////////////////////

	@Bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}

	// //////////////////////////////////////////////////////////////////////////////
	//
	// @Bean
	// use @Bean when spring has to create beans for the returned object
	// this should be considered as a bean
	//
	// TilesConfigurer
	// The TilesConfigurer simply configures a TilesContainer using a set of
	// files containing definitions, to be accessed by {@link TilesView}
	// instances.
	//
	// You must tell Tiles what configuration(like XML) you are using to
	// configure the layout of the site in a format that tiles understand
	// So specify the location tiles.xml(It is the configuration file for tiles)
	// 1. create layouts folder and create default.jsp (this consumes tiles)
	//
	// 2. create content for default.jsp, so create tiles folder
	// a) about.jsp
	// b) home.jsp
	//
	// 3. use tiles.xml to configure the defaulting tiles for default.jsp
	//
	// ////////////////////////////////////////////////////////////////////////////

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		String[] defs = { "/WEB-INF/tiles.xml" };
		tilesConfigurer.setDefinitions(defs);

		return tilesConfigurer;
	}

}
