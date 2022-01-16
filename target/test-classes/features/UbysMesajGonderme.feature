@UBYS
  Feature: UBYS giris yapip mesaj gonderme
    Scenario: ubys mesaj gonderme
      When Kullanici UBYS sayfasina gidilir
      Then Gecerli kullanici adi ve password girilir
      And  Mesajlar sekmesine basilir
      And  Tolgahan kisisine tiklanir ve mesaj atilir