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
@Table(name = "in_good")
public class In_good implements Serializable {

    private static final long serialVersionUID =1956996458L;
    private String car_body_number;
    private String car_bundling_type;
    private Date car_delivery_date;
    private String car_driving_license_ownership;
    private Integer car_engine_volume;
    private Integer car_issue_year;
    private String dict_car_body_type;
    private String dict_car_color;
    private String dict_car_fuel_type;
    private String dict_car_transmission_type;
    private String dictionary_carBrand;
    private String dictionary_carModel;
    private Long id;
    private In_dossier in_dossier;
    private Boolean in_stock;
    private Integer number;
    private BigDecimal price;
    private Date production_date;
    private String retailer_good_name;

    @Vin
    @NotNull
    @Size(max = 17)
    @Column(name = "car_body_number", columnDefinition = "VARCHAR(17)", length = 17)
    public String getCar_body_number() {
        return car_body_number;
    }

    public void setCar_body_number(String car_body_number) {
        this.car_body_number = car_body_number;
    }

    @NotNull
    @Size(max = 250)
    @Column(name = "car_bundling_type", columnDefinition = "VARCHAR(250)", length = 250)
    public String getCar_bundling_type() {
        return car_bundling_type;
    }

    public void setCar_bundling_type(String car_bundling_type) {
        this.car_bundling_type = car_bundling_type;
    }

    @Column(name = "car_delivery_date", columnDefinition = "DATE")
    public Date getCar_delivery_date() {
        return car_delivery_date;
    }

    public void setCar_delivery_date(Date car_delivery_date) {
        this.car_delivery_date = car_delivery_date;
    }

    @Size(max = 5)
    @Column(name = "car_driving_license_ownership", columnDefinition = "VARCHAR(5)", length = 5)
    public String getCar_driving_license_ownership() {
        return car_driving_license_ownership;
    }

    public void setCar_driving_license_ownership(String car_driving_license_ownership) {
        this.car_driving_license_ownership = car_driving_license_ownership;
    }

    @NotNull
    @Column(name = "car_engine_volume", columnDefinition = "INT")
    public Integer getCar_engine_volume() {
        return car_engine_volume;
    }

    public void setCar_engine_volume(Integer car_engine_volume) {
        this.car_engine_volume = car_engine_volume;
    }

    @NotNull
    @IssueYear
    @Column(name = "car_issue_year", columnDefinition = "INT")
    public Integer getCar_issue_year() {
        return car_issue_year;
    }

    public void setCar_issue_year(Integer car_issue_year) {
        this.car_issue_year = car_issue_year;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_car_body_type", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_car_body_type() {
        return dict_car_body_type;
    }

    public void setDict_car_body_type(String dict_car_body_type) {
        this.dict_car_body_type = dict_car_body_type;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_car_color", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_car_color() {
        return dict_car_color;
    }

    public void setDict_car_color(String dict_car_color) {
        this.dict_car_color = dict_car_color;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_car_fuel_type", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_car_fuel_type() {
        return dict_car_fuel_type;
    }

    public void setDict_car_fuel_type(String dict_car_fuel_type) {
        this.dict_car_fuel_type = dict_car_fuel_type;
    }

    @Size(max = 5)
    @Column(name = "dict_car_transmission_type", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_car_transmission_type() {
        return dict_car_transmission_type;
    }

    public void setDict_car_transmission_type(String dict_car_transmission_type) {
        this.dict_car_transmission_type = dict_car_transmission_type;
    }

    @NotNull 
    @Size(max = 5)
    @Column(name = "dictionary_carBrand", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_carBrand() {
        return dictionary_carBrand;
    }

    public void setDictionary_carBrand(String dictionary_carBrand) {
        this.dictionary_carBrand = dictionary_carBrand;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_carModel", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_carModel() {
        return dictionary_carModel;
    }

    public void setDictionary_carModel(String dictionary_carModel) {
        this.dictionary_carModel = dictionary_carModel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="in_dossier_id")
    @NotNull
    public In_dossier getIn_dossier() {
        return in_dossier;
    }

    public void setIn_dossier(In_dossier in_dossier) {
        this.in_dossier = in_dossier;
    }

    @Column(name = "in_stock", columnDefinition = "BIT(1)")
    public Boolean getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(Boolean in_stock) {
        this.in_stock = in_stock;
    }

    @Column(name = "number", columnDefinition = "INT")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @NotNull
    @Check(min = 10000, max = 500000)
    @Column(name = "price", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "production_date", columnDefinition = "DATE")
    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    @Size(max = 100)
    @Column(name = "retailer_good_name", columnDefinition = "VARCHAR(100)", length = 100)
    public String getRetailer_good_name() {
        return retailer_good_name;
    }

    public void setRetailer_good_name(String retailer_good_name) {
        this.retailer_good_name = retailer_good_name;
    }

    @Override
    public String toString() {
        return "In_good@" + hashCode();
    }
}
