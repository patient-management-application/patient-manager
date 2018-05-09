"use strict";

$(document).ready(function() {

    var docId = $('#doctorId').val();
    var myCalendar = $('#calendar');
    //Need a appointments.json
    var url = "/appointments.json?docId=" + docId;
    var events = [];
    var getApps = function(){
        $.get(url, function( data ) {
            data.forEach(function(event){
                event.title = event.patientName;
                event.start = new Date(event['dateCreated'] + ' ' + event['scheduledTime']);
                var scheduledEnd = parseInt(event['scheduledTime'].substring(0, 2));
                scheduledEnd = (++scheduledEnd + ":00");
                event.end = new Date(event['dateCreated'] + ' ' + scheduledEnd);
                events.push(event);
            });

            var curTime = new Date();
            events.forEach(function(e){
                if (Date.parse( e.start ) < curTime){
                    e.past = true;
                    e.color = "#929292";

                } else {
                    var deleteStr = e.start.toString();
                    deleteStr = deleteStr.substring(0, deleteStr.length-33);
                    $('#appointment-delete').append('<option name="id" value='+ e.id + ' >' + deleteStr + '</option>');
                }

                myCalendar.fullCalendar('renderEvent', e);
            });


        });
    };

    getApps();


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
        eventColor: "#489e72"
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