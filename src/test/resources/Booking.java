/*
 * $Id$
 *
 * Copyright (c) 2011, 2012 (javadev75@gmail.com)
 */
package out;

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

import out.validator.*;

/**
 * Automatically generated.
 *
 * @author vko
 * @version $Revision$ $Date$
 */
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID =-650980711L;
    private Integer beds;
    /** Checkin date. */
    private Date checkinDate;
    /** Checkout date. */
    private Date checkoutDate;
    /** Credit card number. */
    private String creditCard;
    private Integer creditCardExpiryMonth;
    private Integer creditCardExpiryYear;
    /** Credit card name. */
    private String creditCardName;
    private Hotel hotel;
    private Long id;
    private Boolean smoking;
    private User user;

    @Column(name = "beds", columnDefinition = "INT", nullable = false)
    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    @NotNull
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "checkinDate", columnDefinition = "DATETIME", nullable = false)
    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "checkoutDate", columnDefinition = "DATETIME", nullable = false)
    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @NotNull(message = "Credit card number is required")
    @Length(min = 16, max = 16, message = "Credit card number must 16 digits long")
    @Pattern(regex = "^\\d*$", message = "Credit card number must be numeric")
    @Size(max = 20)
    @Column(name = "creditCard", columnDefinition = "VARCHAR(20)", nullable = false, length = 20)
    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Column(name = "creditCardExpiryMonth", columnDefinition = "INT", nullable = false)
    public Integer getCreditCardExpiryMonth() {
        return creditCardExpiryMonth;
    }

    public void setCreditCardExpiryMonth(Integer creditCardExpiryMonth) {
        this.creditCardExpiryMonth = creditCardExpiryMonth;
    }

    @Column(name = "creditCardExpiryYear", columnDefinition = "INT", nullable = false)
    public Integer getCreditCardExpiryYear() {
        return creditCardExpiryYear;
    }

    public void setCreditCardExpiryYear(Integer creditCardExpiryYear) {
        this.creditCardExpiryYear = creditCardExpiryYear;
    }

    @NotNull(message = "Credit card name is required")
    @Length(min = 3, max = 70, message = "Credit card name is required")
    @Size(max = 70)
    @Column(name = "creditCardName", columnDefinition = "VARCHAR(70)", nullable = false, length = 70)
    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    @ManyToOne
    @JoinColumn(name="hotel_id")
    @NotNull
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    @Column(name = "smoking", columnDefinition = "BIT(1)", nullable = false)
    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @NotNull
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking@" + hashCode();
    }
}
