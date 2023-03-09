package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import com.example.domains.Serie;
import com.example.repositories.SerieRepository;
import com.example.services.SerieService;

import org.apache.catalina.core.ApplicationContext;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {


	@Test
	void testName() {
		
	}

	@Autowired
	SerieService serieService;
	
	@Autowired
	SerieRepository serieRepository;

	@Test
	void contextLoads() {
		//System.out.println("booo");
		
		Serie serie =new Serie();
		serie.setCover("cover");
		serie.setTitolo("titolo");
		serie.setGenere("genere");
		serie.setLink("link");
		serie.setTrailer("trailer");
		serie.setDescrizione("descrizione");
		serie.setCast("cast");
		Serie newserie=serieService.save(serie).get();
		Optional<Serie> opt=serieService.findById(newserie.getId());
		Serie recSerie=null;
		if (opt.isPresent())
			recSerie=opt.get();
		newserie.setCover("ciao");
	 assertTrue(true);
	}
}
