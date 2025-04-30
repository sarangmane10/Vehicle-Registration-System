// service.js
app.service('AuthService', function($q) {
    this.login = function(user) {
        const deferred = $q.defer();

        // Simulated login check (replace with real API call)
        if (user.email === 'test@example.com' && user.password === 'password') {
            deferred.resolve();
        } else {
            deferred.reject();
        }

        return deferred.promise;
    };
});
