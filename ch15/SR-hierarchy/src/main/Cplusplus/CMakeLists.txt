project(SRH CXX)
add_executable(${PROJECT_NAME} main.cpp OStack.cpp)
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES OStack.hpp
	DESTINATION include)
