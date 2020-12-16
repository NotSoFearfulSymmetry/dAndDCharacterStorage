<jsp:include page="head.jsp" />

<body>
    <form id="signUpForm" role="form" data-toggle="validator" class="pure-form"
          action="signUpUser"
          method="post">
        
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" for="emailAddress">Email
                Address</label>
            <div class="col-sm-4">
                <input type="email" class="form-control" id="emailAddress"
                       name="emailAddress"
                       data-error="Please enter your email address." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" for="userName">Username</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="userName"
                       name="userName"
                       data-error="Please enter your userName." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password
            </label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password"
                       name="password" data-error="Please provide a password."
                       required>
                <div class="help-block with-errors"></div>
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"
                   for="confirmPassword">Retype
                Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="confirmPassword"
                       name="confirmPassword" equalTo="#password"
                       data-match="#password"
                       data-match-error="Confirmation password does not match"
                       required data-error="Please retype your password.">
                <div class="help-block with-errors"></div>
            </div>
        </div>

        <button type="submit" class="btn btn-default col-sm-offset-3"
                data-disable="true">Submit
        </button>
        <button type="reset" class="btn btn-default">Clear</button>
        <!--for google recaptcha-->
        <div class="g-recaptcha" data-sitekey="6LewtTgUAAAAADuEbgusz9FbghpuXq-gBm6rLPS9"></div>
    </form>
</div>
</body>
</html>

</form>