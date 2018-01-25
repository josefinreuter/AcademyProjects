// Written by Riina Purovesi 2017

var laulut = [
    ["Enkeli taivaan", "Virsi 21", "1. Enkeli taivaan lausui näin:<br>Miks hämmästyitte säikähtäin?<br>Mä suuren ilon ilmoitan<br>maan kansoille nyt tulevan.<br><br>2. Herramme Kristus teille nyt<br>on tänään tänne syntynyt,<br>ja tää on teille merkiksi:<br>", "lapsi makaapi.<br><br><b>***</b><br>", "seimessä"],
    ["Joulupukki", "Säveltäjä: P. J. Hannikainen", "Joulupukki, joulupukki, valkoparta, vanha ukki.<br>Eikö taakka paina selkää?<br>Käypä tänne, emme pelkää!<br>Oothan meille vanha tuttu,", "karvanuttu.<br>Tääll´ on myöskin kiltit lapset, kirkassilmät, silkohapset.<br><br>Joulupukki, joulupukki, valkoparta, vanha ukki,<br>vietä iltaa joukossamme täällä meidän riemunamme.<br>Tervetullut meille aina, käypä tänne, puuta paina,<br>tai jos leikkiin tahdot tulla, kahta hauskempaa on sulla!<br><br>***", "puuhkalakki"],
    ["Heinillä härkien kaukalon", "Säv. Ranskalainen joululaulu", "1. Heinillä härkien kaukalon<br>nukkuu", "viaton.<br>Enkelparven tie<br> kohta luokse vie<br>rakkautta suurinta katsomaan.<br><br>2. Helmassa äitinsä armahan<br>nukkuu Poika Jumalan.<br>Enkelparven tie...<br><br> ***", "lapsi"],
    ["Joulupuu on rakennettu", "Säveltäjä: suomalainen kansansävelmä", "Joulupuu on rakennettu, joulu on jo ovella.<br>Namusia ripustettu ompi kuusen oksilla.<br><br>Kuusen pienet kynttiläiset valaisevat kauniisti.<br>Ympärillä lapsukaiset laulelevat sulosti.<br><br>Kiitos sulle, Jeesuksemme, kallis Vapahtajamme,<br>kun sä tulit vieraaksemme, paras", "<br>Tullessasi toit sä valon, lahjat rikkaat, runsahat.<br>Autuuden ja anteeks´annon, kaikki taivaan tavarat.<br><br>Anna, Jeesus, Henkes´ valon jälleen loistaa sieluumme<br>sytytellä uskon palon. Siunaa, Jeesus, joulumme.", "joululahjamme"],
    ["Joulupukki matkaan jo käy", "Lasten joululaulut", "1.Ei itkeä saa, ei meluta saa,<br>joku voi tulla ikkunan taa.<br>Joulupukki matkaan jo käy.<br><br> Nyt nimien kirjaan merkitään taas:<br> tuhma vai kiltti, ajatelkaas!<br> Joulupukki matkaan jo käy.<br><br> Taas pienet tontut liikkuu<br>ja muistiin merkitsee,<br>niin joulupukki tietää saa,<br> kuka", "ansaitsee.<br><br>Siis: Ei itkeä saa, ei meluta saa,<br> sopu on paljon mukavampaa.<br> Joulupukki matkaan jo käy.<br><br>***", "lahjat"],
    ["Näin sydämeeni joulun teet", "Kauneimmat joululaulut", "On jouluyö, sen hiljaisuutta<br>yksin kuuntelen,<br>ja sanaton on sydämeni kieli<br>Vain tähdet öistä avaruutta<br>pukee loistaen ja ikuisuutta kaipaa avoin mieli<br>Näin sydämeeni joulun teen<br>ja","hiljaiseen<br>taas Jeesus-lapsi syntyy uudelleen.", "mieleen"]
];
sn = 0;
var ov = 0;

document.getElementById("SongName").innerHTML = laulut[sn][0];
document.getElementById("sav").innerHTML = laulut[sn][1];
document.getElementById("words").innerHTML = laulut[sn][2];
document.getElementById("words2").innerHTML = laulut[sn][3];

var sana = laulut[sn][4];
var span1 = document.getElementsByClassName("closemodal1")[0];
var winning = document.getElementById("winning");
var form = document.getElementById("word1");

function CheckWord(enkeli) {
    if (sana == enkeli.toLowerCase()) { // Checks if the quessed word is correct
        sn++; // Increases the question number
        ov++; // Increases the amount of correct answers

        if (sn < laulut.length-1) { // If the question is the last questions, user will get different notification and the game will restart
            document.getElementById("voittaa").innerHTML = "Vastauksesi '" + enkeli + "' oli oikein! Hyvä! Sinulla on " + ov + "/6 pistettä.";
        } else {
            document.getElementById("correct").innerHTML = "Vastauksesi '" + enkeli + "' oli oikein! Hyvä! Peli päättyi! Sait " + ov + "/6 pistettä.";
            win();
        }
    } else {
        sn++; // Increases the question number
        if (sn < laulut.length-1) { // If the question is the last questions, user will get different notification and the game will restart
            document.getElementById("voittaa").innerHTML = "Vastauksesi '" + enkeli + "' on väärin! Oikea vastaus olisi ollut: '" + sana + "'. Sinulla on " + ov + "/6 pistettä.";
        }else {
            document.getElementById("correct").innerHTML = "Vastauksesi '" + enkeli + "' on väärin! Oikea vastaus olisi ollut: '" + sana + "'. Peli päättyi! Sait " + ov + "/6 pistettä.";
            win();
        }
    }
    document.getElementById("SongName").innerHTML = laulut[sn][0];
    document.getElementById("sav").innerHTML = laulut[sn][1];
    document.getElementById("words").innerHTML = laulut[sn][2];
    document.getElementById("words2").innerHTML = laulut[sn][3];
    sana = laulut[sn][4];
    form.reset();
}
function win() {
    winning.style.display = "block";
}
span1.onclick = function () {
    winning.style.display = "none";
    location.reload();
}
window.onclick = function (event) {
    if (event.target == winning) {
        winning.style.display = "none";
        location.reload();
    }
}

