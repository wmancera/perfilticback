<%@page import="java.util.ArrayList"%>
<%@page import="com.pruebatic.pruebatic.objects.Article"%>
<%@page import="com.testptic.testptic.controller.BookController"%>
<%@page import="com.pruebatic.pruebatic.objects.Book"%>
<%
        HttpSession sesion = request.getSession(true);
        ArrayList<Article> articles = sesion.getAttribute("cart") == null ? null : (ArrayList) sesion.getAttribute("cart");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>iBook Shop</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="shop.jsp"><img src="images/home/logo.png" alt="" /></a>
						</div>
						
					</div>
					
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">

						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li class="dropdown"><a href="#" class="active">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="shop.jsp" class="active">Products</a></li>
					<li><a href="cart.jsp">Cart</a></li> 
                                    </ul>
                                </li> 

                                </li> 
						</div>
					</div>
				</div>
				</div>
			</div>
	</header><!--/header-->

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            
                                                <%
                                                    BookController bc = new BookController();
                                                    double total = 0;
                                                    if(articles != null){
                                                    for(Article a: articles){
                                                        Book book = bc.getBook(a.getIdArticle());
                                                        total += a.getCantidad() * book.getCost();
                                                        
                                                                                                            
                                                %>
                                            
						<tr>
							<td class="cart_product">
								<a href=""><img src="<%= book.getImage()%>" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%= book.getDescription()%></a></h4>
								<p>ID: <%= book.getId()%></p>
							</td>
							<td class="cart_price">
								<p>$<%= book.getCost()%></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="<%= a.getCantidad()%>" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$<%= Math.round(book.getCost()*a.getCantidad()*100.0) / 100.0%></p>
							</td>
							<td class="cart_delete">
                                                                <span id="idbook" style="display:none;"><%= book.getId()%></span>
								<a class="cart_quantity_delete" href="" id="deleteitem"><i class="fa fa-times"></i></a>
							</td>
						</tr>
<%}}%>
						
					</tbody>
				</table>
                                <% if (articles == null){%>
                                <h4>No hay Articulos en el carro de compras</h4>
                                <%}%>
			</div>
                            <a href="javascript:window.history.go(-2);">Continuar Comprando</a>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="row">

				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span>$<%= Math.round(total*100.0)/100.0%></span></li>
							<li>Total <span>$<%= Math.round(total*100.0)/100.0%></span></li>
						</ul>
                                                <form action="SaveOrder" method="post">
                                                        <button type="submit" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										Save Order
							</button>
                                                        </form>
							
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

	<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
    <script src="js/cart.js"></script>
</body>
</html>