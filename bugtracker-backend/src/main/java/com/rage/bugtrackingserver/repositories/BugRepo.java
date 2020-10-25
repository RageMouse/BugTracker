package com.rage.bugtrackingserver.repositories;

import com.rage.bugtrackingserver.entities.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepo extends JpaRepository<Bug, Long> {
}
