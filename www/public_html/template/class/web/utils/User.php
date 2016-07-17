/** User bean class */
<?php
namespace web\bean;
Class User implements \jsonSerializable
{
	public function __construct($name, $password)
	{
		$this->name = $name;
		$this->password_base64 = \base64_encode($password);
	}
	public function getName()
	{
		return $this->name;
	}
	public function getPassword()
	{
		return base_64_decode($this->password_base64);
	}
	public function jsonSerialize()
	{
		return [
			'username' => $this->getName(),
			'password' => $this->getPassword()
		];
	}
	private $name;
	private $password_base64;
}
?>
