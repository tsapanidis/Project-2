(function ($) {

    $(document).ready(function () {

        var array = document.getElementsByTagName("SELECT");

        function run(items) {
            for ( var i = 0;i< items.length;i++) {
                if (items[i].id != "") {
                    var id = '#'+items[i].id;
                    $(id).val(items[i].id).prop('selected', true);
                }
            }
        }
        run(array);




    });

})(jQuery);