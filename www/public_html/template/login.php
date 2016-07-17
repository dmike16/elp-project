<?php
require_once('autoload.php');
/** Login back end funtionality*/
use web\utils\Utils as Utils;
use web\bean\User as User;
use web\dao\FactoryDao as FactoryDao;

Utils::noCache();
Utils::setHeader("Content-Type","text/html");



$user = new User(Utils::getParameter('username'),Utils::getParameter('password'));
$dao = FactoryDao::generate(FactoryDao::POJO)->getUserDao();
if($dao->retrive(0) == $user)
{
	echo '<p><strong>YOUR SYSTEM ADMIN !!!!</strong></p>';
}else
{
	echo '<p>'.'<ul><li>UserName: '.$user->getName().'</li>';
	echo '<li>Password: '.$user->getPassword().'</li></p>';
}
?>
