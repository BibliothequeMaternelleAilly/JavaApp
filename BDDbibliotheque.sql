-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 27 Juillet 2016 à 16:44
-- Version du serveur: 5.5.50-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `BDDbibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `eleves`
--

CREATE TABLE IF NOT EXISTS `eleves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `eleves`
--

INSERT INTO `eleves` (`id`, `nom`, `prenom`) VALUES
(1, 'NOM_ELEVE1', 'prenom_eleve1');

-- --------------------------------------------------------

--
-- Structure de la table `livres`
--

CREATE TABLE IF NOT EXISTS `livres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_barre` varchar(13) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `auteur` varchar(25) NOT NULL,
  `mots_cles` mediumtext,
  `theme` varchar(15) DEFAULT NULL,
  `idEmprunteur` int(11) DEFAULT NULL,
  `date_emprun` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `livres`
--

INSERT INTO `livres` (`id`, `code_barre`, `titre`, `auteur`, `mots_cles`, `theme`, `idEmprunteur`, `date_emprun`) VALUES
(1, '5555555555555', 'titre_livre1', 'auteur_livre1', 'mot_clé1;mot_clé2;mot_clé3;mot_clé4', 'theme_livre1', 1, '2016-07-26');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
