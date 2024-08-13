<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
<div class="container">
    <div class="mb-3 mt-3 d-flex justify-content-center">
        <h1 class="display-4">삐따기 세상</h1>
    </div>
    <div class="mb-3">
        <h2>Login</h2>
    </div>

    <form novalidate>
        <div class="mb-3">
            <label for="userEmail">Email:</label>
            <input type="text" class="form-control" id="userEmail" placeholder="Enter email" name="userEmail" required
                   value="email@exmaple.com">
        </div>
        <div class="mb-3">
            <label for="userPassword">Password:</label>
            <input type="password" class="form-control" id="userPassword" placeholder="Enter password"
                   name="userPassword" required value="asdf1234!">
        </div>
    </form>
    <div>
        <button id="btnLogin" class="btn btn-success">로그인</button>
        <a href="/pages/user" class="btn btn-primary">회원가입</a>
    </div>
</div>
<script>
    window.onload = function () {
        document.querySelector("#userEmail").focus();
        //submit
        document.querySelector("#btnLogin").onclick = function () {
            if(validate()) {
                login();
            }
        };

    }

    function validate(userName) {
        if (document.querySelector("#userEmail").value.length > 0 &&
            document.querySelector("#userPassword").value.length > 0) return true;
        alert("이메일과 비밀번호를 입력해 주십시오.")
        return false;
    }

    async function login() {
        var userEmail = document.querySelector("#userEmail").value;
        var userPassword = document.querySelector("#userPassword").value;

        let urlParams = new URLSearchParams({
            userEmail: userEmail,
            userPassword: userPassword,
        });

        let fetchOptions = {
            method: "POST",
            body: urlParams,
        }

        let response = await fetch("/auth/login", fetchOptions);
        let data = await response.json();

        if (data.result == "success") {
            window.location.href = "/pages/board";
        } else if (data.result == "fail") {
            alert("이메일 또는 비밀번호가 올바르지 않습니다!");
        }
    }
</script>
</body>
</html>