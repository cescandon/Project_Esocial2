<%@ page language="java" contentType="text/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
  let t = document.querySelector(".list-area");
  let openTasks = false;
  function OpenClose(){
    t.style.marginLeft= openTasks? "-350px" : "0";
    openTasks = !openTasks;
  }

  function Rotate(){
    let f = document.querySelector(".log-front");
    f.classList.toggle("log-drop");
  }

  let openChat = true;
  function ShowChat(){
    let f = document.querySelector(".chat-area");
    f.style.right = openChat? "-350px" : "0";
    openChat = !openChat;
  }
  
   function ShowJoin(){
    let f = document.querySelector(".log-back");
    f.classList.toggle("log-flipover");
  }