var listItems = document.getElementsByClassName("form-control");
var orderButton = document.getElementById("orderButton");
var addOrder = document.getElementById("addOrder");
orderButton.addEventListener("click", activateItem);
addOrder.addEventListener("click", clearText);

function activateItem() {
	var name = listItems[0].value;
	var date = listItems[1].value;
	var place = listItems[2].value;
	var description = listItems[3].value;
	var contact = listItems[4].value;

	var request = new XMLHttpRequest();
	var url = "/offers";
	var params = '{"name":"' + name + '","place":"' + place + '","date":"' + date + '","contact":"' + contact + '","description":"' + description + '"}'
	request.open("POST", url, true);
	request.setRequestHeader("Content-type", "application/json");
    request.onreadystatechange = function() {//Call a function when the state changes.
    	if(request.readyState == 4 && request.status == 200) {
    		displayCurrentOffer();
    	}
    }
	request.send(params);
}

function displayCurrentOffer() {
    var request = new XMLHttpRequest();
    var url = "/offers";
    request.open("GET", url, true);

    request.onload = function() {
        var offersList = JSON.parse(request.responseText);
        maxOfferId = offersList.length;
        displaySingleOffer(maxOfferId);
    }
    request.send();
}

function displaySingleOffer(index) {
    var request = new XMLHttpRequest();
    var url = "/offers/" + index;
    request.open("GET", url, true);

    request.onload = function() {
        listOffer(JSON.parse(request.responseText));
    }
    request.send();
}

function clearText() {
    for (i = 0; i < listItems.length; i++) {
        listItems[i].value = "";
    }
}