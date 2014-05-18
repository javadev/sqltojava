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
@Table(name = "goodexternaldistributor")
public class Goodexternaldistributor implements Serializable {

    private static final long serialVersionUID =1444655529L;
    private String dictionary_good;
    private Externaldistributor externaldistributor;
    private Long id;

    @Size(max = 30)
    @Column(name = "dictionary_good", columnDefinition = "VARCHAR(30)", nullable = false, length = 30)
    public String getDictionary_good() {
        return dictionary_good;
    }

    public void setDictionary_good(String dictionary_good) {
        this.dictionary_good = dictionary_good;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goodexternaldistributor@" + hashCode();
    }
}
