<?php  
spl_autoload_register(function($name){
	echo '<p> Want load '.$name.'</p>';
	include $name.'.php';
});
?>