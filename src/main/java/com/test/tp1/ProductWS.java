package com.test.tp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProductWS {

	@Autowired
	Product product;
	
	@GetMapping("ajouter/{nom}/{brasserie}/{type}/{note}/{region}")
	public String ajouterBiere(
			@PathVariable("nom") String nom, 
			@PathVariable("brasserie") String brasserie,
			@PathVariable("type") String type,
			@PathVariable("note") Integer note,
			@PathVariable("region") String region) {
		try {
			manager.ajouterBiere(new Biere(nom, brasserie, type, note, region));
		} catch (BiereException e) {
			return "insertion impossible : " + e.getMessage();
		}
		return "insertion reussie";
	}
}
