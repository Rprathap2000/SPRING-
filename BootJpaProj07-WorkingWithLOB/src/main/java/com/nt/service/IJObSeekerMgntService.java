package com.nt.service;

import java.util.Optional;

import com.nt.entity.JobSeeker;

public interface IJObSeekerMgntService {
	
	public String registerJobSeeker(JobSeeker js);
	public Optional <JobSeeker> showJobSeekerInfoById(int id);

}
