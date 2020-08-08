<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <title>首页</title>

  <!-- CSS样式 -->
  <style type="text/css">
    * {
      padding: 0;
      margin: 0;
    }

    html {
      height: 100%;
    }

    body {
      background-color: #e4b9b9;
    }

    .container {
      text-align: center;
      padding: 100px 0;
    }

    .btn {
      background: none;
      border: 0;
      outline: 0;
      color: aquamarine;
      font-family: 'JetBrains Mono';
      font-size: 20px;
      cursor: pointer;
      border: 2px solid aquamarine;
      width: 250px;
      height: 50px;
      position: relative;
    }

    .btn label {
      position: absolute;
      left: 0;
      top: 0;
      line-height: 50px;
      width: 100%;
      height: 100%;
      z-index: 1;
      background-color: rgb(51, 51, 51);
    }

    .btn::before {
      content: '';
      position: absolute;
      left: -2px;
      top: -2px;
      width: 0px;
      height: 0;
      z-index: 0;
      background-color: brown;
      transition: width .5s,height .5s;
    }

    .btn::after {
      content: '';
      position: absolute;
      right: -2px;
      bottom: -2px;
      width: 0;
      height: 0;
      z-index: 0;
      background-color: brown;
      transition: width .5s,height .5s;
    }

    .btn:hover {
      color: brown;
    }

    .btn:hover::before {
      width: calc(100% + 4px);
      height: calc(100% + 4px);
    }

    .btn:hover::after {
      width: calc(100% + 4px);
      height: calc(100% + 4px);
    }

    .title{
      font-size: 50px;
      color: #337ab7;
    }
  </style>

  <script type="text/javascript">
    function fun_1() {
      window.location.href = "${pageContext.request.contextPath}/findUserByPageServlet";
    }
    function fun_2() {
      window.location.href = "http://duing.site:8080/crawler/";
    }
  </script>
</head>
<body>
  <div align="center" class="title">${admin.username}，欢迎您！</div>

  <div class="container">
    <button class="btn" onclick="fun_1()">
      <label>查看所有联系人</label>
    </button>
  </div>

  <div class="container">
    <button class="btn" onclick="fun_2()">
      <label>课表系统</label>
    </button>
  </div>
</body>
</html>