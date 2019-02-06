#!/bin/sh
SRC_PATH="./src/"
OUT_PATH="./out/"

all: run

compile:

	clear

	@echo "Project directory: "`pwd`
	@echo "";
	
	@# Compile --------------------------------

		@echo "> Compiling..."
		@echo "All source code"
		@echo "From: [$(SRC_PATH)] to: [$(OUT_PATH)]"

			javac $(SRC_PATH)*.java -d $(OUT_PATH);
		
			wc -c $(OUT_PATH)*.class

		@echo "DONE Compiled!"

	@# ----------------------------------------
	@echo "";

compact: 
	@# Compact

		@echo "> Compacting..."
		jar -cvf $(OUT_PATH)App.jar $(OUT_PATH)*.class
		@echo "DONE Compactated!"

	@# ----------------------------------------
	@echo "";

test:
	@# Test

		jar tf $(OUT_PATH)App.jar

	@# ----------------------------------------
	@echo "";

run: compile compact
	@# Run

		@echo "> Starting..."
		@echo "";
			
			java -cp $(OUT_PATH) App

	@# ----------------------------------------
	@echo "";

clean:
	@# Remove files

		@echo "> Cleaning..."
		@echo "All binary code from [$(OUT_PATH)]"
		@rm -f $(OUT_PATH)*.class $(OUT_PATH)*.jar 
		@echo "DONE Clean!"

	@# ----------------------------------------
	@echo "";