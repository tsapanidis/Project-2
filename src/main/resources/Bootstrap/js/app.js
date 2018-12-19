jQuery(function ($) {

    // $.validator.addMethod("plate", function (value) {
    //     return /[A-Z]{3}-[0-9]{4}/.test(value)
    // })

    function validateUserCreate() {
        $('#create-user').validate({
            rules: {
                vat: {
                    required: true,
                    minlength: 9,
                    maxlength: 9,
                    digits: true
                },
                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },
                address: {
                    required: true,
                    pattern: "[A-Za-z]+\\s[0-9]+"
                },
                password: {
                    required: true
                },
                plate: {
                    required: true,
                    //plate : true
                },
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                vat: {
                    required: 'Please enter your vat',
                    minlength: 'Vat should be 9 digits',
                    maxlength: 'Vat should be 9 digits',
                    digits: 'Vat should contain only digits'
                },
                address:{
                    required: 'Please enter your address',
                    pattern: 'Incorrect type of address'
                },
                plate:{
                    pattern: 'Type of plate AAA-123'
                }
            }
        });
    }

    //validateUserCreate();

    if($('input#dateListing')) {
        $('input#dateListing').datepicker({
            format: 'dd/mm/yyyy'
        });
    }

    if ($('.button-delete-confirmation')) {

        $('.button-delete-confirmation').click(function (e) {

            $('#dialog-delete-confirmation').dialog({
                autoOpen: false,
                modal: true
            });
        });
    }

});
