# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.


## 기능 목록
- [ ] 사용자의 입력을 받는다.
  - [ ] 구입 금액을 입력받는다.
  - [ ] 지난 주 당첨 번호를 ",| "를 delimeter로 입력받는다.
  - [ ] 보너스 볼 숫자를 입력받는다.
- [x] 사용자의 로또 구매 개수를 계산한다. 단위는 1000원이다.
- [ ] 사용자의 구매 개수만큼 랜덤한 로또 번호를 생성한다.
  - [ ] 로또 번호는 중복되지 않는 6개의 숫자로 이뤄진다.
  - [ ] 로또 번호는 1부터 45까지의 범위를 갖는다.
  - [ ] 로또 번호는 정렬되어있다.
- [ ] 당첨 통계를 계산한다.
  - [ ] 숫자 3개가 일치하면 5,000원이다.
  - [ ] 숫자 4개가 일치하면 50,000원이다.
  - [ ] 숫자 5개가 일치하면 1,500,000원이다.
  - [ ] 숫자 5개와 보너스 번호가 일치하면 30,000,000원이다.
  - [ ] 숫자 6개가 일치하면 2,000,000,000원이다.
- [ ] 총 수익률을 계산한다.
- [ ] 요구 사항에 맞는 형태로 콘솔에 출력한다.
