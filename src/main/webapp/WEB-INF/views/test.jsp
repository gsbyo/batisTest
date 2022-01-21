<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    

    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="/resources/static/css/test.css">

    <title>View Test Page</title></head>
<body>
<div class="menu">
    <p>Todo List</p>
</div>


<div class="container">
<c:forEach var="item" items="${list}"> 
    <div class="list-box">
    <p class="item-day">${item.day}</p>
    <p class="item-work">${item.work}</p>
    <div class="button-wrap">
    <button class="cancel-button basic-btn" data-id="${item.id}">삭제</button>
    </div>
     </div>
    <br/> </c:forEach>
</div>

<div class="container">
<form action="/test" method="post">
    <div class="item-box">
        <input id="day" name="day" type="text" class="form-control" placeholder="Input Date">
    </div>
    <div class="item-box">
        <input id="work" name="work" type="text" class="form-control"  placeholder="Input Work">
    </div>
    <button class="basic-btn" type="submit">할 일 등록하기</button>
    <button type="button" class="edit-button basic-btn">수정하기</button>
</form>
</div>
   
    

    <script> 
        var work="";
        var day="";
        var id;

        $('.cancel-button').on('click',function(){
            var del_id = $(this).data("id");
       
           
            $.ajax({
                method: "delete",
                url: "/test",
                data : {
                    id : del_id
                },
                success : function(data){
                    if(data == "success")
                    alert('삭제완료')
                    location.reload();
                },
                error : function(err){
                    console.log('에러');      
                 }
            })
           
        })

        $('.list-box').on('click',function(){
            $('#day').val($(this).children(".item-day").text());
            $('#work').val($(this).children(".item-work").text());

            id = $(this).children(".button-wrap").children('.cancel-button').data("id");
        });

        
        $('#day, #work').on("propertychange change keyup paste input",function(){
          day = $('#day').val();
          work = $('#work').val();
        })
        
        $('.edit-button').on('click',function(){
            
            if(id == null){
                return alert("수정할 박스를 클릭해주세요");
            }
               
        
            $.ajax({
                method: "put",
                url: "/test",
                data : {
                    id : id,
                    day : day,
                    work : work

                },
                success : function(data){
                    if(data == "success")
                    location.reload();
                    alert('수정완료');
                },
                error : function(err){
                    console.log('에러');      
                 }
            })




        });
     
      
    </script>

</form>
</body>
</html>