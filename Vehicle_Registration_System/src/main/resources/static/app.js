var app = angular.module('vehicleApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/profile', {
            templateUrl: 'landing.html',
            controller: 'ProfileController'
        })
        .when('/register', {
            templateUrl: 'register.html',
            controller: 'RegisterController'
        })
        .otherwise({
            redirectTo: '/'
        });
});

app.controller('ProfileController', function($scope) {
    $scope.message = "Welcome to your profile!";
});

app.controller('RegisterController', function($scope) {
    $scope.message = "Please register here!";
});
