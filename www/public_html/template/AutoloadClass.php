<?php
class AutoloadClass
{
	private $id ;
	public function __construct($id){
		$this->id = $id;
	}
	public function getId(){
		return $this->id;
	}
	public function setId($id){
		$this->id = $id;
	}
	public function __destruct(){
		echo '<h1> Bye from '.get_class($this).'</h1>';
	}
}
?>