# 원격저장소(remote repository)

<image src="https://velog.velcdn.com/cloudflare/hippohami/763f57f5-5b66-4a2f-a117-79e603de2967/git.png" width="500">

## 원격 저장소 설정 및 삭제를 배워보자.

> 일단 현재 연결된 원격 저장소를 확인해보자.

```
git remote -v
```

명령어를 실행하면 연결된 원격저장소의 정보를 보여준다.

<image src="https://user-images.githubusercontent.com/104766571/210096667-8cf75441-1ca8-40d0-ab04-8de855d176c2.png">

---

> 연결되어 있는 원격 저장소 끊기!

```
git remote remove origin
git remote -v
```

---

> 원격 저장소의 상세정보 확인 가능 및 브랜치 정보도 확인 가능

```
git remote show origin
```

---

> 원격 저장소 연결하기

```
git remote add origin <link>
```

`link`란에는 깃 주소를 적어주면 된다.
