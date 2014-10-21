cmake_minimum_required(VERSION 2.6)
project(Mirror)

add_subdirectory(${PROJECT_SOURCE_DIR}/src)
add_executable(${PROJECT_NAME} $<TARGET_OBJECTS:mirr>)
target_link_libraries(${PROJECT_NAME} mirrIN)
