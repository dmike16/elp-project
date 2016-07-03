<?php
spl_autoload_register(function($name){
	//echo '<p> Want load '.$name.'</p>';
	$prefix = 'class';
	include $prefix.'/'.$name.'.php';
});
?>
