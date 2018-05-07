"use strict";

$(document).ready(function() {


    $('#calendar').fullCalendar({
        defaultView: 'agendaWeek'
    });



    // var url = "events.json";
    // var events = [];
    // var getApps = function(){
    //     $.get(url, function( data ) {
    //         data.forEach(function(event){
    //             event.start = new Date(event.start.toString());
    //             event.end = new Date(event.end.toString());
    //             events.push(event);
    //             console.log(events);
    //         });
    //         events.forEach(function(e){
    //             myCalendar.fullCalendar('renderEvent', e);
    //         });
    //     });
    // };

    // getApps();
    //
    // $('#done').click(function(){
    //     var date = $('#date-picker').val();
    //     var time = $('#time-picker').val();
    //     var endTime = time.toString();
    //     endTime = parseInt(endTime.substring(0, 2));
    //     endTime = (++endTime + ":00");
    //     var validEvent = true;
    //
    //     var newApp = {
    //         title:"App w/ {username}",
    //         allDay: false,
    //         start: new Date(date + ' ' + time),
    //         end: new Date(date + ' ' + endTime)
    //     };
    //
    //
    //     events.forEach(function(event){
    //         if (newApp.start.toString() === event.start.toString()){
    //             alert("CONFLICTING APPOINTMENT!");
    //             validEvent = false;
    //             console.log(validEvent);
    //         }
    //     });
    //
    //
    //     if (!validEvent){
    //         return;
    //     } else {
    //         events.push(newApp);
    //     }
    //     myCalendar.fullCalendar( 'renderEvent', newApp);
    //
    // });
    //
    //
    // myCalendar.fullCalendar({
    //     defaultView: 'agendaWeek'
    // });
    //
    // $('.fc-prev-button').click(function(){
    //     events.forEach(function(e){
    //         myCalendar.fullCalendar('renderEvent', e);
    //     });
    // });
    // $('.fc-next-button').click(function(){
    //     events.forEach(function(e){
    //         myCalendar.fullCalendar('renderEvent', e);
    //     });
    // });
    // $('.fc-today-button').click(function(){
    //     events.forEach(function(e){
    //         myCalendar.fullCalendar('renderEvent', e);
    //     });
    // });


});