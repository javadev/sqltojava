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
 * Таблица хранит справочники\n

 * @author vko
 * @version $Revision$ $Date$
 */
@Entity
@Table(name = "dictionary_data")
public class Dictionary_data implements Serializable {

    private static final long serialVersionUID =-564810167L;
    private String dkey;
    private String dvalue;
    private String expkey;
    private String expkey2;
    private String expkey3;
    private Date fromdate;
    private Long id;
    private String language;
    private Date lastmodificationdate;
    private String name;
    private Date todate;
    private Boolean valid;

    @Size(max=50)
    @Column(name = "dkey", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

    @Size(max = 1000)
    @Column(name = "dvalue", columnDefinition = "VARCHAR(1000)", nullable = false, length = 1000)
    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue;
    }

    @Size(max = 50)
    @Column(name = "expkey", columnDefinition = "VARCHAR(50)", length = 50)
    public String getExpkey() {
        return expkey;
    }

    public void setExpkey(String expkey) {
        this.expkey = expkey;
    }

    @Size(max = 50)
    @Column(name = "expkey2", columnDefinition = "VARCHAR(50)", length = 50)
    public String getExpkey2() {
        return expkey2;
    }

    public void setExpkey2(String expkey2) {
        this.expkey2 = expkey2;
    }

    @Size(max = 50)
    @Column(name = "expkey3", columnDefinition = "VARCHAR(50)", length = 50)
    public String getExpkey3() {
        return expkey3;
    }

    public void setExpkey3(String expkey3) {
        this.expkey3 = expkey3;
    }

    @Column(name = "fromdate", columnDefinition = "DATETIME")
    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
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

    @Size(max = 30)
    @Column(name = "language", columnDefinition = "VARCHAR(30)", length = 30)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "lastmodificationdate", columnDefinition = "DATETIME")
    public Date getLastmodificationdate() {
        return lastmodificationdate;
    }

    public void setLastmodificationdate(Date lastmodificationdate) {
        this.lastmodificationdate = lastmodificationdate;
    }

    @Size(max = 30)
    @Column(name = "name", columnDefinition = "VARCHAR(30)", length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "todate", columnDefinition = "DATETIME")
    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    @Column(name = "valid", columnDefinition = "BIT(1)", nullable = false)
    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Dictionary_data@" + hashCode();
    }
}
