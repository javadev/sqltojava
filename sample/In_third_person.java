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
@Table(name = "in_third_person")
public class In_third_person implements Serializable {

    private static final long serialVersionUID =-979750292L;
    private String dict_type_of_relation_client;
    private String first_name;
    private Long id;
    private In_dossier in_dossier;
    private String last_name;
    private String patronymic_name;
    private String phone;

    @Size(max = 5)
    @Column(name = "dict_type_of_relation_client", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_type_of_relation_client() {
        return dict_type_of_relation_client;
    }

    public void setDict_type_of_relation_client(String dict_type_of_relation_client) {
        this.dict_type_of_relation_client = dict_type_of_relation_client;
    }

    @Size(max = 60)
    @Column(name = "first_name", columnDefinition = "VARCHAR(60)", length = 60)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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

    @Size(max = 60)
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)", length = 60)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Size(max = 60)
    @Column(name = "patronymic_name", columnDefinition = "VARCHAR(60)", length = 60)
    public String getPatronymic_name() {
        return patronymic_name;
    }

    public void setPatronymic_name(String patronymic_name) {
        this.patronymic_name = patronymic_name;
    }

    @Size(max = 10)
    @Column(name = "phone", columnDefinition = "VARCHAR(10)", length = 10)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "In_third_person@" + hashCode();
    }
}
