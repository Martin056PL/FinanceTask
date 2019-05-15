<b><strong>Procesor XML kont bankowych</strong></b>

Aplikacja ma za zadanie weryfikację kont bankowych dostarczonych pod postacią pliku xml.
Program zgodnie z określonymy kryteriami waliduje informacje o rachunkach, następnie zwalidowane konta sortuje leksykograficznie wg. nazwy rachunku i zwraca listę kont spełniających podane wymagania.
Zwalidowane konta umieszczane są w pilu xml.

Wymagania dotyczące informacji na temat rachunku:
- Rachunek musi posiadać informacje na temat: numer rachunku (IBAN)
- Nazwa rachunku
- Waluta w jakiej jest prowadzony rachunek
- Saldo rachunku
- Data zamknięcia rachunku

W katalogu "processor" należy umieścić plik z listą rachunków o nazwie "input.xml". W przypadku innej nazwy lub lokalizacji pliku program nie wykona walidacji i sortowania rachunków.
Struktura pliku input.xml powinna wyglądać następująco:

< accounts >
	< account iban="(wartość)" >
		< name >(wartość)< /name >
		< currency >(Wartość)< /currency >
		< balance >(Wartość)< /balance >
		< closingDate >(Wartość)< /closingDate >
	< /account >
	< account iban="(wartość)" >
    	.
	    .
	    .
	    .
	< /account >   
< /accounts >

Program zwraca przetworzone dane w tej samej strukturze.

<b>Założenie dotyczące danych rachunku</b>

Aby rachunek został pozytwynie zwalidowany informacje o rachunku muszą spełniać następujące kryteria:

Numer rachunku:
1. W pliku .xml musi zostać umieszczona informacja o numerze rachunku, inaczej rachunek zostanie odrzucony
2. Numer rachunku nie może być pusty ani sładać sie tylko z pustych znaków, inaczej rachunek zostanie odrzucony
3. Numer rachunku musi być w formacie IBAN (musi posiadać dwucyfrowy prefix skaładajacy się z dwóch liter wskazujących na nazwę kraju oraz dodatkowo 26 cyfr)
4. Numer rachunku musi wskazywać tylko na polski rachunek - prefix PL. Inny prefiks spowoduje odrzucenia rachunku
5. Program dopuszcza zapis polskiego prefixu małymi literami (tj. "pl") lub mieszany ("pL"/"Pl")
6. Numer rachunku musi mieć zapis ciągły (spacja zawarta wewnątrz numeru konta spowoduje odrzucenie rachunku)
7. Program dopuszcza znak spacji przed i/lub za numerem rachunku.

Nazwa rachunku:
1. W pliku .xml musi zostać umieszczona informacja o nazwie rachunku, inaczej rachunek zostanie odrzucony
2. Nazwa rachunku nie może być pusta ani sładać sie tylko z pustych znaków, inaczej rachunek zostanie odrzucony
3. Program dopuszcza dowolną nazwę rachunku. Dopuszczale są również znaki zapcji przed i/lub za nazwą rachunku

Waluta rachunku:
1. W pliku .xml musi zostać umieszczona informacja o walucie rachunku, inaczej rachunek zostanie odrzucony
2. Waluta rachunku nie może być pusta ani sładać sie tylko z pustych znaków, inaczej rachunek zostanie odrzucony
3. Waluta rachunku musi wskazywać na polską walutę tj. PLN. Inny nominał spowoduje odrzucenie konta.
4. Dopuszczalny jest zapis waluty rachunku małymi literami tj "pln"
5. Waluta rachunku musi mieć zapis ciągły (spacja zawarta wewnątrz waluty konta spowoduje odrzucenie rachunku)
6. Program dopuszcza znak spacji przed i/lub za walutą rachunku.

Saldo rachunku:
1. W pliku .xml musi zostać umieszczona informacja o saldzie rachunku, inaczej rachunek zostanie odrzucony
2. Saldo rachunku nie może być puste ani sładać sie tylko z pustych znaków, inaczej rachunek zostanie odrzucony
3. Saldo rachunku nie może byc mniejsze od zera
4. Serapator dziesiętny jest akceptowany tylko pod postacią kropki ("."). Separator pod inną postacią jest nieakceptowany i spowoduje odrzucenie konta.
5. Saldo rachunku musi się wyrażać tylko w postaci liczby. Słowny zapis kwoty jest niedopuszczalny i spowoduje odrzucenie rachunku

Data zamknięcia rachunku:
1. W pliku .xml musi zostać umieszczona informacja o dacie zamknięcia rachunku, inaczej rachunek zostanie odrzucony
2. Data zamknięcia rachunku nie może być pusta ani sładać sie tylko z pustych znaków, inaczej rachunek zostanie odrzucony
3. Data zamknięcia rachunku musi być tozsama z datą obecną lub przyszłą. Data przeszła jest nieakceptowalna i spowoduje odrzucenia konta
4. Jedyny akceptowalny format daty zakmnięcia rachunku to yyyy-MM-dd gdzie: y - rok, M - miesiąc, d - dzień, inny format spowoduje odrzucenia konta
5. Program nie uwzględnia stref czasowych
