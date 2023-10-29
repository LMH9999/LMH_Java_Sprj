# Java+DB Personal Project -1-

## 💾프로젝트

**'이것이 자바다'** 책을 통해 배운 것들은 활용해 게시판의 CRUD 기능을 구현
구현 내용을 MyBatis 를 통한 연결로 변경
<br><br><br>

### 🕓기간

- **23.10.21** ~ **23.10.27** <br><br><br>

### 🛠기술 스택

![java](https://img.shields.io/badge/Java-437291?style=for-the-badge&logo=openjdk&logoColor=white), 
![mariadb](https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white), **MyBatis**<br><br><br>

### 📔사용 교재



<details><summary>
   상세보기
</summary>
  <br>

![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/1e7ff7fe-a688-4183-bf88-4d864fd81e10)

</details>

- **'이것이 자바다'** / 한빛미디어 / 신용권, 임경균 저

<br><br><br>

## 📝기능

### Create

<details><summary>
   상세보기
</summary>
  <br>

![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/7d259269-ee5b-41de-b66c-cd660ba9644a)

```java
//새로운 게시물을 생성하는 메소드
    public void createBoard(String title, String content, String writer) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(title, content, writer);
        mapper.createBoard(board);

        //새로운 게시물 올리기 실행
        session.commit();
    }
```

```xml
<!-- 새로운 게시물을 추가하는 쿼리문 -->
    <insert id="createBoard" parameterType="Board">
        INSERT INTO boards (btitle, bcontent, bwriter, bdate)
        VALUES (#{btitle}, #{bcontent}, #{bwriter}, now())
    </insert>
```

</details>

* 새로운 게시물 추가하기<br><br>


### Read

<details><summary>
   상세보기
</summary>
  <br>

사진 1

![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/cb12801b-bcbe-480a-8c48-b63732caacf6)

사진 2

![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/53a365fe-e0e4-4fba-a60f-9471e2076c44)

```java
//데이터베이스에서 모든 게시물 목록을 가져오는 메소드
    public ArrayList<Board> getBoard() {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        ArrayList<Board> boardList = mapper.getBoard();

        //쿼리문으로 불러온 게시물 목록을 리턴
        return boardList;
    }
```

```xml
<!--게시판 전체글 목록을 보여주기 위한 쿼리문 -->
    <select id="getBoard" resultType="Board">
        SELECT bno, btitle, bcontent, bwriter, bdate
        FROM boards
        ORDER BY bno DESC
    </select>
```

```java
//원하는 번호의 게시물을 상세보기 하기위한 메소드
    public Board readBoard(int no){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = mapper.readBoard(no);

        //원하는 게시물 정보를 리턴
        return board;
    }
```

```xml
<!-- 특정 번호의 글을 불러와 보여주는 상세보기 쿼리문 -->
    <select id="readBoard" parameterType="Int" resultType="Board">
        SELECT bno, btitle, bcontent, bwriter, bdate
        FROM boards
        WHERE bno = #{bno}
    </select>
```


</details>

* 게시판 전체 목록을 보여주기 ( 사진 1 )
* 원하는 번호의 게시물을 상세보기 ( 사진 2) <br><br>


### Update

<details><summary>
   상세보기
</summary>
  <br>
  
![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/fbbb9b33-3890-46b2-a16f-4103a8f86366)

```java
//원하는 게시물을 수정하는 메소드
    public void updateBoard(int bno, String title, String content, String writer) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        Board board = new Board(bno, title,content,writer);
        mapper.updateBoard(board);

        //게시물 수정 실행
        session.commit();
    }
```

```xml
<!-- 이미 있는 게시물을 수정하기 위한 쿼리문 -->
    <update id="updateBoard" parameterType="Board">
        UPDATE boards SET btitle=#{btitle}, bcontent=#{bcontent}, bwriter=#{bwriter}
        WHERE bno = #{bno}
    </update>
```


</details>

* 원하는 번호의 게시물을 수정하는 기능<br><br>


### Delete

<details><summary>
   상세보기
</summary>
  <br>

사진 1

![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/58dbc94b-3198-42bc-8f0e-d39be450c4c6)

사진 2

![image](https://github.com/LMH9999/LMH_Java_Sprj/assets/145963633/092e3445-5ce5-4529-8bda-09e03602fbae)


```java
//원하는 게시물을 삭제하는 메소드
    public void deleteBoard(int bno) {
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.deleteBoard(bno);

        //게시물 삭제 실행
        session.commit();
    }
```

```xml
<!-- 특정 게시물을 삭제하기 위한 쿼리문 -->
    <delete id="deleteBoard" parameterType="int">
        DELETE FROM boards WHERE bno=#{bno}
    </delete>
```

```java
//게시물 전체를 삭제하는 메소드
    public void clearBoard(){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        mapper.clearBoard();

        //게시물 전체 삭제 실행
        session.commit();
    }
```

```xml
<!-- 게시물 전체를 삭제하는 쿼리문 -->
    <delete id="clearBoard" parameterType="Board">
        delete from boards
    </delete>
```

</details>

* Delete : 원하는 번호의 게시물을 삭제하는 기능 ( 사진 1 )
* Clear : 모든 게시물을 삭젝하는 기능 ( 사진 2 ) <br><br>

### MyBatis

<details><summary>
   상세보기
</summary>
  <br>

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!-- DB 설정 -->
                <property name="driver" value="org.mariadb.jdbc.Driver"/>
                <property name="url" value="jdbc:mariadb://127.0.0.1:3306/board_prj"/>
                <property name="username" value="root"/>
                <property name="password" value="12345"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <!-- Mapper 파일의 위치 -->
        <mapper resource="BoardMapper.xml"/>
    </mappers>

</configuration>
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="BoardMapper">
    <!--게시판 전체글 목록을 보여주기 위한 쿼리문 -->
    <select id="getBoard" resultType="Board">
        SELECT bno, btitle, bcontent, bwriter, bdate
        FROM boards
        ORDER BY bno DESC
    </select>
    <!-- 새로운 게시물을 추가하는 쿼리문 -->
    <insert id="createBoard" parameterType="Board">
        INSERT INTO boards (btitle, bcontent, bwriter, bdate)
        VALUES (#{btitle}, #{bcontent}, #{bwriter}, now())
    </insert>
    <!-- 특정 번호의 글을 불러와 보여주는 상세보기 쿼리문 -->
    <select id="readBoard" parameterType="Int" resultType="Board">
        SELECT bno, btitle, bcontent, bwriter, bdate
        FROM boards
        WHERE bno = #{bno}
    </select>
    <!-- 이미 있는 게시물을 수정하기 위한 쿼리문 -->
    <update id="updateBoard" parameterType="Board">
        UPDATE boards SET btitle=#{btitle}, bcontent=#{bcontent}, bwriter=#{bwriter}
        WHERE bno = #{bno}
    </update>
    <!-- 특정 게시물을 삭제하기 위한 쿼리문 -->
    <delete id="deleteBoard" parameterType="int">
        DELETE FROM boards WHERE bno=#{bno}
    </delete>
    <!-- 게시물 전체를 삭제하는 쿼리문 -->
    <delete id="clearBoard" parameterType="Board">
        delete from boards
    </delete>
</mapper>
```

</details>

* 데이터베이스를 쉽게 다룰수 있도록 도와주는 ORM 프레임워크
* 데이터베이스 쿼리와 프로그래밍 코드를 나누어 수정과 작성이 편하다 <br><br>

