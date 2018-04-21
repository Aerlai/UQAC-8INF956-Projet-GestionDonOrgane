package com.websystique.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springsecurity.model.Hopital;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.service.HopitalService;
import com.websystique.springsecurity.service.UserProfileService;

@Component
public class HopitalNameToHopitalConverter implements Converter<Object, Hopital>{

	@Autowired
	HopitalService hopitalService;

	/*
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Hopital convert(Object element) {
		String name = ((String)element);
		Hopital hopital= hopitalService.findByName(name);
		System.out.println("Hopital : "+hopital);
		return hopital;
	}
	
	/*
	 * Gets UserProfile by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/*
	public UserProfile convert(Object element) {
		String type = (String)element;
		UserProfile profile= userProfileService.findByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}