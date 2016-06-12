<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
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
  date_default_timezone_set('Europe/Rome');
  $tireqty  = $_POST['tireqty'];
  $oilaty   = $_POST['oilqty'];
  $sparkqty = $_POST['sparkqty'];
  $addr = $_POST['addr'];
  $root = $_SERVER['DOCUMENT_ROOT'];
  $date = date('H:i, jS F Y');

  define('TIREPRICE', 100);
  define('OILPRICE', 10);
  define('SPARKPRICE',4);

  $totalqty = 0;
  $totalamount = (float)$totalqty;

  $totalqty = $tireqty + $oilaty + $sparkqty;

  if ($totalqty == 0){
    echo '<p>No Order Submit</p>';
  } else {
    $find = $_POST['find'];
    echo '<p>Your Order is as follows: </p>';
    echo "$tireqty tires<br/>";
    echo $oilaty.' bottles of oil<br/>';
    echo $sparkqty.' spark plugs<br/>';

    switch ($find) {
      case 'a':
        echo '<p>Customer</p>';
        break;
      case 'b':
        echo '<p>Chkhclhsdhc</p>';
        break;
      case 'c':
        echo '<p> wdwdwdw</p>';
        break;
      case 'd':
        echo '<p>HsSjS</p>';
        break;
      default:
        echo "<p> Bhoooo<p>";
        break;
    }

    // Inizialize Variable

    $totalamount = $tireqty*TIREPRICE
                  + $oilaty * OILPRICE
                  + $sparkqty * SPARKPRICE;

   echo '<p>Subtotal : $'.number_format($totalamount,2).'.</p>';
   $taxrate = 0.10;
   $totalamount = $totalamount * (1 + $taxrate);
   echo '<p>Total including tax: $'.number_format($totalamount,2).'</p>';
   echo '<p> Order processed '.$date.'</p>';

   $outputstring = $date."\t".$tireqty." tires \t".$oilaty." oil\t"
                    .$sparkqty." spark plugs\t".$totalamount."\t".$addr."\n";
   
   $fp = fopen("$root/server-file/order.txt",'ab');

   if(!$fp || !flock($fp, LOCK_EX)){
    echo "<p><strong>Your order can not be processed</strong></p>";
    exit;
   }
   fwrite($fp,$outputstring,strlen($outputstring));
   flock($fp,LOCK_UN);
   fclose($fp);

   echo "<p>Order Written </p>";
}
  ?>
</body>
</html>
