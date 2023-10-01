package com.company.fitdonation.repository;

import com.company.fitdonation.entity.Organization;
import com.company.fitdonation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    Organization findByEmail(String email);

    Organization getAllOrganizations();

}
