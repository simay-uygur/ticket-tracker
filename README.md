# ticket-tracker



com.example.tickettracker
│
├── auth
│   ├── AuthController.java
│   ├── AuthService.java
│   ├── JwtTokenProvider.java
│   ├── JwtAuthenticationFilter.java
│   ├── SecurityConfig.java
│
├── user
│   ├── User.java
│   ├── UserRepository.java
│   ├── UserService.java
│   └── Role.java (enum)
│
├── dto
│   ├── LoginRequest.java
│   ├── SignupRequest.java
│   └── JwtResponse.java




com.example.tickettracker
│
├── controller
│   ├── AuthController.java
│   ├── ConcertController.java
│   └── ArtistController.java
│
├── service
│   ├── AuthService.java
│   └── ...
│
├── security
│   ├── JwtTokenProvider.java
│   ├── JwtAuthenticationFilter.java
│   └── SecurityConfig.java
│
├── entity
│   ├── User.java
│   ├── Artist.java
│   └── Concert.java
│
├── repository
│   └── UserRepository.java
│
├── dto
│   ├── SignupRequest.java
│   ├── LoginRequest.java
│   └── JwtResponse.java
<<<

