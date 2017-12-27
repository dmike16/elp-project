#we can require external file using
# 'require' for global lib
# 'require_relative' for relative lib location
require_relative 'book_in_store'

book1 = BookInStock.new('XXFFVV',23.12)

puts "ISBN is #{book1.isbn}"
puts "Price is #{book1.price}"
puts "Price in cents is #{book1.prince_in_cents}"

book1.prince_in_cents = 1230
puts "New price is #{book1.price}"

# Variable not store object by are ref to object allocated in a pools,
# that in most case is the heap
puts "The obj in 'book1' is of type #{book1.class}"
puts "The obj in 'book1' has id #{book1.object_id}"
puts "The obj has vaule #{book1}"

book2 = book1
book2.price = 120.00

puts "The obj in 'book1' has vaule #{book1}"
puts "The obj in 'book2' has vaule #{book2}"

# ***************************************************************************
# Some class provide a method 'dup' to clone an object
# or a method 'freeze' to prevent modifications
# ***************************************************************************
