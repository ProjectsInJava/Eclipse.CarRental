# CarRental

Jak uruchomić ten projekt :
1) File -> New -> JavaProject
	(Przy wpisywaniu czegokolwiek pomijaj średniki)

	a) tutaj podaj nazwę projektu "CarRental" , oraz lokalizacje jego
	b) w miejscu JRE bądz pewny ,że masz zaznaczone "Use an execution environment JRE : Java SE-1.8"
	c) jeśli masz zazanczona wersje nizsza niz 1.8 , to :
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
	a) wejdz do folderu "CarRental" , który Ci wysłałem
	b) upewnij się ,że masz włączony w "Eclipse" widok "Package Explorer"
	c) przeciągnij na nazwę "CarRental" w Eclipse , foldery : Clock, CarRental,CPU,Customers,Employers ( powinny tam byc tylko pliki txt ).
	d) przejdz do folderu "src" w folderze ,ktory Ci wyslalem
	e) folder "System" przenieś do folderu "src" ,który znajduje się w Twoim projekcie
	f) w tym momencie Twój projekt powinien wyglądać tak : "http://imgur.com/eFe1N58"

3) Dodawanie bibliotek zewnętrznych:
	a) kliknij prawym przyciskiem na "CarRental" w Eclipse -> BuildPath-> AddExternalArchieves
	b) http://imgur.com/RxCfnec
	c) dodaj plik gson-2.3.1.jar z folderu Libraries, który Ci wysłałem
	d) to samo zrób z plikiem junit-4.12
	e) w tym momencie Twój projekt powinien wyglądać tak : "http://imgur.com/2RLcNcr"

4) Uruchomienie programu:
	a) System.GUI
	b) GUI.java
	c) Z menu Run -> Run.

5) Jak dziala program:
	a) Tryb Kupującego:
		- Podaj Customer Name : String
		- Podaj Customer ID : String
		- Podaj Length Of Rent : Integer
		- Wybierz Auto z dostępnych klikając na nie
		- Kliknij Order
	b) Tryb Sprzedającego:
		- Aby Dodac Auto nowe uzupelnij pola:
			- Podaj Car Brand : String
			- Podaj Car Model : String
			- Podaj Car Price : Integer
			- Add Car
		- Aby obliczyć aktualny zarobek 
			- wybierz liczby dni do przodu
			- Nacisnij Recalculate Through
			- Zmieni się liczba aktualnych Transakcji, czas i zarobek
	c) Ładowanie i Zapisywanie danych :
		- aktualny stan programu ładowany jest z folderów z pliku projektu podczas włączania programu
		- aktualny stan programu zapisywany jest z folderów z pliku projektu podczas wyłączania programu czerwonym X-sem.
