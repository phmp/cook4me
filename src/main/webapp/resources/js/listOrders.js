function listAllOffers() {
    var request = new XMLHttpRequest();
    var url = "/offers";
    request.open("GET", url, true);

    request.onload = function() {
        var offersList = JSON.parse(request.responseText);
        if(this.readyState == 4 && this.status == 200) {
             for(var i = 0; i < offersList.length; i++) {
                listOffer(offersList[i])
             }
        }
    }
    request.send();
}

function listOffer(offer) {
    var imagePath = "../dummyDish.png";
    var objTo = document.getElementById('main-container')
    var offerDiv = document.createElement("div");
    offerDiv.className = "col-sm-4";

    var pannelPrimary = document.createElement("div");
	pannelPrimary.className = "panel panel-primary";
	offerDiv.appendChild(pannelPrimary);

	var dishImage = document.createElement("img");
	dishImage.src = imagePath;
	dishImage.style = "width:100%";
	dishImage.className = "img-responsive";
	pannelPrimary.appendChild(dishImage);

    var pannelFooter = document.createElement("div");
    pannelFooter.className = "panel-footer";
	pannelPrimary.appendChild(pannelFooter);

    pannelFooter.innerHTML = offer.name + "<br>" + offer.date + "<br>" + offer.place + "<br>" + offer.description + "<br>" + offer.contact;
    objTo.appendChild(offerDiv);
}

