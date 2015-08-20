Jak uruchomi� ten projekt :
1) File -> New -> JavaProject
	(Przy wpisywaniu czegokolwiek pomijaj �redniki)

	a) tutaj podaj nazw� projektu "CarRental" , oraz lokalizacje jego
	b) w miejscu JRE b�dz pewny ,�e masz zaznaczone "Use an execution environment JRE : Java SE-1.8"
	c) je�li masz zazanczona wersje nizsza niz 1.8 , to :
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
	a) wejdz do folderu "CarRental" , kt�ry Ci wys�a�em
	b) upewnij si� ,�e masz w��czony w "Eclipse" widok "Package Explorer"
	c) przeci�gnij na nazw� "CarRental" w Eclipse , foldery : Clock, CarRental,CPU,Customers,Employers ( powinny tam byc tylko pliki txt ).
	d) przejdz do folderu "src" w folderze ,ktory Ci wyslalem
	e) folder "System" przenie� do folderu "src" ,kt�ry znajduje si� w Twoim projekcie
	f) w tym momencie Tw�j projekt powinien wygl�da� tak : "http://imgur.com/eFe1N58"

3) Dodawanie bibliotek zewn�trznych:
	a) kliknij prawym przyciskiem na "CarRental" w Eclipse -> BuildPath-> AddExternalArchieves
	b) http://imgur.com/RxCfnec
	c) dodaj plik gson-2.3.1.jar z folderu Libraries, kt�ry Ci wys�a�em
	d) to samo zr�b z plikiem junit-4.12
	e) w tym momencie Tw�j projekt powinien wygl�da� tak : "http://imgur.com/2RLcNcr"

4) Uruchomienie programu:
	a) System.GUI
	b) GUI.java
	c) Z menu Run -> Run.

W razie pytan pisz.
