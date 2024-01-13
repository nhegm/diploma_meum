# Git. README.md

## Начало работы

Чтобы скопировать себе данный репозиторий достаточно установить Git ([ссылка](https://git-scm.com/book/ru/v2/%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%A3%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0-Git)), затем проделать данные шаги:

1. Создать каталог в любом месте на своём компьютере
2. Вызвать контекстное меню данной папки (ПКМ на этой папке)
3. Выбрать "Git Bash Here"
4. Ввести команду: git clone https://github.com/nhegm/diploma_meum

### Prerequisites

Что нужно установить на ПК для использования (например: Git, браузер и т.д.).

```
Git
IntelliJ IDEA Community Edition последней версии
Docker
DBeaver
Google Chrome последней версии
```

### Установка и запуск

Пошаговый процесс установки и запуска

```
1. Запустить Docker (под Windows).
2. В терминале java запустить контейнеры командой:
    docker-compose up --build
3. В терминале java запустить приложение с БД mysql:
    java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
4. Запустить тесты командой:
    ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"     
5. В терминале java запустить приложение с БД postgresql:
    java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
6. Запустить тесты командой:
    ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
```
