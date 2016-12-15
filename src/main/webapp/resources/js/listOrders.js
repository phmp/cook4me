function addDiv() {
	var string = 'https://placehold.it/150x80?text=IMAGE';
    var objTo = document.getElementById('main-container')
    var divtest = document.createElement("div");
    divtest.className = "col-sm-4";
    
    var pannelPrimary = document.createElement("div");
	pannelPrimary.className = "panel panel-primary";
	divtest.appendChild(pannelPrimary);

	var dishImage = document.createElement("img");
	dishImage.src = string;
	dishImage.style = "width:100%";
	dishImage.className = "img-responsive";
	pannelPrimary.appendChild(dishImage);

    var pannelFooter = document.createElement("div");
    pannelFooter.className = "panel-footer";
	pannelPrimary.appendChild(pannelFooter);


    pannelFooter.innerHTML = "new div"
    objTo.appendChild(divtest)
}

function createDivs() {
	for (i = 0; i<3; i++) {
		addDiv();
	}
}