var doctors = [];
$('.doctorId').each(function(){
    var id = $(this).val();
    doctors.push(parseInt(id));
});

for (var i = 0; i < doctors.length; i++) {
    var cumulativeRating = [];
    console.log(cumulativeRating);

    $('.rating').each(function () {
        var docId = $(this).attr('name');
        if (parseInt(docId) === doctors[i]){
            var rating = $(this).text();
            cumulativeRating.push(parseInt(rating));
        }
    });

    var sum = 0;
    cumulativeRating.forEach(function(rating){
        sum += rating;
    });
    var avg = (sum / cumulativeRating.length).toFixed(1);
    console.log(avg);


    var doctorRatingDiv = $('.doctor-rating');
    if(avg !== "NaN"){
        doctorRatingDiv.get(i).innerHTML = "<h4>Rating: " + avg + "</h4>";
        doctorRatingDiv.get(i).innerHTML += "<h4>Reviews: " + cumulativeRating.length + "</h4>";
    } else {
        doctorRatingDiv.get(i).innerHTML = "<h4>Unrated</h4>";
        doctorRatingDiv.get(i).innerHTML += "<h4>Reviews: " + cumulativeRating.length + "</h4>";
    }
    // if (parseInt(doctorRatingDiv.attr('name')) === doctors[i]){
    // }
//    Get the index of the doctor in the doctor array
//    compare the index of rating div to doctor index;


}
