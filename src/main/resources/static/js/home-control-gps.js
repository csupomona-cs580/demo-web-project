// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var cs580App = angular.module('cs580App', []);

cs580App.controller('GpsCtrl', function ($scope, $http) {

  $scope.loadGps = function() {
	  $http.get("price/gps/list")
	  	.success(function(data){
	  		$scope.gpsItems = data;
	  	});
  }

  $scope.loadGps();

});
