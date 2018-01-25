// Written by Josefin Reuter 2017

var context = document.getElementById("canvas").getContext("2d");
var score = 0;
document.getElementById("points").innerHTML = "Sinulla on " + score + " pistettä.";

var lucia = new Image();
var christmas = new Image();
var gingerbread = new Image();

lucia.src = '/Pictures/lussebulle.png';
christmas.src = '/Pictures/joulutorttu.png';
gingerbread.src = '/Pictures/gingerbread.png';

lucia.onload = function () {
    context.drawImage(lucia, 50, 5)
}

christmas.onload = function () {
    context.drawImage(christmas, 240, 5)
}

gingerbread.onload = function () {
    context.drawImage(gingerbread, 430, 5)
}

function Buns() {
    makeBunArray();
    context.clearRect(0, 0, 600, 150);
}

function makeBunArray() {
    var lucia1 = new Image();
    var christmas1 = new Image();
    var gingerbread1 = new Image();
    var silli1 = new Image();

    var lucia2 = new Image();
    var christmas2 = new Image();
    var gingerbread2 = new Image();
    var silli2 = new Image();

    var lucia3 = new Image();
    var christmas3 = new Image();
    var gingerbread3 = new Image();
    var silli3 = new Image();

    lucia1.src = '/Pictures/lussebulle.png';
    lucia2.src = '/Pictures/lussebulle.png';
    lucia3.src = '/Pictures/lussebulle.png';

    christmas1.src = '/Pictures/joulutorttu.png';
    christmas2.src = '/Pictures/joulutorttu.png';
    christmas3.src = '/Pictures/joulutorttu.png';

    gingerbread1.src = '/Pictures/gingerbread.png';
    gingerbread2.src = '/Pictures/gingerbread.png';
    gingerbread3.src = '/Pictures/gingerbread.png';

    silli1.src = '/Pictures/silli.png';
    silli2.src = '/Pictures/silli.png';
    silli3.src = '/Pictures/silli.png';

    var guess1 = [lucia1, christmas1, gingerbread1, silli1];
    var guess2 = [lucia2, christmas2, gingerbread2, silli2];
    var guess3 = [lucia3, christmas3, gingerbread3, silli3];

    drawBuns(guess1, guess2, guess3);
}

function drawBuns(guess1, guess2, guess3) {

    var length = guess1.length;

    var rnd1 = Math.floor(Math.random() * length);
    var rnd2 = Math.floor(Math.random() * length);
    var rnd3 = Math.floor(Math.random() * length);

    guess1[rnd1].onload = function () {
        context.drawImage(guess1[rnd1], 50, 5);
    }

    guess2[rnd2].onload = function () {
        context.drawImage(guess2[rnd2], 240, 5);
    }

    guess3[rnd3].onload = function () {
        context.drawImage(guess3[rnd3], 430, 5);
    }

    testSame(rnd1, rnd2, rnd3);
}

function testSame(rnd1, rnd2, rnd3) {
    console.log(rnd1, rnd2, rnd3);

    if(rnd1 === 0 && rnd1 === rnd2 && rnd1 === rnd3){
        score += 100;
        document.getElementById("result").innerHTML = "WAU, sait parhaan mahdollisen tuloksen! \n Luciapullat ovat parhaita, 100 pistettä!!";
        document.getElementById("points").innerHTML = "Sinulla on nyt " + score + " pistettä.";
    }else if(rnd1 === 1 && rnd1 === rnd2 && rnd1 === rnd3){
        score += 50;
        document.getElementById("result").innerHTML = "Mmmm, kolme joulutorttua! \n Tästä saat 50 pistettä.";
        document.getElementById("points").innerHTML = "Sinulla on nyt " + score + " pistettä.";
    }else if(rnd1 === 2 && rnd1 === rnd2 && rnd1 === rnd3){
        score += 20;
        document.getElementById("result").innerHTML = "Hmmmmm, kolme piparkakkua, ei mikään lemppari. Mutta ovathan nämä söpöjä.. \n Saat 20 pistettä.";
        document.getElementById("points").innerHTML = "Sinulla on nyt " + score + " pistettä.";
    }else if(rnd1 === 3 && rnd1 === rnd2 && rnd1 === rnd3){
        score -= 100;
        document.getElementById("result").innerHTML = "HYI, kolme SILLIÄ!!!!! \n Tästä tulee kyllä miinuspisteitä, 100 kappaletta!";
        document.getElementById("points").innerHTML = "Sinulla on nyt " + score + " pistettä.";
    }else {
        document.getElementById("result").innerHTML = "Aiai, ei ihan putkeen mennyt.. \n Tästä ei tullut pisteitä.";
        document.getElementById("points").innerHTML = "Sinulla on " + score + " pistettä.";
    }

}