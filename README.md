# Сервис обработки запросов

## Общая информация о проекте
Проект создан как тестовое задание для ООО "ГПБ Инвестиции". Список используемых технологий и инструментария:

* Java 17
* Spring Boot
* OpenAPI 3.0
* Maven
* MongoDb
* Docker-Compose
* Junit5
* TestContainers

## Инструкция по запуску
Если вы хотите познакомиться с проектом поближе, то выполните следующие действия:

* Выполните mvn clean package и дождитесь сборки jar-файла.
* Если при сборке не запускается TestContainers, то следует выполнить docker pull testcontainers/ryuk:0.3.4
* Затем выполните в терминале docker-compose up -d в папке проекта и дождитесь поднятия контейнеров
* Откройте в браузере http://localhost:8080/swagger-ui/index.html#/

