package com.puru.sample.controller;

import com.puru.sample.client.GetUnivData;
import com.puru.sample.dto.UnivData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Univs {
    @Autowired
    GetUnivData getUnivData;

    @GetMapping("/univs/public")
    public List<UnivData> getGlobalUnivs(){
        return getUnivData.getGlobalUnivs();
    }

    @GetMapping("/univs")
    public List<UnivData> getGlobalUnivsDB(){
        return getUnivData.getGlobalUnivsDB();
    }
    @GetMapping("/univs/{country}")
    public List<UnivData> getGlobalUnivs(@PathVariable String country){
        return getUnivData.getGlobalUnivsPage(country);
    }

    @GetMapping("/univs/city")
    public List<UnivData> getGlobalUnivsCity(@RequestParam String city){
        return getUnivData.getGlobalUnivsCity(city);
    }

    @PostMapping("/univ")
    public void saveUniv(@RequestBody UnivData univ){
         getUnivData.saveUniv(univ);
    }

    @PostMapping("/univs")
    public void saveUniv(@RequestBody List<UnivData> univ){
        getUnivData.saveAllUniv(univ);
    }
}
