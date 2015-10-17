project(hanoi CXX)
set( CMAKE_CXX_FLAGS "-std=c++11")
add_executable(${PROJECT_NAME} main.cpp torriHanoi.cpp) 
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES torriHanoi.hxx
	DESTINATION include)
