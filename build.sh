JARNAME=AllenEaton.jar
cd bin/
jar -cfm $JARNAME manifest.txt AllenEaton.class org rentalcar
cd ..
cp bin/$JARNAME staging/
cp src/swingx-all-1.6.4.jar staging/
