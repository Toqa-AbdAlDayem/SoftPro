package com.app.Installation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallationRepository extends JpaRepository<InstallationDB, Integer> {
    // You can add custom query methods if needed
}