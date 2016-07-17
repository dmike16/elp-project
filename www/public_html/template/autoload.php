<?php
spl_autoload_register(function($name){
	//echo '<p> Want load '.$name.'</p>';
	$prefix = 'class';
	$full_name = str_replace("\\","/",$name);
	include $prefix.'/'.$full_name.'.php';
});
?>
