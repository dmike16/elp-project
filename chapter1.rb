# Simple comment line
puts "Hello from ruby"
puts "It's #{Time.now}"
# simple method definition
def say_hello(name)
  # The last expr evaluted is the returned value
  "Hello #{name}"
end

puts say_hello('Pippo')
#***************************************************************************
# Naming convenction
# Local Variable or method : start with lowercase or underscore
# Instance Variable : @variable
# Class Variable : @@class
# Global Variable : $global
# Class Name : MixedCase
# Constant Name : CONST_NAME
#***************************************************************************
