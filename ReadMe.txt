Jak uruchomiæ ten projekt :
1) File -> New -> JavaProject
	(Przy wpisywaniu czegokolwiek pomijaj œredniki)

	a) tutaj podaj nazwê projektu "CarRental" , oraz lokalizacje jego
	b) w miejscu JRE b¹dz pewny ,¿e masz zaznaczone "Use an execution environment JRE : Java SE-1.8"
	c) jeœli masz zazanczona wersje nizsza niz 1.8 , to :
		- "http://www.oracle.com/technetwork/java/javase/downloads/index.html"
		- sciagnij JDK i JRE i zainstaluj : ( moja lokalizacja to "C:\Program Files\Java" ) a w niej folder "1.8.0_45" ( mozliwe ze jest juz wersja _51 mniejsza z tym )
		- znajdz u siebie w Windowsie zmienne srodowiskowe
		- jesli nie masz to dodaj tam zmienne:
			--name: "CLASSPATH", value : "C:\Program Files\Java\jre1.8.0_40\bin"
			--name: "JAVA_HOME", value : "C:\Program Files\Java\jdk1.8.0_40"
		- wroc do Eclipse:
			--Configure JREs ->Search-> Wskaz lokalizacje tam gdzie masz folder javy (np. "C:\Program Files\Java" ).
			--Zaznacz ostatnia wersje
	d) koniec dodawania projektu wraz z ostatnia wersja Javy

2) Dodawanie plikow projektu i bilbiotek zewnetrznych:
	a) wejdz do folderu "CarRental" , który Ci wys³a³em
	b) upewnij siê ,¿e masz w³¹czony w "Eclipse" widok "Package Explorer"
	c) przeci¹gnij na nazwê "CarRental" w Eclipse , foldery : Clock, CarRental,CPU,Customers,Employers ( powinny tam byc tylko pliki txt ).
	d) przejdz do folderu "src" w folderze ,ktory Ci wyslalem
	e) folder "System" przenieœ do folderu "src" ,który znajduje siê w Twoim projekcie
	f) w tym momencie Twój projekt powinien wygl¹daæ tak : "http://imgur.com/eFe1N58"

3) Dodawanie bibliotek zewnêtrznych:
	a) kliknij prawym przyciskiem na "CarRental" w Eclipse -> BuildPath-> AddExternalArchieves
	b) http://imgur.com/RxCfnec
	c) dodaj plik gson-2.3.1.jar z folderu Libraries, który Ci wys³a³em
	d) to samo zrób z plikiem junit-4.12
	e) w tym momencie Twój projekt powinien wygl¹daæ tak : "http://imgur.com/2RLcNcr"

4) Uruchomienie programu:
	a) System.GUI
	b) GUI.java
	c) Z menu Run -> Run.

W razie pytan pisz.
