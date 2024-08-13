<%@ page import="com.mycom.springmybatisboard.user.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UserDto userDto = (UserDto) session.getAttribute("userDto");
    System.out.println(userDto);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img alt="User Profile Image" src="/assets/img/user/<%=userDto.getUserProfileImage()%>" style="width:34px; height: 34px; border-radius: 50%;">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/pages/board">게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/auth/logout">로그아웃</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-3">
    <h4 class="text-center">게시판</h4>

    <div class="input-group mb-3">
        <input id="inputSearchWord" type="text" class="form-control" placeholder="Search">
        <button id="btnSearchWord" class="btn btn-success" type="button">Search</button>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일시</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody id="boardTbody">
        </tbody>
    </table>

    <div id="paginationWrapper"></div>
    <button class="btn btn-sm btn-primary" id="btnInsertPage">글쓰기</button>
</div>
<script>
    let LIST_ROW_COUNT = 10;
    let OFFSET = 0;

    window.onload = function () {
        listBoard();
    }

    async function listBoard() {
        let url = "/boards/list"
        let urlParams = "?limit=" + LIST_ROW_COUNT + "&offset" + OFFSET
        let response = await fetch(url+urlParams);
        let data = await response.json();

        if(data.result == "success") {
            console.log(data);
            console.log(data.list);
        } else if(data.result == "fail") {
            alert("글 조회 과정에서 오류가 발생했습니다.")
        }
    }

</script>
</body>
</html>