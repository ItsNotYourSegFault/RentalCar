all:
	javac RentalCar.java

clean:
	@rm src/rentalcar/data/*.class src/rentalcar/ui/*.class src/rentalcar/web/*class
