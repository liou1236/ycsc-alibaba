<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册表单</title>
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            var age = document.getElementById("age").value;
            var gender = document.querySelector('input[name="gender"]:checked');
            var hobbies = document.querySelectorAll('input[name="hobby"]:checked');
            var education = document.getElementById("education").value;
            var email = document.getElementById("email").value;
            var error = document.getElementById("error");

            if (username === "" || password === "" || confirmPassword === "" || age === "" || !gender || hobbies.length === 0 || education === "" || email === "") {
                error.innerHTML = "所有字段都必须填写";
                return false;
            }

            if (password !== confirmPassword) {
                error.innerHTML = "密码和确认密码不匹配";
                return false;
            }

            if (isNaN(age) || age < 1 || age > 120) {
                error.innerHTML = "年龄必须是有效数字";
                return false;
            }

            if (!validateEmail(email)) {
                error.innerHTML = "邮箱格式不正确";
                return false;
            }

            var selectedHobbies = [];
            for (var i = 0; i < hobbies.length; i++) {
                selectedHobbies.push(hobbies[i].value);
            }

            var genderValue = gender.value;

            error.innerHTML = "";

            // 输出注册信息
            var output = "户名: " + username + "<br>";
            output += "密码: " + password + "<br>";
            output += "年龄: " + age + "<br>";
            output += "性别: " + genderValue + "<br>";
            output += "爱好: " + selectedHobbies.join(", ") + "<br>";
            output += "学历: " + education + "<br>";
            output += "邮箱: " + email;

            document.getElementById("registrationInfo").innerHTML = output;

            return false;
        }

        function validateEmail(email) {
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailPattern.test(email);
        }
    </script>
</head>
<body>
<h1>注册表单</h1>
<form action="registration.jsp" method="post" onsubmit="return validateForm()">
    <!-- 表单内容（与上述示例相同） -->
    <label for="age">年龄:</label>
    <input type="text" id="age" name="age"><br><br>

    <label for="email">邮箱:</label>
    <input type="text" id="email" name="email"><br><br>

    <input type="submit" value="注册">
    <p id="error" style="color: red;"></p>
</form>

<div id="registrationInfo"></div>
</body>
</html>
