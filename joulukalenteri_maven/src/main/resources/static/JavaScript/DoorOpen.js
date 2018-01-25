// Written by Riina Purovesi & Hennileena Calonius 2017
var thisDate = new Date();

//This function checks which day it is and if the door can be opened - and if it's too early, the pop-up message will be shown.

function DoorOpen (day) { // Checks if current day is the same day than door's day (and month)

    if (( thisDate.getMonth() + 1 ) < 12 || thisDate.getDate() < day) {
        openModal();
        var fail= document.getElementById("fail");
        fail.play();
    } else {
        var link = links[day - 1] [0];
        window.open(link,'','scrollbars=1,height=600,width=800,left=350,top=100');
        var sound = document.getElementById("audio");
        sound.play();
        return false;
    }
}

// Below is the code for the modal element. This modal shows a message telling that the door cannot be opened yet.

    var modal = document.getElementById('doorModal');
    var span = document.getElementsByClassName("closemodal")[0];

    function openModal() {
        modal.style.display = "block";
    }

    span.onclick = function () {
        modal.style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

