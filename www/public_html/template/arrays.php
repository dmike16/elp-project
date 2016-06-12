<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
  <title>Array Test</title>
</head>
	<body>
		<section>
			<h1>Array Test</h1>
			<div>
				<?php
				//$products = array(2,1,3);

				echo '<p>';
				/*for($i = 0; $i < count($products); $i++){
					echo "<span>$products[$i] </span>";
				}*/
				/*foreach($products as $item){
					echo '<span>'.$item.'</span>';
				}*/
				//$items = array('item1'=>12,'item2'=>13,'item3'=>45);
				/*foreach ($items as $key => $value) {
					echo '<span>'.$key.'='.$value.' </span>';
				}*/
				/*while ($ele = each($items)) {
					echo '<span>'.$ele[0].'='.$ele['value'].' </span>';
				}*/
				/*while(list($k,$e)=each($items)){
					echo '<span>'.$k.'='.$e.' </span>';
				}*/
				$prods = array(array('TIR','Tires',100),
					array('OIL','Oil',40),
					array('SPK','Spank',12));
				for($row = 0; $row < count($prods); $row++){
					while(list($k,$e)=each($prods[$row])){
						echo '<span>'.$e.' </span>';
					}
					echo "<br/>";
					reset($prods[$row]);
				}
				echo '</p>';

				function compareTo($x,$y){
					if($x[1] == $y[1]){
						return 0;
					}else if($x[1] < $y[1]){
						return -1;
					}else{
						return 1;
					}
				}
				usort($prods, 'compareTo');
	 			echo '<p>';
				for($row = 0; $row < count($prods); $row++){
					while(list($k,$e)=each($prods[$row])){
						echo '<span>'.$e.' </span>';
					}
					echo "<br/>";
				}
				echo '</p>';
				?>
			</div>
		</section>
	</body>
</html>