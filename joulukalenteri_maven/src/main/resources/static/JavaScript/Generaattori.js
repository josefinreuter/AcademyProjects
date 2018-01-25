// Written by Hennileena Calonius 2017
function tonttuName() {
    var originalName = document.getElementById("originalname");
    var firstLetter = ((originalName.value).substring(0, 1)).toUpperCase();
    function convertName() {
        if (firstLetter === "A") {
            tonttuName = (originalName.value).toUpperCase() + " ANISKARKKI";
            return tonttuName;
        } else if (firstLetter === "B") {
            tonttuName = (originalName.value).toUpperCase() + " BEBELEIVOS";
            return tonttuName;
        } else if (firstLetter === "D") {
            tonttuName = (originalName.value).toUpperCase() + " DOMINOTONTTU";
            return tonttuName;
        } else if (firstLetter === "E") {
            tonttuName = (originalName.value).toUpperCase() + " ELÄINTONTTU";
            return tonttuName;
        } else if (firstLetter === "F") {
            tonttuName = (originalName.value).toUpperCase() + " FAFASTONTTU";
            return tonttuName;
        } else if (firstLetter === "G") {
            tonttuName = (originalName.value).toUpperCase() + " GLÖGINLIPITTÄJÄ";
            return tonttuName;
        } else if (firstLetter === "H") {
            tonttuName = (originalName.value).toUpperCase() + " HERKUTTELIJATONTTU";
            return tonttuName;
        } else if (firstLetter === "I") {
            tonttuName = (originalName.value).toUpperCase() + " ILOTONTTU";
            return tonttuName;
        } else if (firstLetter === "J") {
            tonttuName = (originalName.value).toUpperCase() + " JALOTONTTU";
            return tonttuName;
        } else if (firstLetter === "K") {
            tonttuName = (originalName.value).toUpperCase() + " KUURAPARTA";
            return tonttuName;
        } else if (firstLetter === "L") {
            tonttuName = (originalName.value).toUpperCase() + " LOMATONTTU";
            return tonttuName;
        } else if (firstLetter === "M") {
            tonttuName = (originalName.value).toUpperCase() + " MERITONTTU";
            return tonttuName;
        } else if (firstLetter === "N") {
            tonttuName = (originalName.value).toUpperCase() + " NAMITONTTU";
            return tonttuName;
        } else if (firstLetter === "O") {
            tonttuName = (originalName.value).toUpperCase() + " OLKITONTTU";
            return tonttuName;
        } else if (firstLetter === "P") {
            tonttuName = (originalName.value).toUpperCase() + " PIPARIMASSU";
            return tonttuName;
        } else if (firstLetter === "R") {
            tonttuName = (originalName.value).toUpperCase() + " RIIHITONTTU";
            return tonttuName;
        } else if (firstLetter === "S") {
            tonttuName = (originalName.value).toUpperCase() + " SAUNATONTTU";
            return tonttuName;
        } else if (firstLetter === "T") {
            tonttuName = (originalName.value).toUpperCase() + " TONTTU";
            return tonttuName;
        } else if (firstLetter === "U") {
            tonttuName = (originalName.value).toUpperCase() + " UNITONTTU";
            return tonttuName;
        } else if (firstLetter === "V") {
            tonttuName = (originalName.value).toUpperCase() + " VALETONTTU";
            return tonttuName;
        } else if (firstLetter === "Y") {
            tonttuName = (originalName.value).toUpperCase() + " YÖKUKKUJA";
            return tonttuName;
        } else {
            tonttuName = (originalName.value).toUpperCase() + " HUPSUTONTTU";
            return tonttuName;
        }
    }
    var tonttuName = document.getElementById("tonttu");
    tonttuName.value = convertName();
}