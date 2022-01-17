package com.socialbook.admin.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfoModel {
    @Id
    private Long user_id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "study_at")
    private String studyAt;

    @Column(name = "working_at")
    private String workingAt;

    @Column(name = "address")
    private String address;

    @Column(name = "relationship_status")
    private String relationshipStatus;

    public UserInfoModel() {
    }

    public UserInfoModel(Long user_id, String phoneNumber, Integer gender, Date dateOfBirth, String studyAt,
            String workingAt, String address, String relationshipStatus) {
        this.user_id = user_id;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.studyAt = studyAt;
        this.workingAt = workingAt;
        this.address = address;
        this.relationshipStatus = relationshipStatus;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudyAt() {
        return this.studyAt;
    }

    public void setStudyAt(String studyAt) {
        this.studyAt = studyAt;
    }

    public String getWorkingAt() {
        return this.workingAt;
    }

    public void setWorkingAt(String workingAt) {
        this.workingAt = workingAt;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelationshipStatus() {
        return this.relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public UserInfoModel user_id(Long user_id) {
        setUser_id(user_id);
        return this;
    }

    public UserInfoModel phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public UserInfoModel gender(Integer gender) {
        setGender(gender);
        return this;
    }

    public UserInfoModel dateOfBirth(Date dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public UserInfoModel studyAt(String studyAt) {
        setStudyAt(studyAt);
        return this;
    }

    public UserInfoModel workingAt(String workingAt) {
        setWorkingAt(workingAt);
        return this;
    }

    public UserInfoModel address(String address) {
        setAddress(address);
        return this;
    }

    public UserInfoModel relationshipStatus(String relationshipStatus) {
        setRelationshipStatus(relationshipStatus);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " user_id='" + getUser_id() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", gender='" + getGender() + "'" +
                ", dateOfBirth='" + getDateOfBirth() + "'" +
                ", studyAt='" + getStudyAt() + "'" +
                ", workingAt='" + getWorkingAt() + "'" +
                ", address='" + getAddress() + "'" +
                ", relationshipStatus='" + getRelationshipStatus() + "'" +
                "}";
    }

}
