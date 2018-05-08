(function($) {
    var request = $.ajax({'url': '/appointments.json'});
    request.done(function (appointments) {
        var html = '';
        appointments.forEach(function(appointment) {
            html += '<div>';
            html += '<h1>' + appointment.firstName + '</h1>';
            html += '</div>';
        });
        $('#appointments').html(html);
    });
})(jQuery);