<?php
	header("Cache-Control: no-cache");
	header("Pragma: no-cache");
	header("Content-Type: text/xml");

	$ip = $_SERVER['REMOTE_ADDR'];
	$msg = "Hello Ajax from ".$ip."at".date("h:i:s A");

	print '<?xml version="1.0" encoding="UTF-8" ?>';
	print "<message>$msg</message>";

?>