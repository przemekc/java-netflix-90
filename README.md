# java-netflix-90

## resources

- VideoCassette - klasa reprezentuje wypożyczaną kasetę
- Director - reżyser filmu
- Actor - aktor filmu
- Category - typ wyliczeniowy reprezentujący gatunek filmu
- Gender - typ wyliczeniowy płeć
- Discontable - interfejs znizek - poczatek

## clients - package clients

Zaimplementuj obszar zarzadzania klientami

- klasa Client 
  - atrybuty:
    - identyfikator - String
    - imie
    - nazwisko
    - adres - rozwaz uzycie klasy adres reprezentujacej polski adres. 
    Jakie widzisz zalety uzycia takiej klasy?
    - status klienta - klient typu VIP, NORMAL
    - zastanow sie nad enkapsulacja adresow. Nie pozwol zeby klient nie wiedzial o modyfikacji adresow.

Rozważ wykorzystanie istniejacych juz w projekcie klas. Czy widzisz potrzebe innego podzialu na pakiety?

- klasa ClientCatalog - zapisuje i odczytuje klientow z pliku clients.txt

## video cassetes rentals (wypozyczenia)

Zaimplementuj rejestr wypozyczen

- Klasa Rent (wypozyczenie)
  - atrybuty: 
    - identity - identyfikator - kolejny numer wypozyczenia
    - clientId - identyfikator klienta zgodny z identyfikatorem klasy Client
    - casseteId - identyfikator kasety
    - rentDate - data wypozyczenia
    - rentDays - liczba dni wypozyczenia
    - rentCost - koszt wypozyczenia (obliczany na podstawie dni i kosztu: 5 PLN za dobe. klient VIP znizka 10% na wypozyczenie jesli wypozycza a wiecej niz 3 dni)
    - returnDate - data zwrotu
 - Klasa Rent registry: rejest wypozyczen trzymajacy dane w pamieci i zapisujacy jednoczenie dane do pliku rents.txt.
 
- Robimy fork repo (Lead zespolu)
- dodajmy team members
- member akceptuje zaproszenie na mailu
- kazdy klonuje repo z adresu od Leada
- Lead robi branch dev i pushuje na zdalne repo
- kazdy member pracuje na swoim banchu feature 
  wywiedzionym z dev (checkout -b)
- kazdy member zglasza zmiane PR do team repo

- Kodowanie:
- klasa Category (nazwa, opis) - zapisywana do bazy
- klasa Actor
- klasa Director






