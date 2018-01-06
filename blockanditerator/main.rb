# Block ara a core feature of ruby
# one lne block : {}
# more line block : do ... end
sum = 0

[1,2,3,4].each do |value; square|
  square = value*value
  sum += square
end
puts "Result is #{sum}"

# An iterator is just a method that can invoke a block of code
def two_times
  yield
  yield
end
two_times { puts "HELLO" }

# Enumerators
# we can create it using the method to_enum of collections
a = [1,2,12]
enum_a = a.to_enum
puts enum_a.count
loop do
  puts "Value -#{enum_a.next}-"
end
# many internal iterator return Enumerators object
puts a.each.class
# we can create enumerators explicitly
e = "cat".enum_for(:each_char)
p e.to_a
# Enumerators like generators and filters
# we can create enumerators with the constructor passing a block
triangular_numbers = Enumerator.new do |yielder|
  number = 0
  count = 1
  loop do
    number += count
    count += 1
    yielder.yield number
  end
end

p triangular_numbers.first(5)

def infinite_select(enum,&block)
  Enumerator.new do |yielder|
    enum.each do |val|
      yielder.yield(val) if block.call(val)
    end
  end
end

p infinite_select(triangular_numbers) {|val| val % 10 == 0}.first(5)

# ruby 2.0 has lazy enumerators that comsume data only when requested and enough
# to fullyfill the request. The method of lazy enumerator return anothor enumerator
# that know how to process the data.
def Integer.all
  Enumerator.new do |yielder,n:0|
    loop { yielder.yield(n+=1) }
  end.lazy
end
p Integer.all.first(10)
p Integer.all.select {|i| (i%3).zero? }.first(10)
# the method block_given? can be used to check if a block is passed
def with_and_without_block
  if block_given?
    puts "A block is passed"
  else
    puts "No block"
  end
end
with_and_without_block
with_and_without_block {"hello"}
# Block can be converted in object of class Proc:
# 1 last arg has a & preceding the name (&block)
# 2 using lambda {block}
# 3 using Proc.new

# block can be closures
def n_times(things)
  ->n{things*n} #lambda {|n| things*n}
end
p1 = n_times(23)
p p1.call(3)
p2 = n_times("1")
p p2.call(3)
