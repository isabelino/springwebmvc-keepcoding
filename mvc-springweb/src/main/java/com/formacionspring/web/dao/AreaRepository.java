package com.formacionspring.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.web.entity.Area;


@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

}
