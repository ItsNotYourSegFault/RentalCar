# Add rentalcar source libraries and extra libraries to classpath
export CLASSPATH=$(pwd)/src:$(pwd)/lib:$CLASSPATH

# Initialize and update any submodules used for this project
git submodule init
git submodule update
