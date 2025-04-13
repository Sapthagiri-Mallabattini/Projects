package com.saptha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saptha.model.BloodGroupDetails;

@Repository
public interface IBloodBankRepository extends JpaRepository<BloodGroupDetails, Integer> {
	public List<BloodGroupDetails> findByBloodgroupAndStateAndDistrictAndTehsil(String bloodgroup, String state,
			String district, String tehsil);

	public List<BloodGroupDetails> findByBloodgroup(String bloodgroup);

	public List<BloodGroupDetails> findByState(String state);

	public List<BloodGroupDetails> findByDistrict(String district);

	@Query("SELECT b.email FROM BloodGroupDetails b WHERE b.bloodgroup = :bloodgroup AND b.state = :state AND b.district = :district AND b.tehsil = :tehsil")
	public List<String> findEmails(@Param("bloodgroup") String bloodgroup, @Param("state") String state,
			@Param("district") String district, @Param("tehsil") String tehsil);
}
