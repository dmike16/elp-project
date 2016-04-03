<?php 
	$theFile = "rating.txt";
	$totalsFile = "totals.txt";


	if(isset($_REQUEST['rating'])){
		$rating = $_REQUEST['rating'];
	}else{
		$rating = 0;
	}

	if(isset($_REQUEST['transport'])){
		$transport = $_REQUEST['transport'];
	}else{
		$transport = "downgrade";
	}

	$userIP = $_SERVER['REMOTE_ADDR'];
	$currentTime = date("M d y h:i:s A");

	$filehandle = fopen($theFile, "rb");
	if(is_readable($theFile)){
		print bella;
	}
	if(is_writable($theFile)) echo 'writable ';
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

	header("Cache-Control: no-cache");
	header("Pragma: no-cache");
	header("HTTP/1.1 204 No Content\n\n");
	exit();
?>