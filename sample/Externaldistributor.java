/*
 * $Id$
 *
 * Copyright (c) 2011, 2012 (javadev75@gmail.com)
 */
package sample;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import sample.validator.*;

/**
 * Automatically generated.
 *
 * @author vko
 * @version $Revision$ $Date$
 */
@Entity
@Table(name = "externaldistributor")
public class Externaldistributor implements Serializable {

    private static final long serialVersionUID =-278460437L;
    private String city;
    private String ext_id;
    private String house;
    private Long id;
    private String name;
    private String province;
    private String street;
    private List<Goodexternaldistributor> goodexternaldistributors;
    private List<In_dossier> in_dossiers;
    private List<Powerofattorney> powerofattorneys;
    private List<Credittype> credittypes;
    private List<User> users;

    @NotNull
    @Size(max = 50)
    @Column(name = "city", columnDefinition = "VARCHAR(50)", length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    @Size(max = 20)
    @Column(name = "ext_id", columnDefinition = "VARCHAR(20)", nullable = false, length = 20)
    public String getExt_id() {
        return ext_id;
    }

    public void setExt_id(String ext_id) {
        this.ext_id = ext_id;
    }

    @NotNull
    @Size(max = 10)
    @Column(name = "house", columnDefinition = "VARCHAR(10)", length = 10)
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 100)
    @Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(max = 50)
    @Column(name = "province", columnDefinition = "VARCHAR(50)", length = 50)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @NotNull
    @Size(max = 50)
    @Column(name = "street", columnDefinition = "VARCHAR(50)", length = 50)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @OneToMany(mappedBy="externaldistributor")
    public List<Goodexternaldistributor> getGoodexternaldistributors() {
        return goodexternaldistributors;
    }

    public void setGoodexternaldistributors(List<Goodexternaldistributor> goodexternaldistributors) {
        this.goodexternaldistributors = goodexternaldistributors;
    }

    @OneToMany(mappedBy="externaldistributor")
    public List<In_dossier> getIn_dossiers() {
        return in_dossiers;
    }

    public void setIn_dossiers(List<In_dossier> in_dossiers) {
        this.in_dossiers = in_dossiers;
    }

    @OneToMany(mappedBy="externaldistributor")
    public List<Powerofattorney> getPowerofattorneys() {
        return powerofattorneys;
    }

    public void setPowerofattorneys(List<Powerofattorney> powerofattorneys) {
        this.powerofattorneys = powerofattorneys;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "credittype_has_externaldistributor",
          joinColumns = @JoinColumn(name = "externaldistributor_id"),
          inverseJoinColumns = @JoinColumn(name = "credittype_id"))
    public List<Credittype> getCredittypes() {
        return credittypes;
    }

    public void setCredittypes(List<Credittype> credittypes) {
        this.credittypes = credittypes;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_has_externaldistributor",
          joinColumns = @JoinColumn(name = "externaldistributor_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Externaldistributor@" + hashCode();
    }
}
