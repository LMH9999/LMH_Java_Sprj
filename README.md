# Java+DB Personal Project -1-

## 💾프로젝트

**'이것이 자바다'** 책을 통해 배운 것들은 활용해 <u> **자기소개서** </u>를 웹페이지로 구현<br><br><br>

### 🕓기간

- **23.10.21** ~ **23.10.27** <br><br><br>

### 🛠기술 스택

![java](https://img.shields.io/badge/Java-437291?style=for-the-badge&logo=openjdk&logoColor=white)
![mariadb](https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white)<br>
**MyBatis**<br><br><br>

### 📔사용 교재



<details><summary>
   상세보기
</summary>
  <br>

![image](https://github.com/LMH9999/LMH_Web_Study/assets/145963633/20001b2b-d663-4cb3-a2f0-4c8178b8d663)

</details>

- **'코딩 자율학습 HTML + CSS + 자바스크립트'** / 길벗 / 김기수 저

<br><br><br>

## 📝기능

### 헤더

<details><summary>
   상세보기
</summary>
  <br>
  
![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/e61dfd4b-e63d-4d3c-b545-a3e7df60886a)

```html
<h1>
  <!-- 어디서 누르던지 홈(메인)으로 가는 버튼 -->
  <button data-animation-scroll="true" data-target="#main">LMH</button>
</h1>
```


```css
header{
  /* 스크롤을 내려도 고정된 위치에 보이도록 */
  position:fixed;
  color:white;
  top:0;
  /* 어떤 컨텐츠보다 항상 위에 보이도록 z-index 설정 */
  z-index:1;
  width:100%;
  padding:1rem;
}
```
</details>

* 항상 홈으로 가는 버튼<br>
* 원하는 페이지로 이동하는 메뉴<br>
* 스크롤을 내려도 고정된 위치<br><br>

### 메인

<details><summary>
   상세보기
</summary>
  <br>

![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/e7ba515a-abfa-4c6d-b971-2cb2eed64eb9)

```css
/* 버튼이 위아래로 흔들리는 모션 */
@keyframes upDown{
  0%{
    bottom:1rem;
  }
  50%{
    bottom:1.5rem;
  }
  100%{
    bottom:1rem;
  }
}
```

```css
/* 깜빡이는 애니메이션 */
@keyframes blink {
  0%{
    /* 요소의 불투명도, 0에 가까울수록 투명함 */
    opacity: 1;
  }
  100%{
    opacity: 0;
  }
}
```

```js
// 텍스트 작성과 삭제 즉시 실행 함수
(function(){
  const spanEl = document.querySelector("main h2 span");
  // 타이핑 효과로 바뀌는 문구 종류
  const txtArr = ['Web Publisher', 'Front-End Developer', 'Web UI Designer', 'UX Designer', 'Back-End Developer'];
  let index = 0;
  // 한글자씩 쪼개서 저장
  let currentTxt = txtArr[index].split("");
  function writeTxt(){
    // 쪼갠 배열의 한글자씩을 맨 앞의 요소부터 추출하고 삭제
    spanEl.textContent  += currentTxt.shift(); 
    // 출력할 글자가 남아있는지 체크
    if(currentTxt.length !== 0){ 
      // 랜덤 함수를 이용해 문구가 출력되는 시간을 매번 달라지게 만듬
      setTimeout(writeTxt, Math.floor(Math.random() * 100));
    }else{
      // 모두 출력된 문구를 가져옴
      currentTxt = spanEl.textContent.split("");
      // 3초뒤 텍스트 지우는 함수 호출 
      setTimeout(deleteTxt, 3000);
    }
  }
  // 텍스트 삭제 함수
  function deleteTxt(){
    // 이미 출력된 문구가 저장된 currentTxt에서 끝 글자부터 리턴하고 삭제하는 pop()
    currentTxt.pop();
    // 맨 끝 글자가 삭제된 나머지 한글자씩 쪼개져있던 문구를 하나로 합침
    spanEl.textContent = currentTxt.join("");
    // 문구가 모두 삭제됬는지 체크
    if(currentTxt.length !== 0){
      setTimeout(deleteTxt, Math.floor(Math.random() * 100))
    }else{
      // 문구가 다 삭제되고 끝났으니 다음 문구 불러오기
      index = (index + 1) % txtArr.length;
      currentTxt = txtArr[index].split("");
      writeTxt();
    }
  }
  writeTxt();
})();
```

</details>

* 마우스 아이콘이 흔들리는 애니메이션 구현<br>
* 커서가 깜빡이는 애니메이션 구현<br>
* 여러 문구가 타이핑되는 애니메이션 구현<br><br>


### About , Features , Portfolio

<details><summary>
   상세보기
</summary>
  <br>

사진1
  
![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/b4f0cc0a-1223-45a0-9b60-0f9ea6d5dcb1)

사진2

![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/fa50763c-f5dc-48aa-adba-d9d4e8ace39d)

사진3

![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/20136b7f-e7a5-465e-bd71-0e6a32d24203)

```css
/* 내용 부분 사각형에 마우스를 올렸을 때 강조를 위해 그 사각형 배경,글자 색상 변경 */
section .do-me .do-inner:hover{
  background-color:lightcoral;
  color:white;
}
/* 내용 부분 사각형에 마우스을 때 아이콘의 폰트 색상도 자연스럽도록 변경 */
section .do-me .do-inner:hover i{
  color:white;
}
```

</details>

* About : 나를 소개하는 페이지
* Features : 무슨 역량을 가졌는지 설명하는 페이지
* Fortpolo : 경험을 설명하는 페이지
* 특정 내용에 마우스를 올렸을 때 강조를 위해 색상 변경 (사진 2) <br><br>


### Contact

<details><summary>
   상세보기
</summary>
  <br>
  
![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/1a6d7578-63bc-433b-814f-a9999ae25fa7)

```css
/* textarea에 커서가 활성화되면 파란색 테두리와 그림자 효과 추가 */
section.contact .contact-me .right .form-group textarea:focus{
  outline:none;
  border:1px solid #719ECE;
  box-shadow:0 0 10px #719ECE;
}
```


</details>

* 나에 대한 정보<br>
* 내게 연락하고 싶은 사람을 위한 양식<br>
* 양식에 마우스를 클릭해서 커서가 활성화 될 때 강조 표시<br><br>


### 반응형 코드

<details><summary>
   상세보기
</summary>
  <br>
  
![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/02921135-0157-4675-9b45-2d64f8a903a0)

![image](https://github.com/LMH9999/LMH_Web_SPrj/assets/145963633/579b26f9-aed9-46ff-a837-1f186a4e9ed4)


```css
@media screen and (max-width: 1140px){

  /* 메인 container 기준 1140 -> 992px */
  main .container{
    width: 992px;
  }
  
  /* 섹션 container 기준 1140 -> 600px */
  section .container{
    width:600px;
  }

  /* About me 영역 왼쪽을 너비를 50% -> 100% 변경 */
  section .about-self .left{
    width:100%;
    margin-bottom: 1.5rem;
  }
  /* About me 영역 오른쪽 너비를 50% -> 100% 변경 */
  section  .about-self .right{
    width:100%;
    padding:0;
  }

  /* What I Do 영역의 콘텐츠 박스의 너비를 30% -> 48% 변경 */
  section .do-me .do-inner{
    width:48%;
    margin-bottom: 1.5rem;
    margin-right: 0;
  }

  section .do-me .do-inner:nth-child(2n+1){
    margin-right:4%; /* 1, 3, 5...번째 본문 사각형에 margin-right 4% 적용 */
  }
  
  /* PortFolio 영역의 콘텐츠 박스 너비를 30% ->  48% 변경 */
  section .portfolio-me .portfolio-inner{
    width:48%;
    margin-right: 0;
  }

  section .portfolio-me .portfolio-inner:nth-child(2n+1){
    margin-right:4%;
  }

  /* Contact With Me 영역 */
  section.contact .contact-me .left{
    width:100%; /* 너비 변경 30% -> 100% */
  }
  
  section.contact .contact-me .right{
    width:100%;/* 너비 변경 65% -> 100% */
    margin-left: 0; /* margin 초기화 */
    
  }
}
```

</details>

* 웹 브라우저의 창 크기에 따라 바뀌는 사이즈 및 구조 변경

