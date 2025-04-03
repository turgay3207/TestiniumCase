@trelloapi
Feature: Trello API Otomasyonu

  Scenario: Kullanici Trello uzerinde bir board olusturur ve kart islemlerini yapar
    Given Kullanici Trello API ile yeni bir "Test Board" olusturur
    When Kullanici bu board'a "Card 1" ve "Card 2" isimli iki kart ekler
    And Kullanici rastgele bir karti "Card 3" olarak gunceller
    And Kullanici tum kartlari siler
    And Kullanici board'u siler

