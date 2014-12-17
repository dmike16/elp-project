project(MemoryAllocator CXX)
add_executable(${PROJECT_NAME} main.cpp framis.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES framis.h
	DESTINATION include)
