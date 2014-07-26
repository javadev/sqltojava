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
@Table(name = "credittype_has_externaldistributor")
public class Credittype_has_externaldistributor implements Serializable {

    private static final long serialVersionUID =-820446679L;
    private Long credittype_id;
    private Long externaldistributor_id;
    private Long id;

    @Column(name = "credittype_id", columnDefinition = "BIGINT", nullable = false)
    public Long getCredittype_id() {
        return credittype_id;
    }

    public void setCredittype_id(Long credittype_id) {
        this.credittype_id = credittype_id;
    }

    @Column(name = "externaldistributor_id", columnDefinition = "BIGINT", nullable = false)
    public Long getExternaldistributor_id() {
        return externaldistributor_id;
    }

    public void setExternaldistributor_id(Long externaldistributor_id) {
        this.externaldistributor_id = externaldistributor_id;
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

    @Override
    public String toString() {
        return "Credittype_has_externaldistributor@" + hashCode();
    }
}
