## Express js란?
### 공부하기에 앞서..
> Python의 `Flask`에 어느 정도 익숙해질 찰나에 **Node.js**의 REST API를 구축하는데 중요한 역할을 하는 Express.js를 이번주부터 배우기 시작했다.
> * * *
>![이미지](https://miro.medium.com/max/1400/1*XP-mZOrIqX7OsFInN2ngRQ.png)
>`Flask`로 경험했던 웹 서버 구축 개념이 많이 다르지 않을 것이니 일단 이번주는 차분히 전체적으로 숙지한다는 생각으로 공부해봐야겠다.
> - **Express.js**는 **Node.js로 서버를 빠르고 간편하게 만들 수 있게 도와주는 웹 프레임워크**
> - **Express.js** 이외에 다양한 웹 프레임워크가 존재하지만 오늘날 가장 많은 **Node.js** 웹서버가  **Express.js** 프레임워크를 통해 개발되었다.
> - 최근 각광받고 있는 **Node.js**의 웹 프레임워크로 **Nest.js**도 있다. **Next.js**는 뭘까?
## Routing이란?
> + **Routing**은 클라이언트의 요청 조건(메서드, 주소 등)에 대응해 응답하는 방식.
> + **Router**는 클라이언트의 요청을 쉽게 처리할 수 있게 도와주는 **Express.js** 기능 중 하나!
> 
```javascript
router.METHOD(PATH, HANDLER);
```
+ router : express의 라우터를 정의하기 위해 사용.
+ METHOD : http Method를 나타낸다. (get, post, put, delete)
+ PATH : 실제 서버에서 API를 사용하기 위한 경로.
+ HANDLER : 라우트가 일치할 때 실행되는 함수.