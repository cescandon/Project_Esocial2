<%@ page language="java" contentType="text/javascript; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
let messagesTextArea = document.querySelector("#messagesTextArea")
var websocket = new WebSocket("ws://localhost:8080/chat");

           
messagesTextArea.value = "Starting server connection... \n";
websocket.onopen = function(message){ processOpen(message);};            
websocket.onclose = function(message){ processClose(message);};
websocket.onmessage = function(message){ processMessage(message);};
websocket.onerror = function(message){ processError(message);};
                      
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
	messagesTextArea.value += message.data + " \n";
	/*              

	let jsonData = JSON.parse(message.data);
    if(jsonData.message !== null){
        messagesTextArea.value += jsonData.message + "\n";
        if(jsonData.message.toString()[0] == 'X')
        {
            document.querySelector(".target").innerText = "Changed  " + jsonData.message;
        }
    }   
    
    */            
}         
function sendMessage(){
    websocket.send(messageText.value);
    messageText.value = "";
}            
function closeConnection(){
    messagesTextArea.value += "You have disconnected... \n";
    websocket.close();
}