<?php
namespace web\utils;

/** Utils function to handle request and response in php */
class Utils
{
	public static function setHeader($key,$value)
	{
		\header($key.': '.$value);
	}
	public static function noCache()
	{
		self::setHeader("Cache-Control","no-cache");
		self::setHeader("Pragma","no-cache");
	}
	public static function getParameter($name)
	{
		if( isset($_GET[$name]))
		{
			return $_GET[$name];
		}else if( isset($_POST[$name]))
		{
			return $_POST[$name];
		}else if( isset($_COOKIE[$name]))
		{
			return $_COOKIE[$name];
		}else
		{
			return "";
		}
	}
	public static function JSON_encode($obj, $option = 0, $depth=512)
	{
		return \json_encode($obj,$option,$depth);
	}
}
?>
