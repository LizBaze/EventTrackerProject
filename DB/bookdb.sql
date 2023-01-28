-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bookdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bookdb` ;

-- -----------------------------------------------------
-- Schema bookdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookdb` DEFAULT CHARACTER SET utf8 ;
USE `bookdb` ;

-- -----------------------------------------------------
-- Table `book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `book` ;

CREATE TABLE IF NOT EXISTS `book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `synopsis` TEXT NULL,
  `cover_art` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `description` TEXT NULL,
  `public` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_book_idx` (`book_id` ASC),
  INDEX `fk_review_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_review_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `followers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `followers` ;

CREATE TABLE IF NOT EXISTS `followers` (
  `user_id` INT NOT NULL,
  `user_id1` INT NOT NULL,
  PRIMARY KEY (`user_id`, `user_id1`),
  INDEX `fk_user_has_user_user2_idx` (`user_id1` ASC),
  INDEX `fk_user_has_user_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`user_id1`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS bookworm@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'bookworm'@'localhost' IDENTIFIED BY 'bookworm';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'bookworm'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `book`
-- -----------------------------------------------------
START TRANSACTION;
USE `bookdb`;
INSERT INTO `book` (`id`, `title`, `author`, `synopsis`, `cover_art`) VALUES (1, 'Shadows Of Self', 'Brandon Sanderson', 'With The Alloy of Law, Brandon Sanderson surprised readers with a New York Times bestselling spinoff of his Mistborn books, set after the action of the trilogy, in a period corresponding to late 19th-century America.\nThe trilogy’s heroes are now figures of myth and legend, even objects of religious veneration. They are succeeded by wonderful new characters, chief among them Waxillium Ladrian, known as Wax, hereditary Lord of House Ladrian but also, until recently, a lawman in the ungoverned frontier region known as the Roughs. There he worked with his eccentric but effective buddy, Wayne. They are “twinborn,” meaning they are able to use both Allomantic and Feruchemical magic.\nShadows of Self shows Mistborn’s society evolving as technology and magic mix, the economy grows, democracy contends with corruption, and religion becomes a growing cultural force, with four faiths competing for converts.\nThis bustling, optimistic, but still shaky society now faces its first instance of terrorism, crimes intended to stir up labor strife and religious conflict. Wax and Wayne, assisted by the lovely, brilliant Marasi, must unravel the conspiracy before civil strife stops Scadrial’s progress in its tracks.\nShadows of Self will give fans of The Alloy of Law everything they’ve been hoping for and, this being a Brandon Sanderson book, more, much more.', 'https://coppermind.net/w/images/thumb/Shadows_of_Self_US_Hardcover.jpg/400px-Shadows_of_Self_US_Hardcover.jpg');
INSERT INTO `book` (`id`, `title`, `author`, `synopsis`, `cover_art`) VALUES (2, 'The Eye of the WOrld', 'Robert Jordan', 'The Wheel of Time turns and Ages come and pass, leaving memories that become legend. Legend fades to myth, and even myth is long forgotten when the Age that gave it birth returns again. What was, what will be, and what is, may yet fall under the Shadow.\n\nMoiraine Damodred arrives in Emond’s Field on a quest to find the one prophesized to stand against The Dark One, a malicious entity sowing the seeds of chaos and destruction. When a vicious band of half-men, half beasts invade the village seeking their master’s enemy, Moiraine persuades Rand al’Thor and his friends to leave their home and enter a larger unimaginable world filled with dangers waiting in the shadows and in the light.', 'https://dragonmount.com/uploads/monthly_2020_06/EoTw-metal.jpg.a0413778c1b6020906dca1c21e94db95.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `bookdb`;
INSERT INTO `user` (`id`, `username`, `password`) VALUES (1, 'admin', 'admin');
INSERT INTO `user` (`id`, `username`, `password`) VALUES (2, 'LizzinLaVida', 'password');

COMMIT;


-- -----------------------------------------------------
-- Data for table `review`
-- -----------------------------------------------------
START TRANSACTION;
USE `bookdb`;
INSERT INTO `review` (`id`, `book_id`, `user_id`, `description`, `public`) VALUES (1, 1, 1, 'Excellent read', 1);
INSERT INTO `review` (`id`, `book_id`, `user_id`, `description`, `public`) VALUES (2, 2, 2, 'An epic beginning to a truly epic series.', 1);

COMMIT;

