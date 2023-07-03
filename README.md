# Testy automatyczne dla testowej aplikacji webowej [skleptest.pl](https://skleptest.pl/)

## Framework

- projekt *Maven*
- jezyk programowania *Java*
- biblioteki *Selenide*, aby odwoływać się do elementów DOM aplikacji
- wzorzec *PageObject* do organizacji klas i metod
- framework *Cucumber* opraty na metodologii BDD
- framework *JUnit* wykorzystano głównie do raportowania i monitorowania testów na Jenkins

Dodatkowo:
Konfiguracja środowiska testowego uruchamia na Jenkins dodatkowy kontener *Selenoid* (konfiguracja w pliku *selenoid.yml* i *browsers.json*). Jest to Hub zarządzający dostępem do WebDriver przeglądarek (chrome, opera, firefox).

## Konfiguracja

- w pliku `config.properties` znajdują się domyślne ustawienia parametrów na których uruchamiane są testy
- można zmienić parametry wywołania albo zmieniając wpisy w pliku powyżej, albo uruchamiając testy lub test z konsoli

```sh
mvn -Durl=[https://adres] -DremoteUrl=[http://hub selenoid] -Dbrowser=[nazwa] -DbrowserVersion=[numer wersji] clean test
```

## Debugowanie

- Domyśla konfiguracja uruchamia testy na adresie <https://skleptest.pl/> na przeglądarce Chrome i WebDriver lokalnej maszyny na której uruchomiono testy


## Zasady i pluginy

- testy są niezależne od siebie
- pluginy dla Cucumber

| Plugin                     |
| -------------------------- |
| Cucumber +                 |
| Cucumber for Java          |
| Cucumber Scenarios Indexer |
| Gherkin                    |
