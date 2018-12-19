(function ($) {

    $(document).ready(function () {

        var API_URL = '/Data';
        var error_message = 'No Data available right now.';
        var $tableSelector = $('table#data');

        var secret = '${Secret}';

        var $tableBody = $tableSelector.find('tbody');

        function getItems(success, error) {
            $.ajax({
                url: API_URL,
                method: 'GET'
            }).done(function (response) {
                success(response);
            }).fail(function (response) {
                error();
                console.log(response);
            });

        }

        function renderRowErrorMessage() {
            var $row = $('<tr></tr>');
            var $cell = $('<td></td>').text(error_message);
            $row.append($cell);
            $tableBody.append($row);
        }

        function renderTable(items) {

            items.forEach(function (item) {
                var $tr = $('<tr></tr>');


                Object.values(item).forEach(function (value) {
                    if (item.id != value) {
                        $tr.append('<td>' + value + '</td>');
                    }
                });
                if($('#Secret').val() != "") {
                    $tr.append('<td><a href="/Delete/' + item.id + '"  class="delete btn">Delete</a></td>');
                    $tr.append('<td><a href="/Update/' + item.id + '"  class="btn">Edit</a></td>');
                }
                $tableBody.append($tr);

            });
        }

        if ($tableSelector.length > 0) {
            getItems(function (listOfItems) {
                renderTable(listOfItems);
            }, function () {
                renderRowErrorMessage();
            });
        }

    });

})(jQuery);