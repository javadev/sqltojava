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
@Table(name = "in_bloknot")
public class In_bloknot implements Serializable {

    private static final long serialVersionUID =-774981958L;
    private String bloknot_subtype;
    private String bloknot_type;
    private Date enter_date;
    private Long id;
    private In_dossier in_dossier;
    private String role_ids;
    private String text;
    private String user_login;
    private String user_name;

    @Size(max = 100)
    @Column(name = "bloknot_subtype", columnDefinition = "VARCHAR(100)", length = 100)
    public String getBloknot_subtype() {
        return bloknot_subtype;
    }

    public void setBloknot_subtype(String bloknot_subtype) {
        this.bloknot_subtype = bloknot_subtype;
    }

    @Size(max = 30)
    @Column(name = "bloknot_type", columnDefinition = "VARCHAR(30)", length = 30)
    public String getBloknot_type() {
        return bloknot_type;
    }

    public void setBloknot_type(String bloknot_type) {
        this.bloknot_type = bloknot_type;
    }

    @Column(name = "enter_date", columnDefinition = "DATETIME")
    public Date getEnter_date() {
        return enter_date;
    }

    public void setEnter_date(Date enter_date) {
        this.enter_date = enter_date;
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

    @Size(max = 100)
    @Column(name = "role_ids", columnDefinition = "VARCHAR(100)", length = 100)
    public String getRole_ids() {
        return role_ids;
    }

    public void setRole_ids(String role_ids) {
        this.role_ids = role_ids;
    }

    @Size(max = 500)
    @Column(name = "text", columnDefinition = "VARCHAR(500)", length = 500)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Size(max = 32)
    @Column(name = "user_login", columnDefinition = "VARCHAR(32)", length = 32)
    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    @Size(max = 128)
    @Column(name = "user_name", columnDefinition = "VARCHAR(128)", length = 128)
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "In_bloknot@" + hashCode();
    }
}
