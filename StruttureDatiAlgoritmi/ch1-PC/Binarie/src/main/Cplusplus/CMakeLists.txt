project(binarie CXX)
set( CMAKE_CXX_FLAGS "-std=c++11")
add_executable(${PROJECT_NAME} main.cpp generaBinarie.cpp) 
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES generaBinarie.hxx
	DESTINATION include)
