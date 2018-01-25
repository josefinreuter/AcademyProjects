// Written by Josefin Reuter 2017
var sound = document.getElementById("sound");
sound.play();

var j = 0;
var match = 0;
var click = 0;
var firstImg, secondImg = 0;
document.getElementById("clicks").innerHTML = "Klikkauksia: " + click;

$('li').click(function() {
    click++;
    checkClicks(click);

    document.getElementById("clicks").innerHTML = "Klikkauksia: " + click;
    document.getElementById("point").innerHTML = "";

    //checks if the clicked window is already open, if is, closes
    if(j === 0){
        $('li').removeClass('disabled');
    }

    //marks the clicked window as open
    $(this).addClass('clicked');
    j++;

    //cheks if clicked window is first or second
    if(j === 1) {
        firstImg = $(this).text();
        $(this).addClass('disabled').removeClass('clicked');
    }
    if(j === 2){
        if($(this).hasClass('disabled')){
            $(this).removeClass('disabled').removeClass('clicked');
            j = 0;
        }else {
            secondImg = $(this).text();
            $(this).addClass('disabled').removeClass('clicked');
            checkCondition();
        }
    }
    //checks if all pairs are found
    if(match >= 16) {
        document.getElementById("congrats").innerHTML = "Onneksi olkoon, löysit kaikki parit " + click + " klikkauksella!";
    }
});

var checkCondition = function() {
    if(firstImg === secondImg) {
        $('li').each(function() {
            if($(this).hasClass('disabled')) {
                $(this).addClass('points').removeClass('disabled');
                match++;
            }
        });
        j = 0;
        if (match < 16){
        document.getElementById("point").innerHTML = "Löysit parin, sinulla on nyt " + (match / 2) + " paria!";
        }
    } else {
        j=0;
    }
};

var modal = document.getElementById('loosemodal');
var span = document.getElementsByClassName("closemodal")[0];

function checkClicks(clicks) {

    if(clicks >= 32){

        modal.style.display = "block";

        span.onclick = function () {
            modal.style.display = "none";
            window.location.reload()
        }

        window.onclick = function (event) {
            if (event.target === modal) {
                modal.style.display = "none";
                window.location.reload()
            }
        }

    }
}