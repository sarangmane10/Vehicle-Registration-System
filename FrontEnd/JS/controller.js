app.controller("registerController", function ($scope,loginService, registerService, $location) {
  // Registration
  $scope.customerData = {};
  $scope.form = {};

  $scope.handleRegistration = function () {
    console.log($scope.form.checkPassword);
    if ($scope.customerData.password !== $scope.form.checkPassword) {
      alert("Passwords don't match!");
      return;
    }
    if(loginService.getRole()===null || loginService.getRole()!=="ADMIN"){
      $scope.customerData.userType="USER";
    }else{
      $scope.customerData.userType="ADMIN";
    }
    registerService.registerCustomer($scope.customerData)
      .then(function (response) {
        alert("Registration successful!");
        $location.path("/login");
      })
      .catch(function (error) {
        alert("Registration failed: " + error.data.message);
      });
  };
});

  app.controller("loginController", function ($scope, loginService, $location) {
  // Login
  $scope.login = {};
  $scope.handleLogin = function () {
    loginService.login($scope.login)
      .then(function (response) {
        alert("controller login");
        // console.log(response);
        if (response.role === "USER") {
          $location.path("/profile");
        } else if (response.role === "ADMIN") {
          $location.path("/adminProfile");
        }
      })
      .catch(function (error) {
        alert("Login failed: " + (error.data || "Invalid credentials"));
      });
    $scope.login = {};
  };



  
});

// controllers.js
app.controller("profileController", [
  "$scope",
  "loginService",
  "$location",
  function ($scope, loginService,$location) {
    // Controller logic here
    // console.log(AuthService.getCustomer());
    // console.log("hello");
    if(loginService.getCustomer()!==null){
        $scope.customer = loginService.getCustomer();
      }else{
        $location.path("/login");
      }

      $scope.logOut = function() {
        alert("logout");
        loginService.clearCustomer();
        $scope.customer=null;
        $location.path("/login");
    }
  }
]);
