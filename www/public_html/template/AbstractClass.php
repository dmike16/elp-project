<?php 
	abstract class AbstractClass {
		abstract protected function getValue();

		public function printOut(){
			print $this->getValue()."<br/>";
		}
	}
?>