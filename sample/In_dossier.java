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
@Table(name = "in_dossier")
public class In_dossier implements Serializable {

    private static final long serialVersionUID =-1984822751L;
    private BigDecimal amount_of_loan;
    private BigDecimal annuity_sum;
    private BigDecimal core_amount_of_loan;
    private Credittype credittype;
    private Date date_of_end_of_the_deal;
    private Date date_of_entering_dossier;
    private Date date_of_financing;
    private Date date_of_print_contract_sign;
    /** статус заявки из справочника statusOfDossierList. */
    private String dict_status_of_dossier;
    /** Номер заявки в банковской программе. */
    private String dossier_exp_id;
    /** Первый платеж, грн. */
    private BigDecimal down_payment;
    /** Расчет первого платежа, значения (Процент/Сумма). */
    private String down_payment_calc_method;
    /** Процент. */
    private BigDecimal down_payment_prc;
    /** Величина первого платежа. */
    private BigDecimal down_payment_value;
    private Integer due_date;
    private Integer duration;
    private BigDecimal effective_rate;
    private Externaldistributor externaldistributor;
    private Long id;
    private Boolean is_application_form_signed;
    private BigDecimal monthly_fee;
    private BigDecimal monthly_fee_payment;
    private BigDecimal opening_fee;
    private BigDecimal opening_fee_payment;
    private Boolean preview_documents;
    private Product product;
    private BigDecimal rate;
    private Integer total_good_amount;
    private BigDecimal total_interest;
    private BigDecimal total_loan_cost;
    private BigDecimal total_monthly_payment;
    /** Цена всех товаров. */
    private BigDecimal total_price;
    private String ui_state;
    private String ui_workflow_path;
    /** Пользователь, кототрый ввел заявку. */
    private String user_name_enters_dossier;
    private List<In_asset> in_assets;
    private List<In_bloknot> in_bloknots;
    private List<In_document_store> in_document_stores;
    private List<In_good> in_goods;
    private List<In_person> in_persons;
    private List<In_third_person> in_third_persons;

    @Column(name = "amount_of_loan", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getAmount_of_loan() {
        return amount_of_loan;
    }

    public void setAmount_of_loan(BigDecimal amount_of_loan) {
        this.amount_of_loan = amount_of_loan;
    }

    @Column(name = "annuity_sum", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getAnnuity_sum() {
        return annuity_sum;
    }

    public void setAnnuity_sum(BigDecimal annuity_sum) {
        this.annuity_sum = annuity_sum;
    }

    @Column(name = "core_amount_of_loan", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getCore_amount_of_loan() {
        return core_amount_of_loan;
    }

    public void setCore_amount_of_loan(BigDecimal core_amount_of_loan) {
        this.core_amount_of_loan = core_amount_of_loan;
    }

    @ManyToOne
    @JoinColumn(name="credittype_id")
    @NotNull
    public Credittype getCredittype() {
        return credittype;
    }

    public void setCredittype(Credittype credittype) {
        this.credittype = credittype;
    }

    @Column(name = "date_of_end_of_the_deal", columnDefinition = "DATE")
    public Date getDate_of_end_of_the_deal() {
        return date_of_end_of_the_deal;
    }

    public void setDate_of_end_of_the_deal(Date date_of_end_of_the_deal) {
        this.date_of_end_of_the_deal = date_of_end_of_the_deal;
    }

    @Column(name = "date_of_entering_dossier", columnDefinition = "DATETIME")
    public Date getDate_of_entering_dossier() {
        return date_of_entering_dossier;
    }

    public void setDate_of_entering_dossier(Date date_of_entering_dossier) {
        this.date_of_entering_dossier = date_of_entering_dossier;
    }

    @Column(name = "date_of_financing", columnDefinition = "DATETIME")
    public Date getDate_of_financing() {
        return date_of_financing;
    }

    public void setDate_of_financing(Date date_of_financing) {
        this.date_of_financing = date_of_financing;
    }

    @Column(name = "date_of_print_contract_sign", columnDefinition = "DATE")
    public Date getDate_of_print_contract_sign() {
        return date_of_print_contract_sign;
    }

    public void setDate_of_print_contract_sign(Date date_of_print_contract_sign) {
        this.date_of_print_contract_sign = date_of_print_contract_sign;
    }

    @Size(max = 5)
    @Column(name = "dict_status_of_dossier", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_status_of_dossier() {
        return dict_status_of_dossier;
    }

    public void setDict_status_of_dossier(String dict_status_of_dossier) {
        this.dict_status_of_dossier = dict_status_of_dossier;
    }

    @Size(max = 15)
    @Column(name = "dossier_exp_id", columnDefinition = "VARCHAR(15)", length = 15)
    public String getDossier_exp_id() {
        return dossier_exp_id;
    }

    public void setDossier_exp_id(String dossier_exp_id) {
        this.dossier_exp_id = dossier_exp_id;
    }

    @NotNull
    @Column(name = "down_payment", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getDown_payment() {
        return down_payment;
    }

    public void setDown_payment(BigDecimal down_payment) {
        this.down_payment = down_payment;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "down_payment_calc_method", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDown_payment_calc_method() {
        return down_payment_calc_method;
    }

    public void setDown_payment_calc_method(String down_payment_calc_method) {
        this.down_payment_calc_method = down_payment_calc_method;
    }

    @NotNull
    @Column(name = "down_payment_prc", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getDown_payment_prc() {
        return down_payment_prc;
    }

    public void setDown_payment_prc(BigDecimal down_payment_prc) {
        this.down_payment_prc = down_payment_prc;
    }

    @NotNull
    @Column(name = "down_payment_value", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getDown_payment_value() {
        return down_payment_value;
    }

    public void setDown_payment_value(BigDecimal down_payment_value) {
        this.down_payment_value = down_payment_value;
    }

    @Column(name = "due_date", columnDefinition = "INT")
    public Integer getDue_date() {
        return due_date;
    }

    public void setDue_date(Integer due_date) {
        this.due_date = due_date;
    }

    @Column(name = "duration", columnDefinition = "INT")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Column(name = "effective_rate", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getEffective_rate() {
        return effective_rate;
    }

    public void setEffective_rate(BigDecimal effective_rate) {
        this.effective_rate = effective_rate;
    }

    @ManyToOne
    @JoinColumn(name="externaldistributor_id")
    @NotNull
    public Externaldistributor getExternaldistributor() {
        return externaldistributor;
    }

    public void setExternaldistributor(Externaldistributor externaldistributor) {
        this.externaldistributor = externaldistributor;
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

    @AssertApplicationForm 
    @Column(name = "is_application_form_signed", columnDefinition = "BIT(1)")
    public Boolean getIs_application_form_signed() {
        return is_application_form_signed;
    }

    public void setIs_application_form_signed(Boolean is_application_form_signed) {
        this.is_application_form_signed = is_application_form_signed;
    }

    @Column(name = "monthly_fee", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getMonthly_fee() {
        return monthly_fee;
    }

    public void setMonthly_fee(BigDecimal monthly_fee) {
        this.monthly_fee = monthly_fee;
    }

    @Column(name = "monthly_fee_payment", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getMonthly_fee_payment() {
        return monthly_fee_payment;
    }

    public void setMonthly_fee_payment(BigDecimal monthly_fee_payment) {
        this.monthly_fee_payment = monthly_fee_payment;
    }

    @Column(name = "opening_fee", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getOpening_fee() {
        return opening_fee;
    }

    public void setOpening_fee(BigDecimal opening_fee) {
        this.opening_fee = opening_fee;
    }

    @Column(name = "opening_fee_payment", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getOpening_fee_payment() {
        return opening_fee_payment;
    }

    public void setOpening_fee_payment(BigDecimal opening_fee_payment) {
        this.opening_fee_payment = opening_fee_payment;
    }

    @Transient
    public Boolean getPreview_documents() {
        return preview_documents;
    }

    public void setPreview_documents(Boolean preview_documents) {
        this.preview_documents = preview_documents;
    }

    @ManyToOne
    @JoinColumn(name="product_id")
    @NotNull
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "rate", columnDefinition = "DECIMAL(9,4)")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Column(name = "total_good_amount", columnDefinition = "INT")
    public Integer getTotal_good_amount() {
        return total_good_amount;
    }

    public void setTotal_good_amount(Integer total_good_amount) {
        this.total_good_amount = total_good_amount;
    }

    @Column(name = "total_interest", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getTotal_interest() {
        return total_interest;
    }

    public void setTotal_interest(BigDecimal total_interest) {
        this.total_interest = total_interest;
    }

    @Column(name = "total_loan_cost", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getTotal_loan_cost() {
        return total_loan_cost;
    }

    public void setTotal_loan_cost(BigDecimal total_loan_cost) {
        this.total_loan_cost = total_loan_cost;
    }

    @Column(name = "total_monthly_payment", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getTotal_monthly_payment() {
        return total_monthly_payment;
    }

    public void setTotal_monthly_payment(BigDecimal total_monthly_payment) {
        this.total_monthly_payment = total_monthly_payment;
    }

    @NotNull
    @Column(name = "total_price", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    @Size(max = 64)
    @Column(name = "ui_state", columnDefinition = "VARCHAR(64)", length = 64)
    public String getUi_state() {
        return ui_state;
    }

    public void setUi_state(String ui_state) {
        this.ui_state = ui_state;
    }

    @Size(max = 2000)
    @Column(name = "ui_workflow_path", columnDefinition = "VARCHAR(2000)", length = 2000)
    public String getUi_workflow_path() {
        return ui_workflow_path;
    }

    public void setUi_workflow_path(String ui_workflow_path) {
        this.ui_workflow_path = ui_workflow_path;
    }

    @Size(max = 100)
    @Column(name = "user_name_enters_dossier", columnDefinition = "VARCHAR(100)", length = 100)
    public String getUser_name_enters_dossier() {
        return user_name_enters_dossier;
    }

    public void setUser_name_enters_dossier(String user_name_enters_dossier) {
        this.user_name_enters_dossier = user_name_enters_dossier;
    }

    @OneToMany(mappedBy="in_dossier")
    public List<In_asset> getIn_assets() {
        return in_assets;
    }

    public void setIn_assets(List<In_asset> in_assets) {
        this.in_assets = in_assets;
    }

    @OneToMany(mappedBy="in_dossier")
    public List<In_bloknot> getIn_bloknots() {
        return in_bloknots;
    }

    public void setIn_bloknots(List<In_bloknot> in_bloknots) {
        this.in_bloknots = in_bloknots;
    }

    @OneToMany(mappedBy="in_dossier")
    public List<In_document_store> getIn_document_stores() {
        return in_document_stores;
    }

    public void setIn_document_stores(List<In_document_store> in_document_stores) {
        this.in_document_stores = in_document_stores;
    }

    @OneToMany(mappedBy="in_dossier")
    public List<In_good> getIn_goods() {
        return in_goods;
    }

    public void setIn_goods(List<In_good> in_goods) {
        this.in_goods = in_goods;
    }

    @OneToMany(mappedBy="in_dossier")
    public List<In_person> getIn_persons() {
        return in_persons;
    }

    public void setIn_persons(List<In_person> in_persons) {
        this.in_persons = in_persons;
    }

    @OneToMany(mappedBy="in_dossier")
    public List<In_third_person> getIn_third_persons() {
        return in_third_persons;
    }

    public void setIn_third_persons(List<In_third_person> in_third_persons) {
        this.in_third_persons = in_third_persons;
    }

    @Override
    public String toString() {
        return "In_dossier@" + hashCode();
    }
}
