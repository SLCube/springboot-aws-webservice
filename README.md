# springboot-aws-webservice
- '스프링부트와 AWS로 혼자 구현하는 웹서비스' 도서학습
- 학습기간 : 2022-06-23(목)

---

- JDK version : 1.8
- gradle version : 4.10.2

---
## spring security와 oauth2.0을 이용해 로그인기능을 구현하며..(2022.06.28 작성)

- 책에는 구글로그인, 네이버로그인을 구현했는데 
  우리나라사람중 카카오아이디가 없는사람은 거의 없으니
  카카오로그인까지 구현해보자 라는 생각이 들어 구현을 시도하려는데 궁금한점이 생겼다.

- 코드는 다음과 같다.

```java
public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if ("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }
```

- 네이버와 구글을 단순히 if문을 이용해 구분을 주었는데
  과연 저것이 좋은 코드인가 라는 생각이 들었다.

- 만약 페이스북을 이용한 로그인을 구현한다면? 
  혹은 다른 소셜미디어를 여러개를 추가한다면? 

- 고민되는부분을 정리하면 이렇다
    1. 위의 코드를 보면 소셜미디어 로그인이 추가될때마다 if문을 이용해 추가해주는데
    소셜미디어 로그인이 여러개 추가되면 코드를 '직접' 수정 해줘야된다. 과연 이것이 옳은일인가.
    
    1. 이 프로젝트가 책을 따라하며 단순히 따라하는 프로젝트가 아니라 실제 사용자들이 사용하는 서비스라면 소셜미디어 로그인을 우리의 서비스에 덕지덕지 붙여놓는것이 과연 옳은 일인가.
    