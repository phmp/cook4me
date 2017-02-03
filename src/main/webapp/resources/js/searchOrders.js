var searchButton = document.getElementById("searchButton");
var listItems = document.getElementsByClassName("search-bar-input");
searchButton.addEventListener("click", sendSearchReq);

function sendSearchReq() {

    var place = listItems[0].value;
    var radius = listItems[1].value;
    var date = listItems[2].value;
    var url = "/offers";
    var params = "p1";
	//var params = '{"place":"' + place + '","radius":"' + radius + '","date":"' + date '"}'
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(params);
    alert("ok");
}
