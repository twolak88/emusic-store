<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/jsp/template/header.jsp"%>
<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
	<div class="carousel-indicators">
		<button type="button" data-bs-target="#myCarousel"
			data-bs-slide-to="0" class="active" aria-current="true"
			aria-label="Slide 1"></button>
		<button type="button" data-bs-target="#myCarousel"
			data-bs-slide-to="1" aria-label="Slide 2"></button>
		<button type="button" data-bs-target="#myCarousel"
			data-bs-slide-to="2" aria-label="Slide 3"></button>
	</div>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img class="bd-placeholder-img home-image" src="<c:url value="/resources/images/back01.jpg" />" alt="First Slide" />
			<div class="container">
				<div class="carousel-caption text-start">
					<h1>Welcome to my eMusic Store.</h1>
					<p>Here you find many awesome instruments.</p>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="bd-placeholder-img home-image" src="<c:url value="/resources/images/back02.jpg" />" alt="Second Slide" />
			<div class="container">
				<div class="carousel-caption">
					<h1>Best prices</h1>
					<p>Awesome cheap instruments and accessories.</p>
				</div>
			</div>
		</div>
		<div class="carousel-item">
			<img class="bd-placeholder-img home-image" src="<c:url value="/resources/images/back03.jpg" />" alt="Third Slide" />
			<div class="container">
				<div class="carousel-caption text-end">
					<h1>Outlet</h1>
					<p>Used instruments in good prices.</p>
				</div>
			</div>
		</div>
	</div>
	<button class="carousel-control-prev" type="button"
		data-bs-target="#myCarousel" data-bs-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Previous</span>
	</button>
	<button class="carousel-control-next" type="button"
		data-bs-target="#myCarousel" data-bs-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Next</span>
	</button>
</div>

<div class="container marketing">
	<div class="row">
		<div class="col-lg-4">
			<a class="btn btn-default" href="<c:url value="/products?searchCondition=instrument" />">
				<img class="bd-placeholder-img rounded-circle"
					 width="140" height="140"
					 alt="Instrument Image"
					 src="<c:url value="/resources/images/instrument.png" />"/>
			</a>
			<h2>Instrument</h2>
			<p>Well crafted and delicate instruments.</p>
		</div>
		<div class="col-lg-4">
			<a class="btn btn-default" href="<c:url value="/products?searchCondition=record" />">
				<img class="bd-placeholder-img rounded-circle"
					 width="140" height="140"
					 alt="Record Image"
					 src="<c:url value="/resources/images/record.png" />"/>
			</a>
			<h2>Discography</h2>
			<p>An exceptional collection of music records.</p>
		</div>
		<div class="col-lg-4">
			<a class="btn btn-default" href="<c:url value="/products?searchCondition=accessory" />">
				<img class="bd-placeholder-img rounded-circle"
					 width="140" height="140"
					 alt="Accessories Image"
					 src="<c:url value="/resources/images/accessory.jpg" />"/>
			</a>
			<h2>Accessories</h2>
			<p>Music accessories.</p>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->
<%@include file="/WEB-INF/views/jsp/template/footer.jsp"%>