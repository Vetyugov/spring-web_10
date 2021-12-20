angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
        });
    };

    $scope.loadOrder = function (){
        $http.get(contextPath + '/orders/1')
            .then(function (response) {
                $scope.Order = response.data;
            });
    }

    $scope.addToOrder = function (productId){
        $http({
            url: contextPath + '/orders/add',
            method: 'PUT',
            params: {
                orderId: 1,
                productId: productId
            }
        }).then(function (response) {
            $scope.loadOrder();
        });
    }

    $scope.removeFromOrder = function (productId){
        $http({
            url: contextPath + '/orders/delete',
            method: 'PUT',
            params: {
                orderId: 1,
                productId: productId
            }
        }).then(function (response) {
            $scope.loadOrder();
        });
    }

    $scope.loadProducts();
    $scope.loadOrder();
});