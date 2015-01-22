project(MemoryChecker CXX)
add_executable(${PROJECT_NAME} main.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES travel.hpp bussinessTravel.hpp
	DESTINATION include)
