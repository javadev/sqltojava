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
@Table(name = "in_document_store")
public class In_document_store implements Serializable {

    private static final long serialVersionUID =-1044533736L;
    private byte[] data;
    private String description;
    private Long doc_size;
    private String doc_type;
    private String filename;
    private Long id;
    private In_dossier in_dossier;
    private Date insert_timestamp;
    private Boolean is_not_required;

    @Column(name = "data", columnDefinition = "BLOB")
    @Lob
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Size(max = 50)
    @Column(name = "description", columnDefinition = "VARCHAR(50)", length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "doc_size", columnDefinition = "BIGINT")
    public Long getDoc_size() {
        return doc_size;
    }

    public void setDoc_size(Long doc_size) {
        this.doc_size = doc_size;
    }

    @Size(max = 45)
    @Column(name = "doc_type", columnDefinition = "VARCHAR(45)", length = 45)
    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    @Size(max = 45)
    @Column(name = "filename", columnDefinition = "VARCHAR(45)", length = 45)
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    @Column(name = "insert_timestamp", columnDefinition = "DATE")
    public Date getInsert_timestamp() {
        return insert_timestamp;
    }

    public void setInsert_timestamp(Date insert_timestamp) {
        this.insert_timestamp = insert_timestamp;
    }

    @Column(name = "is_not_required", columnDefinition = "BIT(1)")
    public Boolean getIs_not_required() {
        return is_not_required;
    }

    public void setIs_not_required(Boolean is_not_required) {
        this.is_not_required = is_not_required;
    }

    @Override
    public String toString() {
        return "In_document_store@" + hashCode();
    }
}
