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