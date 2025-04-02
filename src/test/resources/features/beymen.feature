@beymen
Feature: Beymen Web Sitesi Uzerinde Arama ve Sepet Islemleri

  Scenario: Kullanici urun arama, sepete ekleme ve dogrulama islemlerini gerceklestirir
    Given Kullanici "https://www.beymen.com/" sitesini acar
    Then Ana sayfanin acildigini dogrular
    When Kullanici arama kutucuguna Excel dosyasindan "1,1" hucresindeki "sort" kelimesini girer
    And Kullanici arama kutucuguna girilen "sort" kelimesini siler
    And Kullanici arama kutucuguna Excel den "2,1" hucresindeki "gomlek" kelimesini girer
    And Kullanici klavye uzerinden "Enter" tusuna basar
    Then Sonuclara gore sergilenen urunlerden rastgele bir urun secilir
    And Secilen urunun bilgisi ve tutar bilgisi "urun_bilgileri.txt" dosyasina yazilir
    When Secilen urun sepete eklenir
    Then Urun sayfasindaki fiyat ile sepetteki fiyatin dogrulugu karsilastirilir
    When Kullanici sepetteki urun adedini 2'ye cikarir
    Then Urun adedinin 2 oldugu dogrulanir
    When Kullanici urunu sepetten siler
    Then Sepetin bos oldugu dogrulanir

