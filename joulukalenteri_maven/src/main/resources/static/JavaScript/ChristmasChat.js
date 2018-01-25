// Written by Riina Purovesi 2017
var number = 0;
var qstn = '<h1>Tervetuloa JouluChattiin!<br>Kerro nimesi: </h1>';

var output = document.getElementById('chatti');
output.innerHTML = qstn;

$(document).keypress(function(e) { // User can submit text by pressing Enter
    if (e.which == 13) {
        chatbot();
        number++;
    }
});

function chatbot() { // This function reads user's submits and shows questions/comments
    var user = document.getElementById("teksti").value;

    if (number == 0) {
        var x = user.toLowerCase();
        if (x == "en kerro" || x == "" || x == " " || x=="en" || x=="e") {
            emptydis();
            qstn = '<h1>Ei sitten. Aloitetaanpa alusta.</h1>';
            endChat();
        } else {
            output.innerHTML = '<h1>Hei ' + user + '!</h1>';
            emptydis();
            qstn = '<h1>Odotatko jo joulua?</h1>';
            setTimeout(timedQuestion, 2000);
        }
    }
    else if (number == 1) {
        var x = user.toLowerCase();
        if (x == "joo" || x == "ehkä" || x == "joo!" || x == "tottakai" || x == "tietysti" || x == "miksei?" || x == "jooo" || x == "ehdottomasti" || x == "j" || x == "juu" || x == "kyllä" ||x=="odotan" ||x=="todellakin") {
            output.innerHTML = '<h1>Kiva kuulla! Niin minäkin.</h1>';
            emptydis();
            qstn = '<h1>Koetko olleesi kiltti tänä vuonna?</h1>';
            setTimeout(timedQuestion, 2000);
        } else {
            emptydis();
            qstn = '<h1>OK! Ei sitten. Mene muualle jakamaan tuota huonoa joulumieltäsi ja anna vuoro seuraavalle.</h1>';
            endChat();
        }
    }
    else if (number == 2) {
        var x = user.toLowerCase();
        if (x == "joo" || x == "ehkä" || x == "joo!" || x == "tottakai" || x == "tietysti" || x == "miksei?" || x == "jooo" || x == "ehdottomasti" || x == "j" || x == "juu" || x == "kyllä" || x=="toki" ||x=="todellakin") {
            output.innerHTML = '<h1>Hyvä. Saatat siis saada joululahjoja tänä vuonna.</h1>';
            emptydis();
            qstn = '<h1>Kerro jokin asia, mitä toivoisit kaikkein eniten joululahjaksi?</h1>';
            setTimeout(timedQuestion, 2000);
        } else {
            emptydis();
            qstn = '<h1>Selvä. Kannattaisi olla kiltimpi, niin saisit joskus lahjojakin.. Annetaan vuoro seuraavalle.</h1>';
            endChat();
        }
    }
    else if (number == 3) {
        var x = user.toLowerCase();
        if (x == "en kerro" || x == "" || x == " " || x=="en" || x=="e") {
            emptydis();
            qstn = '<h1>Selvä. En voi sitten toteuttaa toiveitasi. Kokeillaan paremmalla ajalla uudelleen.</h1>';
            endChat();
        } else if(x=="koira" || x=="kissa" || x=="pupu") {
            output.innerHTML = '<h1>Vai että haluat '+user.toLowerCase()+'n lemmikiksi. Haluatko että välitän toiveesi joulupukille?</h1>';
            document.getElementById("teksti").value = "";
        }
        else
        output.innerHTML = '<h1>Toivomuksesi ' + user.toLowerCase() + ' vastaanotettu. Haluatko että välitän toiveesi joulupukille?</h1>';
        document.getElementById("teksti").value = "";
    }
    else if (number == 4) {
        var x = user.toLowerCase();
        if (x == "joo" || x == "ehkä" || x == "joo!" || x == "tottakai" || x == "tietysti" || x == "miksei?" || x == "jooo" || x == "ehdottomasti" || x == "j" || x == "juu" || x == "kyllä") {
            output.innerHTML = '<h1>Toiveesi on välitetty korvatunturille!</h1>';
            emptydis();
            qstn = '<h1>Haluaisitko nähdä tonttuja?</h1>';
            setTimeout(timedQuestion, 2000);
        } else {
            emptydis();
            qstn = '<h1>OK! Ei sitten. Mene muualle jakamaan tuota huonoa joulumieltäsi ja anna vuoro seuraavalle.</h1>';
            endChat();
        }
    }
    else if (number == 5) {
        var x = user.toLowerCase();
        if (x == "joo" || x == "ehkä" || x == "joo!" || x == "tottakai" || x == "tietysti" || x == "miksei?" || x == "jooo" || x == "ehdottomasti" || x == "j" || x == "juu" || x == "kyllä") {
            emptydis();
            qstn = '<h1>EI onnistu! HAHAHAHAHA. Peli päättyi.</h1>';
            endChat();
        } else {
            emptydis();
            qstn = '<h1>TIPTAPTIPTATIPPETIPPETIPTAP TIP TIP TAP!</h1>';
            endChat();
        }
    }
}
function emptydis() {
    document.getElementById("teksti").value = "";
    document.getElementById("teksti").disabled = true;
}

function timedQuestion() {
    output.innerHTML = qstn;
    document.getElementById("teksti").disabled = false;
    document.getElementById("teksti").value = "";
}
function endChat() {
    output.innerHTML = qstn;
    document.getElementById("teksti").value = "";
    setTimeout((function() {window.location.reload();}), 4000);
}