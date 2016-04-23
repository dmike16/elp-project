<?php 
	if(isset($_REQUEST['delay']) && is_numeric($_REQUEST['delay'])){
		sleep($_REQUEST['dealy']);
	}
	$theFile = "rating.txt";
	$totalsFile = "totals.txt";

	$rating = htmlentities(substr(urldecode(gpc("rating")), 0,1024));
	$comment = htmlentities(substr(urldecode(gpc("comment")), 0,1024));
	$transport = htmlentities(substr(urldecode(gpc("transport")), 0,1024));
	$response = htmlentities(substr(urldecode(gpc("response")), 0,1024));
	$error = htmlentities(substr(urldecode(gpc("error")), 0,1024));
	$callback = htmlentities(substr(urldecode(gpc("callback")), 0,1024));
	if($rating == ""){
		$rating = 0;
	}
	if($transport == ""){
		$transport = "downgrade";
	}
	if($response == ""){
		$response = "none";
	}
	if($error != ""){
		if($error == "404"){
			header("HTTP/1.1 404 Not Found\n\n");
		}else{
			header("HTTP/1.1 500 Internal Server Error\n\n");
		}
	}

	$userIP = $_SERVER['REMOTE_ADDR'];
	$currentTime = date("M d y h:i:s A");

	$filehandle = fopen($theFile, "rb");
	
	if ($filehandle)
	{
		$data = fread($filehandle, filesize($theFile));
		fclose($filehandle);
	}
	else{
		die('Failed to read file');
	}


	
	$filehandle = fopen($theFile, "wb");

	
	if ($filehandle)
	{
	fwrite($filehandle,"$rating\t $transport\t $userIP @ $currentTime \n");
	fwrite($filehandle, $data);
	fclose($filehandle);
	}
	else {
		die('error'.' '.$theFile);
	}
	
	$votes = $total = $avg = 0;
	$filehandle = fopen($totalsFile, "rb");
	if ($filehandle)
	{
	$line = fgets($filehandle, 4096);
	$tokens = explode("\t", $line);
	if (count($tokens) > 1)
	{
	$votes = $tokens[0] + 1;
	$total = $tokens[1] + $rating;
	}
	fclose($filehandle);
	}
	else{
		die('Failed to read file');
	}

	$filehandle = fopen($totalsFile, "wb");
	if ($filehandle)
	{
	fwrite($filehandle,"$votes\t$total\n");
	fclose($filehandle);
	}
	else {
		die('Failed to write file');
	}

	if($votes != 0){
		$avg = round(($total/$votes),2);
	}

	header("Cache-Control: no-cache");
	header("Pragma: no-cache");
	if($transport != "downgrade"){
		$message = "";
		if($response == "none"){
			header("HTTP/1.1 204 No Content\n\n");
			exit();
		}else if($response == "cookie"){
			$results = $rating."a".$avg."a".$votes;
			$filename = "pixel.gif";
			$fp = fopen($filename, 'rb');
			header("Content-Type: image/gif");
			header("Content-Length: ".filesize($filename));
			setcookie("PollResults",$results,time()+3600,"/","localhost");
			fpassthru($fp);
			exit();
		}else if($response == 'script' && $callback != ''){
			$message = "";
			if($transport != 'script'){
				$message = "<script>";
				if($transport == 'iframe'){
					$message .= "window.parent.";
				}
			}
			$timer = $_REQUEST['timer'];
			$message .= "$callback('$rating','$votes','$avg',$timer);";
			if($transport != "script"){
				$message .= "</script>";
			}else{
				print $message;
				exit;
			}
		}
	}

	function gpc($name){
		if(isset($_GET[$name])){
			return $_GET[$name];
		}elseif (isset($_POST[$name])) {
			return $_POST[name];
		}elseif (isset($_COOKIE[$name])) {
			return $_COOKIE[$name];
		}else{
			return "";
		}
	}
	class ResponseDate{
		public $avg = 0;
		public $rating = 0;
		public $votes = 0;
		public $total = 0;
	}
?>