angular.module('application',[]).controller('indexController',function ($scope,$http) {
    const contextPath ='http://localhost:8189/application';

    $scope.loadProducts =function(){
        $http.get(contextPath +'/products')
            .then(function (response){
                $scope.getProductList=response.data;
            });
    };

    $scope.filterByCost = function(){
        console.log($scope.filters);
        $http({
            url:contextPath +'/products/filter/diapasone',
            method: 'GET',
            params:{
                minCost: $scope.filters.min,
                maxCost: $scope.filters.max
            }
        })
            .then(function(response){
                $scope.getProductList=response.data;
        });
    };

    $scope.removeProduct = function(id){
        $http.get(contextPath+'/products/delete/'+id)
            .then(function(response){
                $scope.loadProducts();
            });
    };

    $scope.addProduct = function(){
          $http({
              url:contextPath+'/products/add',
              method: 'POST',
              params:{
                 title:document.getElementById('title').value,
                 price:document.getElementById('price').value
              }
          })
              .then(function(response){
                  $scope.loadProducts();
              });
      };

    $scope.loadProducts();

});