<?php
require_once 'autoload.php';
class SimpleClass
{
	public static function getIstance(){
		return new static;
	}
	public $var='defult';
	public function displayVar(){
		echo $this->var;
	}
	public function howIsThis(){
		if(isset($this))
		{
			echo '<br/>$this id def(';
			echo get_class($this);
			echo ')<br/>';
		}else{
			echo 'Not Defined.\n';
		}
	}
}

class ExtendClass extends SimpleClass
{
	const CONSTANT = 'value Const';
	public function displayVar()
	{
		echo "<br>Extend Class<br>".self::CONSTANT;;
		parent::displayVar();

	}
}

$sc = new SimpleClass();
$sc->displayVar();
$sc->howIsThis(); 
$scs = 'SimpleClass';
$sc2 = new $scs();
$sc2->howIsThis();
$sc3 = $sc;
$sc4 = &$sc;
$sc5 = SimpleClass::getIstance();

var_dump($sc);
var_dump($sc3);
var_dump($sc4);
var_dump($sc5 instanceof SimpleClass);

$ec = new ExtendClass();
$ec->displayVar();

$al = new AutoloadClass(2);
echo '<p> Your id is'.$al->getId().' </p>';

$ct = new Construct(4,"Jhon");
echo '<p> Your id is'.$ct->getId().' user '.$ct->getUser().' </p>';

class Implement extends AbstractClass{
	protected function getValue(){
		return "ConcreteClass";
	}
 }

 $impl = new Implement();
 $impl->printOut();

 class Base{
 	public function sayHello(){
 		echo 'Hello';
 	}
 }

 trait SayWorld{
 	public function sayHello(){
 		parent::sayHello();
 		echo '--World!';
 	}
 }

 class MyHello extends Base{
 	use SayWorld;
 }

 $ooo = new MyHello();
 $ooo->sayHello();

 class SomeClass{}
 interface SomeInterface{}
 trait SomeTrait{}

 /**
 	PHP 7
 var_dump(new class(10) extends SomeClass implements SomeInterface{
 	private $num;
 	public function __constructor($num)
 	{
 		$this->num = $num;
 	}

 	use SomeTrait;
 });*/

 $overLoad = new PropMethodTest();
 $overLoad->a = 1;
 echo $overLoad->a."<br/>";
 var_dump(isset($overLoad->a));
 unset($overLoad->a);

 echo $overLoad->declared."<br/>";
 $overLoad->runTest("hrlll");
 PropMethodTest::runTest("jijij");

 ?>
