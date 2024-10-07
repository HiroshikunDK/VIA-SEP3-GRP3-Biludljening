#!/bin/bash

echo "Starting Ride Share Service..."
cd "C:/Users/@User/Documents/GitHub/VIA-SEP3-GRP3-Biludljening/Car Rental Service/ride-share-service"
./mvnw spring-boot:run &

echo "Starting Payment Service..."
cd "C:/Users/@User/Documents/GitHub/VIA-SEP3-GRP3-Biludljening/Car Rental Service/payment-service"
./mvnw spring-boot:run &

echo "Starting Car Management Service..."
cd "C:/Users/@User/Documents/GitHub/VIA-SEP3-GRP3-Biludljening/Car Rental Service/car-management-service"
dotnet run &

echo "Starting User Service..."
cd "C:/Users/@User/Documents/GitHub/VIA-SEP3-GRP3-Biludljening/Car Rental Service/user-service"
dotnet run &

echo "All services are starting..."
wait
