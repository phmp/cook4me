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

	var http = new XMLHttpRequest();
	var url = "/offers";
	var params = '{"name":"' + name + '","place":"' + place + '","date":"' + date + '","contact":"' + contact + '","description":"' + description + '"}'
	http.open("POST", url, true);
	http.setRequestHeader("Content-type", "application/json");
	http.send(params);
}

function clearText() {
    for (i = 0; i < listItems.length; i++) {
        listItems[i].value = "";
    }
}