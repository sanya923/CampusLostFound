# Campus Lost & Found Matching System

A full-stack Java OOP mini-project for a college campus.

## Features
- Report a lost item
- Report a found item
- Search by category, location and keyword
- Date-based matching
- Description/keyword matching
- Automatic possible-match scoring
- Owner/contact information
- File persistence using CSV
- Sorting using Java Collections
- REST-like JSON API using Java's built-in HttpServer
- Responsive frontend using HTML/CSS/JavaScript

## Tech Stack
Frontend: HTML5, CSS3, JavaScript
Backend: Java 17+, `com.sun.net.httpserver.HttpServer`
Storage: CSV file
No external Java framework is required.

## Run
1. Install JDK 17+.
2. Open terminal in this project folder.
3. Compile:
   `javac -d out src/main/java/com/campus/lostfound/*.java`
4. Run:
   `java -cp out com.campus.lostfound.LostFoundServer`
5. Open:
   `frontend/index.html`

The frontend expects the backend at `http://localhost:8080`.

## OOP concepts used
- Encapsulation: private fields + getters/setters in `Item`, `Contact`, `MatchResult`.
- Inheritance: `LostItem` and `FoundItem` extend `Item`.
- Abstraction: `Item` is an abstract class and `ItemRepository` is an interface.
- Polymorphism: repository is referenced through `ItemRepository`; `LostItem` and `FoundItem` are handled as `Item`.
- Constructors: overloaded constructors in model classes.
- Method overriding: `getType()` is overridden by `LostItem` and `FoundItem`.
- Composition: `Item` contains a `Contact` object.
- Collections: `ArrayList<Item>`, sorting with `Collections.sort` / `Comparator`.
- String handling: keyword extraction, lowercase normalization, token matching.
- File handling: CSV load/save through `FileItemRepository`.
- Exception handling: validation and file/HTTP error handling.

## API
GET `/api/items`
GET `/api/items?type=LOST&category=Electronics&location=Library&keyword=black`
GET `/api/matches/{id}`
POST `/api/items`

Example POST:
```json
{
  "type":"LOST",
  "name":"Black Wallet",
  "category":"Accessories",
  "description":"Black leather wallet with college ID",
  "location":"Central Library",
  "date":"2026-09-28",
  "ownerName":"Sanya",
  "email":"student@example.com",
  "phone":"9876543210"
}
```
