<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
 <link href="https://fonts.googleapis.com/css?family=Covered+By+Your+Grace|Gloria+Hallelujah|Indie+Flower|Oswald|Permanent+Marker|Rock+Salt|Shadows+Into+Light|Sniglet" rel="stylesheet">
 <link rel="stylesheet" href="css/main">
 <link rel="stylesheet" href="css/cards">
 <link rel="stylesheet" href="css/forms">


</head>



<body>

<nav class="navbar">
  <a href="javascript:void(0)" id="brand-logo">ESocial</a>
  <a href="javascript:void(0)" id="menu">menu</a>
  <div class="nav-options">
    <a href="javascript:void(0)" onclick="Rotate();">Login</a>
    <a href="javascript:void(0)" onclick="ShowJoin();">Signup</a>
  </div>
	<a>${nameLocation}</a>a>
</nav>


${pageContext.request.servletPath}
<div class="wrapper">
  <div class="log-card">
    <div class="log-front">
      <div class="log-front-content">
            <a>Are you ready?</a>
            ${errorLocation}
            
      </div>
    </div>
    <div class="log-form rotating-border">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <form action="mlogin" class="log-front-content" method="post">
        <h1>Login</h1>
        <input type="text" name="name" placeholder="Username">
        <input type="password" name="password" placeholder="Password">
        <input type="submit" name="login" value="Login">
      </form>
    </div>
    <div class="log-back">
      <div class="log-back-content">
        <h1>
          <span>J</span>
          <span>O</span>
          <span>I</span>
          <span>N</span>
          <br>
          <span>N</span>
          <span>O</span>
          <span>W</span>
        </h1>
      <div class="log-form">
        <form action="mlogin" class="log-front-content" method="post">
          <input type="text" name="name" placeholder="Username">
          <input type="password" name="password" placeholder="Password">
          <input type="submit" name="register" value="Register">
      </form>
    </div>
        <div class="sm">
          <a href="#"><i class="fab fa-facebook-f"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-youtube"></i></a>
          <a href="#"><i class="fab fa-instagram"></i></a>
        </div>
      </div>
    </div>
  </div>
</div>

  
 
</body>

<script src="task_js"></script>
</html>
