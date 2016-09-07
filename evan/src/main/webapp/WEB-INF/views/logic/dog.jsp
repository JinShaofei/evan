<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎来到萌宠之家</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css'
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Google Fonts -->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/sticky-navigation.css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<script>
	$(function() {

		// grab the initial top offset of the navigation 
		var sticky_navigation_offset_top = $('#sticky_navigation').offset().top;

		// our function that decides weather the navigation bar should have "fixed" css position or not.
		var sticky_navigation = function() {
			var scroll_top = $(window).scrollTop(); // our current vertical position from the top

			// if we've scrolled more than the navigation, change its position to fixed to stick to top, otherwise change it back to relative
			if (scroll_top > sticky_navigation_offset_top) {
				$('#sticky_navigation').css({
					'position' : 'fixed',
					'top' : 0,
					'left' : 0
				});
			} else {
				$('#sticky_navigation').css({
					'position' : 'relative'
				});
			}
		};

		// run our function on load
		sticky_navigation();

		// and run it again every time you scroll
		$(window).scroll(function() {
			sticky_navigation();
		});

		// NOT required:
		// for this demo disable all links that point to "#"
		$('a[href="#"]').click(function(event) {
			event.preventDefault();
		});

	});
</script>
</head>
<body>
	<!-- Header Part Starts Here -->
	<c:import url="../common/header.jsp"></c:import>
	<div class="container">
		<section id="main">
		<div class="content">
			<div class="pag-nav">
				<ul class="p-list">
					<li><a href="index.htm">首页</a></li> &nbsp;&nbsp;/&nbsp;
					<li class="act">&nbsp;小狗</li>
				</ul>
			</div>
			<div class="coats">
				<h3 class="c-head">Dogs</h3>
				<small><a href="#">查看更多</a></small>
				<div class="coat-row">
					<div class="coat-column">
						<a href="single.html"> <img src="images/men1.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div>
						</a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column">
						<a href="single.html"><img src="images/men2.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column">
						<a href="single.html"><img src="images/men3.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column1">
						<a href="single.html"><img src="images/men4.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="coats">
				<h3 class="c-head">Outerwear</h3>
				<small><a href="#">Show More</a></small>
				<div class="coat-row">
					<div class="coat-column">
						<a href="single.html"> <img src="images/men5.png"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div>
						</a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column">
						<a href="single.html"><img src="images/men6.png"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column">
						<a href="single.html"><img src="images/men5.png"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column1">
						<a href="single.html"><img src="images/men6.png"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="coats">
				<h3 class="c-head">T-shirts</h3>
				<small><a href="single.html">Show More</a></small>
				<div class="coat-row">
					<div class="coat-column">
						<a href="single.html"> <img src="images/p16.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div>
						</a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column">
						<a href="single.html"><img src="images/p17.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column">
						<a href="single.html"><img src="images/p18.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="coat-column1">
						<a href="single.html"><img src="images/p19.jpg"
							class="img-responsive" alt="">
							<div class="prod-desc">
								<h4>Double-Layered Top</h4>
								<small>&euro; 89,95</small>
							</div> </a>
						<div class="mask">
							<div class="info">
								<a href="single.html">View</a>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="look">
				<h3>Check our lookbook</h3>
			</div>
			<!-- Partners Starts Here --->
			<div class="partner">
				<ul id="flexiselDemo3">
					<li><img src="images/ss1.jpg" class="img-responsive" alt="" /></li>
					<li><img src="images/ss2.jpg" class="img-responsive" alt="" /></li>
					<li><img src="images/ss3.jpg" class="img-responsive" alt="" /></li>
					<li><img src="images/ss4.jpg" class="img-responsive" alt="" /></li>
					<li><img src="images/ss5.png" class="img-responsive" alt="" /></li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo3").flexisel({
							visibleItems : 5,
							animationSpeed : 1000,
							autoPlay : true,
							autoPlaySpeed : 3000,
							pauseOnHover : true,
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 1
								},
								landscape : {
									changePoint : 640,
									visibleItems : 2
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
								}
							}
						});

					});
				</script>
				<script type="text/javascript" src="js/jquery.flexisel.js"></script>
			</div>
			<!-- Partners Ends Here --->
			<!-- Footer Menu Starts here --->
			<c:import url="../common/footer.jsp">
			</c:import>
			<!-- Footer Menu Ends here --->
		</div>
		</section>
	</div>
</body>
</html>