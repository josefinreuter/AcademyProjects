// Written by Josefin Reuter 2017

var jokes = ["Miksi joulupukki meni psykiatrille? \n Hän ei enää uskonut itseensä.",
    "Mikä on narsistin joululaulu? \n Mää oon niin kaunis.",
    "Mitä tapahtui tontulle joka hukkasi lakkinsa? \n Siltä jäätyi korva tunturilla",
    "Miksi joulupukilla on poro pulkan edessä? \n Koska elefantin varpaita palelee pakkasella.",
    "Mikä on huonomuististen joululaulu? \n Koska meillä on joulu?",
    "Mikä on suurempi kuin joulukuusi? \n Jouluseitsemän.",
    "Mikä on majavien joululaulu? \n Joulupuu on nakerrettu.",
    "Mitä merkittävää tapahtui Suomessa 24.12.1965? \n Silloin oli jouluaatto.",
    "Miksi joulupukki ajaa poroilla tuntureiden yli? \n Koska ei pääse niiden läpi.",
    "Mitä joulupukki pelkää? \n Säkkipimeää."];

document.getElementById("joke").innerHTML = jokes[0];

function NextJoke() {
    var sound= document.getElementById("sound");
    sound.play();
    getNext();
}

function getNext() {
    var length = jokes.length;
    var rnd = Math.floor(Math.random() * length);
    document.getElementById("joke").innerHTML = jokes[rnd];

}