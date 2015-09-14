project(SRH CXX)
add_executable(${PROJECT_NAME} main.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES Shape.hpp Circle.hpp Square.hpp
	DESTINATION include)
