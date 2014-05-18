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
@Table(name = "credittype")
public class Credittype implements Serializable {

    private static final long serialVersionUID =-612313438L;
    private Date datefinish;
    private Date datestart;
    private String description;
    private BigDecimal downpaymentmax;
    private BigDecimal downpaymentmin;
    private Integer durationmax;
    private Integer durationmin;
    private Long id;
    private Boolean iscommission;
    private Boolean ismonthlyfee;
    private Boolean isopeningfee;
    private Boolean issubsidy;
    private String name;
    private String namescreen;
    private BigDecimal totalpricemax;
    private BigDecimal totalpricemin;
    private BigDecimal valuecommission;
    private BigDecimal valueinterestrate;
    private BigDecimal valuemonthlyfee;
    private BigDecimal valueopeningfee;
    private BigDecimal valuesubsidy;
    private List<In_dossier> in_dossiers;
    private List<Externaldistributor> externaldistributors;

    @Column(name = "datefinish", columnDefinition = "DATETIME")
    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    @Column(name = "datestart", columnDefinition = "DATETIME")
    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    @Size(max = 500)
    @Column(name = "description", columnDefinition = "VARCHAR(500)", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "downpaymentmax", columnDefinition = "DECIMAL(19,2)")
    public BigDecimal getDownpaymentmax() {
        return downpaymentmax;
    }

    public void setDownpaymentmax(BigDecimal downpaymentmax) {
        this.downpaymentmax = downpaymentmax;
    }

    @Column(name = "downpaymentmin", columnDefinition = "DECIMAL(19,2)")
    public BigDecimal getDownpaymentmin() {
        return downpaymentmin;
    }

    public void setDownpaymentmin(BigDecimal downpaymentmin) {
        this.downpaymentmin = downpaymentmin;
    }

    @Column(name = "durationmax", columnDefinition = "INT")
    public Integer getDurationmax() {
        return durationmax;
    }

    public void setDurationmax(Integer durationmax) {
        this.durationmax = durationmax;
    }

    @Column(name = "durationmin", columnDefinition = "INT")
    public Integer getDurationmin() {
        return durationmin;
    }

    public void setDurationmin(Integer durationmin) {
        this.durationmin = durationmin;
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

    @Column(name = "iscommission", columnDefinition = "BIT(1)")
    public Boolean getIscommission() {
        return iscommission;
    }

    public void setIscommission(Boolean iscommission) {
        this.iscommission = iscommission;
    }

    @Column(name = "ismonthlyfee", columnDefinition = "BIT(1)")
    public Boolean getIsmonthlyfee() {
        return ismonthlyfee;
    }

    public void setIsmonthlyfee(Boolean ismonthlyfee) {
        this.ismonthlyfee = ismonthlyfee;
    }

    @Column(name = "isopeningfee", columnDefinition = "BIT(1)")
    public Boolean getIsopeningfee() {
        return isopeningfee;
    }

    public void setIsopeningfee(Boolean isopeningfee) {
        this.isopeningfee = isopeningfee;
    }

    @Column(name = "issubsidy", columnDefinition = "BIT(1)")
    public Boolean getIssubsidy() {
        return issubsidy;
    }

    public void setIssubsidy(Boolean issubsidy) {
        this.issubsidy = issubsidy;
    }

    @Size(max = 100)
    @Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(max = 100)
    @Column(name = "namescreen", columnDefinition = "VARCHAR(100)", length = 100)
    public String getNamescreen() {
        return namescreen;
    }

    public void setNamescreen(String namescreen) {
        this.namescreen = namescreen;
    }

    @Column(name = "totalpricemax", columnDefinition = "DECIMAL(19,2)")
    public BigDecimal getTotalpricemax() {
        return totalpricemax;
    }

    public void setTotalpricemax(BigDecimal totalpricemax) {
        this.totalpricemax = totalpricemax;
    }

    @Column(name = "totalpricemin", columnDefinition = "DECIMAL(19,2)")
    public BigDecimal getTotalpricemin() {
        return totalpricemin;
    }

    public void setTotalpricemin(BigDecimal totalpricemin) {
        this.totalpricemin = totalpricemin;
    }

    @Column(name = "valuecommission", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getValuecommission() {
        return valuecommission;
    }

    public void setValuecommission(BigDecimal valuecommission) {
        this.valuecommission = valuecommission;
    }

    @Column(name = "valueinterestrate", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getValueinterestrate() {
        return valueinterestrate;
    }

    public void setValueinterestrate(BigDecimal valueinterestrate) {
        this.valueinterestrate = valueinterestrate;
    }

    @Column(name = "valuemonthlyfee", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getValuemonthlyfee() {
        return valuemonthlyfee;
    }

    public void setValuemonthlyfee(BigDecimal valuemonthlyfee) {
        this.valuemonthlyfee = valuemonthlyfee;
    }

    @Column(name = "valueopeningfee", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getValueopeningfee() {
        return valueopeningfee;
    }

    public void setValueopeningfee(BigDecimal valueopeningfee) {
        this.valueopeningfee = valueopeningfee;
    }

    @Column(name = "valuesubsidy", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getValuesubsidy() {
        return valuesubsidy;
    }

    public void setValuesubsidy(BigDecimal valuesubsidy) {
        this.valuesubsidy = valuesubsidy;
    }

    @OneToMany(mappedBy="credittype")
    public List<In_dossier> getIn_dossiers() {
        return in_dossiers;
    }

    public void setIn_dossiers(List<In_dossier> in_dossiers) {
        this.in_dossiers = in_dossiers;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "credittype_has_externaldistributor",
          joinColumns = @JoinColumn(name = "credittype_id"),
          inverseJoinColumns = @JoinColumn(name = "externaldistributor_id"))
    public List<Externaldistributor> getExternaldistributors() {
        return externaldistributors;
    }

    public void setExternaldistributors(List<Externaldistributor> externaldistributors) {
        this.externaldistributors = externaldistributors;
    }

    @Override
    public String toString() {
        return "Credittype@" + hashCode();
    }
}
