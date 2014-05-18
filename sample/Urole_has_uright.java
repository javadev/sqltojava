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
@Table(name = "urole_has_uright")
public class Urole_has_uright implements Serializable {

    private static final long serialVersionUID =632484421L;
    private Long id;
    private Long uright_id;
    private Long urole_id;

    @Id
    @Column(name = "id", columnDefinition = "BIGINT", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "uright_id", columnDefinition = "BIGINT", nullable = false)
    public Long getUright_id() {
        return uright_id;
    }

    public void setUright_id(Long uright_id) {
        this.uright_id = uright_id;
    }

    @Column(name = "urole_id", columnDefinition = "BIGINT", nullable = false)
    public Long getUrole_id() {
        return urole_id;
    }

    public void setUrole_id(Long urole_id) {
        this.urole_id = urole_id;
    }

    @Override
    public String toString() {
        return "Urole_has_uright@" + hashCode();
    }
}
