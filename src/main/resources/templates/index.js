angular.module('app',[]).controller('indexController',function ($scope,$http) {
    const contextPath ='http://localhost:8189/application';

    $scope.loadProducts =function(){
        $http.get(contextPath +'/products/list')
            .then(function (response){
                $scope.getProductList=response.data;
            });
    };

    $scope.changePrice = function(id,price){
        $http({
            url:contextPath +'/products/change',
            method: 'GET',
            params:{
                id:id,
                priceDelta:price
            }
        })
            .then(function(response){
                $scope.loadProducts();
        });
    };

    $scope.removeProduct = function(id){
        $http({
            url:contextPath+'/products/remove',
            method: 'GET',
            params:{
                id:id
            }
        })
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