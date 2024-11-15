package com.nt.service;

import java.util.Optional;

import com.nt.entity.JobSeeker;

public class JobSeekermgntServiceimpl implements IJObSeekerMgntService {

	
	private IJObSeekerMgntService jobRepo;
	@Override
	public String registerJobSeeker(JobSeeker js) {
		int idVal=jobRepo.save(js).getJsid();
		return "JobSeeker is registerd with id value:"+idVal;
	}
	@Override
	public Optional<JobSeeker> showJobSeekerInfoById(int id) {
		
		return jobRepo.findById(id);
	}

}
