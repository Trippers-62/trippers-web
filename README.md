# Trippers
### 기간 : 2024.02.13 ~ 2024.03.10


## 목차
- [프로젝트 소개](#프로젝트-소개)
- [최종 결과물](#최종-결과물)
- [AWS 아키텍처](#AWS-아키텍처)
- [사용 기술 및 프레임워크](#사용-기술-및-프레임워크)
- [ERD](#ERD)
- [구현 기능](#구현-기능)
- [CI/CD](#CI/CD)

## 프로젝트 소개
Trippers는 일본 여행을 위한 가성비 항공권과 숙소를 추천하는 웹 서비스입니다.
API와 크롤링을 자동화하여 매일 새로운 데이터가 데이터베이스에 적재되고, 해당 데이터를 바탕으로 검색 기능과 추천 기능을 제공합니다.

### 팀원
- 양현진 : AWS 백엔드 인프라 구축, 백엔드 기능 개발 및 웹 UI 개발, CI/CD
- 여재우 : 환율 파이프라인 설계, ETL, ELT, 웹 UI 개발
- 김혁 : 항공 파이프라인 설계, ETL, ELT
- 정오영 : 숙소 파이프라인 설계, ETL, ELT
- 김형후 : AWS 리소스 세팅, 인프라 구축, 보안 관리

## 최종 결과물
Trippers 웹사이트 : de-6-2-web-alb-937857219.ap-northeast-2.elb.amazonaws.com:8080

## AWS 아키텍처
### 전체 아키텍처
### 백엔드 아키텍처

## 사용 기술 및 프레임워크
- 프론트엔드 : HTML, CSS, JavaScript, SCSS
- 백엔드 : Spring, Thymeleaf, JPA
- 클라우드 : AWS EC2, AWS RDS, AWS S3, AWS Redshift, Application Load Balancer, NAT Gateway
- 커뮤니케이션 : Slack, Gather, Notion

## ERD

## 구현 기능
* 항공권 및 숙소 검색 기능
  * 입력
    * 여행 유형
    * 출발 및 도착 도시
    * 출발 및 도착 날짜 
  * 출력
    * 항공권 리스트
    * 숙소 리스트

* 도시, 항공권, 숙소 추천 기능
  * 입력
    * 출발 및 도착 날짜
    * 예산
  * 출력
    * 출발 및 도착 도시
    * 왕복 항공권
    * 날짜별 숙소 추천 리스트 

## CI/CD

Github Actions을 통해 main 브랜치로 push되면 빌드 후 S3에 업로드
Private Subnet의 EC2에서 미리 작성한 쉘 스크립트 파일로 S3를 통해 빌드된 파일을 가져오고 파일 실행 
