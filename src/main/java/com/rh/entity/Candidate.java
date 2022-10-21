package com.rh.entity;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    
    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String birth;

    @Column
    private int rating;

    
    @Column
    private String skills;


    @Column(name = "job_interview_date")
    private String jobInterviewDate;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

   

    public String getJobInterviewDate() {
        return this.jobInterviewDate;
    }

    public void setJobInterviewDate(String jobInterviewDate) {
        this.jobInterviewDate = jobInterviewDate;
    }

  

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
