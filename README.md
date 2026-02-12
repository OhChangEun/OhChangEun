# 👋 안녕하세요! 저는 홍길동입니다
### Full-Stack Software Engineer | Automotive Domain Expert

---

## 🚀 About Me
**자동차 산업의 디지털 전환**을 경험하고 **사용자 중심 프론트엔드 개발**로 확장한 개발자입니다.  

현대자동차 협력사에서 검차라인 DB 관리, 차량 통신 테스트, 진단 데이터 관리 시스템을 개발하며  
**자동차 도메인 전문성**과 **데이터 무결성 설계 역량**을 쌓았습니다.  

이후 React/Next.js 기반 프론트엔드 개발로 전환하여 **영화 검색 플랫폼**, **학원 ERP 시스템**을 구축하며  
**상태 관리**, **성능 최적화**, **인증 시스템 설계** 경험을 확보했습니다.  

현재는 **프론트엔드-백엔드를 아우르는 풀스택 개발자**로서  
안정적이고 확장 가능한 서비스를 만드는 것을 목표로 하고 있습니다.

---

## 🛠 Tech Stack

| Category   | Tech Stack |
|-----------|-----------|
| **Frontend** | ![React](https://img.shields.io/badge/React-61DAFB?style=flat&logo=react&logoColor=black) ![Next.js](https://img.shields.io/badge/Next.js-black?style=flat&logo=next.js) ![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=flat&logo=typescript&logoColor=white) ![Vue.js](https://img.shields.io/badge/Vue.js-4FC08D?style=flat&logo=vue.js&logoColor=white) ![TailwindCSS](https://img.shields.io/badge/TailwindCSS-38B2AC?style=flat&logo=tailwind-css&logoColor=white) |
| **Backend** | ![Node.js](https://img.shields.io/badge/Node.js-339933?style=flat&logo=node.js&logoColor=white) ![C%23](https://img.shields.io/badge/C%23-239120?style=flat&logo=c-sharp&logoColor=white) |
| **Database** | ![SQLite](https://img.shields.io/badge/SQLite-003B57?style=flat&logo=sqlite&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=flat&logo=postgresql&logoColor=white) |
| **State Management** | ![Redux](https://img.shields.io/badge/Redux-764ABC?style=flat&logo=redux&logoColor=white) ![Pinia](https://img.shields.io/badge/Pinia-FFD859?style=flat&logo=pinia&logoColor=black) |
| **DevOps** | ![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white) ![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=flat&logo=firebase&logoColor=black) ![GitHub Actions](https://img.shields.io/badge/GitHubActions-2088FF?style=flat&logo=githubactions&logoColor=white) |
| **Automotive** | ![Vehicle Diagnostics](https://img.shields.io/badge/Vehicle_Diagnostics-0066CC?style=flat) ![Inspection Line](https://img.shields.io/badge/Inspection_Line-00ADD8?style=flat) ![TCP/IP](https://img.shields.io/badge/TCP%2FIP-FF6B6B?style=flat) |

---

## 💼 Career Experience

### 🚗 자동차 도메인 (현대자동차 협력사 인턴십, 6개월)

**검차라인 DB 관리 시스템** | C# / WinForms / SQLite
- 기본키가 없는 DB 구조에서 데이터 무결성 문제 인지 → 선임과 협의 후 전체 테이블 기본키 설계·적용
- DB 수정 시 최근 변경 데이터 시각적 하이라이팅 처리로 추적성 개선
- 실시간 로그 출력 UI 구현 및 로그 레벨별 필터링, 키워드 검색 기능 개발
- 요구사항 분석 → UI/UX 설계 → 구현 → 문서화 → 코드 리뷰까지 단독 수행

**차량 통신 테스트 프로그램** | C# / Serial / TCP-IP
- Serial 및 TCP/IP 통신을 지원하는 통신 테스트 프로그램 구현
- TCP/IP 1:1, 1:N 통신 구조 설계 및 구현
- 송·수신 데이터를 채팅 UI 형태로 시각화하여 가독성 향상

**스마트 DTC 가이드 개발** | C# / SQLite
- XML / Excel / SQLite 등 다양한 형식의 차종 진단 데이터를 단일 SQLite DB로 통합
- 데이터 가공·정규화 로직 설계 및 관리 기능 구현
- 비동기 처리 구조 설계로 다중 작업 동시 처리 구현
- 비개발 직군(사양가이드팀)과 주 1회 이상 정기 협업 및 요구사항 반영

---

### 🎬 프론트엔드 개발 (영화 검색 플랫폼)

**검색 시스템 구현** | Vue.js / Pinia
- 영화 / 리뷰어 / 감독 / 배우 4개 카테고리 독립 페이지네이션 구현
- `computed()` 기반 페이지네이션 로직 서비스화로 코드 재사용성 향상
- `watch()` 훅으로 검색어·탭 변경 감지 → 자동 검색 트리거 구현

**성능 최적화** | Debounce / Skeleton UI
- Debounce 기반 실시간 검색으로 API 호출 빈도 약 30% 이상 감소
- 영화 TOP 100 리스트에 Skeleton UI 적용으로 초기 로딩 UX 개선

**상태 관리** | Pinia
- 로그인 사용자 정보 전역 상태 관리 구현
- 역할(ADMIN / USER) 기반 라우팅 분기 처리로 접근 제어 구현

---

### 🏫 풀스택 개발 (학원 ERP 시스템)

**인증 시스템** | React / TypeScript / JWT
- JWT 기반 인증 시스템 구현 및 자동 토큰 갱신 메커니즘 개발
- AccessToken 만료 시 RefreshToken으로 자동 재발급 → 요청 재시도 로직 구현
- `useAuthFetch` 커스텀 훅으로 인증 로직 추상화

**상태 관리** | Redux Toolkit
- Redux Toolkit으로 전역 상태관리 시스템 구축
- redux-persist로 localStorage 자동 저장 구현 (세션 유지)

**폼 관리** | TypeScript Generic
- TypeScript 제네릭을 활용한 타입-안전한 3단계 회원가입 폼 구현
- `<K extends keyof MemberInfo>` 제네릭으로 필드 업데이트 시 타입 안전성 확보

**일정 관리** | FullCalendar
- FullCalendar 라이브러리로 달력 렌더링 최적화
- 날짜 범위 겹침 감지 알고리즘 구현 (inclusive/exclusive 경계 처리)
- 주말 자동 필터링으로 데이터 무결성 보장

**회의실 예약** | SVG Interactive UI
- SVG 기반 인터랙티브 회의실 맵 구현
- 실시간 예약 상태(available/reserved/full) 조건부 스타일링

---

## 🎯 Current Focus
- 🎨 React와 TypeScript를 활용한 대규모 프론트엔드 아키텍처 설계
- 🚙 자동차 도메인 지식을 활용한 모빌리티 솔루션 개발 역량 확장
- 🔄 프론트엔드-백엔드 통합 개발로 End-to-End 제품 개발 경험 강화
- ⚡ 성능 최적화 및 사용자 경험 개선

---

## 🏆 Algorithm Problem Solving
[![Solved.ac Profile](http://mazassumnida.wtf/api/v2/generate_badge?boj=YOUR_BOJ_ID)](https://solved.ac/YOUR_BOJ_ID)

---

## 📊 GitHub Stats
<p align="center">
  <img src="https://github-readme-stats.vercel.app/api?username=YOUR_GITHUB_ID&show_icons=true&theme=default" height="150"/>
  <img src="https://github-readme-stats.vercel.app/api/top-langs/?username=YOUR_GITHUB_ID&layout=compact" height="150"/>
</p>

---

## 🌱 GitHub Activity
![GitHub Activity Graph](https://github-readme-activity-graph.vercel.app/graph?username=YOUR_GITHUB_ID&theme=github-light)

---

## 📫 Contact
- Email: your@email.com  
- GitHub: https://github.com/YOUR_GITHUB_ID

---

⭐️ 방문해주셔서 감사합니다!
