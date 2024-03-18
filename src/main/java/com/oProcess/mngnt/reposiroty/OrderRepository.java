package com.oProcess.mngnt.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oProcess.mngnt.dto.Orderdto;

@Repository
public interface OrderRepository extends JpaRepository<Orderdto, Long> {

}
