<image src="https://velog.velcdn.com/cloudflare/hippohami/763f57f5-5b66-4a2f-a117-79e603de2967/git.png" width=400>

# stash

### git stash

> **git pull**을 하기 전에 에러메시지가 뜨면서 제대로 pull이 되지 않았다. 뭐가 문제인지 봤더니 아직 커밋되지 않은 변경사항들이 있어서 정상적으로 작동하지 않은 것이다. '그런데 뭔가 아깝고 변경된 사항들을 잠시 옮겨두고 싶다?' 그럴때 쓰는 깃 명령어가 있다. 바로 **git stash** !

다시 정리해서 말하자면 `branch`를 이용하여 활발하게 작업을 하다보면, `branch` 작업이 완료되지 않은 상태에서 다른 `branch` 로 `checkout` 해야 하는 상황이 빈번하게 발생한다. 이럴때 아직 작업중인 파일을 `commit`을 하기도 곤란하고, `commit`을 하지 않으면 `checkout`이 어려운 상황이 발생한다.
그런 경우에 `stash`를 사용하여 작업중인 파일을 숨겨둘 수 있다.

```
git stash
```

**stash**는 작업 디렉토리와 인덱스의 현재 상태를 안전하게 저장해둘 수 있는 명령이다.
stash 는 감추다, 숨겨두다 라는 뜻을 갖고 있다.

stash 명령은 기본적으로 추적 중인 파일만 저장한다.

---

### git stash list

```
git stash list
stash@{0}: WIP on [branch이름]: [커밋 번호] [커밋 이름]
stash@{1}: WIP on [branch이름]: [커밋 번호] [커밋 이름]
stash@{2}: WIP on [branch이름]: [커밋 번호] [커밋 이름]
```

_(참고 : WIP는 working on progress의 줄임말이다.)_

`stash area` 에 저장되어 있는 것을 목록으로 확인할 때 사용한다.
**stash**는 `stack` 구조로 되어 있기 때문에 가장 가장 최근 것이 제일 위에 있다. 그래서 왠만하면 이름을 붙여 `stash`를 저장하는게 효율적이다.
`stash`에 이름을 붙여 저장하기 위해선 다음과 같은 명령어를 사용한다.

```
git stash save <stash-name>
```

---

### git stash pop

stash에 옮겨진 변경사항을 꺼내서 적용할 때 사용하는 명령어!

```
git stash pop
```

### 참고한 사이트

https://www.boostcourse.org/web344/lecture/35143?isDesc=false/
https://wayhome25.github.io/git/2017/04/05/git-05-stash/
