# 원격저장소(remote repository)

<image src="https://velog.velcdn.com/cloudflare/hippohami/763f57f5-5b66-4a2f-a117-79e603de2967/git.png">

## 원격 저장소 설정 및 삭제를 배워보자.

> 일단 현재 연결된 원격 저장소를 확인해보자.

```
git remote -v
```

---

> 연결되어 있는 원격 저장소 끊기!

```
git remote remove origin
git remote -v
```

---

> 원격 저장소 연결하기

```
git remote add origin <link>
```

`link`란에는 깃 주소를 적어주면 된다.
