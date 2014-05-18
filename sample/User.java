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
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID =-2139478778L;
    private Date activated;
    private Boolean blocked;
    private String blocked_comment;
    private Date blocked_finish;
    private Date blocked_start;
    private Date blocked_temporary;
    private String code_tt;
    private Date created;
    private Date deleted;
    private String deleted_comment;
    private String description;
    private Long id;
    private Boolean isBlockedDateSet;
    private Boolean isDefaultPassword;
    private Boolean isDeleted;
    private Boolean is_nst;
    private String login;
    private String name;
    private String password;
    private String phone;
    private String phone2;
    private String table_number;
    private List<Powerofattorney> powerofattorneys;
    private List<Externaldistributor> externaldistributors;
    private List<Urole> uroles;

    @Column(name = "activated", columnDefinition = "DATETIME")
    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }

    @Column(name = "blocked", columnDefinition = "BIT(1)")
    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @Size(max = 300)
    @Column(name = "blocked_comment", columnDefinition = "VARCHAR(300)", length = 300)
    public String getBlocked_comment() {
        return blocked_comment;
    }

    public void setBlocked_comment(String blocked_comment) {
        this.blocked_comment = blocked_comment;
    }

    @Column(name = "blocked_finish", columnDefinition = "DATETIME")
    public Date getBlocked_finish() {
        return blocked_finish;
    }

    public void setBlocked_finish(Date blocked_finish) {
        this.blocked_finish = blocked_finish;
    }

    @Column(name = "blocked_start", columnDefinition = "DATETIME")
    public Date getBlocked_start() {
        return blocked_start;
    }

    public void setBlocked_start(Date blocked_start) {
        this.blocked_start = blocked_start;
    }

    @Column(name = "blocked_temporary", columnDefinition = "DATETIME")
    public Date getBlocked_temporary() {
        return blocked_temporary;
    }

    public void setBlocked_temporary(Date blocked_temporary) {
        this.blocked_temporary = blocked_temporary;
    }

    @Size(max = 10)
    @Column(name = "code_tt", columnDefinition = "VARCHAR(10)", length = 10)
    public String getCode_tt() {
        return code_tt;
    }

    public void setCode_tt(String code_tt) {
        this.code_tt = code_tt;
    }

    @Column(name = "created", columnDefinition = "DATETIME")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "deleted", columnDefinition = "DATETIME")
    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    @Size(max = 300)
    @Column(name = "deleted_comment", columnDefinition = "VARCHAR(300)", length = 300)
    public String getDeleted_comment() {
        return deleted_comment;
    }

    public void setDeleted_comment(String deleted_comment) {
        this.deleted_comment = deleted_comment;
    }

    @Size(max = 300)
    @Column(name = "description", columnDefinition = "VARCHAR(300)", length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Transient
    public Boolean getIsBlockedDateSet() {
        return isBlockedDateSet;
    }

    public void setIsBlockedDateSet(Boolean isBlockedDateSet) {
        this.isBlockedDateSet = isBlockedDateSet;
    }

    @Transient
    public Boolean getIsDefaultPassword() {
        return isDefaultPassword;
    }

    public void setIsDefaultPassword(Boolean isDefaultPassword) {
        this.isDefaultPassword = isDefaultPassword;
    }

    @Transient
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name = "is_nst", columnDefinition = "BIT(1)")
    public Boolean getIs_nst() {
        return is_nst;
    }

    public void setIs_nst(Boolean is_nst) {
        this.is_nst = is_nst;
    }

    @NotNull
    @Size(max = 15)
    @Column(name = "login", columnDefinition = "VARCHAR(15)", nullable = false, length = 15)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    @Size(min = 5, max = 15)
    @Column(name = "password", columnDefinition = "VARCHAR(15)", nullable = false, length = 15)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Size(max = 10)
    @Column(name = "phone", columnDefinition = "VARCHAR(10)", length = 10)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Size(max = 10)
    @Column(name = "phone2", columnDefinition = "VARCHAR(10)", length = 10)
    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Size(max = 10)
    @Column(name = "table_number", columnDefinition = "VARCHAR(10)", length = 10)
    public String getTable_number() {
        return table_number;
    }

    public void setTable_number(String table_number) {
        this.table_number = table_number;
    }

    @OneToMany(mappedBy="user")
    public List<Powerofattorney> getPowerofattorneys() {
        return powerofattorneys;
    }

    public void setPowerofattorneys(List<Powerofattorney> powerofattorneys) {
        this.powerofattorneys = powerofattorneys;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_has_externaldistributor",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "externaldistributor_id"))
    public List<Externaldistributor> getExternaldistributors() {
        return externaldistributors;
    }

    public void setExternaldistributors(List<Externaldistributor> externaldistributors) {
        this.externaldistributors = externaldistributors;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_has_urole",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "urole_id"))
    public List<Urole> getUroles() {
        return uroles;
    }

    public void setUroles(List<Urole> uroles) {
        this.uroles = uroles;
    }

    @Override
    public String toString() {
        return "User@" + hashCode();
    }
}
