<%@ page language="java" contentType="text/css; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
/* LOGFORM */


.log-form h1{
  color: white;
  text-transform: uppercase;
  font-weight: 500;

  font-family: 'Covered By Your Grace', cursive;
  font-size: 3em;
}


.log-form input{
  color: white;
  font-family: 'Oswald', sans-serif;
  font-size: 1rem;
  z-index: 2;
}

.log-form input[type = "text"],
.log-form input[type = "password"]
{
  border:0;  
  background: none;
  display: block;
  
  margin: 20px; auto;
  text-align: center;
  border: 2px solid #3498db;
  padding: 5px 10px;
  width: 200px;
  outline: none;
  border-radius: 20px;
  transition: 0.25s;
}

.log-form textarea[readonly = "readonly"]{
  border:0;

  
  font-family: 'Oswald', sans-serif;
  background: #0008;
  display: block;
  margin: 20px 7px;

  border: 2px solid #3498db;
  padding: 5px 10px;
  width: 300px;
  outline: none;
  border-radius: 20px;
  resize: none;
  color: white;
}

.log-form input[type = "text"]:focus,
.log-form input[type = "password"]:focus,
.log-form input[type = "button"]:focus
{
  width: 250px;
  border-color: #2ecc71;
}


.log-form input[type = "submit"]
{
  border:0;
  background: none;

  margin: 15px auto;
  text-align: center;
  border: 2px solid #00b894;
  padding: 8px 20px;
  width: 125px;
  outline: none;

  font-size: 1.2em;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}

.log-form input[type = "button"]{
  border:0;
  background: none;

  margin: 5px auto;
  text-align: center;
  border: 2px solid #00b894;
  padding: 8px 20px;
  width: 125px;
  outline: none;

  font-size: 1.2em;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}


.log-form input[type = "submit"]:hover,
.log-form input[type = "button"]:hover
{
  background: #00b894;
}

.loading-screen{
  width: 100%;
  height: 100vh;
  background: #6a89cc;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 9999;
  display: flex;
  align-items: center;
}

.loading-screen::before{
  content: "";
  position: absolute;
  left: 20%;
  transform: translateX(-50%) rotate(0);
 

  width: 80px;
  height: 80px;
  background: #f8c291;
  border-radius: 20px;
  animation: loading 4s infinite linear;
}

@keyframes loading {
  from{
    transform: translate(-50%) rotate(0deg);
  }

  50%{
    left: 80%;
  }

  to{
    transform: translate(-50%) rotate(1400deg);
  }
}



/* ROTATION */


.rotating-border{
  box-shadow: 0 20px 50px rgba(0,0,0,.5);
  overflow: hidden;
}

.rotating-border::before{
  content: "";
  position: absolute;
  z-index: -1;
  top: 2px;
  left: 2px;
  bottom: 2px;
  width: 50%;
  background: rgba(255,255,255,0.08);
}

.rotating-border span:nth-child(1){
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 3px;
  background: linear-gradient(to right, #0c002b, #1779ff);
  animation: animate1 2s linear infinite;
}

@keyframes animate1 {
  0%{
    transform: translateX(-100%);
  }
  100%{
    transform: translateX(100%);
  }
}

.rotating-border span:nth-child(2){
  position: absolute;
  top: 0;
  right: 0;
  width: 3px;
  height: 100%;
  background: linear-gradient(to bottom, #0c002b, #1779ff);
  animation: animate2 2s linear infinite;
  animation-delay: 1s;
}

@keyframes animate2 {
  0%{
    transform: translateY(-100%);
  }
  100%{
    transform: translateY(100%);
  }
}

.rotating-border span:nth-child(3){
  position: absolute;
  bottom: 0;
  right: 0;
  width: 100%;
  height: 3px;
  background: linear-gradient(to left, #0c002b, #1779ff);
  animation: animate3 2s linear infinite;
}

@keyframes animate3 {
  0%{
    transform: translateX(100%);
  }
  100%{
    transform: translateX(-100%);
  }
}

.rotating-border span:nth-child(4){
  position: absolute;
  top: 0;
  left: 0;
  width: 3px;
  height: 100%;
  background: linear-gradient(to top, #0c002b, #1779ff);
  animation: animate4 2s linear infinite;
  animation-delay: 1s;
}

@keyframes animate4 {
  0%{
    transform: translateY(100%);
  }
  100%{
    transform: translateY(-100%);
  }
}
