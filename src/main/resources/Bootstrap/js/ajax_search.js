(function ($) {

    $('form').on('submit',function (e) {

        e.preventDefault();

        var API_URL = "/"+$(HTMLHeadElement).find('title').text()+'/search';
        var error_message = 'No Data available right now.';
        var $tableSelector = $('table#data');

        var data = $('form').serialize();

        var $tableBody = $tableSelector.find('tbody');

        function getItems(success, error) {
            $.ajax({
                url: API_URL,
                method: 'GET',
                data:data
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
                    $tr.append('<td><a href="/Delete/' + item.id + '" class="delete btn">Delete</a></td>');
                    $tr.append('<td><a href="/Update/' + item.id + '"  class="btn">Edit</a></td>');
                }
                $tableBody.append($tr);

            });
        }

        $tableBody.empty();

        if ($tableSelector.length > 0) {
            getItems(function (listOfItems) {
                renderTable(listOfItems);
            }, function () {
                renderRowErrorMessage();
            });
        }

    });

})(jQuery);