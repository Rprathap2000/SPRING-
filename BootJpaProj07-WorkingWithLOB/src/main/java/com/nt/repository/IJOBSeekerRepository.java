package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.JobSeeker;

public interface IJOBSeekerRepository extends JpaRepository<JobSeeker, Integer> {
    // This interface will automatically provide CRUD operations.
}
