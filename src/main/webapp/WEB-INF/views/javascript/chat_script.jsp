<%@ page language="java" contentType="text/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
let messagesTextArea = document.querySelector("#messagesTextArea")
let websocket = null;
let isconnected = false;


function startConnection(){

	if(!isconnected){
		messagesTextArea.value = "Starting server connection... \n";
		websocket = new WebSocket("ws://${localh}:8080/chat");
		websocket.onopen = function(message){ processOpen(message);};            
		websocket.onclose = function(message){ processClose(message);};
		websocket.onmessage = function(message){ processMessage(message);};
		websocket.onerror = function(message){ processError(message);};
	}
}

                      
function processOpen(message){
    messagesTextArea.value += "Server connect... \n";
}
function processClose(message){    
    websocket.send("client disconnected...");
    messagesTextArea.value += "Server Disconnect...\n";
} 
function processError(message){
    messagesTextArea.value += "error ... \n";
}          
function processMessage(message){
	console.log(message);
	console.log("process");
	processCMD(message);	           
}
let count = 0;
function processCMD(message){
	let msg = "";
	msg += message.data;
	let check = msg.substring(0, 4);
	if(check.localeCompare("CT"))
	{
		console.log("Doing command");
		AddTask(count++, msg.substring(3,msg.length));
	}
	else if (check.localeCompare("CR"))
	{
	    console.log("Doing reminder");
		AddReminder(count++, msg.substring(3,msg.length));
	}
	else
		messagesTextArea.value += msg.data + " \n";
}
      
function sendMessage(){
	if(!isconnected)
	{
		startConnection();
		isconnected = true;
		return;
	}
    websocket.send(messageText.value);
    messageText.value = "";
}   
         
function closeConnection(){
    messagesTextArea.value += "You have disconnected... \n";
    websocket.close();
}