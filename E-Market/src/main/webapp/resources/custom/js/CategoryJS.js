//define namespace. It's not necessary, but will help in future
var WebPage = WebPage || {};
//define class
var CategoryDataController = function () {
    //this will be reference to the controller
    var obj = {};

    //private functions will look like this:
    /**
     * callback for successful call;
     * @param data obtained in response
     */
    function onDataLoaded(data) {
        //use '$' prefix when you use jQuery variable - it will be a bit easier to understand
        var $tableBody = $("#categoriesTableBody");
        $tableBody.empty();
        //use native forEach - it's more fast. Or use Lodash/Underscore - util libs for arrays and objects
        data.forEach(function (value) {
            //ints just a bit more convenient way to use jQuery
            var $row = $("<tr>");
            $row.append($("<td>").text(value.body_type))
                .append($("<td>").text(value.colour))
                .append($("<td>").text(value.engine_capacity))
                .append($("<td>").text(value.engine_volume))
                .append($("<td>").text(value.max_speed));
            $tableBody.append($row);
        });
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