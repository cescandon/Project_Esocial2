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
 <link rel="stylesheet" href="css/tasks">

</head>



<body>

<nav class="navbar">
  <a href="javascript:void(0)" id="brand-logo">ESocial</a>
  <a href="javascript:void(0)" id="menu">menu</a>
  <div class="nav-options">
    <a href="javascript:void(0)" onclick="OpenClose();">My Tasks</a>
    <a href="javascript:void(0)" onclick="OpenClose();">Messages</a>
    <a href="javascript:void(0)" onclick="Rotate();">Login</a>
  </div>

</nav>

<div class="wrapper">
  <div class="log-card">
    <div class="log-front">
      <div class="log-front-content">
            <a>Are you ready?</a>
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
        <input type="password" name="pwd" placeholder="Password">
        <input type="submit" name="login" value="Login">
      </form>
    </div>
    <div class="log-back">

      <!-- <div class="log-back-content">
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
        <span>Github</span>
        <div class="sm">
          <a href="#"><i class="fab fa-facebook-f"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-youtube"></i></a>
          <a href="#"><i class="fab fa-instagram"></i></a>
        </div>
      </div> -->
    </div>
  </div>
</div>



  <div class="task-list">
      <div class="list-area">
        <label class="task">
          <input type="checkbox" >
          <i class="fas fa-check"></i>
          <span class="text">Have Breakfast</span>
        </label>

        <label class="task">
          <input type="checkbox" >
          <i class="fas fa-check"></i>
          <span class="text">Go to school and do some homework and do other things</span>
        </label>

        <label class="task" >
          <input type="checkbox" >
          <i class="fas fa-check"></i>
          <span class="text">Read a book</span>
        </label>

        <label class="task">
          <input type="checkbox" >
          <i class="fas fa-check"></i>
          <span class="text">Play games</span>
        </label>
     </div>
  </div>



  <!-- <div class="loading-screen">

  </div> -->







</body>

<script type="text/javascript">
  let t = document.querySelector(".list-area");
  let openTasks = false;
  let openOrders = false;
  function OpenClose(){
    t.style.marginLeft= openTasks? "-350px" : "0";
    openTasks = !openTasks;
  }

  function Rotate(){
    let f = document.querySelector(".log-front");
    f.classList.toggle("log-drop");

  }

</script>

</html>
