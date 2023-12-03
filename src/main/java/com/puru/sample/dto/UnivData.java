package com.puru.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UnivData {

    @JsonProperty("university")
    public String university;
    @JsonProperty("rank_display")
    public String rankDisplay;
    @JsonProperty("score")
    public Float score;
    @JsonProperty("type")
    public String type;
    @JsonProperty("student_faculty_ratio")
    public Integer studentFacultyRatio;
    @JsonProperty("international_students")
    public String internationalStudents;
    @JsonProperty("faculty_count")
    public String facultyCount;
    @JsonProperty("location")
    public Location location;

}