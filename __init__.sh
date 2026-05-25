#!/bin/bash
cd mess
clear
echo "______________________________INIT________________________________________"
mvn spring-boot:run
echo "______________________________EXIT_________________________________________"
echo "I have a update (y/n)?"
read -p "->" answer
if [ "$answer" = "y" ]; then
     clear
     git pull
     echo "Start too ?"
     read -p "->" answer1
     if [ "$answer1" = "y" ]; then
          clear
          echo "______________________________INIT________________________________________"
          mvn spring-boot:run
     fi
fi
