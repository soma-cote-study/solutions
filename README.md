# Soma Coding Test Study
소프트웨어 마에스트로 코딩테스트 대비를 위한 알고리즘 & SQL 스터디입니다.

---

## 스터디원
- [김소희](https://github.com/sohee52): C++
- [박세민](https://github.com/semInDev): Java, Python
- [나원빈](https://github.com/tray0244): Java
- [심유진](https://github.com/ujinsim): JavaScript
- [이하영](https://github.com/hayeounglee): Python

---

## 스터디 깃허브 활용법
- `main` 브랜치에는 직접 push하지 않습니다.
- 각 주차별로 개인 브랜치를 생성하여 작업합니다.

### 브랜치 전략
- `main` 브랜치: 모든 스터디원이 푼 문제들의 풀이가 모여있는 브랜치
- `weekN/이름` 브랜치: 각 주차별로 본인이 푼 문제들의 풀이를 올리는 브랜치
  - N: 주차 (1~9)
  - 이름: 본인 이름 (예: sohee, semin, ...)
  - 예: `week1/sohee`, `week2/semin`, ...

### Repo 구조
```
solutions/
├── week1/
│   ├── hayoung/
│   │   ├── BOJ_어린_왕자.cpp
│   │   ├── Programmers_가장_큰_수.sql
│   ├── semin/
│   │   ├── BOJ_어린_왕자.java
│   │   └── Programmers_가장_큰_수.sql
│   ├── sohee/
│   ├── ujin/
│   ├── wonbin/
│
├── week2/
│   ├── hayoung/
│   └── semin/
│   └── sohee/
│   └── ujin/
│   └── wonbin/
```

#### 파일 이름 
- 백준 문제: `BOJ_문제이름.확장자` (예: `BOJ_어린_왕자.cpp`)
- 프로그래머스 문제: `Programmers_문제이름.확장자` (예: `Programmers_가장_큰_수.py`, `Programmers_거리두기_확인하기.sql`)

### 커밋 컨벤션
#### type 목록
| type       | 의미          |
| ---------- | ----------- |
| `solve`    | 문제 풀이 추가    |
| `refactor` | 풀이 개선, 리팩토링 |
| `fix`      | 오답 수정, 예외 처리       | 
| `docs`     | 문서 수정       |
| `chore`    | 기타 작업(폴더 정리, 파일명 변경)       |

#### 커밋 메시지 작성법
- 형식:
    ```
    <type>: <플랫폼>_<문제이름>.<확장자>
    <type>: <플랫폼>_<문제이름>.<확장자> - 간단한 설명
    ```
  - 간단한 설명은 선택 사항입니다.
  - docs와 chore의 경우 위의 형식을 따르지 않고 작업 내용을 간단히 작성해도 됩니다.
- 예시:
    ```
    solve: BOJ_어린_왕자.cpp
    refactor: Programmers_가장_큰_수.py - 코드 최적화
    fix: BOJ_숫자_카드_2.java - 예외 처리 추가
    docs: README.md - 스터디 소개 업데이트
    chore: solutions/week1/김소희 - 폴더 구조 정리
    ```
### PR
- **PR 주기**: **목요일, 일요일**에 PR 업로드
- **PR 단위**: 여러 문제를 **하나의 PR**로 묶어서 제출
- **PR 양식**: 템플릿 양식에 맞춰서 작성 ([PR 템플릿 보기](.github/pull_request_template.md))

### Code Review
- PR에 코드 및 아이디어 리뷰 진행
- 리뷰하고 싶은 코드 라인 옆의 + 버튼을 클릭하여 코멘트 작성

---

## 주차별 유형 및 진행 현황
| 주차  | 유형 | 김소희 | 박세민 | 나원빈 | 심유진 | 이하영 |
|-------|------|--------|--------|--------|--------|--------|
| 1주차 | 구현, 조합, 유니온파인드, SQL |  |  |  |  |  |
| 2주차 | DFS/BFS, 그래프, deque/큐, SQL |  |  |  |  |  |
| 3주차 | DFS/BFS, 그래프, deque/큐, SQL |  |  |  |  |  |
| 4주차 | DFS/BFS, 분할정복, 백트래킹, SQL |  |  |  |  |  |
| 5주차 | DP, 수학, 자료구조, SQL |  |  |  |  |  |
| 6주차 | DP, 완전탐색, SQL |  |  |  |  |  |
| 7주차 | 그리디, 이분탐색, SQL |  |  |  |  |  |
| 8주차 | 정렬, 비트마스킹, SQL |  |  |  |  |  |
| 9주차 | - |  |  |  |  |  |

> 진행 현황 표는 매주 목요일과 일요일에 PR이 머지된 후에 업데이트 됩니다.

### 상태 표시:
- ✅: 모든 문제 풀이 완료
- ⭕: 일부 문제 풀이 완료
- ❌: 문제 풀이 미완료

> 주차별로 본인 이름 밑에 2개의 상태가 표시됩니다.
> 
> (예: "✅⭕" → 목요일 모든 문제 풀이 완료, 일요일 일부 문제 풀이 완료)


