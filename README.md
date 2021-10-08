# Opis rozwiązań

### Zadanie 1

W zadaniu 1 zostały utworzone 2 klasy, DeciduousTree (drzewo liściaste) i ConiferTree (drzewo iglaste). Dziedziczą one 
z klasy Tree (drzewo). W tej klasie znajduje się obiekt Trunk (pień), lista obiektów klasy Branch (gałąź), lista 
obiektów ILeaf (interfejs liścia). Klasy Needle (igła) i Leaf (liść) implementują ten interfejs. Dodatkowo w klasie
Tree znajduje się lista obiektów IFruit (interfejs owocu). Drzewo posiada również metody:
* grow() - metoda oznaczjąca rośnięcie drzewa, tj. zwiększanie pnia, zwiększanie ilości gałązek itp.
* growFruit() - metoda oznaczająca rośnięcie owoców,
* growLeaves() - metoda oznaczająca rośnięcie liści,
* produceOxygen() - metoda oznaczająca produkcję tlenu,
* shedLeaves() - metoda oznaczająca tracenie liści,
* dropFruits() - metoda oznaczająca zrzucanie owoców,
* hibernate() - metoda oznaczająca hibernację,

### Zadanie 2

W zadaniu 2 został stworzony model oraz DTO lokalizacji, który zawiera:

* id - identyfikator wpisu, typem tej zmiennej jest Long, występuje tylko w modelu
* deviceId - identyfikator urządzenia które wysłało dane, typem tej zmiennej jest String
* latitude - szerokość geograficzna, typem tej zmiennej jest int
* longitude - długość geograficzna, typem tej zmiennej jest int

Poza tym, zostało stworzone repozytorium, rozszerzające klasę JpaRepository. Poza domyślnymi 
metodami znajdującymi się w repo, dodana została metoda znajdująca wszystkie wpisy dla danego urządzenia.

Również został stworzony interfejs serwisu oraz jego implementacja. Posiadają one podstawowe metody, takie jak zapis
pojedynczego obiektu, wielu obiektów, usuwanie po identyfikatorze, wyszukiwanie po identyfikatorze, wyszukiwanie
wszystkich obiektów oraz wyszukiwanie wszystkich obiektów które mają dany identyfikator urządzenia.

Kontroler dla tego zadania posiada 2 endpointy:
* /localisation - Request typu GET zwróci wszystkie wpisy pobranych lokalizacji znajdujące się w bazie. Request typu 
POST przyjmuje JSON (np. {"deviceId":"12345","latitude":50231,"longitude":12314}) i zapisuje te dane do bazy.
* /localisation/device - Request typu GET, należy podać parametr w requ.escie 
(np. /localisation/device?deviceId=1231145). Zwrócone zostaną wszystkie wpisy dla danego urządzenia. 

### Zadanie 3

W zadaniu 3 została zaimplementowana biblioteka obsługująca faktury w systemie płatności Stripe. Aby z niej korzystać, 
użytkownik podaje swój klucz API w konstruktorze obiektu StripeLibrary. Następnie, może tworzyć dla danego użytkownika
fakturę poprzez użycie funkcji _createInvoice(customer)_, gdzie customer jest identyfikatorem użytkownika. Jako
odpowiedź, użytkownik otrzyma informację o pomyślnym utworzeniu faktury oraz otrzyma jej ID, bądź
otrzyma informację o błędzie. Poza tym, może on również pobrać fakturę poprzez użycie funkcji _getInvoice(invoiceId)_, 
gdzie invoiceId jest identyfikatorem faktury. Jeżeli faktura istnieje, zostanie ona zwrócona jako obiekt klasy 
JSONObject. Jeżeli jednak wystąpi błąd, zostanie zwrócona wartość _null_ oraz zostanie wyświetlona informacja o błędzie.

### Podsumowanie

Zadanie zostało wykonane w Spring Boot 2, przeprowadzone zostały testy jednostkowe na serwisie lokalizacji. Również
wymagane jest zalogowanie się na domyślnego użytkow,0nika aby móc wysyłać jakiekolwiek requesty.