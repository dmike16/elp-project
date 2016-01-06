<!DOCTYPE html>
<html>
<head>
  <title>Bob's Auto Parts - Order Results</title>
</head>
<body>
  <h1>Bob's Auto Parts</h1>
  <h2>Order Results</h2>
  <?php
  /* Author: dmike
     Process the customer Order
  */
  // Store Form Variable
  $tireqty  = $_POST['tireqty'];
  $oilaty   = $_POST['oilqty'];
  $sparkqty = $_POST['sparkqty'];

  echo '<p>Your Order is as follows: </p>';
  echo "$tireqty tires<br/>";
  echo $oilaty.' bottles of oil<br/>';
  echo $sparkqty.' spark plugs<br/>';

  // Inizialize Variable
  $totalqty = 0;
  $totalamount = $totalqty;

  echo '<p> Order processed '.date('H:i, js F Y').'</p>';
  echo <<<EOF
  bella zio
  heroDoc
  Syntax
EOF;

  ?>
</body>
</html>
