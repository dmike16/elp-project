<?php
	sleep(1);

	class colorObject{
		public function __construct($name,$r,$g,$b){
			$this->name = $name;
			$this->r = $r;
			$this->g = $g;
			$this->b = $b;
		}
	}

	$userIP = $_SERVER['REMOTE_ADDR'];
	$currentTime = date("M d y h:i:s A");

	if(isset($_REQUEST['username'])){
		$username = htmlentities(substr(urldecode($_REQUEST['username']), 0,1024));
	}else{
		$username = "";
	}

	$colorArray = array();

	$colorArray[] = new colorObject("Orange", 255, 165, 0);
	$colorArray[] = new colorObject("Lime", 0, 255, 0);
	$colorArray[] = new colorObject("Red", 255, 0, 0);
	$colorArray[] = new colorObject("Blue", 0, 0, 255);
	$colorArray[] = new colorObject("Yellow", 255, 255, 0);
	$colorArray[] = new colorObject("Purple", 128, 0, 128);

	$index = rand(0, count($colorArray) -1);
	$color = $colorArray[$index]->name;
	$r = $colorArray[$index]->r;
	$g = $colorArray[$index]->g;
	$b = $colorArray[$index]->b;

	$message1 = "$username from $userIP your custom $color image";
	$message2 = "was created on $currentTime.  Enjoy it!";
	header("Cache-Control: no-cache");
	header("Pragma: no-cache");
	header ("Content-type: image/png");

	$imageHandle = imagecreate(600, 80) or die("Cannot create image");
	$backColor = imagecolorallocate($imageHandle, $r, $g, $b);
	$textColor = imagecolorallocate($imageHandle, 3, 3, 3);
	imagestring($imageHandle, 31, 5, 5, $message1, $textColor);
	imagestring($imageHandle, 31, 5, 41, $message2, $textColor);
	imagepng($imageHandle);
?>