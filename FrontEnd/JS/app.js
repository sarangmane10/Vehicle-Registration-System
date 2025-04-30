  let app = angular.module("vehicleApp", ["ngRoute"]);
  app.config(function ($routeProvider) {
    $routeProvider
      .when("/", {
        templateUrl: "view/home.html",
      })
      .when("/login", {
        templateUrl: "view/login.html",
        controller: "loginController",
      })
      .when("/register", {
        templateUrl: "view/register.html",
        controller: "registerController",
      })
      .when("/profile", {
        templateUrl: "view/profile.html",
        controller: "profileController",
      })
      .otherwise({ redirectTo: "/" });
  });
  