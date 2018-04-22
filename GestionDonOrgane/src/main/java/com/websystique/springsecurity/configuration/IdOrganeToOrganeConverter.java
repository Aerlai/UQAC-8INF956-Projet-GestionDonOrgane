package com.websystique.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springsecurity.model.Organe;
import com.websystique.springsecurity.service.OrganeService;

@Component
public class IdOrganeToOrganeConverter implements Converter<Object, Organe>{

	@Autowired
	OrganeService organeService;

	/*
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Organe convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Organe profile= organeService.findById(id);
		System.out.println("Organe : "+profile);
		return profile;
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