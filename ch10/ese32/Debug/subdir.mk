################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../mirror.cpp \
../mirror3.cpp \
../mirror2.cpp \
../mirror1.cpp \
../mirror4.cpp \
../mirror5.cpp \
#../solu1.cpp 

OBJS += \
./mirror.o \
./mirror3.o \
./mirror2.o \
./mirror1.o \
./mirror4.o \
./mirror5.o \
#./solu1.o 

CPP_DEPS += \
./mirror.d \
./mirror3.d \
./mirror2.d \
./mirror1.d \
./mirror4.d \
./mirror5.d \
#./solu1.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT $@ -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


