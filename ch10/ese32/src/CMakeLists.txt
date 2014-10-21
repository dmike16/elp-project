project(Mirroring)
set(src mirror1.cpp mirror2.cpp mirror3.cpp mirror4.cpp mirror5.cpp)
#include_directories(include)
add_library(mirrIN ${src})
target_include_directories(mirrIN PRIVATE ${PROJECT_SOURCE_DIR}/include)

add_library(mirr OBJECT mirror.cpp)
target_include_directories(mirr PRIVATE ${PROJECT_SOURCE_DIR}/include)
