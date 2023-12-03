package com.puru.sample.client;

import com.puru.sample.dto.Location;
import com.puru.sample.dto.UnivData;
import com.puru.sample.dto.UnivPages;
import com.puru.sample.repository.UnivRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUnivData {

    @Autowired
    UnivRepo univRepo;
   public List<UnivData> getGlobalUnivs(){
       String endPoint = "https://jsonmock.hackerrank.com/api/universities?";
       RestTemplate restTemplate = new RestTemplate();
       ResponseEntity<UnivPages> responseEntity = restTemplate.getForEntity(endPoint, UnivPages.class);
       int pages = responseEntity.getBody().getTotalPages();
       List<UnivData> resp = new ArrayList<>();
       resp.addAll(responseEntity.getBody().getData());
       for (int i = 2; i <= pages; i++) {
           resp.addAll(getGlobalUnivsPage(i));
       }
       return resp;
   }
    public List<UnivData> getGlobalUnivsPage(int page){
        String endPoint = "https://jsonmock.hackerrank.com/api/universities?page="+page;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UnivPages> responseEntity = restTemplate.getForEntity(endPoint, UnivPages.class);
        return responseEntity.getBody().getData();
    }

    public List<UnivData> getGlobalUnivsPage(String country){
        return getGlobalUnivs().stream().filter(a -> (a.getLocation().getCountry().toLowerCase().equals(country))).collect(Collectors.toList());
    }

    public void saveUniv(UnivData data){
        univRepo.save(data);
    }

    public void saveAllUniv(List<UnivData> data){
        univRepo.saveAll(data);
    }

    public List<UnivData> getGlobalUnivsDB() {
       return univRepo.findAll();
    }

    public List<UnivData> getGlobalUnivsCity(String city){
       return univRepo.findByLocationCity(city);
    }
}
