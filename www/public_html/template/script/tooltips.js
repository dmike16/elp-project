function ToolTip(){
	"use strict";
	var instance = null;
	var storedInstance = null;

	ToolTip = function ToolTip(){
		return instance;
	};

	function SingleToolTip(){
		this.delayTimeout = null;
		this.delay = 1500;

		this.element = document.createElement("div");
		this.element.setAttribute("style","display:none;position:fixed;");
		this.element.classList.add("toolTip");
		document.body.appendChild(this.element);
	}

	SingleToolTip.prototype = {
		start: function start(e,text){
			if(this.delayTimeout === null){
				var _that = this;
				var x = e.clientX;
				var y = e.clientY;

				this.delayTimeout = setTimeout(function(){
					_that.show(x,y,text);
				},this.delay);
			}
		},
		show: function show(x,y,text){
			clearTimeout(this.delayTimeout);
			this.delayTimeout = null;
			this.element.textContent = text;
			this.element.style.left = x + "px";
			this.element.style.top = (y+20) + "px";
			this.element.style.display = "block";
		},
		hide: function hide(){
			clearTimeout(this.delayTimeout);
			this.delayTimeout = null;
			this.element.style.display = "none";
		}
	};

	instance = {
		insert: function insert(tagEle, text){
			var tt = this.get();

			tagEle.addEventListener("mouseover",function(e){
				tt.start(e,text);
			},false);
			tagEle.addEventListener("mouseout",function(e){
				tt.hide();
			},false);
		},
		get: function get(){
			if(storedInstance === null){
				storedInstance = new SingleToolTip();
			}
			return storedInstance;
		}
	};

	return instance;
}