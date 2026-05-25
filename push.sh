#!/bin/bash

clear
git init
git add .
git commit -m "new update"
git remote add origin https://github.com/noyemkaren-ship-it/Messanger 2>/dev/null || git remote set-url origin https://github.com
git push origin master
