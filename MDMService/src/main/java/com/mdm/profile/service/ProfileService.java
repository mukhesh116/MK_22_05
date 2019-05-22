package com.mdm.profile.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import com.mdm.profile.io.ProfileRequest;
import com.mdm.profile.io.ProfileResponse;
import com.mdm.profile.io.StatusMessage;
import com.mdm.profile.utils.MessageCodes;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ProfileService {

	
	public ProfileResponse processProfileDetailsById(ProfileRequest request) throws IOException {
		String fileName = null;
		if(!StringUtils.isEmpty(request) && request.getData().contains("WELLSFARGO")) {
			fileName = "output_wells_fargo_id";
		}else if(!StringUtils.isEmpty(request) && request.getData().contains("JPMORGAN")) {
			fileName = "output_jp_morgan_id";
		}
		String inputData = readOutput(fileName);
		log.info("ProfileService :: processProfileDetails() :: Ends");
		return ProfileResponse.builder()
				.status(MessageCodes.SUCCESS)
				.statusMessage(new StatusMessage(MessageCodes.SUCCESS_MSG,MessageCodes.PROFILE_DETAIL_SUCCESS))
				.data(inputData)
				.build();
	}
	
	public ProfileResponse processProfileDetailsByName(ProfileRequest request) throws IOException {
		String fileName = null;
		if(!StringUtils.isEmpty(request) && request.getData().contains("WELLSFARGO")) {
			fileName = "output_wells_fargo_name";
		}else if(!StringUtils.isEmpty(request) && request.getData().contains("JPMORGAN")) {
			fileName = "output_jp_morgan_name";
		}
		String inputData = readOutput(fileName);
		log.info("ProfileService :: processProfileDetails() :: Ends");
		return ProfileResponse.builder()
				.status(MessageCodes.SUCCESS)
				.statusMessage(new StatusMessage(MessageCodes.SUCCESS_MSG,MessageCodes.PROFILE_DETAIL_SUCCESS))
				.data(inputData)
				.build();
	}
	
	private String readOutput(String fileName) throws IOException  {
		String data = "";
		ClassPathResource cpr = new ClassPathResource("/reference/"+fileName+".json");
		byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
	    data = new String(bdata, StandardCharsets.UTF_8);
		return data;
	}
	
}
