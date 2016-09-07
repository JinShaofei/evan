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
					<li class="act">&nbsp;注册</li>
				</ul>
			</div>
			<div class="coats">
				<h3 class="c-head">欢迎注册</h3>
				<p>Lorem ipsum dolor sit amet enim. Etiam ullamcorp uspendisse a
					pellentesque.</p>
			</div>
			<div class="register">
				<form action="register.htm" method="post">
					<div class="register-top-grid">
						<h3>PERSONAL INFORMATION</h3>
						<div>
							<span>宠物昵称<label>*</label></span> <input type="text"
								name="userName">
						</div>
						<div>
							<span>手机号<label>*</label></span> <input type="text"
								name="userMobile">
						</div>
						<div class="clearfix"></div>
						<a class="news-letter" href="#"> </a>
					</div>
					<div class="register-bottom-grid">
						<h3>LOGIN INFORMATION</h3>
						<div>
							<span>密码<label>*</label></span> <input type="password"
								name="userPass1">
						</div>
						<div>
							<span>确认密码<label>*</label></span> <input type="password"
								name="userPass2">
						</div>
					</div>
					<div class="register-but">
						<input type="submit" value="注册">
					</div>
				</form>

			</div>
			<div class="look">
				<h3>You May Also Like</h3>
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