all:
	javac RentalCar.java

clean:
	@rm -rf src/rentalcar/data/*.class src/rentalcar/ui/*.class src/rentalcar/web/*class lib/org/json/*.class
