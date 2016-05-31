var WebPage = WebPage || {};

var UserDataController = function () {
    var obj = {};


    function userHandler(data) {
        $.post('registeruser', data, function () {

        }, 'json');
    }

    function addClickHandler() {
        $("#registerButton").off("click").on("click", handleClick);

    }

    function handleClick(event) {
        event.preventDefault();
        event.stopPropagation();
        var username = $("#username").val();
        var email = $("#email").val();
        var password = $("#password").val();

        var user = {username: username, email: email, password: password};
        userHandler(user);
    }

    obj.init = function () {
        addClickHandler();

    };
    return obj;
};

$(function () {
    WebPage.userDataController = UserDataController();
    WebPage.userDataController.init();
});



