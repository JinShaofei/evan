<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="container">
		<div id="demo_top_wrapper">
			<div id="sticky_navigation_wrapper">
				<div id="sticky_navigation">
					<div class="demo_container navigation-bar">
						<div class="navigation">
							<div class="logo">
								<a href="index.htm">COLA</a>
							</div>
							<span class="menu"></span>
							<script>
								$("span.menu").click(function() {
									$(".navig").slideToggle("slow", function() {
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
								<c:if test="${u eq null }">
									<li><span></span><a href="toLogin.htm">登录</a></li>
									<li><span class="bascket"></span><a href="toRegister.htm">注册</a></li>
								</c:if>
								<c:if test="${u ne null }">
									<li><span></span>你好：${u.userName}</li>
									<li><span></span><a href="toLoginOut.htm">退出</a></li>
								</c:if>
								<li>
									<button class="search"></button>
								</li>
							</ul>
						</div>
						<div class="clearfix"></div>
						<div class="serch">
							<span> <input type="text" placeholder="Search" required="">
								<input type="submit" value="" />
							</span>
						</div>
						<script>
							$("button.search").click(function() {
								$(".serch").slideToggle("slow", function() {
									// Animation complete.
								});
							});
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>