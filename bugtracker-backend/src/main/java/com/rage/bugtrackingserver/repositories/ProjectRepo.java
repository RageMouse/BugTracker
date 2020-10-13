package com.rage.bugtrackingserver.repositories;

import com.rage.bugtrackingserver.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
