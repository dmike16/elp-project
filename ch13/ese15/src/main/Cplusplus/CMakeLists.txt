project(MemoryChecker CXX)
add_executable(${PROJECT_NAME} main.cpp memorycheker.cpp widget.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES memorycheker.h widget.h
	DESTINATION include)
