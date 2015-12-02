(function() {
  "use strict";
  // Interface
  function Interface(name, methods) {
    if (arguments.length != 2) {
      throw new Error("Interface constructor called with " + arguments.length +
        "arguments, but expected exaclty 2");
    }
    if (!(this instanceof Interface)) {
      return new Interface(name, methods);
    }

    this.name = name;
    this.methods = [];
    for (var i = 0, len = methods.length; i < len; i++) {
      if (typeof methods[i] !== 'string') {
        throw new Error("Interface constructor expects method names to be string");
      }
      this.methods.push(methods[i]);
    }
  }
  Interface.ensureImplements = function ensureImplements(object) {
    if (arguments.length < 2) {
      throw new Error("Function Interface,ensureImplements called with" +
        arguments.length + " arguments, but expected at least 2");
    }

    for (var i = 1, len = arguments.length; i < len; i++) {
      var _interface = arguments[i];
      if (_interface.constructor !== Interface) {
        throw new Error("Function expects arguments to be istances of Interface");
      }

      for (var j = 0, mLen = _interface.methods.length; j < mLen; j++) {
        var method = _interface.methods[j];
        if (!object[method] || typeof object[method] !== 'function') {
          throw new Error("function: object does not implement the" + _interface.name +
            "interface Method" + method + "was not found");
        }
      }
    }
  };

  function extend(subClass, superClass) {
    var F = function() {};
    F.prototype = superClass.prototype;
    subClass.prototype = new F();
    subClass.prototype.constructor = subClass;

    subClass.superclass = superClass.prototype;
    if (superClass.prototype.constructor == Object.prototype.constructor) {
      superClass.prototype.constructor = superClass;
    }
  }
  // Composite Pattern Form Validation
  var Composite = new Interface('Composite', ['add', 'remove', 'getChild']);
  var FormItem = new Interface('FormItem', ['save']);

  var CompositeForm = function(id, method, action){
    this.formComponets = [];

    this.element = document.createElement('form');
    this.element.id =id;
    this.element.method =method || 'POST';
    this.element.action = action || '#';
  };
  CompositeForm.prototype = {
    add: function(child){
      Interface.ensureImplements(child,Composite,FormItem);
      this.formComponets.push(child);
      this.element.appendChild(child.getElement());
    },
    remove: function(child){
      for(var i = 0,len = this.formComponets.length; i < len; i++){
        if(this.formComponets[i] === child){
          this.formComponets.splice(i,1);
          break;
        }
      }
    },
    getChild: function(i){
      return this.formComponets[i];
    },
    save: function(){
      for(var i = 0, len = this.formComponets.length; i < len; i++){
        this.formComponets[i].save();
      }
    },
    getElement: function(){
      return this.element;
    }
  };
  var CompositeFieldSet = function(id, legendText){
      this.components = {};

      this.element = document.createElement('fieldset');
      this.element.id = id;

      if (legendText){
        this.legend = document.createElement('legend');
        this.legend.appendChild(document.createTextNode(legendText));
        this.element.appendChild(this.legend);
      }
  };
  CompositeFieldSet.prototype = {
    add: function(child){
      Interface.ensureImplements(child, Composite, FormItem);
      this.components[child.getElement().id] = child;
      this.element.appendChild(child.getElement());
    },
    remove: function(child){
      delete this.components[child.getElement().id];
    },
    getChild: function(id){
      if (typeof this.components[id] != 'undefined'){
        return this.components[id];
      } else {
        return null;
      }
    },
    save: function(){
      for(var id in this.components){
        if(!this.components.hasOwnProperty(id))continue;
        this.components[id].save();
      }
    },
    getElement: function(){
      return this.element;
    }
  };

  var Field = function(id){
    this.id = id;
    this.element = null;
  };
  Field.prototype = {
    add: function(){},
    remove: function(){},
    getChild: function(){},
    save: function(){
      console.log("Save in Leaf " + this.getValue());
    },
    getElement: function(){
      return this.element;
    },
    getValue: function(){
      throw new Error('Unsupported operation on the class Field');
    }
  };

  var InputField = function(id,label){
    Field.call(this,id);

    this.input = document.createElement('input');
    this.input.id = id;

    this.label = document.createElement('label');
    var labelTexNode = document.createTextNode(label);
    this.label.appendChild(labelTexNode);

    this.element = document.createElement('div');
    this.element.className = 'input-field';
    this.element.appendChild(this.label);
    this.element.appendChild(this.input);
  };
  extend(InputField, Field);
  InputField.prototype.getValue = function(){
    return this.input.value;
  };

  var TextareaField = function(id, label){
    Field.call(this,id);

    this.textarea = document.createElement('textarea');
    this.textarea.id = id;

    this.label = document.createElement('label');
    var labelTexNode = document.createTextNode(label);
    this.label.appendChild(labelTexNode);

    this.element = document.createElement('div');
    this.element.className = 'input-field';
    this.element.appendChild(this.label);
    this.element.appendChild(this.textarea);
  };
  extend(TextareaField, Field);
  TextareaField.prototype.getValue = function(){
    return this.textarea.value;
  };

  var SelectField = function(id, label){
    Field.call(this, id);

    this.select = document.createElement('select');
    this.select.id = id;

    this.label = document.createElement('label');
    var labelTexNode = document.createTextNode(label);
    this.label.appendChild(labelTexNode);

    this.element = document.createElement('div');
    this.element.className = 'input-field';
    this.element.appendChild(this.label);
    this.element.appendChild(this.select);
  };
  extend(SelectField, Field);
  SelectField.prototype.getValue = function(){
    return this.select.options[this.select.selectedIndex].value;
  };

  // USE COMPOSITE Pattern
  var contactForm = new CompositeForm('contact-form', 'POST', 'contact.php');
  var nameFiedlSet = new CompositeFieldSet('name-field');

  nameFiedlSet.add(new InputField('first-name','First Name'));
  nameFiedlSet.add(new InputField('last-name', 'Last Name'));
  contactForm.add(nameFiedlSet);

  var addressFieldset = new CompositeFieldSet('address-field');
  addressFieldset.add(new InputField('address', 'Address'));
  addressFieldset.add(new InputField('city','City'));
  addressFieldset.add(new SelectField('state','State'));
  addressFieldset.add(new InputField('zip','Zip'));
  contactForm.add(addressFieldset);

  contactForm.add(new TextareaField('comments', 'Comments'));

  document.body.appendChild(contactForm.element);

}());
