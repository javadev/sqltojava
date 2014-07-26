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
@Table(name = "powerofattorney")
public class Powerofattorney implements Serializable {

    private static final long serialVersionUID =1260817908L;
    private Date attorney_date_finish;
    private Date attorney_date_start;
    private String attorney_number;
    private String dictionary_type_of_attorney;
    private String dictionary_type_purpose;
    private Externaldistributor externaldistributor;
    private Long id;
    private Product product;
    private User user;

    @Future
    @Column(name = "attorney_date_finish", columnDefinition = "DATE")
    public Date getAttorney_date_finish() {
        return attorney_date_finish;
    }

    public void setAttorney_date_finish(Date attorney_date_finish) {
        this.attorney_date_finish = attorney_date_finish;
    }

    @Column(name = "attorney_date_start", columnDefinition = "DATE")
    public Date getAttorney_date_start() {
        return attorney_date_start;
    }

    public void setAttorney_date_start(Date attorney_date_start) {
        this.attorney_date_start = attorney_date_start;
    }

    @Size(max = 300)
    @Column(name = "attorney_number", columnDefinition = "VARCHAR(300)", length = 300)
    public String getAttorney_number() {
        return attorney_number;
    }

    public void setAttorney_number(String attorney_number) {
        this.attorney_number = attorney_number;
    }

    @Size(max = 5)
    @Column(name = "dictionary_type_of_attorney", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_type_of_attorney() {
        return dictionary_type_of_attorney;
    }

    public void setDictionary_type_of_attorney(String dictionary_type_of_attorney) {
        this.dictionary_type_of_attorney = dictionary_type_of_attorney;
    }

    @Size(max = 5)
    @Column(name = "dictionary_type_purpose", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_type_purpose() {
        return dictionary_type_purpose;
    }

    public void setDictionary_type_purpose(String dictionary_type_purpose) {
        this.dictionary_type_purpose = dictionary_type_purpose;
    }

    @ManyToOne
    @JoinColumn(name="externaldistributor_id")
    @NotNull
    public Externaldistributor getExternaldistributor() {
        return externaldistributor;
    }

    public void setExternaldistributor(Externaldistributor externaldistributor) {
        this.externaldistributor = externaldistributor;
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

    @ManyToOne
    @JoinColumn(name="product_id")
    @NotNull
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @NotNull
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Powerofattorney@" + hashCode();
    }
}
