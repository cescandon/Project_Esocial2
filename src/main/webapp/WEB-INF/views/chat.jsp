<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Chat Service</title>

 <link rel="stylesheet" href="css/main">
 <link rel="stylesheet" href="css/cards">
 <link rel="stylesheet" href="css/forms">
</head>

 
</head>
<body>
    
<div class="wrapper" id="chat-wrapper">
  <div class="log-card">
    <div class="log-chat">
      <div class="log-chat-content log-form">
        <h1 class="target">Online Chat</h1>
        <textarea id="messagesTextArea" readonly="readonly" rows="10" cols="30"></textarea><br/>
        <input type="text" id="messageText" size="50" />
        <input type="button" value="Send" onclick="sendMessage();" />
      </div>
    </div>
  </div>
</div>

</body>
    
    <script src="chat_js"></script>
</html>