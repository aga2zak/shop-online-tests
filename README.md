# Testy automatyczne dla aplikacji webowej WebX

## Framework

- projekt *Maven*
- jezyk programowania *Java*
- biblioteki *Selenide*, aby odwoływać się do elementów DOM aplikacji
- wzorzec *PageObject* do organizacji klas i metod
- framework *Cucumber* opraty na metodologii BDD co uławia tworzenie i rozumienie skryptów testowych zgodnie z organizacją pracy w zespole PWO z uwzglednieniem oczekiwań biznesu
- framework *JUnit* wykorzystano głównie do raportowania i monitorowania testów na Jenkins

Dodatkowo:
Konfiguracja środowiska testowego uruchamia na Jenkins dodatkowy kontener *Selenoid* (konfiguracja w pliku *selenoid.yml* i *browsers.json*). Jest to Hub zarządzający dostępem do WebDriver przeglądarek (chrome, opera, firefox).

## Konfiguracja

- w pliku `config.properties` znajdują się domyślne ustawienia parametrów na których uruchamiane są testy
- można zmienić parametry wywołania albo zmieniając wpisy w pliku powyżej, albo uruchamiając testy lub test z konsoli

```sh
mvn -Durl=[https://adres] -DremoteUrl=[http://hub selenoid] -Dbrowser=[nazwa] -DbrowserVersion=[numer wersji] -Dlogin=[login] -Dpassword=[hasło] -Dcustomer=[klient] clean test
```

## Debugowanie

- Domyśla konfiguracja uruchamia testy na adresie <https://skleptest.pl/> na przeglądarce Chrome i WebDriver lokalnej maszyny na której uruchomiono testy


## Zasady i pluginy

- stosujemy ogólnie przyjęte standardy kodowania dla Java
- w IntelliJ używamy pluginu **google-java-format**
- testy są niezależne od siebie
- w IntelliJ włączyć pluginy dla Cucumber

| Plugin                     |
| -------------------------- |
| Cucumber +                 |
| Cucumber for Java          |
| Cucumber Scenarios Indexer |
| Gherkin                    |
