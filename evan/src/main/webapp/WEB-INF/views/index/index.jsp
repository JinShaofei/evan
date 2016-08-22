<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎来到萌宠之家</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Google Fonts -->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/sticky-navigation.css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<script>
$(function() {

	// grab the initial top offset of the navigation 
	var sticky_navigation_offset_top = $('#sticky_navigation').offset().top;
	
	// our function that decides weather the navigation bar should have "fixed" css position or not.
	var sticky_navigation = function(){
		var scroll_top = $(window).scrollTop(); // our current vertical position from the top
		
		// if we've scrolled more than the navigation, change its position to fixed to stick to top, otherwise change it back to relative
		if (scroll_top > sticky_navigation_offset_top) { 
			$('#sticky_navigation').css({ 'position': 'fixed', 'top':0, 'left':0 });
		} else {
			$('#sticky_navigation').css({ 'position': 'relative' }); 
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
	$('a[href="#"]').click(function(event){ 
		event.preventDefault(); 
	});
	
});
</script>
</head>
<body>
	<!-- Header Part Starts Here -->
<div class="header">
	<div class="container">
	<div id="demo_top_wrapper">
	<div id="sticky_navigation_wrapper">
		<div id="sticky_navigation">
			<div class="demo_container navigation-bar">
				<div class="navigation">
					<div class="logo"><a href="index.htm">COLA</a></div>
					<span class="menu"></span>
					<script>
						$( "span.menu" ).click(function() {
						  $( ".navig" ).slideToggle( "slow", function() {
						    // Animation complete.
						  });
						});
					</script>
					<div class="navig">
						<ul>
							<li><a href="toDog.htm">小狗</a></li>
							<li><a href="toCat.htm">小猫</a></li>
							<li><a href="toOthers.htm">其他</a></li>
							<!-- <li><a href="#"></a></li> -->
							<li><a href="about.htm">关于我们</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="navigation-right">
					<ul class="user">
						<li>
							<span></span><a href="toLogin.htm">登录</a>
						</li>
						<li>
							<span class="bascket"></span><a href="bascket.html">购物车(0)</a>
						</li>
						<li>
							<button class="search"></button>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="serch">
								<span>
									<input type="text" placeholder="Search" required="">
									<input type="submit" value="" />
								</span>
				</div>
				<script>
					$( "button.search" ).click(function() {
					  $( ".serch" ).slideToggle( "slow", function() {
					    // Animation complete.
					  });
					});
				</script>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<div class="container">
<section id="main">
	<div class="content">
		<!-- Banner Starts Here 放一张比较温馨的宠物和人一起玩的照片 --->
		<div class="banner">
			<h1>Hazy Shade of spring</h1>
			<small>Quisque lorem tortor fringilla sed, vestibulum id, eleifend justo.</small>
			<div class="ban-btn">
				<a href="#">check new arrivals</a>
			</div>
		</div>
		<!-- Banner Ends Here --->
		<!-- Gallery Starts Here --->
		<div class="gallery">
			<div class="gallery-row">
				<div class="gallery-grid">
					<div class="grid-top img-pos"><img src="images/p1.jpg" alt="" class="img-responsive">
						<div class="img-caption">
							<p>HEATHER <br>GREY BASICS</p>
							<small>New Arrival</small>
						</div>
					</div>
					<div class="grid-bot img-pos"><img src="images/p2.jpg" alt="" class="img-responsive"><div class="img-caption"></div></div>
				</div>
                <div class="copyrights">Collect from  <a href="http://www.mycodes.net/" target="_blank">&#28304;&#30721;&#20043;&#23478;</a></div>
				<div class="gallery-grid1">
					<div class="grid1-row1">
						<div class="g1-r2">
							<div class="twit t-wit">
								<span class="line"></span>
								<i class="twit-icon"></i>
								<span class="line"></span>
								<p>Opening Ceremony @IndonesiaFW tomorrow, PMers! Are you ready for the biggest fashion movement in</p>
								<small>@PuspitaMarthaID </small>
							</div>
							<div class="twit img-pos"><img src="images/p3.jpg" alt="" class="img-responsive"><div class="img-caption"></div></div>
							<div class="clearfix"></div>
						</div>
						<div class="g1-r2">
							<div class="twit img-pos"><img src="images/p4.jpg" alt="" class="img-responsive">
								<div class="img-caption jk-t">
									<p>chuck taylors</p>
									<small>$125.00</small>
								</div>
							</div>
							<div class="twit t-wit">
								<span class="line"></span>
								<i class="twit-icon"></i>
								<span class="line"></span>
								<p>Girls, Girls, Girls: A Look Back at 50 Years of the Pirelli Calendar</p>
								<small>@Vogue</small>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="grid1-row2">
						<div class="twit t-hat">
							<i class="aarow"></i>
							<p>Jaxon Hat</p>
							<small>Beanie Hat</small>
						</div>
						<div class="twit img-pos"><img src="images/p5.jpg" alt="" class="img-responsive">
							<div class="img-caption jk-t">
									<p>basic blazer</p>
									<small>from $199.00</small>
								</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="gallery-grid">
					<div class="grid-bot t-hat">
						<i class="aarow"></i>
						<p>elegant shoes</p>
						<small>BRAIDED LEATHER</small>
					</div>
					<div class="grid-top img-pos"><img src="images/p6.jpg" alt="" class="img-responsive respon">
						<div class="img-caption">
							<p>jeans for<br>ADVENTURE</p>
							<small>New Arrival</small>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- Gallery Ends Here --->
		<!--- Subscribe Bar Starts here -->
		<div class="subscribe">
			<h3>sign up to receive our updates</h3>
			<p>Nulla ipsum dolor lacus, suscipit adipiscing. Cum sociis natoque penatibus et ultrices volutpat.</p>
			<div class="sub-bar">
				<span>
					<input type="text"  placeholder="Your e-mail" required="" />
					<input type="submit" value="add" />
				</span>
			</div>
		</div>
		<!--- Subscribe Bar Ends here -->
		<!-- Partners Starts Here --->
		<div class="partner">
				<ul id="flexiselDemo3">
				   <li><img src="images/ss1.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss2.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss3.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss4.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="images/ss5.png" class="img-responsive" alt=""/></li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo3").flexisel({
							visibleItems: 5,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
					    	responsiveBreakpoints: { 
					    		portrait: { 
					    			changePoint:480,
					    			visibleItems: 1
					    		}, 
					    		landscape: { 
					    			changePoint:640,
					    			visibleItems: 2
					    		},
					    		tablet: { 
					    			changePoint:768,
					    			visibleItems: 3
					    		}
					    	}
					    });
					    
					});
			 </script>
	         <script type="text/javascript" src="js/jquery.flexisel.js"></script>
		</div>
		<!-- Partners Ends Here --->
		<!-- Footer Menu Starts here --->
		<div class="footer">
			<div class="row footer-row">
				<div class="col-md-3 footer-col">
					<h3 class="ft-title">宠物部落</h3>
					<ul class="ft-list">
						<li><a href="#">小狗</a></li>
						<li><a href="#">小猫</a></li>
						<li><a href="#">其他</a></li>
						<li><a href="#">敬请期待</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-col">
					<h3 class="ft-title">帮助中心</h3>
					<ul class="ft-list  list-h">
						<li><a href="#">账户管理</a></li>
						<li><a href="#">注册指南 </a></li>
						<li><a href="#">宠物乐园</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-col">
					<h3 class="ft-title">关于我们</h3>
					<ul class="ft-list list-h">
						<li><a href="#">了解我们</a></li>
						<li><a href="#">加入我们</a></li>
						<li><a href="#">联系我们</a></li>
					</ul>
				</div>
				<div class="col-md-3 foot-cl">
					<h3 class="ft-title">关注我们</h3>
					<ul class="ft-list list-h">
						<li><a href="#">新浪微博</a></li>
						<li><a href="#">宠物部落</a></li>
						<li><a href="#">官方微信</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- Footer Menu Ends here --->
	</div>
</section>
</div>
	<!-- Header Part Starts Here -->
</body>
</html>