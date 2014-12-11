project(nestedIterator CXX)
add_executable(${PROJECT_NAME} main.cpp obj.cpp) 
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES objcontainer.h obj.h
	DESTINATION include)
