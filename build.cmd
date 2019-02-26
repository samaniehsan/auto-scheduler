#!/usr/bin/env bash

rm ./code/src/org/txstate/auto_scheduler/*.class
rm ./code/src/org/txstate/auto_scheduler/*.jar
javac -d ./code/bin ./code/src/org/txstate/auto_scheduler/*.java
jar -cvfm ./code/bin/org/txstate/auto_scheduler/auto_scheduler.jar ./code/src/org/txstate/auto_scheduler/MANIFEST.MF ./code/bin/org/txstate/auto_scheduler/*.class
