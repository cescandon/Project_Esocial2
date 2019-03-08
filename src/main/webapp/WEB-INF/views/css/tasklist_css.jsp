<%@ page language="java" contentType="text/css; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 /* TASK LIST */
 
 .middle{
  position: absolute;
  top: 0%;
  left: 0;
  text-decoration: none;
  color: white;
  /* transition: translate(-50%,-50%); */
}

.task-list{
  width: 350px;
  height: 100px;
}

.list-area
{
  position: absolute;
  top: 75px;
  padding: 0 15px;
  transition: 1s margin;
  margin-left: -350px;

  box-sizing: content-box;
  display: flex;
  flex-direction: column;

  max-height: 400px;
  overflow-y: scroll;
  overflow-x: hidden;
}

.list-area::after{
  content: "";
  height: calc(100% - 200px);
  margin-top: 50px;
  width: 2px;
  position: absolute;
  right: -5px;
  background-color: white;
}



.task-list h2{
  color: #fff;
  text-align: center;
  text-transform: uppercase;
  padding: 5px 0 15px;
}

.task{
  display: flex;
  flex-grow: 0;
  flex-shrink: 0;

  padding: 10px 0;
  align-items: center;
  cursor: pointer;
  width: 300px;
}

.task input{
  position: absolute;
  visibility: hidden;
}

.task i{
  display: inline-block;
  width: 48px;
  height: 48px;
  border-radius: 50%;
  border: 3px solid #ddd;
  text-align: center;
  line-height: 48px;
  font-size: 20px;
  margin-right: 14px;
  color: transparent;
}

.text{
  font-size: 22px;
  color: #fff;
  width: 250px;
  text-shadow: 2px 2px 5px black;
}

.task input:checked ~ i{
  color: #e74c3c;
  border-color: #e74c3c;
}

.task input:checked ~ .text{
  color: #e74c3c;
  text-decoration: line-through;
}

.task input:checked ~ .text:before{
  height: 3px;
}
 