var listItems = document.getElementsByClassName("form-control");
var orderButton = document.getElementById("orderButton");
var addOrder = document.getElementById("addOrder");
orderButton.addEventListener("click", activateItem);
addOrder.addEventListener("click", clearText);

var orders;

function activateItem() {
	var name = listItems[0].value;
	var date = listItems[1].value;
	var place = listItems[2].value;
	var description = listItems[3].value;
	var contact = listItems[4].value;

	var http = new XMLHttpRequest();
	var url = "/offers";
	var params = '{"name":"' + name + '","place":"' + place + '","date":"' + date + '","contact":"' + contact + '","description":"' + description + '"}'
	http.open("POST", url, true);
	http.setRequestHeader("Content-type", "application/json");
    http.onreadystatechange = function() {//Call a function when the state changes.
    	if(http.readyState == 4 && http.status == 200) {
    		loadDoc();
    	}
    }

	http.send(params);
}

function clearText() {
    for (i = 0; i < listItems.length; i++) {
        listItems[i].value = "";
    }
}

function loadDoc() {
  var xhttp = new XMLHttpRequest();
  var url = "/offers";
  xhttp.open("GET", url, true);
  xhttp.onload = function() {
    var offersList = JSON.parse(xhttp.responseText);
    maxId = offersList.length;
    console.log("Ilosc ofert: " + maxId);
    lastOffer(maxId);
   /*
    if (this.readyState == 4 && this.status == 200) {
      console.log(this.responseText);
    }
    */
  };
  xhttp.send();
}

function lastOffer(index) {
var request = new XMLHttpRequest();
    var urlOffer = "/offers/" + index;
    request.open("GET", urlOffer, true);
    request.onload = function() {
        lastAdded = JSON.parse(request.responseText);
            console.log("Potrawa: " + lastAdded.name);
        displayOffer(lastAdded)
    }
    request.send();
}