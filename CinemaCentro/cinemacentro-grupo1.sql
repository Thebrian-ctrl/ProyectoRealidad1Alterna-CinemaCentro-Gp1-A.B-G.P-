-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2025 a las 22:55:11
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinemacentro-grupo1`
--
CREATE DATABASE IF NOT EXISTS `cinemacentro-grupo1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cinemacentro-grupo1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `idComprador` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `password` varchar(50) NOT NULL,
  `medioDePago` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`idComprador`, `dni`, `nombre`, `fechaNacimiento`, `password`, `medioDePago`) VALUES
(3, 41221751, 'Gimenez Paula', '1998-06-06', '123', 'Mercado Pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleticket`
--

CREATE TABLE `detalleticket` (
  `idDetalleTicket` int(11) NOT NULL,
  `idFuncion` int(11) NOT NULL,
  `idLugar` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalleticket`
--

INSERT INTO `detalleticket` (`idDetalleTicket`, `idFuncion`, `idLugar`, `cantidad`, `subtotal`) VALUES
(2, 5, 46, 1, 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idFuncion` int(11) NOT NULL,
  `idPelicula` int(11) NOT NULL,
  `idioma` varchar(30) NOT NULL,
  `es3d` tinyint(1) NOT NULL,
  `subtitulado` tinyint(1) NOT NULL,
  `horarioInicio` datetime NOT NULL,
  `horarioFin` datetime NOT NULL,
  `lugarDisponible` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `funcion`
--

INSERT INTO `funcion` (`idFuncion`, `idPelicula`, `idioma`, `es3d`, `subtitulado`, `horarioInicio`, `horarioFin`, `lugarDisponible`, `idSala`, `precio`) VALUES
(5, 3, 'espanol', 0, 1, '2025-12-16 16:30:00', '2025-12-16 18:30:00', 0, 3, 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar`
--

CREATE TABLE `lugar` (
  `idLugar` int(11) NOT NULL,
  `fila` char(1) NOT NULL,
  `num` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idFuncion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lugar`
--

INSERT INTO `lugar` (`idLugar`, `fila`, `num`, `estado`, `idFuncion`) VALUES
(46, 'A', 1, 1, 5),
(47, 'A', 2, 1, 5),
(48, 'A', 3, 1, 5),
(49, 'B', 1, 1, 5),
(50, 'B', 2, 1, 5),
(51, 'B', 3, 1, 5),
(52, 'C', 1, 1, 5),
(53, 'C', 2, 1, 5),
(54, 'C', 3, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL,
  `titulo` varchar(70) NOT NULL,
  `director` varchar(70) NOT NULL,
  `actores` varchar(200) NOT NULL,
  `origen` varchar(70) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `estreno` date NOT NULL,
  `cartelera` tinyint(1) NOT NULL,
  `rutaImagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idPelicula`, `titulo`, `director`, `actores`, `origen`, `genero`, `estreno`, `cartelera`, `rutaImagen`) VALUES
(3, 'El señor de los anillos', 'Chritopher Nolan', 'Brad pitt', 'Estado Unidos', 'Aventuras', '2005-03-15', 1, NULL),
(4, 'La guerra de los mundos', 'Steven Spielberg', '', 'Estados Unidos', 'Ciencia ficcion', '2005-06-25', 1, NULL),
(5, 'Interestelar', 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway', 'Estados Unidos', 'Ciencia Ficcion, Dra', '2014-10-26', 1, 'src/img/Interestellar.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idSala` int(10) NOT NULL,
  `nroSala` int(10) NOT NULL,
  `apta3d` tinyint(1) NOT NULL,
  `capacidad` int(230) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`idSala`, `nroSala`, `apta3d`, `capacidad`, `estado`) VALUES
(3, 1, 1, 200, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `fechaFuncion` datetime NOT NULL,
  `monto` double NOT NULL,
  `idComprador` int(11) NOT NULL,
  `idDetalleTicket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`idTicket`, `fechaCompra`, `fechaFuncion`, `monto`, `idComprador`, `idDetalleTicket`) VALUES
(1, '2025-10-28', '2025-10-29 22:00:13', 15, 3, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`idComprador`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  ADD PRIMARY KEY (`idDetalleTicket`),
  ADD KEY `idFuncion` (`idFuncion`),
  ADD KEY `idLugar` (`idLugar`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`idFuncion`),
  ADD KEY `idPelicula` (`idPelicula`),
  ADD KEY `idSala` (`idSala`);

--
-- Indices de la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`idLugar`),
  ADD KEY `idFuncion` (`idFuncion`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `idComprador` (`idComprador`),
  ADD KEY `idDetalleTicket` (`idDetalleTicket`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comprador`
--
ALTER TABLE `comprador`
  MODIFY `idComprador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  MODIFY `idDetalleTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `idFuncion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `lugar`
--
ALTER TABLE `lugar`
  MODIFY `idLugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `idSala` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  ADD CONSTRAINT `detalleticket_ibfk_1` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`),
  ADD CONSTRAINT `detalleticket_ibfk_2` FOREIGN KEY (`idLugar`) REFERENCES `lugar` (`idLugar`);

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `funcion_ibfk_1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `funcion_ibfk_2` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`);

--
-- Filtros para la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD CONSTRAINT `lugar_ibfk_1` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `comprador` (`idComprador`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idDetalleTicket`) REFERENCES `detalleticket` (`idDetalleTicket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
