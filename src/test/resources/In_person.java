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
@Table(name = "in_person")
public class In_person implements Serializable {

    private static final long serialVersionUID =-450359601L;
    private String another_employers;
    private String birth_place;
    private Date birthday;
    private String citizenship;
    private Date date_of_giving_tin_certificate;
    private Date date_of_issue_tin_certificate;
    private Date date_of_issuing_identity_doc;
    private String dict_activity_sector;
    private String dict_client_type;
    private String dict_empl_regcity;
    private String dict_empl_regprovince;
    private String dict_empl_regregion;
    private String dict_employment_type;
    private String dict_identity_document_type;
    private String dict_level_of_education;
    private String dict_profession;
    private String dict_relation;
    private String dict_type_employer_by_size;
    private String dict_type_of_activity_spd;
    private String dict_type_of_income_doc;
    private String dictionary_gender;
    /** Ситуация с жильем и местом жительства. */
    private String dictionary_habitation_situation;
    private String dictionary_mailcity;
    /** Область. */
    private String dictionary_mailprovince;
    private String dictionary_mailregion;
    private String dictionary_marital_status;
    private String dictionary_regcity;
    /** Область адреса регистрации. */
    private String dictionary_regprovince;
    private String dictionary_regregion;
    private String edrpou_of_employer;
    private String email;
    private String empl_regadditionalinfo;
    private String empl_regflat;
    private String empl_reghouse;
    private String empl_regpostindex;
    private String empl_regstreet;
    private String employer;
    private Date end_data_of_employment;
    /** Код клиента в банковской программе. */
    private String exp_id;
    private BigDecimal expenses_for_alimony;
    private BigDecimal expenses_for_car_loan;
    private BigDecimal expenses_for_other_loans;
    private BigDecimal expenses_for_renting;
    private String first_name;
    private String first_name_latin;
    private String first_name_ru;
    private BigDecimal gross_income;
    /** С какого времени ситуация с жильем. */
    private Date habit_situation_start_date;
    /** нет ИНН. */
    private Boolean has_no_tin;
    private Long id;
    /** Серия и номер паспорта. */
    private String identity_document_number;
    private In_dossier in_dossier;
    private Boolean is_client_changed_surname;
    /** Временная регистрация. */
    private Boolean is_regstatus_temporary;
    private String issuer_of_identity_document;
    private String issuer_of_tin;
    private String last_name;
    private String last_name_latin;
    private String last_name_ru;
    /** Дополнительная информация (корпус, блок, другое). */
    private String mailadditionalinfo;
    /** квартира. */
    private String mailflat;
    /** номер дома. */
    private String mailhouse;
    private String mailpostindex;
    private String mailstreet;
    private String mobile_phone;
    /** Количество человек на содержании, в том числе несовершеннолетние дети. */
    private Integer number_of_children;
    private Integer number_of_months_of_experience;
    private Integer number_of_years_of_experience;
    private BigDecimal other_income;
    private String patronymic_name;
    private String patronymic_name_ru;
    private String phone;
    private String phone_of_employer;
    private String prev_employer_name;
    private Integer prev_employer_num_years_experience;
    private String prev_last_name;
    private Date reg_enddate;
    /** Дополнительная информация (корпус, блок, другое). */
    private String regadditionalinfo;
    private String regflat;
    private String reghouse;
    private String regpostindex;
    private String regstreet;
    private String second_phone_employer;
    private Date start_employment_date;
    private String tin;

    @Size(max = 100)
    @Column(name = "another_employers", columnDefinition = "VARCHAR(100)", length = 100)
    public String getAnother_employers() {
        return another_employers;
    }

    public void setAnother_employers(String another_employers) {
        this.another_employers = another_employers;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 40)
    @Column(name = "birth_place", columnDefinition = "VARCHAR(40)", length = 40)
    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    @NotNull
    @Past
    @Column(name = "birthday", columnDefinition = "DATE")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Size(max = 30)
    @Column(name = "citizenship", columnDefinition = "VARCHAR(30)", length = 30)
    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @NotNull
    @Past
    @UkrainianDate
    @Column(name = "date_of_giving_tin_certificate", columnDefinition = "DATE")
    public Date getDate_of_giving_tin_certificate() {
        return date_of_giving_tin_certificate;
    }

    public void setDate_of_giving_tin_certificate(Date date_of_giving_tin_certificate) {
        this.date_of_giving_tin_certificate = date_of_giving_tin_certificate;
    }

    @NotNull
    @UkrainianDate
    @Column(name = "date_of_issue_tin_certificate", columnDefinition = "DATE")
    public Date getDate_of_issue_tin_certificate() {
        return date_of_issue_tin_certificate;
    }

    public void setDate_of_issue_tin_certificate(Date date_of_issue_tin_certificate) {
        this.date_of_issue_tin_certificate = date_of_issue_tin_certificate;
    }

    @NotNull
    @Past
    @UkrainianDate
    @Column(name = "date_of_issuing_identity_doc", columnDefinition = "DATE")
    public Date getDate_of_issuing_identity_doc() {
        return date_of_issuing_identity_doc;
    }

    public void setDate_of_issuing_identity_doc(Date date_of_issuing_identity_doc) {
        this.date_of_issuing_identity_doc = date_of_issuing_identity_doc;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_activity_sector", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_activity_sector() {
        return dict_activity_sector;
    }

    public void setDict_activity_sector(String dict_activity_sector) {
        this.dict_activity_sector = dict_activity_sector;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_client_type", columnDefinition = "VARCHAR(5)", nullable = false, length = 5)
    public String getDict_client_type() {
        return dict_client_type;
    }

    public void setDict_client_type(String dict_client_type) {
        this.dict_client_type = dict_client_type;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_empl_regcity", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_empl_regcity() {
        return dict_empl_regcity;
    }

    public void setDict_empl_regcity(String dict_empl_regcity) {
        this.dict_empl_regcity = dict_empl_regcity;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_empl_regprovince", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_empl_regprovince() {
        return dict_empl_regprovince;
    }

    public void setDict_empl_regprovince(String dict_empl_regprovince) {
        this.dict_empl_regprovince = dict_empl_regprovince;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_empl_regregion", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_empl_regregion() {
        return dict_empl_regregion;
    }

    public void setDict_empl_regregion(String dict_empl_regregion) {
        this.dict_empl_regregion = dict_empl_regregion;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_employment_type", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_employment_type() {
        return dict_employment_type;
    }

    public void setDict_employment_type(String dict_employment_type) {
        this.dict_employment_type = dict_employment_type;
    }

    @Size(max = 5)
    @Column(name = "dict_identity_document_type", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_identity_document_type() {
        return dict_identity_document_type;
    }

    public void setDict_identity_document_type(String dict_identity_document_type) {
        this.dict_identity_document_type = dict_identity_document_type;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_level_of_education", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_level_of_education() {
        return dict_level_of_education;
    }

    public void setDict_level_of_education(String dict_level_of_education) {
        this.dict_level_of_education = dict_level_of_education;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_profession", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_profession() {
        return dict_profession;
    }

    public void setDict_profession(String dict_profession) {
        this.dict_profession = dict_profession;
    }

    @Size(max = 5)
    @Column(name = "dict_relation", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_relation() {
        return dict_relation;
    }

    public void setDict_relation(String dict_relation) {
        this.dict_relation = dict_relation;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_type_employer_by_size", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_type_employer_by_size() {
        return dict_type_employer_by_size;
    }

    public void setDict_type_employer_by_size(String dict_type_employer_by_size) {
        this.dict_type_employer_by_size = dict_type_employer_by_size;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dict_type_of_activity_spd", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_type_of_activity_spd() {
        return dict_type_of_activity_spd;
    }

    public void setDict_type_of_activity_spd(String dict_type_of_activity_spd) {
        this.dict_type_of_activity_spd = dict_type_of_activity_spd;
    }

    @Size(max = 5)
    @Column(name = "dict_type_of_income_doc", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDict_type_of_income_doc() {
        return dict_type_of_income_doc;
    }

    public void setDict_type_of_income_doc(String dict_type_of_income_doc) {
        this.dict_type_of_income_doc = dict_type_of_income_doc;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_gender", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_gender() {
        return dictionary_gender;
    }

    public void setDictionary_gender(String dictionary_gender) {
        this.dictionary_gender = dictionary_gender;
    }

    @Size(max = 5)
    @Column(name = "dictionary_habitation_situation", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_habitation_situation() {
        return dictionary_habitation_situation;
    }

    public void setDictionary_habitation_situation(String dictionary_habitation_situation) {
        this.dictionary_habitation_situation = dictionary_habitation_situation;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_mailcity", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_mailcity() {
        return dictionary_mailcity;
    }

    public void setDictionary_mailcity(String dictionary_mailcity) {
        this.dictionary_mailcity = dictionary_mailcity;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_mailprovince", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_mailprovince() {
        return dictionary_mailprovince;
    }

    public void setDictionary_mailprovince(String dictionary_mailprovince) {
        this.dictionary_mailprovince = dictionary_mailprovince;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_mailregion", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_mailregion() {
        return dictionary_mailregion;
    }

    public void setDictionary_mailregion(String dictionary_mailregion) {
        this.dictionary_mailregion = dictionary_mailregion;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_marital_status", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_marital_status() {
        return dictionary_marital_status;
    }

    public void setDictionary_marital_status(String dictionary_marital_status) {
        this.dictionary_marital_status = dictionary_marital_status;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_regcity", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_regcity() {
        return dictionary_regcity;
    }

    public void setDictionary_regcity(String dictionary_regcity) {
        this.dictionary_regcity = dictionary_regcity;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_regprovince", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_regprovince() {
        return dictionary_regprovince;
    }

    public void setDictionary_regprovince(String dictionary_regprovince) {
        this.dictionary_regprovince = dictionary_regprovince;
    }

    @NotNull
    @Size(max = 5)
    @Column(name = "dictionary_regregion", columnDefinition = "VARCHAR(5)", length = 5)
    public String getDictionary_regregion() {
        return dictionary_regregion;
    }

    public void setDictionary_regregion(String dictionary_regregion) {
        this.dictionary_regregion = dictionary_regregion;
    }

    @Size(max = 10)
    @Column(name = "edrpou_of_employer", columnDefinition = "VARCHAR(10)", length = 10)
    public String getEdrpou_of_employer() {
        return edrpou_of_employer;
    }

    public void setEdrpou_of_employer(String edrpou_of_employer) {
        this.edrpou_of_employer = edrpou_of_employer;
    }

    @Size(max = 50)
    @Column(name = "email", columnDefinition = "VARCHAR(50)", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Size(max = 20)
    @Column(name = "empl_regadditionalinfo", columnDefinition = "VARCHAR(20)", length = 20)
    public String getEmpl_regadditionalinfo() {
        return empl_regadditionalinfo;
    }

    public void setEmpl_regadditionalinfo(String empl_regadditionalinfo) {
        this.empl_regadditionalinfo = empl_regadditionalinfo;
    }

    @Size(max = 20)
    @Column(name = "empl_regflat", columnDefinition = "VARCHAR(20)", length = 20)
    public String getEmpl_regflat() {
        return empl_regflat;
    }

    public void setEmpl_regflat(String empl_regflat) {
        this.empl_regflat = empl_regflat;
    }

    @NotNull
    @Size(max = 20)
    @Column(name = "empl_reghouse", columnDefinition = "VARCHAR(20)", length = 20)
    public String getEmpl_reghouse() {
        return empl_reghouse;
    }

    public void setEmpl_reghouse(String empl_reghouse) {
        this.empl_reghouse = empl_reghouse;
    }

    @Size(max = 5)
    @Column(name = "empl_regpostindex", columnDefinition = "VARCHAR(5)", length = 5)
    public String getEmpl_regpostindex() {
        return empl_regpostindex;
    }

    public void setEmpl_regpostindex(String empl_regpostindex) {
        this.empl_regpostindex = empl_regpostindex;
    }

    @NotNull
    @Size(max = 50)
    @Column(name = "empl_regstreet", columnDefinition = "VARCHAR(50)", length = 50)
    public String getEmpl_regstreet() {
        return empl_regstreet;
    }

    public void setEmpl_regstreet(String empl_regstreet) {
        this.empl_regstreet = empl_regstreet;
    }

    @NotNull
    @Size(max = 100)
    @Column(name = "employer", columnDefinition = "VARCHAR(100)", length = 100)
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    @Column(name = "end_data_of_employment", columnDefinition = "DATE")
    public Date getEnd_data_of_employment() {
        return end_data_of_employment;
    }

    public void setEnd_data_of_employment(Date end_data_of_employment) {
        this.end_data_of_employment = end_data_of_employment;
    }

    @Size(max = 15)
    @Column(name = "exp_id", columnDefinition = "VARCHAR(15)", length = 15)
    public String getExp_id() {
        return exp_id;
    }

    public void setExp_id(String exp_id) {
        this.exp_id = exp_id;
    }

    @Column(name = "expenses_for_alimony", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getExpenses_for_alimony() {
        return expenses_for_alimony;
    }

    public void setExpenses_for_alimony(BigDecimal expenses_for_alimony) {
        this.expenses_for_alimony = expenses_for_alimony;
    }

    @Column(name = "expenses_for_car_loan", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getExpenses_for_car_loan() {
        return expenses_for_car_loan;
    }

    public void setExpenses_for_car_loan(BigDecimal expenses_for_car_loan) {
        this.expenses_for_car_loan = expenses_for_car_loan;
    }

    @Column(name = "expenses_for_other_loans", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getExpenses_for_other_loans() {
        return expenses_for_other_loans;
    }

    public void setExpenses_for_other_loans(BigDecimal expenses_for_other_loans) {
        this.expenses_for_other_loans = expenses_for_other_loans;
    }

    @Column(name = "expenses_for_renting", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getExpenses_for_renting() {
        return expenses_for_renting;
    }

    public void setExpenses_for_renting(BigDecimal expenses_for_renting) {
        this.expenses_for_renting = expenses_for_renting;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "first_name", columnDefinition = "VARCHAR(60)", length = 60)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Size(max = 40)
    @Column(name = "first_name_latin", columnDefinition = "VARCHAR(40)", length = 40)
    public String getFirst_name_latin() {
        return first_name_latin;
    }

    public void setFirst_name_latin(String first_name_latin) {
        this.first_name_latin = first_name_latin;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "first_name_ru", columnDefinition = "VARCHAR(60)", length = 60)
    public String getFirst_name_ru() {
        return first_name_ru;
    }

    public void setFirst_name_ru(String first_name_ru) {
        this.first_name_ru = first_name_ru;
    }

    @Column(name = "gross_income", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getGross_income() {
        return gross_income;
    }

    public void setGross_income(BigDecimal gross_income) {
        this.gross_income = gross_income;
    }

    @NotNull 
    @Column(name = "habit_situation_start_date", columnDefinition = "DATE")
    public Date getHabit_situation_start_date() {
        return habit_situation_start_date;
    }

    public void setHabit_situation_start_date(Date habit_situation_start_date) {
        this.habit_situation_start_date = habit_situation_start_date;
    }

    @Column(name = "has_no_tin", columnDefinition = "BIT(1)")
    public Boolean getHas_no_tin() {
        return has_no_tin;
    }

    public void setHas_no_tin(Boolean has_no_tin) {
        this.has_no_tin = has_no_tin;
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

    @NotNull
    @DocumentNumber
    @Size(max = 8)
    @Column(name = "identity_document_number", columnDefinition = "VARCHAR(8)", length = 8)
    public String getIdentity_document_number() {
        return identity_document_number;
    }

    public void setIdentity_document_number(String identity_document_number) {
        this.identity_document_number = identity_document_number;
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

    @Column(name = "is_client_changed_surname", columnDefinition = "BIT(1)")
    public Boolean getIs_client_changed_surname() {
        return is_client_changed_surname;
    }

    public void setIs_client_changed_surname(Boolean is_client_changed_surname) {
        this.is_client_changed_surname = is_client_changed_surname;
    }

    @Column(name = "is_regstatus_temporary", columnDefinition = "BIT(1)")
    public Boolean getIs_regstatus_temporary() {
        return is_regstatus_temporary;
    }

    public void setIs_regstatus_temporary(Boolean is_regstatus_temporary) {
        this.is_regstatus_temporary = is_regstatus_temporary;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "issuer_of_identity_document", columnDefinition = "VARCHAR(60)", length = 60)
    public String getIssuer_of_identity_document() {
        return issuer_of_identity_document;
    }

    public void setIssuer_of_identity_document(String issuer_of_identity_document) {
        this.issuer_of_identity_document = issuer_of_identity_document;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "issuer_of_tin", columnDefinition = "VARCHAR(60)", length = 60)
    public String getIssuer_of_tin() {
        return issuer_of_tin;
    }

    public void setIssuer_of_tin(String issuer_of_tin) {
        this.issuer_of_tin = issuer_of_tin;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)", length = 60)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Size(max = 40)
    @Column(name = "last_name_latin", columnDefinition = "VARCHAR(40)", length = 40)
    public String getLast_name_latin() {
        return last_name_latin;
    }

    public void setLast_name_latin(String last_name_latin) {
        this.last_name_latin = last_name_latin;
    }

    @NotNull
    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "last_name_ru", columnDefinition = "VARCHAR(60)", length = 60)
    public String getLast_name_ru() {
        return last_name_ru;
    }

    public void setLast_name_ru(String last_name_ru) {
        this.last_name_ru = last_name_ru;
    }

    @Size(max = 20)
    @Column(name = "mailadditionalinfo", columnDefinition = "VARCHAR(20)", length = 20)
    public String getMailadditionalinfo() {
        return mailadditionalinfo;
    }

    public void setMailadditionalinfo(String mailadditionalinfo) {
        this.mailadditionalinfo = mailadditionalinfo;
    }

    @Size(max = 20)
    @Column(name = "mailflat", columnDefinition = "VARCHAR(20)", length = 20)
    public String getMailflat() {
        return mailflat;
    }

    public void setMailflat(String mailflat) {
        this.mailflat = mailflat;
    }

    @NotNull
    @Size(max = 20)
    @Column(name = "mailhouse", columnDefinition = "VARCHAR(20)", length = 20)
    public String getMailhouse() {
        return mailhouse;
    }

    public void setMailhouse(String mailhouse) {
        this.mailhouse = mailhouse;
    }

    @NotNull
    @Size(max = 6)
    @Column(name = "mailpostindex", columnDefinition = "VARCHAR(6)", length = 6)
    public String getMailpostindex() {
        return mailpostindex;
    }

    public void setMailpostindex(String mailpostindex) {
        this.mailpostindex = mailpostindex;
    }

    @NotNull
    @Size(max = 60)
    @Column(name = "mailstreet", columnDefinition = "VARCHAR(60)", length = 60)
    public String getMailstreet() {
        return mailstreet;
    }

    public void setMailstreet(String mailstreet) {
        this.mailstreet = mailstreet;
    }

    @Size(max = 10)
    @Column(name = "mobile_phone", columnDefinition = "VARCHAR(10)", length = 10)
    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    @NotNull
    @Min(value = 0)
    @Max(value = 10)
    @Column(name = "number_of_children", columnDefinition = "INT")
    public Integer getNumber_of_children() {
        return number_of_children;
    }

    public void setNumber_of_children(Integer number_of_children) {
        this.number_of_children = number_of_children;
    }

    @NotNull
    @Column(name = "number_of_months_of_experience", columnDefinition = "INT")
    public Integer getNumber_of_months_of_experience() {
        return number_of_months_of_experience;
    }

    public void setNumber_of_months_of_experience(Integer number_of_months_of_experience) {
        this.number_of_months_of_experience = number_of_months_of_experience;
    }

    @NotNull
    @Column(name = "number_of_years_of_experience", columnDefinition = "INT")
    public Integer getNumber_of_years_of_experience() {
        return number_of_years_of_experience;
    }

    public void setNumber_of_years_of_experience(Integer number_of_years_of_experience) {
        this.number_of_years_of_experience = number_of_years_of_experience;
    }

    @Column(name = "other_income", columnDefinition = "DECIMAL(9,2)")
    public BigDecimal getOther_income() {
        return other_income;
    }

    public void setOther_income(BigDecimal other_income) {
        this.other_income = other_income;
    }

    @CyrilicSymbols
    @Size(max = 60)
    @Column(name = "patronymic_name", columnDefinition = "VARCHAR(60)", length = 60)
    public String getPatronymic_name() {
        return patronymic_name;
    }

    public void setPatronymic_name(String patronymic_name) {
        this.patronymic_name = patronymic_name;
    }

    @Size(max = 60)
    @Column(name = "patronymic_name_ru", columnDefinition = "VARCHAR(60)", length = 60)
    public String getPatronymic_name_ru() {
        return patronymic_name_ru;
    }

    public void setPatronymic_name_ru(String patronymic_name_ru) {
        this.patronymic_name_ru = patronymic_name_ru;
    }

    @Size(max = 10)
    @Column(name = "phone", columnDefinition = "VARCHAR(10)", length = 10)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull
    @Size(max = 10)
    @Column(name = "phone_of_employer", columnDefinition = "VARCHAR(10)", length = 10)
    public String getPhone_of_employer() {
        return phone_of_employer;
    }

    public void setPhone_of_employer(String phone_of_employer) {
        this.phone_of_employer = phone_of_employer;
    }

    @NotNull
    @Size(max = 50)
    @Column(name = "prev_employer_name", columnDefinition = "VARCHAR(50)", length = 50)
    public String getPrev_employer_name() {
        return prev_employer_name;
    }

    public void setPrev_employer_name(String prev_employer_name) {
        this.prev_employer_name = prev_employer_name;
    }

    @NotNull
    @Column(name = "prev_employer_num_years_experience", columnDefinition = "INT")
    public Integer getPrev_employer_num_years_experience() {
        return prev_employer_num_years_experience;
    }

    public void setPrev_employer_num_years_experience(Integer prev_employer_num_years_experience) {
        this.prev_employer_num_years_experience = prev_employer_num_years_experience;
    }

    @Size(max = 40)
    @Column(name = "prev_last_name", columnDefinition = "VARCHAR(40)", length = 40)
    public String getPrev_last_name() {
        return prev_last_name;
    }

    public void setPrev_last_name(String prev_last_name) {
        this.prev_last_name = prev_last_name;
    }

    @Column(name = "reg_enddate", columnDefinition = "DATE")
    public Date getReg_enddate() {
        return reg_enddate;
    }

    public void setReg_enddate(Date reg_enddate) {
        this.reg_enddate = reg_enddate;
    }

    @Size(max = 20)
    @Column(name = "regadditionalinfo", columnDefinition = "VARCHAR(20)", length = 20)
    public String getRegadditionalinfo() {
        return regadditionalinfo;
    }

    public void setRegadditionalinfo(String regadditionalinfo) {
        this.regadditionalinfo = regadditionalinfo;
    }

    @Size(max = 20)
    @Column(name = "regflat", columnDefinition = "VARCHAR(20)", length = 20)
    public String getRegflat() {
        return regflat;
    }

    public void setRegflat(String regflat) {
        this.regflat = regflat;
    }

    @NotNull
    @Size(max = 20)
    @Column(name = "reghouse", columnDefinition = "VARCHAR(20)", length = 20)
    public String getReghouse() {
        return reghouse;
    }

    public void setReghouse(String reghouse) {
        this.reghouse = reghouse;
    }

    @NotNull
    @Size(max = 6)
    @Column(name = "regpostindex", columnDefinition = "VARCHAR(6)", length = 6)
    public String getRegpostindex() {
        return regpostindex;
    }

    public void setRegpostindex(String regpostindex) {
        this.regpostindex = regpostindex;
    }

    @NotNull
    @Size(max = 60)
    @Column(name = "regstreet", columnDefinition = "VARCHAR(60)", length = 60)
    public String getRegstreet() {
        return regstreet;
    }

    public void setRegstreet(String regstreet) {
        this.regstreet = regstreet;
    }

    @Size(max = 10)
    @Column(name = "second_phone_employer", columnDefinition = "VARCHAR(10)", length = 10)
    public String getSecond_phone_employer() {
        return second_phone_employer;
    }

    public void setSecond_phone_employer(String second_phone_employer) {
        this.second_phone_employer = second_phone_employer;
    }

    @NotNull
    @Column(name = "start_employment_date", columnDefinition = "DATE")
    public Date getStart_employment_date() {
        return start_employment_date;
    }

    public void setStart_employment_date(Date start_employment_date) {
        this.start_employment_date = start_employment_date;
    }

    @NotNull
    @Tin
    @CheckSum
    @Size(max = 10)
    @Column(name = "tin", columnDefinition = "VARCHAR(10)", length = 10)
    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    @Override
    public String toString() {
        return "In_person@" + hashCode();
    }
}
