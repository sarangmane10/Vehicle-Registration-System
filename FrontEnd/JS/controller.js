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
          $location.path("/customerHome");
        } else if (response.role === "ADMIN") {
          $location.path("/adminHome");
        }
      })
      .catch(function (error) {
        alert("Login failed: " + (error.data || "Invalid credentials"));
      });
    $scope.login = {};
  };



  
});

// controllers.js
app.controller("customerController", [
  "$scope",
  "loginService",
  "$location",
  function ($scope, loginService,$location) {
      // Initialize controller
      $scope.currentView = 'dashboard';
      $scope.currentYear = new Date().getFullYear();
      $scope.registrationStep = 1;
      
      // Available vehicles for registration
      $scope.availableVehicles = [
        { 
          make: 'Toyota', 
          model: 'Camry', 
          type: 'Sedan', 
          year: 2023, 
          engineType: '2.5L 4-cylinder',
          transmission: 'Automatic',
          image: 'https://www.toyota.com/imgix/responsive/images/mlp/colorizer/2023/camry/1H1/1.png'
        },
        { 
          make: 'Honda', 
          model: 'Civic', 
          type: 'Sedan', 
          year: 2023, 
          engineType: '2.0L 4-cylinder',
          transmission: 'Automatic',
          image: 'https://www.honda.com/imgix/responsive/images/mlp/colorizer/2023/civic-sedan/1H1/1.png'
        },
        { 
          make: 'Ford', 
          model: 'F-150', 
          type: 'Truck', 
          year: 2023, 
          engineType: '3.5L V6 EcoBoost',
          transmission: '10-Speed Automatic',
          image: 'https://www.ford.com/imgix/responsive/images/mlp/colorizer/2023/f150/1H1/1.png'
        },
        { 
          make: 'Tesla', 
          model: 'Model 3', 
          type: 'Sedan', 
          year: 2023, 
          engineType: 'Electric',
          transmission: 'Single-Speed',
          image: 'https://www.tesla.com/imgix/responsive/images/mlp/colorizer/2023/model-3/1H1/1.png'
        },
        { 
          make: 'Jeep', 
          model: 'Wrangler', 
          type: 'SUV', 
          year: 2023, 
          engineType: '3.6L V6',
          transmission: '8-Speed Automatic',
          image: 'https://www.jeep.com/imgix/responsive/images/mlp/colorizer/2023/wrangler/1H1/1.png'
        },
        { 
          make: 'Harley-Davidson', 
          model: 'Sportster', 
          type: 'Motorcycle', 
          year: 2023, 
          engineType: '1.2L V-Twin',
          transmission: '5-Speed',
          image: 'https://www.harley-davidson.com/imgix/responsive/images/mlp/colorizer/2023/sportster/1H1/1.png'
        }
      ];
      
      // Initialize form data
      $scope.resetRegistrationForm = function() {
        $scope.vehicleForm = {
          registrationNumber: '',
          make: '',
          model: '',
          type: '',
          year: '',
          color: ''
        };
        $scope.registrationStep = 1;
      };
      $scope.resetRegistrationForm();
      
      // Vehicle selection functions
      $scope.selectVehicle = function(vehicle) {
        $scope.vehicleForm.make = vehicle.make;
        $scope.vehicleForm.model = vehicle.model;
        $scope.vehicleForm.type = vehicle.type;
        $scope.vehicleForm.year = vehicle.year;
        $scope.registrationStep = 2;
      };
      
      $scope.showCustomVehicleForm = function() {
        $scope.vehicleForm = {
          registrationNumber: '',
          make: '',
          model: '',
          type: '',
          year: '',
          color: ''
        };
        $scope.registrationStep = 2;
      };
      
      $scope.backToVehicleSelection = function() {
        $scope.registrationStep = 1;
      };
      
      // Rest of the controller remains the same as previous solution
      // (customer data, vehicles array, dashboard stats, etc.)
      
      // Sample customer data
      $scope.customer = {
        name: 'John Doe',
        email: 'john.doe@example.com',
        phone: '(123) 456-7890',
        address: '123 Main Street, City, Country'
      };
      
      // Sample vehicle data
      $scope.vehicles = [
        { 
          id: 1, 
          make: 'Toyota', 
          model: 'Camry', 
          type: 'Sedan',
          year: 2020,
          color: 'Red',
          registrationNumber: 'ABC-1234', 
          status: 'APPROVED',
          registeredDate: new Date(2023, 0, 15)
        },
        { 
          id: 2, 
          make: 'Honda', 
          model: 'Civic', 
          type: 'Sedan',
          year: 2021,
          color: 'Blue',
          registrationNumber: 'XYZ-5678', 
          status: 'PENDING',
          registeredDate: new Date(2023, 2, 10)
        }
      ];
      
      // Dashboard statistics
      $scope.updateStats = function() {
        $scope.vehicleCount = $scope.vehicles.length;
        $scope.approvedCount = $scope.vehicles.filter(v => v.status === 'APPROVED').length;
        $scope.pendingCount = $scope.vehicles.filter(v => v.status === 'PENDING').length;
      };
      $scope.updateStats();
      
      // Recent activities
      $scope.recentActivities = $scope.vehicles.map(vehicle => ({
        date: vehicle.registeredDate,
        type: 'Registration',
        vehicle: `${vehicle.make} ${vehicle.model}`,
        status: vehicle.status
      })).sort((a, b) => b.date - a.date);
      
      // View management
      $scope.setView = function(view) {
        $scope.currentView = view;
        if (view === 'register') {
          $scope.resetRegistrationForm();
        }
      };
      
      // Vehicle registration
      $scope.registerVehicle = function() {
        const newId = Math.max(...$scope.vehicles.map(v => v.id), 0) + 1;
        
        $scope.vehicles.push({
          id: newId,
          make: $scope.vehicleForm.make,
          model: $scope.vehicleForm.model,
          type: $scope.vehicleForm.type,
          year: $scope.vehicleForm.year,
          color: $scope.vehicleForm.color,
          registrationNumber: $scope.vehicleForm.registrationNumber,
          status: 'PENDING',
          registeredDate: new Date()
        });
        
        $scope.updateStats();
        $scope.resetRegistrationForm();
        $scope.setView('vehicles');
        alert('Vehicle registration submitted successfully!');
      };
      
      // Profile actions
      $scope.updateProfile = function() {
        alert('Profile updated successfully!\n' + JSON.stringify($scope.customer, null, 2));
      };
      
      // Logout
      $scope.logout = function() {
        if(confirm('Are you sure you want to logout?')) {
          loginService.clearCustomer();
          $location.path("/login");
          alert('Logged out successfully');
        }
      };

  }
]);


app.controller("adminController",[
  "$scope",
  "adminService",
  "$location",
  function ($scope, adminService,$location) {

    $scope.currentView = 'customers';
    $scope.showModal = false;
    $scope.customers;
    // Sample data
    adminService.getCustomerStat().then((response)=>{
      $scope.customers=response;
    }).then(()=>{console.log($scope.customers);})
    // $scope.customers = [
    //   { id: '#C1001', name: 'John Doe', email: 'john@example.com', 
    //     phone: '(123) 456-7890', vehicles: [{make: 'Toyota', model: 'Camry'}] },
    //   { id: '#C1002', name: 'Jane Smith', email: 'jane@example.com', 
    //     phone: '(234) 567-8901', vehicles: [{make: 'Honda', model: 'Civic'}] }
    // ];
    
    $scope.allRegistrations = [
      { 
        id: '#VR-2023-001', 
        customerName: 'John Doe',
        vehicle: { make: 'Toyota', model: 'Camry', year: 2022 },
        submittedDate: new Date('2023-07-15'),
        status: 'APPROVED'
      },
      { 
        id: '#VR-2023-002', 
        customerName: 'Jane Smith',
        vehicle: { make: 'Honda', model: 'Civic', year: 2021 },
        submittedDate: new Date('2023-07-16'),
        status: 'PENDING'
      }
    ];
    
    $scope.vehicles = [
      { id: '#VH-1001', make: 'Toyota', model: 'Camry', year: 2022, 
        plateNumber: 'ABC-1234', status: 'ACTIVE' },
      { id: '#VH-1002', make: 'Honda', model: 'Civic', year: 2021, 
        plateNumber: 'XYZ-5678', status: 'ACTIVE' }
    ];
    
    $scope.adminProfile = {
      name: 'Admin User',
      email: 'admin@vehiclesystem.com',
      phone: '(555) 123-4567'
    };
    
    $scope.newVehicle = {};
    
    // Computed property
    $scope.pendingRegistrations = $scope.allRegistrations.filter(r => r.status === 'PENDING');
    
    // View management
    $scope.setView = function(view) {
      $scope.currentView = view;
    };
    
    // Modal functions
    $scope.showAddVehicleModal = function() {
      $scope.showModal = true;
    };
    
    $scope.closeModal = function() {
      $scope.showModal = false;
      $scope.newVehicle = {};
    };
    
    // Vehicle functions
    $scope.addVehicle = function() {
      $scope.vehicles.push({
        id: '#VH-' + (1000 + $scope.vehicles.length + 1),
        make: $scope.newVehicle.make,
        model: $scope.newVehicle.model,
        year: $scope.newVehicle.year,
        plateNumber: $scope.newVehicle.plateNumber,
        status: 'ACTIVE'
      });
      $scope.closeModal();
    };
    
    $scope.viewVehicle = function(id) {
      alert('Viewing vehicle: ' + id);
    };
    
    $scope.editVehicle = function(id) {
      alert('Editing vehicle: ' + id);
    };
    
    $scope.deleteVehicle = function(id) {
      if(confirm('Are you sure you want to delete this vehicle?')) {
        $scope.vehicles = $scope.vehicles.filter(v => v.id !== id);
      }
    };
    
    // Registration functions
    $scope.viewRegistration = function(id) {
      alert('Viewing registration: ' + id);
    };
    
    $scope.approveRegistration = function(id) {
      const reg = $scope.allRegistrations.find(r => r.id === id);
      if(reg) reg.status = 'APPROVED';
    };
    
    $scope.rejectRegistration = function(id) {
      const reg = $scope.allRegistrations.find(r => r.id === id);
      if(reg) reg.status = 'REJECTED';
    };
    
    // Profile functions
    $scope.updateProfile = function() {
      if($scope.adminProfile.newPassword && 
         $scope.adminProfile.newPassword !== $scope.adminProfile.confirmPassword) {
        alert('Passwords do not match!');
        return;
      }
      alert('Profile updated successfully!');
    };
    
    // Logout
    $scope.logout = function() {
      if(confirm('Are you sure you want to logout?')) {
        // Implement logout logic
        window.location.href = 'login.html';
      }
    };
}])