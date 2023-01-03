@login
Feature: TC-001 Login Islemleri

  Scenario: Gecerli kullanici bilgileriyle login olunmasi

    Given Kullanici giris sayfasini goruntuler
    And Dil olarak English secilir
    And Explore butonuna tiklanir
    And Ana sayfa goruntulenir
    And Hesabim butonuna tiklanir
    And Daha once giris yapılmıssa giris secenekleri sekmesi asagi kaydirilir
    And Sayfa uzerindeki Create Your Account yazisi gorulur
    And Continue with Email butonuna tiklanir
    And Sayfa uzerindeki Enter your email address yazisi gorulur
    And Email address kutusu eMail-Not-Valid ile doldurulur
    And Send butonuna tiklanir
    And Sayfa uzerindeki Email address is not valid yazisi gorulur
    And Email address kutusu eMail-Not-Valid2 ile doldurulur
    And Send butonuna tiklanir
    And Sayfa uzerindeki Invalid parameter, please check error details yazisi gorulur
    And Email address kutusu eMail-Valid ile doldurulur
    And Send butonuna tiklanir
    And Sayfa uzerindeki Your magic link has been sent to your email address yazisi gorulur


