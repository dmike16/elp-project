/**
 * 
 */

var person= {
		firstName: "Jhon",
		lastName: "Doe",
		age: 50,
		ec: "blue",
		fullName: function(){
			return this.firstName + " " + this.lastName;
		}
		
};

function whoIs(){
	document.getElementById("who").innerHTML = person.fullName();
}