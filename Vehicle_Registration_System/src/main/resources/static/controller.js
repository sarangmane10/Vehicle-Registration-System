// controller.js
app.controller('MainController', function($scope, AuthService, $location) {
    $scope.login = {};
    $scope.register = {};
    $scope.showLogin = false;
    $scope.showRegister = false;

    $scope.toggleLogin = function() {
        $scope.showLogin = true;
        $scope.showRegister = false;
    };

    $scope.toggleRegister = function() {
        $scope.showRegister = true;
        $scope.showLogin = false;
    };

    $scope.handleLogin = function() {
        AuthService.login($scope.login).then(function() {
            $location.path('/profile');
        }).catch(function() {
            alert("Invalid credentials");
        });
    };
});

app.controller('ProfileController', function($scope) {
    $scope.message = "Welcome to your profile!";
});
