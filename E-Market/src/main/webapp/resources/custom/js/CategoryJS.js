//define namespace. It's not necessary, but will help in future
var WebPage = WebPage || {};
//define class
var CategoryDataController = function () {
    //this will be reference to the controller
    var obj = {};

    //private functions will look like this:

    function buildProductTable(data) {
        var $tableBody = $("#products_by_category_id");
        $tableBody.empty();
        data.forEach(function (value) {
            //ints just a bit more convenient way to use jQuery
            var $row = $("<tr>");
            $row.append($("<td>").text(value.model))
                .append($("<td>").text(value.year))
                .append($("<td>").text(value.mileage))
                .append($("<td>").text(value.price));
            $tableBody.append($row);
        });
    }

    function loadProductDataByCategory(categoryId) {
        $.get('loadListOfProductsByCategoryId', {categoryId: categoryId}, buildProductTable)
    }

    function tableHandler() {
        var $tableBody = $("#categoriesTableBody");
        $tableBody.find("[data-category-id]").on('click', function (event) {
            event.preventDefault();
            event.stopPropagation();
            var $this = $(this);
            var categoryId = $this.data('category-id');
            loadProductDataByCategory(categoryId);
        });
    }

    function onDataLoaded(data) {
        //use '$' prefix when you use jQuery variable - it will be a bit easier to understand
        var $tableBody = $("#categoriesTableBody");
        $tableBody.empty();
        //use native forEach - it's more fast. Or use Lodash/Underscore - util libs for arrays and objects
        data.forEach(function (value) {
            //ints just a bit more convenient way to use jQuery
            var $row = $("<tr>");
            $row.append($("<td>").attr('data-category-id', value.category_id).text(value.body_type));
            $tableBody.append($row);
        });
        tableHandler();
    }

    /**
     * data loading function
     */
    function loadData() {
        $.get("loadListOfCategories", onDataLoaded);
    }

    //public functions will look like this
    obj.init = function () {
        loadData();
    };

    return obj;
};
/**
 * Function that will executed after document loaded;
 */
$(function () {
    //create element in namespace
    WebPage.categoryDataController = CategoryDataController();
    //call public method
    WebPage.categoryDataController.init();
});