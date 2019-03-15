<%@ page language="java" contentType="text/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
  var tlist = {};
    
  let t = document.querySelector(".list-area");
  let openTasks = false;
  function OpenClose(){
    t.style.marginLeft= openTasks? "-350px" : "0";
    openTasks = !openTasks;
  }
  
  function AddTask(taskname, task){
  	tlist[taskname] = task;
  	console.log("Doing task \n: " + task);
  	let htmlString = "";
  	for(let key in tlist) {
  		htmlString += tlist[key];		
  	}
  	t.innerHTML = htmlString;
  }
  
  function DeleteTask(taskname, task){
  	delete tlist[taskname];
  	let htmlString = "";
  	for(let key in tlist) {
  		htmlString += tlist[key];		
  	}
  	t.innerHTML = htmlString;
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