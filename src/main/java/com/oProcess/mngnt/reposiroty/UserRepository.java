package com.oProcess.mngnt.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oProcess.mngnt.dto.Userdto;
@Repository
public interface UserRepository extends JpaRepository<Userdto, Long> {

}
