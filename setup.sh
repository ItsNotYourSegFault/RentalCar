# Add rentalcar source libraries and extra libraries to classpath
export CLASSPATH=$(pwd)/src:$(pwd)/src/swingx-all-1.6.4.jar

# Initialize and update any submodules used for this project
git submodule init
git submodule update
