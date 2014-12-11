project(nestedIterator CXX)
add_executable(${PROJECT_NAME} main.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES Dog.h doghouse.h
	DESTINATION include)
