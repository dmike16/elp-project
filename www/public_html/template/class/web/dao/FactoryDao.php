<?php
namespace web\dao;
abstract class FactoryDao
{
	const POJO = 'POJO';
	const POSTGRESS = 'POSTGRESS';
	const MYSQL = 'MYSQL';
	const ORACLE = 'ORACLE';

	abstract public function getUserDao();

	public static function generate($type)
	{
		switch($type)
		{
		case self::POJO:
			return new PojoDao();
		default:
			return NULL;
		}
	}
}
?>
