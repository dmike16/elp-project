<?php 
class PropMethodTest {
	private $data = array();
	public $declared = 23;
	private $hidden = 2;

	public function __set($name,$value)
	{
		echo "Setting '$name' to '$value'"."<br/>";
		$this->data[$name]=$value;
	}

	public function __get($name)
	{
		echo "Getting '$name'"."<br/>";
		if(array_key_exists($name, $this->data))
		{
			return $this->data[$name];
		}

		$trace = debug_backtrace();
		trigger_error('Undefined property via __get() '.$name,E_USER_NOTICE);

		return null;
	}
	public function __isset($name)
	{
		echo "IS '$name' set ? "."<br/>";
		return isset($this->data[$name]);
	}
	public function __unset($name)
	{
		echo "Unsetting '$name' "."<br/>";
		unset($this->data[$name]);
	}	
	public function __call($name,$argumnets)
	{
		echo "Calling method '$name' "."<br/>";
	}
	public static function __callStatic($name,$arguments)
	{
		echo "Calling static method '$name' "."<br/>";
	}
	
}
?>