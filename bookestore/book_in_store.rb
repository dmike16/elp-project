#***************************************************************************
#
# Class in ruby are defined with class .... end
# We create an object with ClassName.new(...)
# After an instance of a class is created ruby call
# the initialize method with the param passed to new
# Instance variable are defined with @varname
class BookInStock
  #ruby create access reader method
  attr_reader :isbn
  #creste both get and set
  attr_accessor :price

  def initialize(isbn,price)
    @isbn = isbn
    @price = Float(price)
  end
  #attribute access method ara not only wrapper around instance variable
  def prince_in_cents
    Integer(@price * 100 + 0.5)
  end
  #we can create left-assignment method creating method of the form methodName=
  def prince_in_cents=(cents)
    @price = cents / 100.00
  end
  #To print an object like a string we can implement to_s method
  def to_s
    "ISBN #{@isbn}, price #{@price}"
  end
  #In ruby can control method access using the function
  #'public' : default method can be access by anyone
  #'protected' : method can be access only by object of the same class or subclass
  #'private': method can be access only inside the object context
  # If the access function are used without arguments  they set the access control
  # of subsequente method :
  # public
  #  func1 is public
  #  func2 is public
  #  ... is public
  # protected
  #  func3 is protected
  #  func4 is protected
  #  ... is protected
  #  private
  #   func5 is private
  #   func6 is private
  #   ... is private
  # Alternstive we can pass function names as arga :
  # public :func1 :func2
  # protected :func3 func4
  # private :func5 func6
end
