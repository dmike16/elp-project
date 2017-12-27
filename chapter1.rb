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
#***************************************************************************
#  Array
a = [1, 'cat',3.14]
puts "First element is #{a[0]}"
a[2] = nil
puts "All the array is #{a.inspect}"
s = %w{bella zio tutto zio bello}
puts "Say all : #{s}"
# Hash collection
coll = {
  'cello' => 'string',
  'zio' => 'bella'
}
p coll['zio']
p coll['uncle']
# hash with default to 0
hist = Hash.new(0)
hist['ruby']
p hist['ruby']
# symbol ara always unique
# we do not need to define them
hist[:zio]=123
p hist[:zio]
# control structure without brackets only key and 'end'
today = Time.now
if today.saturday?
  puts 'Sat'
else
  puts 'Go to work'
end
# more concise syntax
#line = nil
#puts line.downcase while line = gets
# Block
def call_block
  puts "Before call"
  yield
  puts "After call"
end
call_block {puts 'Hello block'}
# we can pass arguments
def call_w_arg
  puts "BBBBBBB"
  yield("ZIO BLOCK")
  puts "AAAAAAA"
end
call_w_arg do |arg|
  puts "Insied block"
  puts "#{arg}"
end
