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
@Table(name = "uright")
public class Uright implements Serializable {

    private static final long serialVersionUID =116322628L;
    private String description;
    private Long id;
    private String name;
    private Rgroup rgroup;
    private List<Urole> uroles;

    @Size(max = 256)
    @Column(name = "description", columnDefinition = "VARCHAR(256)", length = 256)
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

    @Size(max = 45)
    @Column(name = "name", columnDefinition = "VARCHAR(45)", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="rgroup_id")
    @NotNull
    public Rgroup getRgroup() {
        return rgroup;
    }

    public void setRgroup(Rgroup rgroup) {
        this.rgroup = rgroup;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "urole_has_uright",
          joinColumns = @JoinColumn(name = "uright_id"),
          inverseJoinColumns = @JoinColumn(name = "urole_id"))
    public List<Urole> getUroles() {
        return uroles;
    }

    public void setUroles(List<Urole> uroles) {
        this.uroles = uroles;
    }

    @Override
    public String toString() {
        return "Uright@" + hashCode();
    }
}
