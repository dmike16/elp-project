<?php
include_once "autoload.php";
header("Cache-Control:no-cache");
header("Pragma:no-cache");

$headers = apache_request_headers();
$user = urldecode($_GET['user']);
$info = new Info(gethostbyname($_SERVER['REMOTE_ADDR']),date("h:i:s A"));
echo "Greeting ".$user. " from ".$info." at localhost<br/>";
echo "<p>Request Header </p>";
foreach($headers as $header => $value)
{
  echo "$header: $value <br/>";
}
 ?>
