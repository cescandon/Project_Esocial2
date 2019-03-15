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
  <link rel="stylesheet" href="css/tasks">
</head>


<body>

<nav class="navbar">
  <a href="javascript:void(0)" id="brand-logo">ESocial</a>
  <a href="javascript:void(0)" id="menu">menu</a>
  <div class="nav-options">
    <a href="javascript:void(0)" onclick="OpenClose();">My Tasks</a>
    <a href="javascript:void(0)" onclick="OpenClose();">Messages</a>
    <a href="javascript:void(0)" onclick="ShowChat();">Chat</a>
  </div>

</nav>



<div class="chat-area">
  <div class="log-chat">
    <div class="log-chat-content log-form">
      <textarea id="messagesTextArea" readonly="readonly" rows="10" cols="30"></textarea><br/>
      <input type="text" id="messageText" size="50" />
      <input type="button" value="Send" onclick="sendMessage();" />
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

  <!-- <div class="loading-screen"></div> -->

</body>
    <script src="chat_js"></script>
    <script src="task_js"></script>
</html>