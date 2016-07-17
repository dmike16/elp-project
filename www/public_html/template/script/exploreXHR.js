/* Explore XHR Response and Request */
(function()
 {
	 "use strict";
	 var dom_form = document.forms.requestForm;
	 var dom_login = dom_form.requestButton;
	 var dom_output = document.getElementById("responseOutput");
	 function login(url,async)
	 {
		 var _action_url = url || 'http://localhost/~andrea/elp-project/branches/html/www/public_html/template/login.php';
		 var _async = async || true;
		 var _xhr = createXHR();
		 var _payload = 'username='+encodeUriFixed(dom_form.username.value)
			 + '&password=' + encodeUriFixed(dom_form.password.value);
		 if(_xhr)
		 {
			 _xhr.open("POST",_action_url,_async);
			 /* Ohter useful event are :
			  *	onload: fire on request compelte
			  *	onerror: fire on request error
			  *	onprogress: fire during the progress of the request*/
			 _xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			 _xhr.onreadystatechange = function()
			 {
				 if(_xhr.readyState === 4)
				 {
					 try
					 {
						 switch(_xhr.status)
						 {
							 case 200:
								 callback(_xhr);
								 break;
							 default:
								 errorCallback(_xhr);
								 break;

						 }
					 }catch( ex )
					 {
						 errorCallback(e);
					 }
				 }
			 }
			 _xhr.send(_payload);

		 }else
		 {
			 dom_output.innerHTML = '<p><strong>No XHR functionlity</<strong></p>';
			 dom_output.setAttribute('style','display:block');

		 }
	 }

	 function errorCallback(error)
	 {
		 var html_error= ['<p><span style="color:red;">'];
		 if(error instanceof Error)
		 {
			 html_error.push(error.message);
		 }else
		 {
			 html_error.push(error.status + ' ' +error.statusText);
		 }
		 html_error.push('</span></p>');
		 dom_output.innerHTML = html_error.join('');
		 dom_output.setAttribute('style','display:block');

		 error = null;
	 }

	 function callback(data)
	 {

		 try
		 {
			 if(callback.type.HTML(data))
			 {
				 dom_output.innerHTML = data.responseText;
			 }else if (callback.type.XML(data))
			 {
				 printXML(data.responseXML);
			 }else if(callback.type.JSON(data))
			 {
				 var obj = JSON.parse(data.response);
				 dom_output.innerHTML = obj.toString.replace('/\n/g','<br/>');
			 }else
			 {
				 dom_output.innerHTML = data.responseText;
			 }
			 dom_output.setAttribute('style','display:block');

		 }catch( error )
		 {
			 errorCallback(error);
		 }finally{

			 data = null;
		 }
	 }
	 callback.type =
	 {
		 HTML : function(obj)
		 {
			 var ct = obj.getResponseHeader('content-type') || '';
			 return ct.indexOf('html') > -1;
		 },
		 XML : function(obj)
		 {
			 var ct = obj.getResponseHeader('content-type') || '';
			 return ct.indexOf('xml') > -1;
		 },
		 JSON : function(obj)
		 {
			 var ct = obj.getResponseHeader('content-type') || '';
			 return ct.indexOf('json');
		 }
	 };

	 function printXML(doc)
	 {
		 if(!doc || !doc.documentElement)
		 {
			 errorCallback(new Error("Document XML doesn't exist"));
		 }else
		 {
			 var spot = document.getElementById("responseOutput");

			 spot.innerHTML = recurviseXML(doc).join('');
		 }
	 }
	 function recurviseXML(node)
	 {
		 var spot = [];
		 var tagname = node.tagName;
		 var val = node.value;

		 if(tagname)
		 {
			 spot.push('&lt;'+tagname + '&gt;');
		 }else if (val)
		 {
			 var converted = val.replace(/<([^>]*)>/g,'&lt;$1&gt;');
			 converted = converted.replace(/\n/g,'<br/>');
			 spot.push(converted);
		 }

		 node = node.firstChild;
		 while(doc)
		 {
			 spot.concat(recurviseXML(doc));
			 node = node.nextSibling;
		 }

		 if(tagname)
		 {
			 spot.push('&lt;/' + tagname + '&gt;');
		 }

		 return spot;
	 }

	 dom_login.onclick = function(){ login(); };
 }());


