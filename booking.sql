SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User@Customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`user` (
  `username` VARCHAR(15) NOT NULL COMMENT '@Id @Length(min = 5, max = 15)  @Pattern(regex = \"^\\\\w*$\", message = \"not a valid username\")' ,
  `password` VARCHAR(15) NOT NULL COMMENT '@NotNull @Length(min = 5, max = 15)' ,
  `name` VARCHAR(100) NOT NULL COMMENT '@NotNull @Length(max = 100)' ,
  PRIMARY KEY (`username`) ), 
COMMENT = '    public User(String name, String password, String usernam' /* comment truncated */ ;


-- -----------------------------------------------------
-- Table `mydb`.`Hotel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`hotel` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '@Id @GeneratedValue' ,
  `name` VARCHAR(50) NOT NULL COMMENT '@Length(max = 50) @NotNull' ,
  `address` VARCHAR(100) NOT NULL COMMENT '@Length(max = 100) @NotNull' ,
  `city` VARCHAR(40) NOT NULL COMMENT '@Length(max = 40) @NotNull' ,
  `state` VARCHAR(10) NOT NULL COMMENT '@Length(min = 2, max = 10) @NotNull' ,
  `zip` VARCHAR(6) NOT NULL COMMENT '@Length(min = 4, max = 6) @NotNull' ,
  `country` VARCHAR(40) NOT NULL COMMENT '@Length(min = 2, max = 40) @NotNull' ,
  `price` DECIMAL(6,2) NULL COMMENT '@Column(precision = 6, scale = 2)' ,
  PRIMARY KEY (`id`) );


-- -----------------------------------------------------
-- Table `mydb`.`Booking`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`booking` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '@Id @GeneratedValue' ,
  `checkinDate` DATETIME NOT NULL COMMENT 'Checkin date @NotNull @Basic @Temporal(TemporalType.DATE)' ,
  `checkoutDate` DATETIME NOT NULL COMMENT 'Checkout date @Basic @Temporal(TemporalType.DATE) @NotNull' ,
  `creditCard` VARCHAR(20) NOT NULL COMMENT 'Credit card number @NotNull(message = \"Credit card number is required\") @Length(min = 16, max = 16, message = \"Credit card number must 16 digits long\") @Pattern(regex = \"^\\\\d*$\", message = \"Credit card number must be numeric\")' ,
  `creditCardName` VARCHAR(70) NOT NULL COMMENT 'Credit card name @NotNull(message = \"Credit card name is required\") @Length(min = 3, max = 70, message = \"Credit card name is required\")' ,
  `creditCardExpiryMonth` INT NOT NULL ,
  `creditCardExpiryYear` INT NOT NULL ,
  `smoking` BIT NOT NULL ,
  `beds` INT NOT NULL ,
  `User_username` VARCHAR(15) NOT NULL ,
  `Hotel_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Booking_User1` (`User_username` ASC) ,
  INDEX `fk_Booking_Hotel1` (`Hotel_id` ASC) ,
  CONSTRAINT `fk_Booking_User1`
    FOREIGN KEY (`User_username` )
    REFERENCES `mydb`.`User@Customer` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_Hotel1`
    FOREIGN KEY (`Hotel_id` )
    REFERENCES `mydb`.`Hotel` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '    public Booking() { }\n\n    public Booking(Hotel hotel, Us' /* comment truncated */ ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
