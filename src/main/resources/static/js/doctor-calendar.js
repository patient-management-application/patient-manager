"use strict";

$(document).ready(function() {

    var docId = $('#doctorId').val();
    var patId = $('#patientId').val();
    var patientName = $('.patientName').val();
    console.log(patientName);


    var myCalendar = $('#calendar');
    //Need a appointments.json
    var url = "/appointments.json?docId=" + docId;
    var events = [];
    var getApps = function(){
        $.get(url, function( data ) {
            data.forEach(function(event){
                event.title = patientName;
                event.start = new Date(event['dateCreated'] + ' ' + event['scheduledTime']);
                var scheduledEnd = parseInt(event['scheduledTime'].substring(0, 2));
                scheduledEnd = (++scheduledEnd + ":00");
                event.end = new Date(event['dateCreated'] + ' ' + scheduledEnd);
                events.push(event);
            });

            events.forEach(function(e){
                myCalendar.fullCalendar('renderEvent', e);
            });

        });
    };

    getApps();



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
    //         title:"My Appointment",
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
    //     if (!validEvent){
    //         return;
    //     } else {
    //         events.push(newApp);
    //         //    create a new post and add to database!
    //
    //     }
    //     myCalendar.fullCalendar( 'renderEvent', newApp);
    //
    // });

    myCalendar.fullCalendar({
        defaultView: 'agendaWeek',
        allDaySlot : false,
        businessHours: {
            dow: [ 1, 2, 3, 4, 5 ], // Monday - Thursday
            start: '09:00', // a start time (10am in this example)
            end: '17:00' // an end time (6pm in this example)
        },
        minTime : '09:00',
        maxTime : '19:00',
        nowIndicator: true,
        eventColor: "#9e9e9e"
    });

    $('.fc-prev-button').click(function(){
        events.forEach(function(e){
            myCalendar.fullCalendar('renderEvent', e);
        });
    });
    $('.fc-next-button').click(function(){
        events.forEach(function(e){
            myCalendar.fullCalendar('renderEvent', e);
        });
    });
    $('.fc-today-button').click(function(){
        events.forEach(function(e){
            myCalendar.fullCalendar('renderEvent', e);
        });
    });


});