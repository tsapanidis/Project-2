<<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Owners/Users</title>
    <link rel="stylesheet" type="text/css" href="/Bootstrap/css/register.css">
</head>
</head>
<body>
<form name="registerForm" action="/register" method="post">
    <form action="action_page.php">
        <div class="container">
            <h1>Registration form</h1>
            <p>Please complete the following form to register new user.</p>
            <hr>

            <label for="SSN"><b>SSN</b></label>
            <input type="text" placeholder="Insert SSN" name="SSN" required>

            <label for="Name"><b>Name</b></label>
            <input type="text" placeholder="Insert name" name="Name" required>

            <label for="Last Name"><b>Last name</b></label>
            <input type="text" placeholder="Insert Last name" name="Last Name" required>

            <label for="Address"><b>Address</b></label>
            <input type="text" placeholder="Insert Address" name="Address" required>

            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Insert email" name="Email" required>

            <label for="Password"><b>Password</b></label>
            <input type="password" placeholder="Insert Password" name="password" required>

            <label for="Licence Plate"><b>Licence Plate</b></label>
            <input type="text" placeholder="Insert Licence Plate" name="licencePlate" required>

            <select width="300" style="width: 100%">
                <option value="administrator">Administrator</option>
                <option value="user">User</option>
            </select>

            <hr>

            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
            <button type="submit" class="registerbtn">Register</button>
        </div>


    </form>
</html>
