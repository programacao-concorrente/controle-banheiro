#!/bin/bash
clear
echo "Empacotando a aplicação em um .jar..."
mvn clean && mvn compile && mvn package
