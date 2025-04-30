// app.service("loginService", function ($window,$http, $q) {
//   // Login
//   this.setCustomer = function (customer) {
//     $window.sessionStorage.setItem("currentCustomer", JSON.stringify(customer));
//   };

//   // Get customer data
//   this.getCustomer = function () {
//     var customer = $window.sessionStorage.getItem("currentCustomer");
//     return customer ? JSON.parse(customer) : null;
//   };

//   // Clear on logout
//   this.clearCustomer = function () {
//     $window.sessionStorage.removeItem("currentCustomer");
//   };
//   var ser=this;
//   this.login = function (credentials) {
//     return $http
//       .post("http://localhost:8080/api/login", credentials)
//       .then( (response)=> {
//         if (response.data.status === "success") {
//           ser.setCustomer(response.data.user);
//           console.log(response);
//           return response.data; // Contains message, user data, role
//         } else {
//           return $q.reject(response.data);
//         }
//       })
//       .catch((error)=> {
//         alert("catch");
//         console.log(error);
//         return $q.reject(error + "error"); // Properly reject the promise
//       });
//   };

//   // this.getCustomer = () => {
//   //   return customer;
//   // };
// });

app.service("loginService", function($window, $http, $q) {
  var service = this; // Capture service instance
  
  // Store customer data
  service.setCustomer = function(customer,role) {
      $window.sessionStorage.setItem("currentCustomer", JSON.stringify(customer));
      $window.sessionStorage.setItem("role", JSON.stringify(role));
  };

  // Get customer data
  service.getCustomer = function() {
      var customer = $window.sessionStorage.getItem("currentCustomer");
      return customer ? JSON.parse(customer) : null;
  };

  service.getRole = function() {
    var role = $window.sessionStorage.getItem("role");
    return role ? JSON.parse(role) : null;
};

  // Clear on logout
  service.clearCustomer = function() {
      $window.sessionStorage.removeItem("currentCustomer");
      $window.sessionStorage.removeItem("role");
  };

  // Login method
  service.login = function(credentials) {
      return $http.post("http://localhost:8080/api/login", credentials)
          .then(function(response) {
              if (response.data.status === "success") {
                  service.setCustomer(response.data.user,response.data.role);
                  console.log("Login successful, user stored:", response.data);
                  return response.data;
              }
              console.warn("Login failed with response:", response.data);
              return $q.reject(response.data);
          })
          .catch(function(error) {
              console.error("Login error:", error);
              return $q.reject({
                  message: "Login failed",
                  details: error.data || error.statusText
              });
          });
  };
});

app.service("registerService", function ($http, $q) {
  // Registration
  this.registerCustomer = function (data) {
    alert("service");
    return $http
      .post("http://localhost:8080/api/customers", data)
      .then(function (response) {
        return response.data; // Return data for chaining
      })
      .catch(function (error) {
        alert(error);
        return $q.reject(error + "error"); // Properly reject the promise
      });
  };
});

// angular.module('vehicleApp')
// .service('CustomerService', ['$http', 'AuthService', function($http, AuthService) {
//   let cachedCustomer = null;

//   // Get customer data (from cache or API)
//   this.getCurrentCustomer = function() {
//       return new Promise((resolve, reject) => {
//           // 1. Check cache first
//           if (cachedCustomer) {
//               resolve(cachedCustomer);
//               return;
//           }

//           // 2. Check AuthService (login data)
//           const authCustomer = AuthService.getCustomer();
//           // console.log(authCustomer);
//           if (authCustomer) {
//               cachedCustomer = authCustomer;
//               resolve(cachedCustomer);
//               return;
//           }

//           // 3. Fallback to API call
//           $http.get('/api/customers/')
//               .then(response => {
//                   cachedCustomer = response.data;
//                   resolve(cachedCustomer);
//               })
//               .catch(reject);
//       });
//   };

//   // Clear cache (e.g., on logout)
//   this.clearCache = function() {
//       cachedCustomer = null;
//   };

// }])
