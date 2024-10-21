<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 10/19/2024
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        /* Style cho thanh chờ */
        #loading {
            display: none; /* Ẩn thanh chờ ban đầu */
            width: 100%;
            height: 10px;
            background-color: #f3f3f3;
            margin-top: 20px;
        }

        #loading-bar {
            width: 0;
            height: 10px;
            background-color: #4caf50;
            animation: loading 2s linear infinite; /* Tạo hiệu ứng chạy thanh chờ */
        }

        @keyframes loading {
            0% { width: 0; }
            100% { width: 100%; }
        }
    </style>
</head>
<body>
    <div>Diểm danh lớp cầu lông</div>
    <form action="waiting"  method="get" onsubmit="showLoading()">
        <input type = "text" name = "week" placeholder="Nhập tuần cần lấy danh sách vắng" />
        <input type = "submit" value="Lấy danh sách">
    </form>
    <!-- Thanh chờ -->
    <div id="loading">
        <div id="loading-bar"></div>
    </div>

    <script>
        // Hàm hiển thị thanh chờ khi form được submit
        function showLoading() {
            document.getElementById('loading').style.display = 'block'; // Hiển thị thanh chờ
        }
    </script>
</body>
</html>
