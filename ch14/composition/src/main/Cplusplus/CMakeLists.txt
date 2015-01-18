project(MemoryChecker CXX)
add_executable(${PROJECT_NAME} car.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES 
	DESTINATION include)
