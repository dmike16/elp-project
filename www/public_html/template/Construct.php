<?php 
require_once 'AutoloadClass.php';
class Construct extends AutoloadClass
{
	private $user ;
	public function __construct($id,$name){
		parent::__construct($id);
		$this->user = $name;
	}
	public function getUser(){
		return $this->user;
	}
	public function __destruct(){
		parent::__destruct();
	}
}
?>