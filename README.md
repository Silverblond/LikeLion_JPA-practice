## 1. 개발한 기능 및 방법(프로그램의 흐름)
User-Post REST API 구현
- GET/api/v1/users : 전체 유저 조회
- GET/api/v1/users/{id} : 단일 유저 조회(ID로 검색)
- POST/api/v1/users : 신규 유저 등록
- PUT/api/v1/users/{id} : 특정 유저 전체 수정
- PATCH/api/v1/users/{id} : 특정 유저 부분수정
- DELETE/api/v1/users/{id} : 특정 유저 삭제

- GET/api/v1/users/post : 전체 글 조회
- GET/api/v1/users/post/{id} : 단일 글 조회(ID로 검색)
- POST/api/v1/users/post : 신규 글 등록
- PUT/api/v1/users/post/{id} : 특정 글 전체 수정
- PATCH/api/v1/users/post/{id} : 특정 글 부분수정
- DELETE/api/v1/users/post/{id} : 특정 글 삭제

## 2.내가 개발할 때 유의 깊게 개발한 부분
1. JPA을 사용하면서 이전에 도서 API를 개발했을때랑 어떤부분이 다른지 생각하였습니다.
2. 이전에 DTO를 잘모르고 사용할 줄 몰랐는데, 이번엔 최대한 사용해보고자 하였습니다.
3. 람다 함수 사용하는걸 최대한 참고하면서 작성해 보았습니다.

## 3. 개발하면서 들었던 의문 사항
1. builer()가 얼추 builder에 선언한 애들을 enum처럼 활용할 수 있다는 건 알겠는데, 정확히 어떻게 활용해야할지 모르겠습니다. 그래서 어쩌다보니 사용하지 않게 되었네요.
2. 의문사항은 크게 없었고, 오랜만에 다시 보니깐 Repository interface만 선언하고 내부에 아무내용도 없고, 구현부도 없으니깐 "어? 안되는거 아닌가?"했는데 생각해보니 이미 다 되어있는 거였네요..

## 4. 코드 리뷰어에게 전하는 말
잘부탁드립니다.
