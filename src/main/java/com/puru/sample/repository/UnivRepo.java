package com.puru.sample.repository;

import com.puru.sample.dto.UnivData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnivRepo extends JpaRepository<UnivData, String> {


    List<UnivData> findByLocationCity(String city);
}