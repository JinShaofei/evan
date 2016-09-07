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
					<li class="act">&nbsp;关于我们</li>
				</ul>
			</div>
			<div class="coats">
				<h3 class="c-head">About</h3>
				<p>Lorem ipsum dolor sit amet enim. Etiam ullamcorp uspendisse a
					pellentesque.</p>
			</div>
			<div class="row about-row">
				<div class="col-md-6 about-col">
					<img src="images/about1.jpg" alt="" class="img-responsive">
					<div class="who">
						<h3>Who we are?</h3>
						<p>Lorem ipsum dolor sit amet enim. Etiam ullamcorper.
							Suspendisse a pellentesque dui, non felis. Maecenas malesuada
							elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut
							molestie a, ultricies porta urna. Vestibulum commodo volutpat a,
							convallis ac, laoreet enim.</p>
						<p>Phasellus fermentum in, dolor. Pellentesque facilisis.
							Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec
							malesuada fames ac turpis velit, rhoncus eu, luctus et interdum
							adipiscing wisi. Aliquam erat ac ipsum. Integer aliquam purus.
							Quisque lorem tortor fringilla sed, vestibulum id,</p>
					</div>
				</div>
				<div class="col-md-6 about-col">
					<img src="images/about2.jpg" alt="" class="img-responsive">
					<div class="who">
						<h3>What we are doing?</h3>
						<p>Lorem ipsum dolor sit amet enim. Etiam ullamcorper.
							Suspendisse a pellentesque dui, non felis. Maecenas malesuada
							elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut
							molestie a, ultricies porta urna. Vestibulum commodo volutpat a,
							convallis ac, laoreet enim.</p>
						<p>Phasellus fermentum in, dolor. Pellentesque facilisis.
							Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec
							malesuada fames ac turpis velit, rhoncus eu, luctus et interdum
							adipiscing wisi. Aliquam erat ac ipsum. Integer aliquam purus.
							Quisque lorem tortor fringilla sed, vestibulum id,</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="sap_tabs">
				<div id="horizontalTab"
					style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>About
								Product</span></li>
						<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>Product
								sales</span></li>
						<li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>Reviews</span></li>
						<div class="clear"></div>
					</ul>
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="facts">
								<ul class="tab_list">
									<li><a href="#">Lorem ipsum dolor sit amet,
											consectetuer adipiscing elit, sed diam nonummy nibh euismod
											tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut
											wisi enim ad minim veniam, quis nostrud exerci tation
											ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
											consequat</a></li>
									<li><a href="#">augue duis dolore te feugait nulla
											facilisi. Nam liber tempor cum soluta nobis eleifend option
											congue nihil imperdiet doming id quod mazim placerat facer
											possim assum. Typi non habent claritatem insitam; est usus
											legentis in iis qui facit eorum claritatem. Investigatione</a></li>
									<li><a href="#">claritatem insitam; est usus legentis
											in iis qui facit eorum claritatem. Investigationes
											demonstraverunt lectores legere me lius quod ii legunt
											saepius. Claritas est etiam processus dynamicus, qui sequitur
											mutationem consuetudium lectorum. Mirum est notare quam
											littera gothica</a></li>
									<li><a href="#">Mirum est notare quam littera gothica,
											quam nunc putamus parum claram, anteposuerit litterarum
											formas humanitatis per seacula quarta decima et quinta
											decima. Eodem modo typi, qui nunc nobis videntur parum clari,
											fiant sollemnes in futurum.</a></li>
								</ul>
							</div>
						</div>
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
							<div class="facts">
								<ul class="tab_list">
									<li><a href="#">augue duis dolore te feugait nulla
											facilisi. Nam liber tempor cum soluta nobis eleifend option
											congue nihil imperdiet doming id quod mazim placerat facer
											possim assum. Typi non habent claritatem insitam; est usus
											legentis in iis qui facit eorum claritatem. Investigatione</a></li>
									<li><a href="#">claritatem insitam; est usus legentis
											in iis qui facit eorum claritatem. Investigationes
											demonstraverunt lectores legere me lius quod ii legunt
											saepius. Claritas est etiam processus dynamicus, qui sequitur
											mutationem consuetudium lectorum. Mirum est notare quam
											littera gothica</a></li>
									<li><a href="#">Mirum est notare quam littera gothica,
											quam nunc putamus parum claram, anteposuerit litterarum
											formas humanitatis per seacula quarta decima et quinta
											decima. Eodem modo typi, qui nunc nobis videntur parum clari,
											fiant sollemnes in futurum.</a></li>
								</ul>
							</div>
						</div>
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
							<ul class="tab_list">
								<li><a href="#">Lorem ipsum dolor sit amet,
										consectetuer adipiscing elit, sed diam nonummy nibh euismod
										tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut
										wisi enim ad minim veniam, quis nostrud exerci tation
										ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
										consequat</a></li>
								<li><a href="#">augue duis dolore te feugait nulla
										facilisi. Nam liber tempor cum soluta nobis eleifend option
										congue nihil imperdiet doming id quod mazim placerat facer
										possim assum. Typi non habent claritatem insitam; est usus
										legentis in iis qui facit eorum claritatem. Investigatione</a></li>
								<li><a href="#">claritatem insitam; est usus legentis
										in iis qui facit eorum claritatem. Investigationes
										demonstraverunt lectores leg</a></li>
								<li><a href="#">Mirum est notare quam littera gothica,
										quam nunc putamus parum claram, anteposuerit litterarum formas
										humanitatis per seacula quarta decima et quinta decima. Eodem
										modo typi, qui nunc nobis videntur parum clari, fiant
										sollemnes in futurum.</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#horizontalTab').easyResponsiveTabs({
						type : 'default', //Types: default, vertical, accordion           
						width : 'auto', //auto or any width like 600px
						fit : true
					// 100% fit in a container
					});
				});
			</script>
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
			<c:import url="../common/footer.jsp"></c:import>
			<!-- Footer Menu Ends here --->
		</div>
		</section>
	</div>
</body>
</html>