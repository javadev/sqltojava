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
@Table(name = "in_asset")
public class In_asset implements Serializable {

    private static final long serialVersionUID =112211952L;
    private Integer count_of;
    private String dictionary_asset;
    private Long id;
    private In_dossier in_dossier;
    private Boolean selected;
    private Boolean visible;

    @NotNull
    @Column(name = "count_of", columnDefinition = "INT")
    public Integer getCount_of() {
        return count_of;
    }

    public void setCount_of(Integer count_of) {
        this.count_of = count_of;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_asset", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_asset() {
        return dictionary_asset;
    }

    public void setDictionary_asset(String dictionary_asset) {
        this.dictionary_asset = dictionary_asset;
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

    @Transient
    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Transient
    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "In_asset@" + hashCode();
    }
}
