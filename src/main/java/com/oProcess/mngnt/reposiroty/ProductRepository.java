package com.oProcess.mngnt.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oProcess.mngnt.dto.Productdto;

@Repository
public interface ProductRepository extends JpaRepository<Productdto,Long>{

}
