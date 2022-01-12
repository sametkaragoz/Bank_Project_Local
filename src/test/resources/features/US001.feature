@US001
  Feature: US001 Sistem, herhangi bir kullanıcının başarı mesajıyla doğrulanan
           geçerli kimlik bilgileriyle kaydolmasına izin vermelidir.

  Scenario: TC001 register sayfasina gidilip kayit olunmali
    When GMIBank sayfasina gidilir
    Then Sag ustteki insan figurune tiklanir ve ardindan register butonuna tiklanir
    Then Acilan Registration sayfasinin dogru sayfa oldugu kontrol edilir
    And  SSN, 9 haneli ve ***-**-**** formatinda olmalidir
    And  First Name bilgisi girilir
    And  Last Name bilgisi girilir
    And  Adress bilgisi girilir
    And  Phone Number, 10 haneli ve ***-***-**** formatinda olmalidir
    And  Username bilgisi girilir
    And  Email, '@' ve '.' karakterlerini icermelidir
    And  New password, en guclu olmasi icin en az bir rakam, buyuk harf, ozel karakter ve toplam 7 hane icermelidir
    And  Password strength, tum barlar dolmali ve yesil olmalidir
    And  New password confirmation, new password ile ayni olmalidir
    And  Gerekli bilgi kutularinin hepsinin bos olmadigi test edilir
    And  Register butonuna basilir ve kayit mesaji alinir
