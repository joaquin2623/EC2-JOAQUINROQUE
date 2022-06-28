package com.example.HospitalIdat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HospitalIdat.model.Recepcionista;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista,Integer>{

}
