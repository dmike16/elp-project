<?php
class Info
{
  public function __construct($ip,$timestamp)
  {
    $this->ip = $ip;
    $this->timestamp = $timestamp;
  }
  public function __toString(){
    return 'IP: '.$this->ip.' At time: '.$this->timestamp;
  }
  private $ip;
  private $timestamp;
}
?>
