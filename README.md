# Автоматизация тестов

Проект автоматизации веб-тестов с использованием **Selenide**, **JUnit5** и **Allure**.

## Установка

1. Клонировать репозиторий:
   bash
   git clone https://github.com/NiDimAr/IFQA_Nikitin/tree/IF_HW6
   cd project
   Собрать проект:
   mvn clean install

Все настройки хранятся в src/test/resources/application.properties
Доступ к настройкам осуществляется через класс Config:
Все проверки значений выполняются в классе Config автоматически.

Запуск тестов

mvn test
Allure отчёт
allure serve target/allure-results
Структура проекта
src/
├─ main/java
├─ test/java
├─ test/resources/application.properties
pom.xml
.gitignore
README.md
Контакты
Email: nidim.nikitin97@yandex.ru