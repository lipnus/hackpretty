-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- 생성 시간: 17-09-17 04:33
-- 서버 버전: 10.1.13-MariaDB
-- PHP 버전: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `hackpretty`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `danger`
--

CREATE TABLE `danger` (
  `danger_id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL,
  `description` varchar(300) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 테이블의 덤프 데이터 `danger`
--

INSERT INTO `danger` (`danger_id`, `name`, `description`) VALUES
(1, '벤젠', 'WHO의 국제암연구소에서 발암물질 Group 1으로 분류되었다.'),
(2, 'VOCs', '발암성이 강하다고 알려져 있는 화학물질이 다수 포함되어 있다. 광화학 반응을 일으켜 오존과 같은 2차 오염물질인 광화학산화물을 생성한다.'),
(3, '스틸렌부타디엔공중합체', 'UN의 유해 화학물질 시스템 GHS에 의해 발암물질로 분류됨'),
(4, '스타이렌', '노출시 오심, 피로, 두통 등이 나타난다. 발암성 항목 구분 2(암을 일으킬 것으로 의심됨)에 해당되는 물질이다.'),
(5, '염화에틸', '노출시 두통, 시야흐림, 어지러움, 구토, 복통 등을 유발할 수 있다. 인간에 대한 장기적 연구는 없으나 최근 발암 가능성이 제기되고 있다.'),
(6, '클로로포름', '장기간 높은 농도의 클로로포름이 함유된 물을 마시거나 공기를 흡입하면 간과 신장이 손상될 수 있습니다. 다량의 클로로포름에 피부 접촉 시 따가움을 느낄 수 있다.'),
(7, '다이옥신', '국제암연구센터에서 1등급 발암물질로 지정한 물질이다.'),
(8, '글리포세이트', '제초제 성분으로 접촉에 의해 피부와 눈을 자극하며, 호흡에 의해 코와 목 점막을 자극하기도 한다. 간과 신장에 독성이 있는 것으로 알려져있다.'),
(9, '2,5-디니트로톨루엔', '호흡노출을 통한 연구에서 낮은 장기 독성을 보이는 것으로 나타남.'),
(10, '2-니트로-p-페닐렌다이아민', '섭취 또는 흡입시 위험하며, 피부에 자극이 나타날 수 있다. 비임상 연구에서 간과 피부에 독성 영향이 보고되어 있다.'),
(11, '2-브로모-2-나이트로프로판-1,3-디올', '패치 테스트에서 낮은 반응성 자극과 알레르기 반응을 보이는 환자가 있었다.'),
(12, '2-하이드록시-4-메톡시벤조페논', '스웨덴 연구기관에서 벤조페논-3이 들어있는 자외선 차단제가 어린이에게 부적합하다고 결정했다.'),
(13, '4-클로로-o-페닐렌다이아민', '비임상 연구 결과, 간암유발물지로 알려져있다. 가열하면 분해되어 유독가스가 발생된다.'),
(14, 'FD & C 옐로우 6번', '비임상 연구에서 생식 독성 영향과 위장관 장애 현상이 보고되었다. 가열시 분해되어 산화질소 및 산화황 유독가스를 발생시킨다'),
(15, 'HC 블루 1', '피부로 흡수될 수 있으며, 피부염과 안구염증이 발생할 수 있다. 각막, 결막 및 눈꺼풀, 안구 등에 손상을 유발하기도 한다. 비임상 연구에서 간 종양 발생이 증가하였다.'),
(16, 'P-페닐렌디아민', '섭취, 피하, 정맥 내 및 복강 내 투여 경로를 통해 중독된다. 피부에 자극적이다. 치명적인 간 손상을 일으킨다.');

-- --------------------------------------------------------

--
-- 테이블 구조 `ingredient`
--

CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `danger_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 테이블의 덤프 데이터 `ingredient`
--

INSERT INTO `ingredient` (`id`, `prod_id`, `danger_id`) VALUES
(1, 6, 1),
(2, 6, 2),
(3, 55, 1),
(4, 55, 3),
(5, 55, 7),
(6, 55, 2),
(7, 55, 5);

-- --------------------------------------------------------

--
-- 테이블 구조 `product`
--

CREATE TABLE `product` (
  `prod_id` int(11) NOT NULL,
  `brand` varchar(10) CHARACTER SET utf8 NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `corp` varchar(10) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 테이블의 덤프 데이터 `product`
--

INSERT INTO `product` (`prod_id`, `brand`, `name`, `corp`) VALUES
(1, '화이트', '시크릿홀 울트라', '유한킴벌리'),
(2, '화이트', '시크릿홀 라벤더', '유한킴벌리'),
(3, '화이트', '시크릿홀 슬림 날개형', '유한킴벌리'),
(4, '화이트', '시크릿홀 슬림 일반형', '유한킴벌리'),
(5, '화이트', '스타일핏 수퍼울트라', '유한킴벌리'),
(6, '화이트', '오버나이트 슬림', '유한킴벌리'),
(7, '화이트', '오버나이트 울트라 슬림', '유한킴벌리'),
(8, '화이트', '오버나이트 슬림 수퍼롱', '유한킴벌리'),
(17, '좋은느낌', '좋은느낌 매직쿠션 울트라 슬림 일반형', '유한킴벌리'),
(18, '좋은느낌', '좋은느낌 매직쿠션 울트라 슬림 날개형', '유한킴벌리'),
(19, '좋은느낌', '좋은느낌 매직쿠션 슬림 날개형', '유한킴벌리'),
(20, '좋은느낌', '좋은순면 울트라 슬림', '유한킴벌리'),
(21, '좋은느낌', '좋은느낌 슬림', '유한킴벌리'),
(22, '좋은느낌', '좋은순면 참숯 울트라 슬림', '유한킴벌리'),
(23, '좋은느낌', '오가닉 순면 커버 울트라', '유한킴벌리'),
(24, '좋은느낌', '오가닉 순면 커버 슬림', '유한킴벌리'),
(25, '좋은느낌', '한초랑 울트라', '유한킴벌리'),
(26, '좋은느낌', '한초랑 오가닉 순면 슬림', '유한킴벌리'),
(27, '좋은느낌', '코튼플라워 울트라 슬림', '유한킴벌리'),
(28, '좋은느낌', '좋은느낌 순수 울트라 날개', '유한킴벌리'),
(29, '좋은느낌', '스키니핏 하이퍼 울트라', '유한킴벌리'),
(30, '좋은느낌', '좋은느낌 울트라 날개', '유한킴벌리'),
(31, '좋은느낌', '좋은느낌 슬림 날개', '유한킴벌리'),
(32, '좋은느낌', '좋은순면 수퍼롱', '유한킴벌리'),
(33, '좋은느낌', '좋은느낌 수퍼롱', '유한킴벌리'),
(34, '좋은느낌', '좋은느낌 오버나이트', '유한킴벌리'),
(35, '좋은느낌', '한초랑 오버나이트', '유한킴벌리'),
(36, '좋은느낌', '좋은느낌 입는 오버나이트', '유한킴벌리'),
(44, '바디피트', '내몸에 순한면 안심숙면', '엘지 유니참'),
(45, '바디피트', '유기농 100% 순면커버', '엘지 유니참'),
(46, '바디피트', '유기농 100% 순면커버 안심숙면', '엘지 유니참'),
(47, '바디피트', '바디피트 볼록맞춤', '엘지 유니참'),
(48, '바디피트', '바디피트 볼록맞춤 안심숙면', '엘지 유니참'),
(49, '바디피트', '바디피트 볼록맞춤 라벤더', '엘지 유니참'),
(50, '바디피트', '바디피트 순간흡수', '엘지 유니참'),
(51, '바디피트', '바디피트 순간흡수 안심숙면', '엘지 유니참'),
(52, '귀애랑', '귀애랑 안심숙면', '엘지 유니참'),
(53, '귀애랑', '귀애랑 천연홍삼', '엘지 유니참'),
(54, '릴리안', '릴리안 초흡수', '깨끗한 나라'),
(55, '보솜이', '천연코튼', '보솜이');

-- --------------------------------------------------------

--
-- 테이블 구조 `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `author` varchar(20) CHARACTER SET utf8 NOT NULL,
  `score` int(11) NOT NULL,
  `content` varchar(300) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 테이블의 덤프 데이터 `review`
--

INSERT INTO `review` (`id`, `prod_id`, `author`, `score`, `content`) VALUES
(1, 6, 'shcho', 4, '좋아요'),
(2, 6, 'abc', 3, 'no good'),
(3, 55, 'bosom', 2, '안 좋음'),
(4, 55, 'mosob', 1, '그저 그렇다'),
(5, 55, 'apple', 2, '그냥 다른거 살게요'),
(6, 6, 'cho', 3, 'data send!!\n'),
(7, 6, 'cho', 3, 'data send\n'),
(8, 6, 'cho', 3, 'data send'),
(9, 6, 'cho', 3, '하하흐'),
(10, 6, 'cho', 3, '터턴나'),
(11, 17, 'bob', 5, '배송이 빨라요');

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `danger`
--
ALTER TABLE `danger`
  ADD PRIMARY KEY (`danger_id`);

--
-- 테이블의 인덱스 `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- 테이블의 인덱스 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`prod_id`);

--
-- 테이블의 인덱스 `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `danger`
--
ALTER TABLE `danger`
  MODIFY `danger_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- 테이블의 AUTO_INCREMENT `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 테이블의 AUTO_INCREMENT `product`
--
ALTER TABLE `product`
  MODIFY `prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- 테이블의 AUTO_INCREMENT `review`
--
ALTER TABLE `review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
