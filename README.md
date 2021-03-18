# gitPractice
There is nothing to see here. This repo was created to improve my git skills gradually. 

# MiniCrmProject
Репозиторий содержит учебный проект. Это CRM система, в которой есть пользователи с разными правами доступа (в зависимости от роли) и, соответственно, разным функционалом. 

## Функционал:
- добавление / обновление / удаление работников
- просмотр фото работника
- поиск по имени / фамилии
- сортировка по имени / фамилии / email
- просмотр списка всех пользователей crm с ролями (только для роли Admin)
- пагинация


## Stack
Spring Boot, Spring Data JPA, Spring Security, JUnit, Postgresql (Docker image), Thymeleaf, Maven

## Инструкции по запуску приложения
- Инициализация БД:
1. установить docker клиент
2. развернуть образ с базой данных, командой docker-compose up -d из корня проекта
3. подключиться к БД любым клиентом, используя строку подключения: jdbc:postgresql://localhost:54320/postgres username/password: postgres
4. создать БД для нужд проекта командой в клиенте: create database minicrm;
5. подключиться к БД minicrm клиентом по адресу jdbc:postgresql://localhost:54320/minicrm username/password: postgres и выполнить команды из скрипта home/sql-scripts/postgresInit.sql
Здесь же сразу можно создать БД для интеграционных тестов: create database minicrmtests. Скрипт инициализации выполнять не требуется.

- Запуск приложения:
Если на локальной машине установлен Maven: ```sh mvnw spring-boot:run ```
Если на локальной машине не установлен Maven: ```sh mvn spring-boot:run ```

Приложение будет доступно по адресу ```sh http://localhost:8888 ```

Данные для входа
Admin: alena (пароль pass123)
Manager: boris (пароль pass123)
Employee: andrey (пароль pass123)

## Тестирование
В проекте реализовано интеграционное тестирование (контроллер, логин система) и модульное тестирование (методы сервисов).
Команда для запуска тестов: ```sh mvn clean test ``` или ```sh mvnw clean test ```
