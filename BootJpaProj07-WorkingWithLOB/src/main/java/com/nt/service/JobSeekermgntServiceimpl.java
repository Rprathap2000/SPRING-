package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repository.IJOBSeekerRepository;

@Service
public class JobSeekermgntServiceimpl implements IJObSeekerMgntService {

    @Autowired
    private IJOBSeekerRepository jobRepo;

    @Override
    public String registerJobSeeker(JobSeeker js) {
        JobSeeker savedJobSeeker = jobRepo.save(js);
        return "JobSeeker is registered with ID: " + savedJobSeeker.getJsid();
    }

    @Override
    public Optional<JobSeeker> showJobSeekerInfoById(int id) {
        return jobRepo.findById(id);
    }
}
