project(ccopy CXX)
add_executable(${PROJECT_NAME} main.cpp dog.cpp) 
install(TARGETS ${PROJECT_NAME} 
	RUNTIME DESTINATION bin)
install(FILES animal.hpp dog.hpp
	DESTINATION include)
