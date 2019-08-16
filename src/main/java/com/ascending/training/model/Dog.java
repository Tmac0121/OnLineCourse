package com.ascending.training.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs")

public class Dog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

//    @Column(name = "owner_id")
//    private long owner_id;

    @Column(name = "name")
    private String dog_name;

    @Column(name = "Spay_neuter")
    private String spay_neuter;

    @Column(name = "Rabies")
    private String rabies;

    @Column(name = "Distemper")
    private String distemper;

    @Column(name = "Parvo")
    private String parvo;

    @Column(name= "Adenovirus")
    private String adenovirus;

    @Column(name = "Bordetella")
    private String bordetella;




    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private User user;

    public User getUser(){return user;}
    public void setUser(User u){
        this.user = u;
    }



    public long getId() {
        return id;
    }

//    public long getOwnerId() {
//        return owner_id;
//    }

    public String getName() {
        return dog_name;
    }

    public String getSpayNeuter() {
        return spay_neuter;
    }

    public String getRabies() {
        return rabies;
    }

    public String getDistemper() {
        return distemper;
    }

    public String getParvo() {
        return parvo;
    }

    public String getAdenovirus() {
        return adenovirus;
    }

    public String getBordetella() {
        return bordetella;
    }




    public void setId(long i) {
        this.id = i;
    }

//    public void setOwnerId(long i) {
//        this.owner_id = i;
//    }

    public void setName(String i) {
        this.dog_name = i;
    }

    public void setSpayNeuter(String i) {
        this.spay_neuter = i;
    }

    public void setRabies(String i) {
        this.rabies = i;
    }

    public void setDistemper(String i) {
        this.distemper = i;
    }

    public void setParvo(String i) {
        this.parvo = i;
    }

    public void setAdenovirus(String i) {
        this.adenovirus = i;
    }

    public void setBordetella(String i) {
        this.bordetella = i;
    }

//    public int getDog_id() {
//        return dog_id;
//    }

//    public void setDog_id(int dog_id) {
//        this.dog_id = dog_id;
//    }
}
