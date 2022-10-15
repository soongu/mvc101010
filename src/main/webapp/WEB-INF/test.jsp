<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <% for (int i = 0; i < 3; i++) { %>
        <h1>test.jsp 입니다~~~ 하하호호</h1>
    <% } %>

    <%
        String[] arr = {"감자", "고구마", "당근"};
        for (String s : arr) {
    %>
        <h2> <%= s %> 캐러 가자! </h2>
    <% } %>

</body>
</html>