SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`product` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `name` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`credittype`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`credittype` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `name` VARCHAR(100) NOT NULL ,
  `namescreen` VARCHAR(100) NULL ,
  `description` VARCHAR(500) NULL ,
  `datestart` DATETIME NULL ,
  `datefinish` DATETIME NULL ,
  `durationmin` INT NULL ,
  `durationmax` INT NULL ,
  `totalpricemin` DECIMAL(19,2) NULL ,
  `totalpricemax` DECIMAL(19,2) NULL ,
  `downpaymentmin` DECIMAL(19,2) NULL ,
  `downpaymentmax` DECIMAL(19,2) NULL ,
  `valueinterestrate` DECIMAL(9,4) NULL ,
  `isopeningfee` BIT(1) NULL ,
  `valueopeningfee` DECIMAL(9,4) NULL ,
  `ismonthlyfee` BIT(1) NULL ,
  `valuemonthlyfee` DECIMAL(9,4) NULL ,
  `issubsidy` BIT(1) NULL ,
  `valuesubsidy` DECIMAL(9,4) NULL ,
  `iscommission` BIT(1) NULL ,
  `valuecommission` DECIMAL(9,4) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`externaldistributor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`externaldistributor` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `name` VARCHAR(100) NOT NULL COMMENT '@NotNull' ,
  `ext_id` VARCHAR(20) NOT NULL COMMENT '@NotNull' ,
  `province` VARCHAR(50) NULL COMMENT '@NotNull' ,
  `city` VARCHAR(50) NULL COMMENT '@NotNull' ,
  `street` VARCHAR(50) NULL COMMENT '@NotNull' ,
  `house` VARCHAR(10) NULL COMMENT '@NotNull' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`in_dossier`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_dossier` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `core_amount_of_loan` DECIMAL(9,2) NULL ,
  `amount_of_loan` DECIMAL(9,2) NULL ,
  `total_price` DECIMAL(9,2) NULL COMMENT 'Цена всех товаров\n@NotNull' ,
  `total_good_amount` INT NULL ,
  `date_of_entering_dossier` DATETIME NULL ,
  `date_of_financing` DATETIME NULL ,
  `product_id` BIGINT NOT NULL ,
  `credittype_id` BIGINT NOT NULL ,
  `externaldistributor_id` BIGINT NOT NULL ,
  `down_payment_value` DECIMAL(9,2) NULL COMMENT 'Величина первого платежа @NotNull' ,
  `down_payment` DECIMAL(9,2) NULL COMMENT 'Первый платеж, грн @NotNull' ,
  `down_payment_calc_method` VARCHAR(5) NULL COMMENT 'Расчет первого платежа, значения (Процент/Сумма) @NotNull' ,
  `down_payment_prc` DECIMAL(9,4) NULL COMMENT 'Процент @NotNull' ,
  `duration` INT NULL ,
  `ui_state` VARCHAR(64) NULL ,
  `ui_workflow_path` VARCHAR(2000) NULL ,
  `dict_status_of_dossier` VARCHAR(5) NULL COMMENT 'статус заявки из справочника statusOfDossierList' ,
  `dossier_exp_id` VARCHAR(15) NULL COMMENT 'Номер заявки в банковской программе' ,
  `user_name_enters_dossier` VARCHAR(100) NULL COMMENT 'Пользователь, кототрый ввел заявку' ,
  `is_application_form_signed` BIT(1) NULL COMMENT '@AssertApplicationForm\n' ,
  `preview_documents` BIT(1) NULL COMMENT '@Transient' ,
  `date_of_end_of_the_deal` DATE NULL ,
  `date_of_print_contract_sign` DATE NULL ,
  `due_date` INT NULL ,
  `annuity_sum` DECIMAL(9,2) NULL ,
  `total_monthly_payment` DECIMAL(9,2) NULL ,
  `rate` DECIMAL(9,4) NULL ,
  `opening_fee` DECIMAL(9,4) NULL ,
  `opening_fee_payment` DECIMAL(9,2) NULL ,
  `monthly_fee` DECIMAL(9,4) NULL ,
  `monthly_fee_payment` DECIMAL(9,2) NULL ,
  `effective_rate` DECIMAL(9,4) NULL ,
  `total_interest` DECIMAL(9,2) NULL ,
  `total_loan_cost` DECIMAL(9,2) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_in_dossier_product1_idx` (`product_id` ASC) ,
  INDEX `fk_in_dossier_credittype1_idx` (`credittype_id` ASC) ,
  INDEX `fk_in_dossier_externaldistributor1_idx` (`externaldistributor_id` ASC) ,
  CONSTRAINT `fk_in_dossier_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `mydb`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_in_dossier_credittype1`
    FOREIGN KEY (`credittype_id` )
    REFERENCES `mydb`.`credittype` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_in_dossier_externaldistributor1`
    FOREIGN KEY (`externaldistributor_id` )
    REFERENCES `mydb`.`externaldistributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Таблица хранит заявки@org.hibernate.annotations.Table(\\n   a /* comment truncated */ /*ppliesTo = "in_dossier",\n   indexes = {\n      @org.hibernate.annotations.Index(name="date_of_entering_dossier_index", columnNames = {"date_of_entering_dossier"})\n   }\n)\n*/';


-- -----------------------------------------------------
-- Table `mydb`.`in_person`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_person` (
  `id` BIGINT NOT NULL COMMENT '@Id\n@GeneratedValue' ,
  `dictionary_gender` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `tin` VARCHAR(10) NULL COMMENT '@NotNull\n@Tin\n@CheckSum' ,
  `date_of_issue_tin_certificate` DATE NULL COMMENT '@NotNull\n@UkrainianDate' ,
  `birthday` DATE NULL COMMENT '@NotNull\n@Past' ,
  `birth_place` VARCHAR(40) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `citizenship` VARCHAR(30) NULL ,
  `identity_document_number` VARCHAR(8) NULL COMMENT 'Серия и номер паспорта @NotNull\n@DocumentNumber' ,
  `date_of_issuing_identity_doc` DATE NULL COMMENT '@NotNull\n@Past\n@UkrainianDate' ,
  `email` VARCHAR(50) NULL ,
  `first_name` VARCHAR(60) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `last_name` VARCHAR(60) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `patronymic_name` VARCHAR(60) NULL COMMENT '@CyrilicSymbols' ,
  `phone` VARCHAR(10) NULL ,
  `mobile_phone` VARCHAR(10) NULL ,
  `issuer_of_identity_document` VARCHAR(60) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `issuer_of_tin` VARCHAR(60) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `date_of_giving_tin_certificate` DATE NULL COMMENT '@NotNull\n@Past\n@UkrainianDate' ,
  `in_dossier_id` BIGINT NOT NULL ,
  `dictionary_regprovince` VARCHAR(5) NULL COMMENT 'Область адреса регистрации\n@NotNull' ,
  `dictionary_regregion` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dictionary_regcity` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `regpostindex` VARCHAR(6) NULL COMMENT '@NotNull' ,
  `dictionary_mailregion` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dictionary_mailcity` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `mailpostindex` VARCHAR(6) NULL COMMENT '@NotNull' ,
  `mailstreet` VARCHAR(60) NULL COMMENT '@NotNull' ,
  `regstreet` VARCHAR(60) NULL COMMENT '@NotNull' ,
  `reghouse` VARCHAR(20) NULL COMMENT '@NotNull' ,
  `regflat` VARCHAR(20) NULL ,
  `regadditionalinfo` VARCHAR(20) NULL COMMENT 'Дополнительная информация (корпус, блок, другое)' ,
  `mailhouse` VARCHAR(20) NULL COMMENT 'номер дома\n@NotNull' ,
  `mailflat` VARCHAR(20) NULL COMMENT 'квартира' ,
  `mailadditionalinfo` VARCHAR(20) NULL COMMENT 'Дополнительная информация (корпус, блок, другое)' ,
  `is_regstatus_temporary` BIT(1) NULL COMMENT 'Временная регистрация' ,
  `reg_enddate` DATE NULL ,
  `dictionary_mailprovince` VARCHAR(5) NULL COMMENT 'Область\n@NotNull' ,
  `number_of_children` INT NULL COMMENT 'Количество человек на содержании, в том числе несовершеннолетние дети\n@NotNull\n@Min(value = 0)\n@Max(value = 10)' ,
  `dictionary_habitation_situation` VARCHAR(5) NULL COMMENT 'Ситуация с жильем и местом жительства' ,
  `habit_situation_start_date` DATE NULL COMMENT 'С какого времени ситуация с жильем\n@NotNull\n' ,
  `dictionary_marital_status` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_type_of_income_doc` VARCHAR(5) NULL ,
  `gross_income` DECIMAL(9,2) NULL ,
  `other_income` DECIMAL(9,2) NULL ,
  `expenses_for_renting` DECIMAL(9,2) NULL ,
  `expenses_for_car_loan` DECIMAL(9,2) NULL ,
  `expenses_for_other_loans` DECIMAL(9,2) NULL ,
  `expenses_for_alimony` DECIMAL(9,2) NULL ,
  `last_name_latin` VARCHAR(40) NULL ,
  `first_name_latin` VARCHAR(40) NULL ,
  `exp_id` VARCHAR(15) NULL COMMENT 'Код клиента в банковской программе' ,
  `dict_level_of_education` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_activity_sector` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_type_of_activity_spd` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_profession` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_employment_type` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `start_employment_date` DATE NULL COMMENT '@NotNull' ,
  `end_data_of_employment` DATE NULL ,
  `employer` VARCHAR(100) NULL COMMENT '@NotNull' ,
  `dict_empl_regprovince` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_empl_regregion` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_empl_regcity` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `empl_regpostindex` VARCHAR(5) NULL ,
  `empl_regstreet` VARCHAR(50) NULL COMMENT '@NotNull' ,
  `empl_reghouse` VARCHAR(20) NULL COMMENT '@NotNull' ,
  `empl_regflat` VARCHAR(20) NULL ,
  `empl_regadditionalinfo` VARCHAR(20) NULL ,
  `phone_of_employer` VARCHAR(10) NULL COMMENT '@NotNull' ,
  `second_phone_employer` VARCHAR(10) NULL ,
  `dict_type_employer_by_size` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `another_employers` VARCHAR(100) NULL ,
  `prev_employer_name` VARCHAR(50) NULL COMMENT '@NotNull' ,
  `prev_employer_num_years_experience` INT NULL COMMENT '@NotNull' ,
  `number_of_years_of_experience` INT NULL COMMENT '@NotNull' ,
  `number_of_months_of_experience` INT NULL COMMENT '@NotNull' ,
  `edrpou_of_employer` VARCHAR(10) NULL ,
  `dict_client_type` VARCHAR(5) NOT NULL COMMENT '@NotNull' ,
  `dict_relation` VARCHAR(5) NULL ,
  `dict_identity_document_type` VARCHAR(5) NULL ,
  `has_no_tin` BIT(1) NULL COMMENT 'нет ИНН' ,
  `is_client_changed_surname` BIT(1) NULL ,
  `prev_last_name` VARCHAR(40) NULL ,
  `first_name_ru` VARCHAR(60) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `last_name_ru` VARCHAR(60) NULL COMMENT '@NotNull\n@CyrilicSymbols' ,
  `patronymic_name_ru` VARCHAR(60) NULL ,
  PRIMARY KEY (`in_dossier_id`, `id`) ,
  INDEX `fk_in_preson_in_dossier1_idx` (`in_dossier_id` ASC) ,
  CONSTRAINT `fk_in_preson_in_dossier1`
    FOREIGN KEY (`in_dossier_id` )
    REFERENCES `mydb`.`in_dossier` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`in_good`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_good` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `price` DECIMAL(9,2) NULL COMMENT '@NotNull' ,
  `production_date` DATE NULL ,
  `retailer_good_name` VARCHAR(100) NULL ,
  `number` INT NULL ,
  `in_dossier_id` BIGINT NOT NULL ,
  `dictionary_carBrand` VARCHAR(5) NULL COMMENT '@NotNull\n' ,
  `dictionary_carModel` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `car_body_number` VARCHAR(17) NULL COMMENT '@Vin @NotNull' ,
  `car_issue_year` INT NULL COMMENT '@NotNull\n@Min(value = 1950)\n@Max(value = 2012)' ,
  `car_engine_volume` INT NULL COMMENT '@NotNull' ,
  `dict_car_transmission_type` VARCHAR(5) NULL ,
  `dict_car_body_type` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `dict_car_fuel_type` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `car_bundling_type` VARCHAR(250) NULL COMMENT '@NotNull' ,
  `dict_car_color` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `in_stock` BIT(1) NULL ,
  `car_delivery_date` DATE NULL ,
  `car_driving_license_ownership` VARCHAR(5) NULL ,
  PRIMARY KEY (`id`, `in_dossier_id`) ,
  INDEX `fk_in_good_in_dossier1_idx` (`in_dossier_id` ASC) ,
  CONSTRAINT `fk_in_good_in_dossier1`
    FOREIGN KEY (`in_dossier_id` )
    REFERENCES `mydb`.`in_dossier` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `login` VARCHAR(15) NOT NULL COMMENT '@NotNull' ,
  `password` VARCHAR(15) NOT NULL COMMENT '@NotNull @Size(min = 5, max = 15)' ,
  `name` VARCHAR(100) NOT NULL COMMENT '@NotNull @Size(max = 100)' ,
  `description` VARCHAR(300) NULL ,
  `created` DATETIME NULL ,
  `deleted` DATETIME NULL ,
  `deleted_comment` VARCHAR(300) NULL ,
  `blocked` BIT(1) NULL ,
  `blocked_start` DATETIME NULL ,
  `blocked_finish` DATETIME NULL ,
  `blocked_comment` VARCHAR(300) NULL ,
  `blocked_temporary` DATETIME NULL ,
  `is_nst` BIT(1) NULL ,
  `table_number` VARCHAR(10) NULL ,
  `code_tt` VARCHAR(10) NULL ,
  `phone` VARCHAR(10) NULL ,
  `phone2` VARCHAR(10) NULL ,
  `activated` DATETIME NULL ,
  `isDeleted` BIT(1) NULL COMMENT '@Transient' ,
  `isDefaultPassword` BIT(1) NULL COMMENT '@Transient' ,
  `isBlockedDateSet` BIT(1) NULL COMMENT '@Transient' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = 'Таблица хранит пользователей системы\n';


-- -----------------------------------------------------
-- Table `mydb`.`credittype_has_externaldistributor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`credittype_has_externaldistributor` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `credittype_id` BIGINT NOT NULL ,
  `externaldistributor_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_credittype_has_externaldistributor_credittype1_idx` (`credittype_id` ASC) ,
  INDEX `fk_credittype_has_externaldistributor_externaldistributor1_idx` (`externaldistributor_id` ASC) ,
  CONSTRAINT `fk_credittype_has_externaldistributor_credittype1`
    FOREIGN KEY (`credittype_id` )
    REFERENCES `mydb`.`credittype` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_credittype_has_externaldistributor_externaldistributor1`
    FOREIGN KEY (`externaldistributor_id` )
    REFERENCES `mydb`.`externaldistributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_has_externaldistributor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user_has_externaldistributor` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `user_id` BIGINT NOT NULL ,
  `externaldistributor_id` BIGINT NOT NULL ,
  `active` BIT(1) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_has_externaldistributor_user1_idx` (`user_id` ASC) ,
  INDEX `fk_user_has_externaldistributor_externaldistributor1_idx` (`externaldistributor_id` ASC) ,
  CONSTRAINT `fk_user_has_externaldistributor_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_externaldistributor_externaldistributor1`
    FOREIGN KEY (`externaldistributor_id` )
    REFERENCES `mydb`.`externaldistributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dictionary_data`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`dictionary_data` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `language` VARCHAR(30) NULL ,
  `valid` BIT(1) NOT NULL ,
  `fromdate` DATETIME NULL ,
  `todate` DATETIME NULL ,
  `lastmodificationdate` DATETIME NULL ,
  `name` VARCHAR(30) NULL ,
  `dkey` VARCHAR(50) NOT NULL COMMENT '@Size(max=50)' ,
  `dvalue` VARCHAR(1000) NOT NULL ,
  `expkey` VARCHAR(50) NULL ,
  `expkey2` VARCHAR(50) NULL ,
  `expkey3` VARCHAR(50) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = '
Таблица хранит справочники\n
';


-- -----------------------------------------------------
-- Table `mydb`.`goodexternaldistributor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`goodexternaldistributor` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `dictionary_good` VARCHAR(30) NOT NULL ,
  `externaldistributor_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`, `externaldistributor_id`) ,
  INDEX `fk_goodexternaldistributor_externaldistributor1_idx` (`externaldistributor_id` ASC) ,
  CONSTRAINT `fk_goodexternaldistributor_externaldistributor1`
    FOREIGN KEY (`externaldistributor_id` )
    REFERENCES `mydb`.`externaldistributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`competence_level`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`competence_level` (
  `id` BIGINT NOT NULL COMMENT '@Id' ,
  `name` VARCHAR(30) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`urole`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`urole` (
  `id` BIGINT NOT NULL COMMENT '@Id' ,
  `name` VARCHAR(45) NULL ,
  `last_update` DATE NULL ,
  `description` VARCHAR(100) NULL ,
  `is_allowed_make_decision` BIT(1) NULL ,
  `competence_level_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_role_competence_level1_idx` (`competence_level_id` ASC) ,
  CONSTRAINT `fk_role_competence_level1`
    FOREIGN KEY (`competence_level_id` )
    REFERENCES `mydb`.`competence_level` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rgroup`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`rgroup` (
  `id` BIGINT NOT NULL COMMENT '@Id' ,
  `code` VARCHAR(30) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`uright`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`uright` (
  `id` BIGINT NOT NULL COMMENT '@Id' ,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(256) NULL ,
  `rgroup_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_uright_ugroup1_idx` (`rgroup_id` ASC) ,
  CONSTRAINT `fk_uright_ugroup1`
    FOREIGN KEY (`rgroup_id` )
    REFERENCES `mydb`.`rgroup` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_has_urole`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user_has_urole` (
  `user_id` BIGINT NOT NULL ,
  `urole_id` BIGINT NOT NULL ,
  `id` BIGINT NOT NULL COMMENT '@Id\n@GeneratedValue' ,
  INDEX `fk_user_has_urole_urole1_idx` (`urole_id` ASC) ,
  INDEX `fk_user_has_urole_user1_idx` (`user_id` ASC) ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_user_has_urole_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_urole_urole1`
    FOREIGN KEY (`urole_id` )
    REFERENCES `mydb`.`urole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`urole_has_uright`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`urole_has_uright` (
  `urole_id` BIGINT NOT NULL ,
  `uright_id` BIGINT NOT NULL ,
  `id` BIGINT NOT NULL COMMENT '@Id' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_urole_has_uright_uright1_idx` (`uright_id` ASC) ,
  INDEX `fk_urole_has_uright_urole1_idx` (`urole_id` ASC) ,
  CONSTRAINT `fk_urole_has_uright_urole1`
    FOREIGN KEY (`urole_id` )
    REFERENCES `mydb`.`urole` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_urole_has_uright_uright1`
    FOREIGN KEY (`uright_id` )
    REFERENCES `mydb`.`uright` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`in_third_person`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_third_person` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `in_dossier_id` BIGINT NOT NULL ,
  `first_name` VARCHAR(60) NULL ,
  `last_name` VARCHAR(60) NULL ,
  `patronymic_name` VARCHAR(60) NULL ,
  `phone` VARCHAR(10) NULL ,
  `dict_type_of_relation_client` VARCHAR(5) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_In_third_person_in_dossier1_idx` (`in_dossier_id` ASC) ,
  CONSTRAINT `fk_In_third_person_in_dossier1`
    FOREIGN KEY (`in_dossier_id` )
    REFERENCES `mydb`.`in_dossier` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`in_document_store`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_document_store` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `data` BLOB NULL ,
  `doc_size` BIGINT NULL ,
  `doc_type` VARCHAR(45) NULL ,
  `insert_timestamp` DATE NULL ,
  `description` VARCHAR(50) NULL ,
  `in_dossier_id` BIGINT NOT NULL ,
  `is_not_required` BIT(1) NULL ,
  `filename` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_in_document_store_in_dossier1_idx` (`in_dossier_id` ASC) ,
  CONSTRAINT `fk_in_document_store_in_dossier1`
    FOREIGN KEY (`in_dossier_id` )
    REFERENCES `mydb`.`in_dossier` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`in_asset`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_asset` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `count_of` INT NULL COMMENT '@NotNull' ,
  `dictionary_asset` VARCHAR(5) NULL COMMENT '@NotNull' ,
  `in_dossier_id` BIGINT NOT NULL ,
  `selected` BIT(1) NULL COMMENT '@Transient' ,
  `visible` BIT(1) NULL COMMENT '@Transient' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_in_asset_in_dossier1_idx` (`in_dossier_id` ASC) ,
  CONSTRAINT `fk_in_asset_in_dossier1`
    FOREIGN KEY (`in_dossier_id` )
    REFERENCES `mydb`.`in_dossier` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`powerofattorney`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`powerofattorney` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `attorney_date_start` DATE NULL ,
  `attorney_date_finish` DATE NULL COMMENT '@Future' ,
  `dictionary_type_of_attorney` VARCHAR(5) NULL ,
  `dictionary_type_purpose` VARCHAR(5) NULL ,
  `attorney_number` VARCHAR(300) NULL ,
  `user_id` BIGINT NOT NULL ,
  `product_id` BIGINT NOT NULL ,
  `externaldistributor_id` BIGINT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_powerofattorney_user1_idx` (`user_id` ASC) ,
  INDEX `fk_powerofattorney_product1_idx` (`product_id` ASC) ,
  INDEX `fk_powerofattorney_externaldistributor1_idx` (`externaldistributor_id` ASC) ,
  CONSTRAINT `fk_powerofattorney_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `mydb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_powerofattorney_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `mydb`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_powerofattorney_externaldistributor1`
    FOREIGN KEY (`externaldistributor_id` )
    REFERENCES `mydb`.`externaldistributor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`in_bloknot`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`in_bloknot` (
  `id` BIGINT NOT NULL COMMENT '@Id @GeneratedValue' ,
  `bloknot_type` VARCHAR(30) NULL ,
  `bloknot_subtype` VARCHAR(100) NULL ,
  `enter_date` DATETIME NULL ,
  `role_ids` VARCHAR(100) NULL ,
  `text` VARCHAR(500) NULL ,
  `user_login` VARCHAR(32) NULL ,
  `user_name` VARCHAR(128) NULL ,
  `in_dossier_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_in_bloknot_in_dossier1_idx` (`in_dossier_id` ASC) ,
  CONSTRAINT `fk_in_bloknot_in_dossier1`
    FOREIGN KEY (`in_dossier_id` )
    REFERENCES `mydb`.`in_dossier` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
