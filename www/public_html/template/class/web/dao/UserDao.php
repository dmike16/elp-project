<?php
namespace web\dao;
interface UserDao
{
	public function retrive($id);
	public function insert(\web\bean\User $user);
	public function remove($id);
	public function retriveAll();
}
?>
