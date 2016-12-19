function displayAllOffers() {
    var xhttp = new XMLHttpRequest();
    var url = "/offers";
    xhttp.open("GET", url, true);
    xhttp.onload = function() {
        var offersList = JSON.parse(xhttp.responseText);
        console.log(offersList.length);
        if (this.readyState == 4 && this.status == 200) {
             for (var i = 0; i < offersList.length; i++) {
                    displayOffer(offersList[i])
                }
        }
    };
    xhttp.send();
}

function displayOffer(offer) {
console.log("HERE");
    var string = 'https://placehold.it/150x80?text=IMAGE';
    var objTo = document.getElementById('main-container')
    var divtest = document.createElement("div");
    divtest.className = "col-sm-4";
    console.log("HERE2");

    var pannelPrimary = document.createElement("div");
	pannelPrimary.className = "panel panel-primary";
	divtest.appendChild(pannelPrimary);
    console.log("HERE3");

	var dishImage = document.createElement("img");
	dishImage.src = string;
	dishImage.style = "width:100%";
	dishImage.className = "img-responsive";
	pannelPrimary.appendChild(dishImage);
    console.log("HERE4");

    var pannelFooter = document.createElement("div");
    pannelFooter.className = "panel-footer";
	pannelPrimary.appendChild(pannelFooter);
    console.log("HERE5");

    pannelFooter.innerHTML = offer.name + "<br>" + offer.date + "<br>" + offer.place + "<br>" + offer.contact;
    objTo.appendChild(divtest);
    console.log("HERE6");
}

