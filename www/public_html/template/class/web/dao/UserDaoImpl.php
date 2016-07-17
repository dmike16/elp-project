<?php
namespace web\dao;
use \web\bean\User as User;
class UserDaoImpl implements UserDao
{
	public static $count = 1;
	public static $table = array();

	public function insert(User $user)
	{
		$id = self::$count++;
		self::$table[$id] = $user;
		return \array_key_exists($id,self::$table) && isset(self::$table[$id]);
	}
	public function remove($id)
	{
		unset(self::$table[$id]);
		array_values(self::$table);
	}
	public function retrive($id)
	{
		return isset(self::$table[$id])? self::$table[$id]: NULL;
	}
	public function retriveAll()
	{
		return self::$table;
	}
}
?>
