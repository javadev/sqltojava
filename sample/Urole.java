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
@Table(name = "urole")
public class Urole implements Serializable {

    private static final long serialVersionUID =-1711319973L;
    private Competence_level competence_level;
    private String description;
    private Long id;
    private Boolean is_allowed_make_decision;
    private Date last_update;
    private String name;
    private List<Uright> urights;
    private List<User> users;

    @ManyToOne
    @JoinColumn(name="competence_level_id")
    @NotNull
    public Competence_level getCompetence_level() {
        return competence_level;
    }

    public void setCompetence_level(Competence_level competence_level) {
        this.competence_level = competence_level;
    }

    @Size(max = 100)
    @Column(name = "description", columnDefinition = "VARCHAR(100)", length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "is_allowed_make_decision", columnDefinition = "BIT(1)")
    public Boolean getIs_allowed_make_decision() {
        return is_allowed_make_decision;
    }

    public void setIs_allowed_make_decision(Boolean is_allowed_make_decision) {
        this.is_allowed_make_decision = is_allowed_make_decision;
    }

    @Column(name = "last_update", columnDefinition = "DATE")
    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    @Size(max = 45)
    @Column(name = "name", columnDefinition = "VARCHAR(45)", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "urole_has_uright",
          joinColumns = @JoinColumn(name = "urole_id"),
          inverseJoinColumns = @JoinColumn(name = "uright_id"))
    public List<Uright> getUrights() {
        return urights;
    }

    public void setUrights(List<Uright> urights) {
        this.urights = urights;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_has_urole",
          joinColumns = @JoinColumn(name = "urole_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Urole@" + hashCode();
    }
}
