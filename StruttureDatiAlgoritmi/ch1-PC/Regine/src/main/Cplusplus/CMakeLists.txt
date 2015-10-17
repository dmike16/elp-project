project(regine CXX)
set( CMAKE_CXX_FLAGS "-std=c++11")
add_executable(${PROJECT_NAME} main.cpp regine.cpp) 
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES regine.hxx
	DESTINATION include)
