package com.mdm.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdm.profile.io.ProfileRequest;
import com.mdm.profile.io.ProfileResponse;
import com.mdm.profile.service.ProfileService;
import com.mdm.profile.utils.NamespaceConstants;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "ProfileController", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value=NamespaceConstants.BASE_VERSION)
public class ProfileController {

	
	@Autowired
	private ProfileService service; 
	
	/**
	 * This API is used to fetch company profile details.
	 * @author Mukesh
	 * @param request
	 * @return response
	 */
	@PostMapping(value=NamespaceConstants.PROFILE_DETAILS_ID)
	public ResponseEntity<ProfileResponse> processProfileDetailsById(@RequestBody ProfileRequest request) throws Exception {
		log.info("ProfileController :: processProfileDetailsById() :: Request "+ request.toString());
		ProfileResponse response = service.processProfileDetailsById(request);
		log.info("ProfileController :: processProfileDetailsById() :: Response "+ response.toString());
		return ResponseEntity.ok(response);
	}
	
	/**
	 * This API is used to fetch company profile details.
	 * @author Mukesh
	 * @param request
	 * @return response
	 */
	@PostMapping(value=NamespaceConstants.PROFILE_DETAILS_NAME)
	public ResponseEntity<ProfileResponse> processProfileDetailsByName(@RequestBody ProfileRequest request) throws Exception {
		log.info("ProfileController :: processProfileDetailsByName() :: Request "+ request.toString());
		ProfileResponse response = service.processProfileDetailsByName(request);
		log.info("ProfileController :: processProfileDetailsByName() :: Response "+ response.toString());
		return ResponseEntity.ok(response);
	}
	
	
}
