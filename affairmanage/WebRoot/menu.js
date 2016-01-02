
var ajccache=new Object();
var tempref;
var waitInterval;
var MouseDelayTiem = 150;
function getTBprefixName(str, sta) {
	if(str.indexOf("active")!=-1 || str.indexOf("normal")!=-1) {
		str = str.substr(6);
	}else if(str.indexOf("over")!=-1) {
		str = str.substr(4);
	}else{
		str = "";
	}
	return sta+str;
}

function startajaxtabs() {
	for(var i=0;i<arguments.length;i++) {
		var ulobj = document.getElementById(arguments[i]);
		ulist = ulobj.getElementsByTagName("a")[0];
		for(var j=0;j<ulist.length;j++) {
			var thelist = ulist[j];
			if(thelist.parentNode.parentNode!=ulobj) continue;
			var ulistlink = thelist.getElementsByTagName("a")[0];
			var ulistlinkurl = ulistlink.getAttribute("urn");
			var ulistlinkarget = ulistlink.getAttribute("rel");
			thelist.setActive = function(bactive) {
				if(bactive) {
					this.status = "active";
					this.className = getTBprefixName(this.className, "active");
				}else{
					this.status = "normal";
					this.className = getTBprefixName(this.className, "normal");
				}
			}
			
			thelist.LoadTab = function() {
				this.setActive(true);
				this.parentNode.parentNode.activetab.setActive(false);
				this.parentNode.parentNode.activetab = this;
				var ulistlink = this.getElementsByTagName("a")[0];
				loadAJAXTab(ulistlink.getAttribute("urn"), ulistlink.getAttribute("rel"));
			}
			
			thelist.onmouseover = function(aEvent) {
				var myEvent = window.event ? window.event : aEvent;
				var fm = myEvent.fromElement;
				if(IsChild(fm, this) || fm==this) return ;
				if(this.status == "active") return;
				tempref = this;
				clearTimeout(waitInterval);
				waitInterval = window.setTimeout("tempref.LoadTab();", MouseDelayTime);
			}
			
			thelist.onmouseout = function(aEvent) {
				var myEvent = window.event ? window.event : aEvent;
				var em = myEvent.toElement;
				if(IsChild(em, this) || em==this) return;
				if(this.status == "active") return;
				clearTimeout(waitInterval);
			}
			
			if(ulistlinkurl.indexOf("#default")!=-1) {
				thelist.setActive(true);
				ulobj.activetab = thelist;
				ajccache[ulistlinkurl] = getElement(ulistlinktarget).innerHTML;
			}else{
				thelist.setActive(false);
			}
		}
		if(ulobj.activetab == null) ulobj.activetab = ulist[0];
	}
}

function IsChild(cNode, pNode) {
	while(cNode != null) {
		cNode = cNode.parentNode;
		if(cNode == pNode) return true;
	}
	return false;
}

function getXmlhttp() {
	var http_request;
	if(window.XMLHttpRequest) {
		http_request = new XMLHttpRequest();
		if(http_request.overrideMimeType) {
			http_request.overrideMimeType("text/xml");
		}
	}else if(window.ActiveXObject) {
		try{
			http_request = new ActiveXOject("Msxml2.XMLHTTP");
		}catch(e) {
			try{
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){}
		}
	}
	
	if(!http_request) {
		window.alert("can't creat XMLHttpRequest object.");
		return null;
	}
}

function loadAJAXTab(url, contentid) {
	var ocontent = getElement(contentid);
	if(ajccache[url] == null) {
		var xhttp = getXmlhttp();
		xhttp.onreadystatechange = function() {
			if(xhttp.readyState == 4 && (xhttp.status==200 || window.location.href.indexOf("http")==-1)){
				ocontent.innderHTML = xhttp.responseText;
				ajccache[url] = ocontent.innderHTML;
			}
		}
		xhttp.open("GET", url, true);
		xhttp.send(null);
	}else{
		ocontent.innerHTML = ajccache[url];
	}
}

window.onerror = function(){return true;}

















