<jsp:include page="head.jsp" />

<html>

<body>
    <h1>Before we can proceed, we must have your name for the Adventurers' Guild records.</h1>
    <form id="signUpForm" class="pure-form pure-form-stacked" action="userAdded.jsp" method="post">

            <label for="emailAddress">Email Address</label>

                <input type="email" class="form-control" id="emailAddress"
                       name="emailAddress"
                       data-error="Please enter your email address." required>

            <label for="userName">Username</label>

                <input type="text" id="userName"
                       name="userName"
                       data-error="Please enter your userName." required>

            <label for="password">Password</label>

                <input type="password" id="password"
                       name="password" data-error="Please provide a password."
                       required>

            <label for="confirmPassword">Retype password</label>

                <input type="password" id="confirmPassword"
                       name="confirmPassword" equalTo="#password"
                       data-match="#password"
                       data-match-error="Confirmation password does not match"
                       required data-error="Please retype your password.">

        <button type="submit" data-disable="true">Submit</button>
        <button type="reset" >Clear</button>
    </form>

</body>
</html>