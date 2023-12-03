package com.puru.sample.controller;

import com.puru.sample.client.GetUnivData;
import com.puru.sample.dto.UnivData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Univs {
    @Autowired
    GetUnivData getUnivData;

    @GetMapping("/univ")
    public List<UnivData> getGlobalUnivs(){
        return getUnivData.getGlobalUnivs();
    }
    @GetMapping("/univ/{country}")
    public List<UnivData> getGlobalUnivs(@PathVariable String country){
        return getUnivData.getGlobalUnivsPage(country);
    }
}
