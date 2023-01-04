-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 26, 2020 at 10:25 PM
-- Server version: 10.2.32-MariaDB-log
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hot_ostrich`
--

-- --------------------------------------------------------

--
-- Table structure for table `AcademicContent`
--

CREATE TABLE `AcademicContent` (
  `idAcademicContent` int(11) NOT NULL,
  `academicContent` varchar(1800) NOT NULL DEFAULT 'No Description',
  `dateCreated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `AcademicContent_has_CourseDescription`
--

CREATE TABLE `AcademicContent_has_CourseDescription` (
  `AcademicContent_idAcademicContent` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Approval`
--

CREATE TABLE `Approval` (
  `idApproval` int(11) NOT NULL,
  `approvalDeadline` datetime NOT NULL DEFAULT current_timestamp(),
  `approved` tinyint(4) DEFAULT 0,
  `approvedDate` datetime DEFAULT NULL,
  `approvedCourseCoordinator` tinyint(4) DEFAULT 0,
  `approvedDateCourseCoordinator` datetime DEFAULT NULL,
  `approvedInstituteLeader` tinyint(4) DEFAULT 0,
  `approvedDateInstituteLeader` datetime DEFAULT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Comments`
--

CREATE TABLE `Comments` (
  `idComment` int(11) NOT NULL,
  `title` varchar(45) NOT NULL DEFAULT 'No Title Defined',
  `content` varchar(240) NOT NULL DEFAULT 'No Content',
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `CourseDescription_idCourse` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `archived` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CompetenceGoals`
--

CREATE TABLE `CompetenceGoals` (
  `idCompetenceGoals` int(11) NOT NULL,
  `competenceGoals` varchar(6000) NOT NULL DEFAULT 'No Description',
  `dateCreated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CompetenceGoals_has_CourseDescription`
--

CREATE TABLE `CompetenceGoals_has_CourseDescription` (
  `CompetenceGoals_idCompetenceGoals` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CourseCode`
--

CREATE TABLE `CourseCode` (
  `idCourseCode` int(11) NOT NULL,
  `courseCode` varchar(45) NOT NULL DEFAULT 'XXX-0000',
  `name_nb_no` varchar(45) NOT NULL DEFAULT 'Intet Navn Definert',
  `name_nb_nn` varchar(45) NOT NULL DEFAULT 'Inkje Namn Definert',
  `name_en_gb` varchar(45) NOT NULL DEFAULT 'No Name Defined',
  `Degree_idDegree` tinyint(4) NOT NULL,
  `StudyPoints_idStudyPoints` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CourseCode_has_CourseDescription`
--

CREATE TABLE `CourseCode_has_CourseDescription` (
  `CourseCode_idCourseCode` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CourseCoordinator`
--

CREATE TABLE `CourseCoordinator` (
  `User_idUser` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL,
  `CoursePart` varchar(45) NOT NULL DEFAULT 'Part Not Defined'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CourseDescription`
--

CREATE TABLE `CourseDescription` (
  `idCourse` int(11) NOT NULL,
  `year` smallint(6) NOT NULL,
  `dateCreated` datetime NOT NULL DEFAULT current_timestamp(),
  `dateChanged` datetime DEFAULT NULL,
  `singleCourse` tinyint(4) NOT NULL,
  `continuation` tinyint(4) NOT NULL,
  `semesterFall` tinyint(4) NOT NULL,
  `semesterSpring` tinyint(4) NOT NULL,
  `archived` tinyint(4) DEFAULT NULL,
  `CreatedBy_idUser` int(11) NOT NULL,
  `Language_idLanguage` tinyint(4) NOT NULL,
  `ExamType_idExamType` tinyint(4) NOT NULL,
  `GradeScale_idGradeScale` tinyint(4) NOT NULL,
  `TeachingLocation_idTeachingLocation` int(11) NOT NULL,
  `ArchivedBy_idUser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CourseLeader`
--

CREATE TABLE `CourseLeader` (
  `idCourseLeader` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `CourseCode_idCourseCode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CourseLog`
--

CREATE TABLE `CourseLog` (
  `idCourseLog` int(11) NOT NULL,
  `dateChanged` datetime NOT NULL DEFAULT current_timestamp(),
  `User_idUser` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Degree`
--

CREATE TABLE `Degree` (
  `idDegree` tinyint(4) NOT NULL,
  `degree` varchar(45) NOT NULL DEFAULT 'No Degree Defined'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Degree`
--

INSERT INTO `Degree` (`idDegree`, `degree`) VALUES
(3, 'Bachelor'),
(5, 'Doktor'),
(2, 'Forkurs'),
(1, 'Ingen'),
(4, 'Master'),
(6, 'ph.d');

-- --------------------------------------------------------

--
-- Table structure for table `ExamType`
--

CREATE TABLE `ExamType` (
  `idExamType` tinyint(4) NOT NULL,
  `examType` varchar(45) NOT NULL DEFAULT 'Written'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ExamType`
--

INSERT INTO `ExamType` (`idExamType`, `examType`) VALUES
(1, 'Skriftlig'),
(2, 'Muntlig'),
(3, 'Mappe'),
(4, 'Prosjekt');

-- --------------------------------------------------------

--
-- Table structure for table `Fakultet`
--

CREATE TABLE `Fakultet` (
  `idFakultet` int(255) NOT NULL,
  `nameFakultet` varchar(33) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `GradeScale`
--

CREATE TABLE `GradeScale` (
  `idGradeScale` tinyint(4) NOT NULL,
  `scale` varchar(20) NOT NULL DEFAULT 'A-F'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `GradeScale`
--

INSERT INTO `GradeScale` (`idGradeScale`, `scale`) VALUES
(1, 'A-F'),
(2, 'Godkjent');

-- --------------------------------------------------------

--
-- Table structure for table `Inbox`
--

CREATE TABLE `Inbox` (
  `id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(600) DEFAULT NULL,
  `opened` tinyint(4) NOT NULL DEFAULT 0,
  `type` int(11) NOT NULL DEFAULT 1,
  `user_id` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `InboxType`
--

CREATE TABLE `InboxType` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `InboxType`
--

INSERT INTO `InboxType` (`id`, `name`) VALUES
(2, 'Emne til godkjenning'),
(4, 'Oppdatert emnebeskrivelse'),
(3, 'Oppdatert emnekode'),
(1, 'Ukategorisert');

-- --------------------------------------------------------

--
-- Table structure for table `Language`
--

CREATE TABLE `Language` (
  `idLanguage` tinyint(4) NOT NULL,
  `language` varchar(45) NOT NULL DEFAULT 'No Language Set'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Language`
--

INSERT INTO `Language` (`idLanguage`, `language`) VALUES
(1, 'Norsk'),
(2, 'Nynorsk'),
(3, 'English');

-- --------------------------------------------------------

--
-- Table structure for table `LearningMethods`
--

CREATE TABLE `LearningMethods` (
  `idLearningMethods` int(11) NOT NULL,
  `learningMethods` varchar(900) NOT NULL DEFAULT 'No Description',
  `dateCreated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `LearningMethods_has_CourseDescription`
--

CREATE TABLE `LearningMethods_has_CourseDescription` (
  `LearningMethods_idLearningMethods` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `OffersOnlineStudents`
--

CREATE TABLE `OffersOnlineStudents` (
  `idOffersOnlineStudents` int(11) NOT NULL,
  `streaming` tinyint(4) NOT NULL DEFAULT 0,
  `webMeetingLecture` tinyint(4) NOT NULL DEFAULT 0,
  `webMeetingEvening` tinyint(4) NOT NULL DEFAULT 0,
  `followUp` tinyint(4) NOT NULL DEFAULT 0,
  `organizedArrangements` tinyint(4) NOT NULL DEFAULT 0,
  `other` varchar(1000) DEFAULT 'No Description',
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Position`
--

CREATE TABLE `Position` (
  `idPosition` tinyint(4) NOT NULL,
  `position` varchar(45) NOT NULL DEFAULT 'No Position Defined'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Position`
--

INSERT INTO `Position` (`idPosition`, `position`) VALUES
(1, 'Administrator'),
(2, 'Dekan'),
(5, 'Foreleser'),
(3, 'Instituttleder'),
(4, 'Professor');

-- --------------------------------------------------------

--
-- Table structure for table `Prerequisites`
--

CREATE TABLE `Prerequisites` (
  `idPrerequisites` int(11) NOT NULL,
  `required` tinyint(4) NOT NULL DEFAULT 0,
  `CourseDescription_idCourse` int(11) NOT NULL,
  `CourseCode_idCourseCode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `idRole` tinyint(4) NOT NULL,
  `role` varchar(45) NOT NULL DEFAULT 'No Role Defined',
  `read` tinyint(4) NOT NULL DEFAULT 1,
  `write` tinyint(4) NOT NULL DEFAULT 0,
  `edit` tinyint(4) NOT NULL DEFAULT 0,
  `delete` tinyint(4) NOT NULL DEFAULT 0,
  `create` tinyint(4) NOT NULL DEFAULT 0,
  `approve` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`idRole`, `role`, `read`, `write`, `edit`, `delete`, `create`, `approve`) VALUES
(1, 'Administrator', 1, 1, 1, 1, 1, 1),
(2, 'Dekan', 1, 1, 1, 1, 1, 1),
(3, 'Instituttleder', 1, 1, 1, 1, 1, 1),
(4, 'Fagkoordinator', 1, 1, 1, 0, 0, 0),
(5, 'Emneansvarlig', 1, 1, 1, 0, 1, 1),
(6, 'Foreleser', 1, 1, 0, 0, 0, 0),
(7, 'Ikke registrert', 1, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Statistics`
--

CREATE TABLE `Statistics` (
  `idStatistics` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `StudyPoints`
--

CREATE TABLE `StudyPoints` (
  `idStudyPoints` tinyint(4) NOT NULL,
  `studyPoints` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `StudyPoints`
--

INSERT INTO `StudyPoints` (`idStudyPoints`, `studyPoints`) VALUES
(1, 0),
(2, 5),
(3, 10),
(4, 15),
(5, 20),
(6, 25),
(7, 30),
(8, 60);

-- --------------------------------------------------------

--
-- Table structure for table `TeachingLocation`
--

CREATE TABLE `TeachingLocation` (
  `idTeachingLocation` int(11) NOT NULL,
  `narvik` tinyint(4) NOT NULL DEFAULT 0,
  `tromso` tinyint(4) NOT NULL DEFAULT 0,
  `alta` tinyint(4) NOT NULL DEFAULT 0,
  `moIRana` tinyint(4) NOT NULL DEFAULT 0,
  `bodo` tinyint(4) NOT NULL DEFAULT 0,
  `webBased` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `idUser` int(11) NOT NULL,
  `username` varchar(45) NOT NULL DEFAULT 'No Username Defined',
  `email` varchar(45) NOT NULL DEFAULT 'No Email Defined',
  `password` varchar(255) NOT NULL DEFAULT 'No Password Defined',
  `firstName` varchar(45) NOT NULL DEFAULT 'No Name Defined',
  `lastName` varchar(45) NOT NULL DEFAULT 'No Last Name Defined',
  `employeeNumber` int(11) NOT NULL DEFAULT 0,
  `numLogin` int(11) DEFAULT 0,
  `Position_idPosition` tinyint(4) NOT NULL DEFAULT 1,
  `Role_idRole` tinyint(4) NOT NULL DEFAULT 7,
  `lastLogin` date NOT NULL DEFAULT current_timestamp(),
  `Fakultet_idFakultet` int(255) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`idUser`, `username`, `email`, `password`, `firstName`, `lastName`, `employeeNumber`, `numLogin`, `Position_idPosition`, `Role_idRole`, `lastLogin`, `Fakultet_idFakultet`) VALUES
(1, 'Administrator', 'Administrator@uit.no', '$2y$10$29iruj3/JIKPd/LWPe.FUukEccBTBbt6wpoSX4IX8k4kdwVmGd0Ai', 'Administrator', 'Bruker', 0, 9, 1, 1, '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `WorkRequirements`
--

CREATE TABLE `WorkRequirements` (
  `idWorkRequirements` int(11) NOT NULL,
  `workRequirements` varchar(3000) NOT NULL DEFAULT 'No Description',
  `dateCreated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `WorkRequirements_has_CourseDescription`
--

CREATE TABLE `WorkRequirements_has_CourseDescription` (
  `WorkRequirements_idWorkRequirements` int(11) NOT NULL,
  `CourseDescription_idCourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AcademicContent`
--
ALTER TABLE `AcademicContent`
  ADD PRIMARY KEY (`idAcademicContent`),
  ADD UNIQUE KEY `idAcademicContent_UNIQUE` (`idAcademicContent`);

--
-- Indexes for table `AcademicContent_has_CourseDescription`
--
ALTER TABLE `AcademicContent_has_CourseDescription`
  ADD PRIMARY KEY (`AcademicContent_idAcademicContent`,`CourseDescription_idCourse`),
  ADD KEY `fk_AcademicContent_has_CourseDescription_CourseDescription1_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_AcademicContent_has_CourseDescription_AcademicContent1_idx` (`AcademicContent_idAcademicContent`);

--
-- Indexes for table `Approval`
--
ALTER TABLE `Approval`
  ADD PRIMARY KEY (`idApproval`),
  ADD UNIQUE KEY `idApproval_UNIQUE` (`idApproval`),
  ADD KEY `fk_Approval_CourseDescriptions1_idx` (`CourseDescription_idCourse`);

--
-- Indexes for table `Comments`
--
ALTER TABLE `Comments`
  ADD PRIMARY KEY (`idComment`),
  ADD UNIQUE KEY `idComments_UNIQUE` (`idComment`),
  ADD KEY `fk_Comments_CourseDescription1_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_comments_User1_idx` (`User_idUser`);

--
-- Indexes for table `CompetenceGoals`
--
ALTER TABLE `CompetenceGoals`
  ADD PRIMARY KEY (`idCompetenceGoals`),
  ADD UNIQUE KEY `idCompetenceGoals_UNIQUE` (`idCompetenceGoals`);

--
-- Indexes for table `CompetenceGoals_has_CourseDescription`
--
ALTER TABLE `CompetenceGoals_has_CourseDescription`
  ADD PRIMARY KEY (`CompetenceGoals_idCompetenceGoals`,`CourseDescription_idCourse`),
  ADD KEY `fk_CompetenceGoals_has_CourseDescription_CourseDescription1_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_CompetenceGoals_has_CourseDescription_CompetenceGoals1_idx` (`CompetenceGoals_idCompetenceGoals`);

--
-- Indexes for table `CourseCode`
--
ALTER TABLE `CourseCode`
  ADD PRIMARY KEY (`idCourseCode`),
  ADD UNIQUE KEY `idCourseCode_UNIQUE` (`idCourseCode`),
  ADD UNIQUE KEY `courseCode_UNIQUE` (`courseCode`),
  ADD KEY `fk_CourseCode_Degree1_idx` (`Degree_idDegree`),
  ADD KEY `fk_CourseCode_StudyPoints1_idx` (`StudyPoints_idStudyPoints`);

--
-- Indexes for table `CourseCode_has_CourseDescription`
--
ALTER TABLE `CourseCode_has_CourseDescription`
  ADD PRIMARY KEY (`CourseCode_idCourseCode`,`CourseDescription_idCourse`),
  ADD KEY `fk_CourseCode_has_CourseDescription_CourseDescription1_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_CourseCode_has_CourseDescription_CourseCode1_idx` (`CourseCode_idCourseCode`);

--
-- Indexes for table `CourseCoordinator`
--
ALTER TABLE `CourseCoordinator`
  ADD PRIMARY KEY (`User_idUser`,`CourseDescription_idCourse`),
  ADD KEY `fk_CourseDescription_has_USer_User1_idx` (`User_idUser`),
  ADD KEY `fk_CourseCoordinator_CourseDescription1_idx` (`CourseDescription_idCourse`);

--
-- Indexes for table `CourseDescription`
--
ALTER TABLE `CourseDescription`
  ADD PRIMARY KEY (`idCourse`),
  ADD UNIQUE KEY `CourseCode_UNIQUE` (`idCourse`),
  ADD KEY `fk_CourseDescription_CreatedBy_User1_idx` (`CreatedBy_idUser`),
  ADD KEY `fk_CourseDescription_Language1_idx` (`Language_idLanguage`),
  ADD KEY `fk_CourseDescription_ExamType1_idx` (`ExamType_idExamType`),
  ADD KEY `fk_CourseDescription_GradeScale1_idx` (`GradeScale_idGradeScale`),
  ADD KEY `fk_CourseDescription_TeachingLocation1_idx` (`TeachingLocation_idTeachingLocation`),
  ADD KEY `fk_CourseDescription_ArchivedBy_User1_idx1` (`ArchivedBy_idUser`);

--
-- Indexes for table `CourseLeader`
--
ALTER TABLE `CourseLeader`
  ADD PRIMARY KEY (`idCourseLeader`),
  ADD UNIQUE KEY `idCourseLeader_UNIQUE` (`idCourseLeader`),
  ADD KEY `fk_User_has_CourseCode_CourseCode1_idx` (`CourseCode_idCourseCode`),
  ADD KEY `fk_User_has_CourseCode_User1_idx` (`User_idUser`);

--
-- Indexes for table `CourseLog`
--
ALTER TABLE `CourseLog`
  ADD PRIMARY KEY (`idCourseLog`),
  ADD UNIQUE KEY `idCourseLog_UNIQUE` (`idCourseLog`),
  ADD KEY `fk_CourseLog_User1_idx` (`User_idUser`),
  ADD KEY `fk_CourseLog_CourseDescription1_idx` (`CourseDescription_idCourse`);

--
-- Indexes for table `Degree`
--
ALTER TABLE `Degree`
  ADD PRIMARY KEY (`idDegree`),
  ADD UNIQUE KEY `idDegree_UNIQUE` (`idDegree`),
  ADD UNIQUE KEY `degree_UNIQUE` (`degree`);

--
-- Indexes for table `ExamType`
--
ALTER TABLE `ExamType`
  ADD PRIMARY KEY (`idExamType`),
  ADD UNIQUE KEY `idExamType_UNIQUE` (`idExamType`);

--
-- Indexes for table `Fakultet`
--
ALTER TABLE `Fakultet`
  ADD PRIMARY KEY (`idFakultet`),
  ADD UNIQUE KEY `idFakultet_UNIQUE` (`idFakultet`);

--
-- Indexes for table `GradeScale`
--
ALTER TABLE `GradeScale`
  ADD PRIMARY KEY (`idGradeScale`),
  ADD UNIQUE KEY `idGradeScale_UNIQUE` (`idGradeScale`);

--
-- Indexes for table `Inbox`
--
ALTER TABLE `Inbox`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type` (`type`),
  ADD KEY `user` (`user_id`);

--
-- Indexes for table `InboxType`
--
ALTER TABLE `InboxType`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `Language`
--
ALTER TABLE `Language`
  ADD PRIMARY KEY (`idLanguage`),
  ADD UNIQUE KEY `idLanguage_UNIQUE` (`idLanguage`);

--
-- Indexes for table `LearningMethods`
--
ALTER TABLE `LearningMethods`
  ADD PRIMARY KEY (`idLearningMethods`),
  ADD UNIQUE KEY `idLearningMethods_UNIQUE` (`idLearningMethods`);

--
-- Indexes for table `LearningMethods_has_CourseDescription`
--
ALTER TABLE `LearningMethods_has_CourseDescription`
  ADD PRIMARY KEY (`LearningMethods_idLearningMethods`,`CourseDescription_idCourse`),
  ADD KEY `fk_LearningMethods_has_CourseDescription_CourseDescription1_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_LearningMethods_has_CourseDescription_LearningMethods1_idx` (`LearningMethods_idLearningMethods`);

--
-- Indexes for table `OffersOnlineStudents`
--
ALTER TABLE `OffersOnlineStudents`
  ADD PRIMARY KEY (`idOffersOnlineStudents`),
  ADD UNIQUE KEY `idOffersOnlineStudents_UNIQUE` (`idOffersOnlineStudents`),
  ADD KEY `fk_OffersOnlineStudents_CourseDescription1_idx` (`CourseDescription_idCourse`);

--
-- Indexes for table `Position`
--
ALTER TABLE `Position`
  ADD PRIMARY KEY (`idPosition`),
  ADD UNIQUE KEY `idPosition_UNIQUE` (`idPosition`),
  ADD UNIQUE KEY `position_UNIQUE` (`position`);

--
-- Indexes for table `Prerequisites`
--
ALTER TABLE `Prerequisites`
  ADD PRIMARY KEY (`idPrerequisites`),
  ADD UNIQUE KEY `idPrerequisites_UNIQUE` (`idPrerequisites`),
  ADD KEY `fk_Prerequisites_CourseDescription1_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_Prerequisites_CourseCode1_idx` (`CourseCode_idCourseCode`);

--
-- Indexes for table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`idRole`),
  ADD UNIQUE KEY `idRole_UNIQUE` (`idRole`);

--
-- Indexes for table `StudyPoints`
--
ALTER TABLE `StudyPoints`
  ADD PRIMARY KEY (`idStudyPoints`),
  ADD UNIQUE KEY `studyPoints_UNIQUE` (`studyPoints`),
  ADD UNIQUE KEY `idStudyPoints_UNIQUE` (`idStudyPoints`);

--
-- Indexes for table `TeachingLocation`
--
ALTER TABLE `TeachingLocation`
  ADD PRIMARY KEY (`idTeachingLocation`),
  ADD UNIQUE KEY `idTeachingLocation_UNIQUE` (`idTeachingLocation`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `idUser_UNIQUE` (`idUser`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD KEY `fk_User_Position1_idx` (`Position_idPosition`),
  ADD KEY `fk_User_Role1_idx` (`Role_idRole`),
  ADD KEY `Role_idRole` (`Role_idRole`),
  ADD KEY `fk_User_idFakultet1` (`Fakultet_idFakultet`),
  ADD KEY `employeeNumber_idx` (`employeeNumber`) USING BTREE;

--
-- Indexes for table `WorkRequirements`
--
ALTER TABLE `WorkRequirements`
  ADD PRIMARY KEY (`idWorkRequirements`),
  ADD UNIQUE KEY `idCompetenceGoals_UNIQUE` (`idWorkRequirements`);

--
-- Indexes for table `WorkRequirements_has_CourseDescription`
--
ALTER TABLE `WorkRequirements_has_CourseDescription`
  ADD PRIMARY KEY (`WorkRequirements_idWorkRequirements`,`CourseDescription_idCourse`),
  ADD KEY `fk_WorkRequirements_has_CourseDescription_CourseDescription_idx` (`CourseDescription_idCourse`),
  ADD KEY `fk_WorkRequirements_has_CourseDescription_WorkRequirements1_idx` (`WorkRequirements_idWorkRequirements`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `AcademicContent`
--
ALTER TABLE `AcademicContent`
  MODIFY `idAcademicContent` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Approval`
--
ALTER TABLE `Approval`
  MODIFY `idApproval` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Comments`
--
ALTER TABLE `Comments`
  MODIFY `idComment` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CompetenceGoals`
--
ALTER TABLE `CompetenceGoals`
  MODIFY `idCompetenceGoals` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CourseCode`
--
ALTER TABLE `CourseCode`
  MODIFY `idCourseCode` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CourseDescription`
--
ALTER TABLE `CourseDescription`
  MODIFY `idCourse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CourseLeader`
--
ALTER TABLE `CourseLeader`
  MODIFY `idCourseLeader` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `CourseLog`
--
ALTER TABLE `CourseLog`
  MODIFY `idCourseLog` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Degree`
--
ALTER TABLE `Degree`
  MODIFY `idDegree` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ExamType`
--
ALTER TABLE `ExamType`
  MODIFY `idExamType` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Fakultet`
--
ALTER TABLE `Fakultet`
  MODIFY `idFakultet` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `GradeScale`
--
ALTER TABLE `GradeScale`
  MODIFY `idGradeScale` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Inbox`
--
ALTER TABLE `Inbox`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `InboxType`
--
ALTER TABLE `InboxType`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Language`
--
ALTER TABLE `Language`
  MODIFY `idLanguage` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `LearningMethods`
--
ALTER TABLE `LearningMethods`
  MODIFY `idLearningMethods` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `OffersOnlineStudents`
--
ALTER TABLE `OffersOnlineStudents`
  MODIFY `idOffersOnlineStudents` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Position`
--
ALTER TABLE `Position`
  MODIFY `idPosition` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Prerequisites`
--
ALTER TABLE `Prerequisites`
  MODIFY `idPrerequisites` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Role`
--
ALTER TABLE `Role`
  MODIFY `idRole` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Statistics`
--
ALTER TABLE `Statistics`
  MODIFY `idStatistics` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `StudyPoints`
--
ALTER TABLE `StudyPoints`
  MODIFY `idStudyPoints` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `TeachingLocation`
--
ALTER TABLE `TeachingLocation`
  MODIFY `idTeachingLocation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `WorkRequirements`
--
ALTER TABLE `WorkRequirements`
  MODIFY `idWorkRequirements` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `AcademicContent_has_CourseDescription`
--
ALTER TABLE `AcademicContent_has_CourseDescription`
  ADD CONSTRAINT `fk_AcademicContent_has_CourseDescription_AcademicContent1` FOREIGN KEY (`AcademicContent_idAcademicContent`) REFERENCES `AcademicContent` (`idAcademicContent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_AcademicContent_has_CourseDescription_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Approval`
--
ALTER TABLE `Approval`
  ADD CONSTRAINT `fk_Approval_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Comments`
--
ALTER TABLE `Comments`
  ADD CONSTRAINT `fk_Comments_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Comments_User1` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CompetenceGoals_has_CourseDescription`
--
ALTER TABLE `CompetenceGoals_has_CourseDescription`
  ADD CONSTRAINT `fk_CompetenceGoals_has_CourseDescription_CompetenceGoals1` FOREIGN KEY (`CompetenceGoals_idCompetenceGoals`) REFERENCES `CompetenceGoals` (`idCompetenceGoals`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CompetenceGoals_has_CourseDescription_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CourseCode`
--
ALTER TABLE `CourseCode`
  ADD CONSTRAINT `fk_CourseCode_Degree1` FOREIGN KEY (`Degree_idDegree`) REFERENCES `Degree` (`idDegree`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseCode_StudyPoints1` FOREIGN KEY (`StudyPoints_idStudyPoints`) REFERENCES `StudyPoints` (`idStudyPoints`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CourseCode_has_CourseDescription`
--
ALTER TABLE `CourseCode_has_CourseDescription`
  ADD CONSTRAINT `fk_CourseCode_has_CourseDescription_CourseCode1` FOREIGN KEY (`CourseCode_idCourseCode`) REFERENCES `CourseCode` (`idCourseCode`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseCode_has_CourseDescription_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CourseCoordinator`
--
ALTER TABLE `CourseCoordinator`
  ADD CONSTRAINT `fk_CourseCoordinator_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseDescription_has_User_User1` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CourseDescription`
--
ALTER TABLE `CourseDescription`
  ADD CONSTRAINT `fk_CourseDescription_ArchivedBy_User1` FOREIGN KEY (`ArchivedBy_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseDescription_CreatedBy_User1` FOREIGN KEY (`CreatedBy_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseDescription_ExamType1` FOREIGN KEY (`ExamType_idExamType`) REFERENCES `ExamType` (`idExamType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseDescription_GradeScale1` FOREIGN KEY (`GradeScale_idGradeScale`) REFERENCES `GradeScale` (`idGradeScale`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseDescription_Language1` FOREIGN KEY (`Language_idLanguage`) REFERENCES `Language` (`idLanguage`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseDescription_TeachingLocation1` FOREIGN KEY (`TeachingLocation_idTeachingLocation`) REFERENCES `TeachingLocation` (`idTeachingLocation`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CourseLeader`
--
ALTER TABLE `CourseLeader`
  ADD CONSTRAINT `fk_User_has_CourseCode_CourseCode1` FOREIGN KEY (`CourseCode_idCourseCode`) REFERENCES `CourseCode` (`idCourseCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_has_CourseCode_User1` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `CourseLog`
--
ALTER TABLE `CourseLog`
  ADD CONSTRAINT `fk_CourseLog_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_CourseLog_User1` FOREIGN KEY (`User_idUser`) REFERENCES `User` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Inbox`
--
ALTER TABLE `Inbox`
  ADD CONSTRAINT `type` FOREIGN KEY (`type`) REFERENCES `InboxType` (`id`),
  ADD CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `User` (`idUser`) ON DELETE CASCADE;

--
-- Constraints for table `LearningMethods_has_CourseDescription`
--
ALTER TABLE `LearningMethods_has_CourseDescription`
  ADD CONSTRAINT `fk_LearningMethods_has_CourseDescription_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_LearningMethods_has_CourseDescription_LearningMethods1` FOREIGN KEY (`LearningMethods_idLearningMethods`) REFERENCES `LearningMethods` (`idLearningMethods`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `OffersOnlineStudents`
--
ALTER TABLE `OffersOnlineStudents`
  ADD CONSTRAINT `fk_Offers_OnlineStudents_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Prerequisites`
--
ALTER TABLE `Prerequisites`
  ADD CONSTRAINT `fk_Prerequisites_CourseCode1` FOREIGN KEY (`CourseCode_idCourseCode`) REFERENCES `CourseCode` (`idCourseCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Prerequisites_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `fk_User_Position1` FOREIGN KEY (`Position_idPosition`) REFERENCES `Position` (`idPosition`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_Role1` FOREIGN KEY (`Role_idRole`) REFERENCES `Role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_User_idFakultet1` FOREIGN KEY (`Fakultet_idFakultet`) REFERENCES `Fakultet` (`idFakultet`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `WorkRequirements_has_CourseDescription`
--
ALTER TABLE `WorkRequirements_has_CourseDescription`
  ADD CONSTRAINT `fk_WorkRequirements_has_CourseDescription_CourseDescription1` FOREIGN KEY (`CourseDescription_idCourse`) REFERENCES `CourseDescription` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_WorkRequirements_has_CourseDescription_WorkRequirements1` FOREIGN KEY (`WorkRequirements_idWorkRequirements`) REFERENCES `WorkRequirements` (`idWorkRequirements`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
