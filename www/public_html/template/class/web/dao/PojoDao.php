<?php
namespace web\dao;
class PojoDao extends FactoryDao
{
	public function getUserDao()
	{
		return new UserDaoImpl();
	}
}
?>
