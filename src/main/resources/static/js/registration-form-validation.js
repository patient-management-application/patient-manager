$(document).ready(function(){

    var username = $('#username');
    var email = $('#email');
    var password = $('#password');
    var phoneNumber = $('#phoneNumber');
    var firstName = $('#firstName');
    var lastName = $('#lastName');
    var dob = $('#dob');
    var gender = $('#gender');
    var street = $('#street');
    var city = $('#city');
    var state = $('#state');
    var zipcode = $('#zipcode');
    var form = $('#registration-form');

    var validPhoneNumber = false;
    var validUsername = false;
    var validEmail = false;
    var validPassword = false;
    var validFirstName = false;
    var validLastName = false;
    var validDob = false;
    var validGender = false;
    var validStreet = false;
    var validCity = false;
    var validState = false;
    var validZipcode = false;



    username.keyup(function(){
        if ($(this).val().length < 5){
            form.submit(function (e) {
                e.preventDefault();
            });
            validUsername = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validUsername = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    email.keyup(function(){
        if (email.val().includes("@") && email.val().includes(".")){
            validEmail = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });

        } else {
            form.submit(function (e) {
                e.preventDefault();
            });
            validEmail = false;
            $(this).css({
                "background-color" :   "#c78078"
            });

        }
    });

    password.keyup(function(){
        if (!email.val().length > 3){
            form.submit(function (e) {
                e.preventDefault();
            });
            validPassword = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validPassword = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    firstName.keyup(function(){
        if (!firstName.val().length > 0){
            form.submit(function (e) {
                e.preventDefault();
            });
            validFirstName = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validFirstName = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    lastName.keyup(function(){
        if (!lastName.val().length > 0){
            form.submit(function (e) {
                e.preventDefault();
            });
            validLastName = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validLastName = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    dob.change(function(){
        var dobDateString = new Date(dob.val()).toString();
        if (dob.val().length === "" ||  Date.parse(dobDateString) > new Date()){
            form.submit(function (e) {
                e.preventDefault();
            });
            validDob = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validDob = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    gender.keyup(function(){
        if (!gender.val().length > 0){
            form.submit(function (e) {
                e.preventDefault();
            });
            validGender = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validGender = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    street.keyup(function(){
        if (!street.val().length > 0){
            form.submit(function (e) {
                e.preventDefault();
            });
            validStreet = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validStreet = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    city.keyup(function(){
        if (!city.val().length > 0){
            form.submit(function (e) {
                e.preventDefault();
            });
            validCity = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validCity = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    state.keyup(function(){
        if (!state.val().length > 0 || state.val().length !== 2){
            form.submit(function (e) {
                e.preventDefault();
            });
            validState = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validstate = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    zipcode.keyup(function(){
        if (zipcode.val().length !== 5 || (typeof parseInt(zipcode.val()) !== "number")){
            form.submit(function (e) {
                e.preventDefault();
            });
            validZipcode = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validZipcode = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    phoneNumber.keyup(function(){
        if (phoneNumber.val().length !== 10 || (typeof parseInt(phoneNumber.val()) !== "number")){
            form.submit(function (e) {
                e.preventDefault();
            });
            validPhoneNumber = false;
            $(this).css({
                "background-color" :   "#c78078"
            });
        } else {
            validPhoneNumber = true;
            $(this).css({
                "background-color" :   "#8ac77e"
            });
        }
    });

    $('#submit-btn').click(function(){
       if (validUsername && validEmail && validPassword && validGender && validStreet && validCity && validDob && validFirstName && validLastName && validZipcode && validState && validPhoneNumber){
           form.submit();
       } else {
           alert("Check form for errors");
       }
    });







});