<!--Written by Riina Purovesi 2017-->

var winning = document.getElementById("winning");
var m2 = document.getElementById("move1");
var m3 = document.getElementById("move2");
var m4 = document.getElementById("move3");
var m5 = document.getElementById("move4");
var m6 = document.getElementById("move5");

var span1 = document.getElementsByClassName("closemodal1")[0];
var span2 = document.getElementsByClassName("closemodal2")[0];
var span3 = document.getElementsByClassName("closemodal3")[0];
var span4 = document.getElementsByClassName("closemodal4")[0];
var span5 = document.getElementsByClassName("closemodal5")[0];
var span6 = document.getElementsByClassName("closemodal6")[0];

function win() {
    winning.style.display = "block";
}
span1.onclick = function () {
    winning.style.display = "none";
}
window.onclick = function (event) {
    if (event.target == winning) {
        winning.style.display = "none";
    }
}

function moveObject1() {
    m2.style.display = "block";
}

span2.onclick = function () {
    m2.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == m2) {
        m2.style.display = "none";
    }
}
function moveObject2() {
    m3.style.display = "block";
}

span3.onclick = function () {
    m3.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == m3) {
        m3.style.display = "none";
    }
}
function moveObject3() {
    m4.style.display = "block";
}

span4.onclick = function () {
    m4.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == m4) {
        m4.style.display = "none";
    }
}

function moveObject4() {
    m5.style.display = "block";
}

span5.onclick = function () {
    m5.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == m5) {
        m5.style.display = "none";
    }
}

function moveObject5() {
    m6.style.display = "block";
}

span6.onclick = function () {
    m6.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == m6) {
        m6.style.display = "none";
    }
}

// Functions for different movements when pressing the buttons
function move1() {
    var elem = document.getElementById("anim");
    var pos = 0;
    var id = setInterval(frame, 10);
    function frame() {
        if (pos == 150) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.top = pos + 'px';
            elem.style.left = pos + 'px';
        }
    }setTimeout(function(){win()}, 2000);

}
function move2() {
    var elem = document.getElementById("anim");
    var pos = 0;
    var id = setInterval(frame, 1);
    function frame() {
        if (pos == 400) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.bottom = pos + 'px';
        }
    }setTimeout(function(){moveObject1()}, 2000)
    $("#anim").animate({'left':'300','opacity':'0'}, 2000, function(){

        $(this).css({'left':'0','opacity':'1'});
        normal();
    });
}
function move3() {
    var elem = document.getElementById("anim");
    var pos = 0;
    var id = setInterval(frame, 1);

    function frame() {
        if (pos == 200) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.top = pos + 'px';
        }
    }setTimeout(function(){moveObject2()}, 2000)
    $("#anim").animate({'left':'300','opacity':'0'}, 2000, function(){

        $(this).css({'left':'0','opacity':'1'});
        normal();
    });
}
function move4() {
    var elem = document.getElementById("anim");
    var pos = 0;
    var id = setInterval(frame, 1);

    function frame() {
        if (pos == 200) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.left = pos + 'px';
            elem.style.top = pos + 'px';
        }
    }setTimeout(function(){moveObject3()}, 2000)
    $("#anim").animate({'left':'300','opacity':'0'}, 2000, function(){

        $(this).css({'left':'0','opacity':'1'});
        normal();

    });
}
function move5() {
    var elem = document.getElementById("anim");
    var pos = 0;
    var id = setInterval(frame, 1);
    function frame() {
        if (pos == 200) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.right = pos + 'px';
            elem.style.top = pos + 'px';
        }
    }setTimeout(function(){moveObject4()}, 2000)
    $("#anim").animate({'left':'300','opacity':'0'}, 2000, function(){

        $(this).css({'left':'0','opacity':'1'});
        normal();
    });
}
function move6() {
    var elem = document.getElementById("anim");
    var pos = 0;
    var id = setInterval(frame, 1);
    function frame() {
        if (pos == 600) {
            clearInterval(id);
        } else {
            pos++;
            elem.style.bottom = pos + 'px';
        }
    }setTimeout(function(){moveObject5()}, 2000)
    $("#anim").animate({'left':'300','opacity':'0'}, 2000, function(){

        $(this).css({'left':'0','opacity':'1'});
        normal();
    });
}
// This function returns the hat back to its original position
function normal() {
    $("#anim").animate({'left':'100', 'top': '100', 'opacity':'0'}, 3000, function(){

        $(this).css({'left':'0', 'top':'10', 'padding-left':'10', 'opacity':'1'});
    });
}