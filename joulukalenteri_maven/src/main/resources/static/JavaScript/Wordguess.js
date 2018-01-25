// Written by Hennileena Calonius 2017

var words = ["joulukuusi", "tonttu", "puurokauha", "tunnelma", "piparitalo", "glögi", "kynttilä",
            "joulumuori", "amaryllis", "kaneli", "konvehti", "silli", "lumiukko", "rosolli"];
var rightWord;
var context = document.getElementById("canvas").getContext("2d");
var context2 = document.getElementById("canvas2").getContext("2d");
var context3 = document.getElementById("canvas3").getContext("2d");
var wrongAnswer = 0;

function pickAWord() {
    var mixedWords = words.sort(function(a, b){return 0.5 - Math.random()});
    rightWord = mixedWords[0];
    createGame();
    wrongAnswer = 0;
    context2.clearRect(0, 0, 600, 72);
    context3.clearRect(0, 0, 600, 70);
    setPresents();
}

function createGame() {
    context.clearRect(0, 0, 600, 70);
    var circle1 = new Circle(58, 35, 20);
    var circle2 = new Circle(108, 35, 20);
    var circle3 = new Circle(158, 35, 20);
    var circle4 = new Circle(208, 35, 20);
    var circle5 = new Circle(258, 35, 20);
    var circle6 = new Circle(308, 35, 20);
    var circle7 = new Circle(358, 35, 20);
    var circle8 = new Circle(408, 35, 20);
    var circle9 = new Circle(458, 35, 20);
    var circle10 = new Circle(508, 35, 20);

    function Circle(x, y, r) {
        this.x = (x === null) ? 0 : x;
        this.y = (y === null) ? 0 : y;
        this.r = (r === null) ? 0 : r;
        this.fill = function (context) {
            context.beginPath();
            context.arc(this.x, this.y, this.r, 0, Math.PI * 2);
            context.fill();
        }
    }
    circle1.fill(context);
    circle2.fill(context);
    circle3.fill(context);
    circle4.fill(context);
    circle5.fill(context);
    if (rightWord.length > 5) {
        circle6.fill(context);
    }
    if (rightWord.length > 6) {
        circle7.fill(context);
    }
    if (rightWord.length > 7) {
        circle8.fill(context);
    }
    if (rightWord.length > 8) {
        circle9.fill(context);
    }
    if (rightWord.length > 9) {
        circle10.fill(context);
    }
}

function revealLetter(guessedLetter) {
    var letter1 = new Letter(50, 20, 20);
    var letter2 = new Letter(100, 20, 20);
    var letter3 = new Letter(150, 20, 20);
    var letter4 = new Letter(200, 20, 20);
    var letter5 = new Letter(250, 20, 20);
    var letter6 = new Letter(300, 20, 20);
    var letter7 = new Letter(350, 20, 20);
    var letter8 = new Letter(400, 20, 20);
    var letter9 = new Letter(450, 20, 20);
    var letter10 = new Letter(500, 20, 20);

    function Letter(x, y, r) {
        this.x = (x === null) ? 0 : x;
        this.y = (y === null) ? 0 : y;
        this.r = (r === null) ? 0 : r;
    }
    for (i = 0; i < rightWord.length; i++) {
        if (rightWord.charAt(i).toUpperCase() === guessedLetter.toUpperCase()) {
            context2.font="30px Georgia";
            context2.strokeText(guessedLetter, positionX(i), 70, 20);
        }
    }
}

function positionX(indeksi) {
    if (indeksi === 0) {
        x = 50;
    } else if (indeksi === 1) {
        x = 100;
    } else if (indeksi === 2) {
        x = 150;
    } else if (indeksi === 3) {
        x = 200;
    } else if (indeksi === 4) {
        x = 250;
    } else if (indeksi === 5) {
        x = 300;
    } else if (indeksi === 6) {
        x = 350;
    } else if (indeksi === 7) {
        x = 400;
    } else if (indeksi === 8) {
        x = 450;
    } else if (indeksi === 9) {
        x = 500;
    } else {
        x = 550;
    }
    return x;
}

function setPresents() {
    var present1 = new Image();
    var present2 = new Image();
    var present3 = new Image();
    var present4 = new Image();
    var present5 = new Image();
    present1.src = '/Pictures/gift.png';
    present2.src = '/Pictures/gift.png';
    present3.src = '/Pictures/gift.png';
    present4.src = '/Pictures/gift.png';
    present5.src = '/Pictures/gift.png';
    present1.onload = function(){
        context3.drawImage(present1, 50, 5);
    }
    present2.onload = function(){
        context3.drawImage(present2, 150, 5);
    }
    present3.onload = function(){
        context3.drawImage(present3, 250, 5);
    }
    present4.onload = function(){
        context3.drawImage(present4, 350, 5);
    }
    present5.onload = function(){
        context3.drawImage(present5, 450, 5);
    }
}

function letterCheck(guessedLetter) {
    if ((rightWord.toUpperCase()).indexOf(guessedLetter) > -1 ) {
        revealLetter(guessedLetter);
    } else {
        wrongAnswer++;
        if (wrongAnswer === 1) {
            loseFirstPresent();
        } else if (wrongAnswer === 2) {
            loseSecondPresent();
        } else if (wrongAnswer === 3) {
            loseThirdPresent();
        } else if (wrongAnswer === 4) {
            loseFourthPresent();
        } else {
            loseGame2();
        }
    }
}

function answerCheck() {
    var guessed = document.getElementById("guess");
    if (rightWord.toUpperCase() === (guessed.value).toUpperCase()) {
        winGame();
    } else {
        context.clearRect(0, 0, 600, 70);
        context2.clearRect(0, 0, 600, 72);
        loseGame();
    }
}

function loseFirstPresent() {
    var deleteIcon1 = new Image();
    deleteIcon1.src = '/Pictures/cancel.png';
    deleteIcon1.onload = function(){
        context3.drawImage(deleteIcon1, 50, 5);
    }
}

function loseSecondPresent() {
    var deleteIcon2 = new Image();
    deleteIcon2.src = '/Pictures/cancel.png';
    deleteIcon2.onload = function(){
        context3.drawImage(deleteIcon2, 150, 5);
    }
}

function loseThirdPresent() {
    var deleteIcon3 = new Image();
    deleteIcon3.src = '/Pictures/cancel.png';
    deleteIcon3.onload = function(){
        context3.drawImage(deleteIcon3, 250, 5);
    }
}

function loseFourthPresent() {
    var deleteIcon4 = new Image();
    deleteIcon4.src = '/Pictures/cancel.png';
    deleteIcon4.onload = function(){
        context3.drawImage(deleteIcon4, 350, 5);
    }
}

var loseModal = document.getElementById("loseModal");
var lose2Modal = document.getElementById("lose2Modal");
var winModal = document.getElementById("winModal");
var span1 = document.getElementsByClassName("closemodal1")[0];
var span2 = document.getElementsByClassName("closemodal2")[0];
var span3 = document.getElementsByClassName("closemodal3")[0];

function loseGame() {
    loseModal.style.display = "block";
    document.getElementById("correctWord1").innerHTML = rightWord.toUpperCase();
    pickAWord();
}

span1.onclick = function () {
    loseModal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == loseModal) {
        loseModal.style.display = "none";
    }
}

function loseGame2() {
    lose2Modal.style.display = "block";
    document.getElementById("correctWord2").innerHTML = rightWord.toUpperCase();
    pickAWord();
}

span2.onclick = function () {
    lose2Modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == lose2Modal) {
        lose2Modal.style.display = "none";
    }
}

function winGame() {
    winModal.style.display = "block";
    pickAWord();
}

span3.onclick = function () {
    winModal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == winModal) {
        winModal.style.display = "none";
    }
}

