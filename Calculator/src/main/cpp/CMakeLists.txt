project(calculator CXX)
set( CMAKE_CXX_FLAGS "-std=c++11")
add_executable(${PROJECT_NAME} main.cpp input.cpp parser.cpp error.cpp) 
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES input.hxx parser.hxx error.hxx
	DESTINATION include)
