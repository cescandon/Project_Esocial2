<%@ page language="java" contentType="text/css; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
/*LOGCARD*/


.wrapper{
  margin-top: 50px;
  width: 100vw;
  height: 600px;
  overflow: hidden !important;
  background: #34495e;
  position: relative;
  display: flex;
}

.log-card{
  cursor: pointer;
  position: absolute;
  width: 340px;
  height: 480px;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
}

/* .log-front,
.log-back */
.log-card > div{
  display: flex;
  width: 100%;
  height: 100%;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background-color: #222;
  backface-visibility: hidden;
  position: absolute;
}

.log-front{
  background-image: url('../images/fadebackh.jpg');
  background-size: cover;
  z-index: 1;
}
.log-back{
  background-image: url("../images/darkhands.jpg");
  background-position: bottom;
  z-index: -1;
}

.log-chat{
   text-align: center;
}

.log-front-content{
   margin:auto;
   text-align: center;
}


.log-front-content a{
  font-size: 2em;
  color: #0984e3;;
  border: 7px solid #0984e3;
  background-color: #fffd;
  margin: auto;
  padding: 2px 10px;
  font-family: 'Permanent Marker', cursive;
  letter-spacing: .1em;
  z-index: 1;
}

.log-drop{
  animation: dropcard 4s linear forwards;
}

.log-flipover{
  animation: flipover .7s linear forwards;
}

@keyframes dropcard{
  0%{
    opacity: 1;
    filter: blur(0px);
    left: 50%;
  }

  10%{
    left: 80%;
    transform: rotateZ(-80deg);
  }

  100%{
    left: 80%;
    opacity: 0;
    transform: rotateZ(-80deg);
  }
}

@keyframes flipover{
  0%{
    left: 50%;
    z-index: -2;
  }

  50%{
    left: 130%;
  }

  75%{
    left: 160%;
    z-index: -2;
  }



  100%{
    left: 50%;
    z-index: 2;
  }
}


.log-back-content{
  color: #ddd;
  align-content: center;
  text-align: center;
  width: 100%;
  margin: auto;
  font-size: 1.5em;
  text-shadow: 3px 3px 5px black;
  z-index: 0;
}

.log-back-content i{
  color: white;
  text-shadow: 3px 3px 5px black;
}

.sm{
  margin: 20px 0;
}

.sm a{
  display: inline-flex;
  width: 40px;
  height: 40px;
  justify-content: center;
  align-items: center;
  color: #2c3e50;
  font-size: 18px;
  transition: 0.4s;
  border-radius: 50%;
}

.sm a:hover{
  background: #2c3e50;
  color: white;
}

