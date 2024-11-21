package com.nt.service;

import java.util.Optional;
import com.nt.entity.JobSeeker;

public interface IJObSeekerMgntService {
    String registerJobSeeker(JobSeeker js);
    Optional<JobSeeker> showJobSeekerInfoById(int id);
}
