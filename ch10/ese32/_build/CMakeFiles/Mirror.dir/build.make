# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 2.8

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list

# Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/dmike/Development/elp-project/ch10/ese32

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/dmike/Development/elp-project/ch10/ese32/_build

# Include any dependencies generated for this target.
include CMakeFiles/Mirror.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Mirror.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Mirror.dir/flags.make

# Object files for target Mirror
Mirror_OBJECTS =

# External object files for target Mirror
Mirror_EXTERNAL_OBJECTS = \
"/home/dmike/Development/elp-project/ch10/ese32/_build/src/CMakeFiles/mirr.dir/mirror.cpp.o"

Mirror: src/CMakeFiles/mirr.dir/mirror.cpp.o
Mirror: CMakeFiles/Mirror.dir/build.make
Mirror: src/libmirrIN.a
Mirror: CMakeFiles/Mirror.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --red --bold "Linking CXX executable Mirror"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Mirror.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Mirror.dir/build: Mirror
.PHONY : CMakeFiles/Mirror.dir/build

CMakeFiles/Mirror.dir/requires:
.PHONY : CMakeFiles/Mirror.dir/requires

CMakeFiles/Mirror.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Mirror.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Mirror.dir/clean

CMakeFiles/Mirror.dir/depend:
	cd /home/dmike/Development/elp-project/ch10/ese32/_build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/dmike/Development/elp-project/ch10/ese32 /home/dmike/Development/elp-project/ch10/ese32 /home/dmike/Development/elp-project/ch10/ese32/_build /home/dmike/Development/elp-project/ch10/ese32/_build /home/dmike/Development/elp-project/ch10/ese32/_build/CMakeFiles/Mirror.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Mirror.dir/depend
