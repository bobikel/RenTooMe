package com.rentoome.auth.repository;

import com.rentoome.auth.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long>, JpaSpecificationExecutor<Privilege> {

    
}
