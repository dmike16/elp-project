<?php
	$max_size = 100000;
	$msg_full = "";

	foreach ($_FILES as $file) {
		$target_path = "uploades/";
		$msg = "";
		$filename = $file['name'];
		$ext = strtolower(substr($filename, strrpos($filename, '.') + 1));

		if($ext != "gif" && $ext != "jpg" && $ext != "png"){
			$msg = "Error: " .  basename($filename).  " must be an image file with the .gif, .jpg, or .png extension.  <br />";
		}else if($file['size'] > $max_size){
			$msg = "Error: File " . basename($filename).  " is too large.  Please ensure file is less than 100Kb.  <br />"; 
		}

		if($msg == ""){
			$target_path = $target_path.basename( $filename); 
			if(move_uploaded_file($file['tmp_name'], $target_path)) 
        {
            $msg =  "The file ".  basename($filename).  " has been uploaded. <br />";
            @chmod($target_path,0755);
        } 
        else
        {
            $msg =  "There was an unspecified error uploading the file " .  basename($filename).  ", please try again! <br />";
            error_log($msg,0);
        }
		}
		$msg_full .= $msg;
	}
	echo "<div style='background:#F3E7C3;'>$msg_full</div>";
?>