"use strict";

function initMap() {
    var sanAntonio = {lat: 29.4241, lng: -98.4936};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 10,
        center: sanAntonio
    });

    var coder = new google.maps.Geocoder();
    var markers = [];

    function setMapOnAll(map) {
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(map);
        }
    }

    function addMarker(location) {
        // $('#search-bar').val(closestCity);
        setMapOnAll(map);
        var marker = new google.maps.Marker({
            position: location,
            animation: google.maps.Animation.DROP,
            map: map
        });
        markers.push(marker);
    }



// Removes the markers from the map, but keeps them in the array.
    function clearMarkers() {
        setMapOnAll(null);
    }

// Deletes all markers in the array by removing references to them.
    function deleteMarkers() {
        clearMarkers();
        markers = [];
    }


    function geoCodeIt(add){
        coder.geocode({
            address: add,
            componentRestrictions: {
                country: 'US'
            }
        }, function(results, status){
            if(status === "OK"){
                map.setCenter(results[0].geometry.location);
                map.setZoom(10);
                deleteMarkers();
                addMarker(results[0].geometry.location);
            } else {
                alert("Geocoding Error! - Status: " + status);
            }
        });
    }




//FINALLY!!!!!!!!!! OMG!!!!! I FINALLY GOT IT YA!!!!!!! HUZZAH!!!!!
    $('.view-btn').each(function(){
        $(this).click(function(){
            geoCodeIt($(this).next().next().next().text());
        })
    })





}