# ppumting (ppumping dating)
+ 같이 운동하기를 원하는 사람들을 위한 운동파트너 만남 및 PT 결제 사이트 🏃
+ 2022.7.11 ~ 2022.7.15
## 팀 구성원
+ 5명 ( [성호(본인)](https://github.com/LeeSeongHo7984) [상규](https://github.com/parkSangGyu98) [태영](https://github.com/wed456) [기열](https://github.com/BaekKiYeol) [태우](https://github.com/workhan0918) )

## 사용한 기술 및 환경
+ eclipse
+ MySQL
+ JSP
+ HTML/CSS
+ Java
+ bootstrap
+ Servlet
+ tomcat 8.5
+ git

## 구현기능
+ 사용자
  + 회원 가입, 수정, 탈퇴, 로그인, 로그아웃
  + 게시판 등록, 조회, 수정, 삭제
  + 포인트 계좌 생성, 포인트 충전, 조회, 차감
  + 쪽지 발송, 답장, 조회, 삭제
+ 트레이너
  + 회원가입, 조회, 로그인, 로그아웃

## 주요 코드
### 사용자 부분
 + 개인정보 수정
   1. 수정 클릭 시 현재 로그인 되어있는 아이디를 이용하여 고객 정보를 가져와 미리 화면에 띄워둡니다.
   2. 완료 클릭 시 빈칸이 없는지 유효성 검사를 합니다.
   3. 빈칸이 없을 시 유저정보를 수정합니다.

             UserUpdateServlet 일부

             protected void doPost(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException {
             request.setCharacterEncoding("UTF-8");

             String userId = request.getParameter("userId");

             HttpSession session = request.getSession(false);
             session.setAttribute("userId", userId);
             response.sendRedirect("../home");


             String pw = request.getParameter("pw");
             String phone = request.getParameter("phone");
             String name = request.getParameter("name");
             String addr = request.getParameter("addr");

             List<String> errorMsgs = new ArrayList<>();

             if(pw == null || pw.length() == 0) {
              errorMsgs.add("비밀번호를 입력해주세요");
             }else if(name == null || name.length() == 0) {
              errorMsgs.add("이름을 입력해주세요");
             }else if(phone == null || phone.length() == 0) {
              errorMsgs.add("전화번호를 입력해주세요");
             }else if(addr == null || addr.length() == 0) {
              errorMsgs.add("주소를 입력해주세요");
             }

             User user = new User();
             user.setUserId(userId);
             user.setPw(pw);
             user.setName(name);
             user.setPhone(phone);
             user.setAddr(addr);

             userService.updateUser(user);
             request.setAttribute("user", user);
             }
       
+ 포인트 계좌 생성
  1. 회원가입시 랜덤한 숫자의 포인트가 0인 계좌를 생성해 줍니다.
  2. 본인 계좌번호는 충전을 할 경우 확인할 수 있습니다.
        
          PointDao 일부

          public String createAccountNum(String userId) { 
          String sql = "INSERT INTO Point (point, accountNum, userId) VALUES (0, ?, ?)";

          String numStr = String.valueOf((int) (Math.random() * 1000000000));
          StringBuilder sb = new StringBuilder();
          sb.append(numStr.substring(0, 3));
          sb.append("-");
          sb.append(numStr.substring(3, 5));
          sb.append("-");
          sb.append(numStr.substring(5));

          String result = sb.toString();

          try {
            Connection con = datasource.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            try {
              if (pointdao.isValidUser(userId)) { 
                if( pointdao.checkAccountNum(userId) == null ) { //생성해주기
                  stmt.setString(1, result);
                  stmt.setString(2, userId);
                  stmt.executeUpdate();
                }else { 
                  result = null;
                }
              } else {
                result = null;
              }
            } finally {
              stmt.close();
              con.close();
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
          return result;
          }

+ 쪽지삭제
  1. 받은 보관함에서 쪽지를 삭제하면 상대방의 보낸 쪽지에서도 같이 삭제되는 상황이 발생하여
     받는사람, 보내는 사람의 DB를 각각 만들어 해결하였습니다.
     
              Note.sql 일부

              CREATE TABLE RcvNotes (
              no			BIGINT		 	PRIMARY KEY	AUTO_INCREMENT,
              sentid 		VARCHAR(20) 	NOT NULL	DEFAULT	'',
              userId		VARCHAR(20)		NOT NULL	DEFAULT	'',
              title		VARCHAR(100)	NOT NULL 	DEFAULT '',
              msg			VARCHAR(200)	NOT NULL 	DEFAULT '',
              sentDate 	TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
              sendnote	BOOLEAN			NOT NULL	DEFAULT FALSE
              );

              CREATE TABLE SendNotes (
              no			BIGINT		 	PRIMARY KEY	AUTO_INCREMENT,
              userId 		VARCHAR(20) 	NOT NULL	DEFAULT	'',
              recvid		VARCHAR(20)		NOT NULL	DEFAULT	'',
              title		VARCHAR(100)	NOT NULL 	DEFAULT '',
              msg			VARCHAR(200)	NOT NULL 	DEFAULT '',
              sentDate 	TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
              sendnote	BOOLEAN			NOT NULL	DEFAULT TRUE
              );
             
+ 회원가입
  1. 입력한 정보들의 공백 여부를 확인합니다.
  2. 공백이 있다면 에러메시지를 error.jsp로 넘겨 alert을 띄워줍니다.
  3. 공백이 없으면 User객체에 정보들을 저장한 뒤 DB에 저장 시킵니다.

              UserServlet 일부

              protected void doPost(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException {

              request.setCharacterEncoding("UTF-8");

              String userId = request.getParameter("userId");
              String pw = request.getParameter("pw");
              String name = request.getParameter("name");
              String ssn = request.getParameter("ssn");
              String phone = request.getParameter("phone");
              String addr1 = request.getParameter("addr1");
              String addr2 = request.getParameter("addr2");

              List<String> errorMsgs = new ArrayList<>();
              if(userId == null || userId.length() == 0) {
                errorMsgs.add("id를 입력해주세요,");		
              }else if(pw == null || pw.length() == 0) {
                errorMsgs.add("비밀번호를 입력해주세요");
              }else if(name == null || name.length() == 0) {
                errorMsgs.add("이름을 입력해주세요");
              }else if(ssn == null || ssn.length() == 0) {
                errorMsgs.add("주민번호를 입력해주세요");
              }else if(phone == null || phone.length() == 0) {
                errorMsgs.add("전화번호를 입력해주세요");
              }else if(addr1 == null || addr1.length() == 0 || 
                  addr2 == null || addr2.length() == 0) {
                errorMsgs.add("주소를 입력해주세요");
              }

              RequestDispatcher dispatcher = null;
              if(errorMsgs.size() > 0) {
                dispatcher = request.getRequestDispatcher("error.jsp");
                request.setAttribute("errorMsgs", errorMsgs);
                dispatcher.forward(request, response);
                return;
              }


              User user = new User();
              user.setUserId(userId);
              user.setPw(pw);
              user.setName(name);
              user.setSsn(ssn);
              user.setPhone(phone);
              user.setAddr(addr1+ " " + addr2);
              Userservice userService = new Userservice();
              userService.addUser(user);
              pointService.createAccountNum(userId);
              request.setAttribute("user", user);
              response.sendRedirect("../loginout/login");
              return;
              }	

+ 게시판 수정
  1. 게시판에 올라와있는 글 중, 본인 글만 수정할 수 있어야 하는데 모든 글을 수정할 수 있어서 어려움을 겪었습니다.
  2. 세션으로 현재 로그인 되어있는 아이디와 게시글 글쓴이 아이디를 비교하여 해결할 수 있었습니다.

            SelectQnaSevlet 일부
  	
            protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

            Qna qnas = new Qna();
            qnas = service.viewQna(request.getParameter("qnaNo"));
            HttpSession session = request.getSession(false);
            String userId = (String) session.getAttribute("userId");

            if(qnas.getUserId().equals(userId)) { //게시글 주인이라면
              request.setAttribute("qnas", qnas);	// "qnas"(jsp에서 뿌려주는 이름)는 키, qnas는 값
              request.setAttribute("check", true);
              request.getRequestDispatcher("selectNoQna.jsp").forward(request, response);
            }else {
              request.setAttribute("qnas", qnas);
              request.setAttribute("check", false);
              request.getRequestDispatcher("selectNoQna.jsp").forward(request, response);
            }
            }


            selectNoQna.jsp 일부

            <c:if test="${check == false}">
            <div
            style="width: 100%; height: 50px; display: flex; text-align: center; font-size: 30px; line-height: 38px;">
            <a class="addBu" onclick="back()" style="text-decoration: none;">뒤로가기</a>
            </div>
            </c:if>
            <c:if test="${check == true}">
            <form action="modifyQna.do" method="post">
              <!--  <button type="submit" value="${qnas.qnaNo}" name="qnaNo">수정</button> -->
              <button type="submit" value="${qnas.qnaNo}" name="qnaNo"
                onclick="location.href='modifyQna.jsp'" class="addBu">
                <span style="font-size: 30px; line-height: 38px;" class="ft">수정</span>
              </button>
            </form>
            <form action="deleteQna.do" method="post">
              <button type="submit" value="${qnas.qnaNo}" name="qnaNo"
                class="addBu">
                <span style="font-size: 30px; line-height: 38px;" class="ft">삭제</span>
              </button>
            </form>
            <div
              style="width: 100%; height: 50px; display: flex; text-align: center; font-size: 30px; line-height: 38px;">
              <a class="addBu" onclick="back()" style="text-decoration: none;">뒤로가기</a>
            </div>
            </c:if>

## 구현 화면
### 사용자, 트레이너 로그인
![image](https://user-images.githubusercontent.com/75346102/187378371-b38b88bb-8301-4e7c-8ff1-ed1e252f34a8.png)
![image](https://user-images.githubusercontent.com/75346102/187378475-30ab105b-6c9a-4528-a707-bf4bbbaff458.png)

### 사용자, 트레이너 회원가입
![image](https://user-images.githubusercontent.com/75346102/187378580-a3fcd4b7-8480-4190-8102-31b66b75c030.png)
![image](https://user-images.githubusercontent.com/75346102/187378633-e17aabe0-06c4-4321-b1f4-f68b882334c8.png)

### 회원정보 수정
![image](https://user-images.githubusercontent.com/75346102/187379127-cb9a55b3-9d9f-494c-b911-6cef13450118.png)

### 메인
![image](https://user-images.githubusercontent.com/75346102/187379211-79a86e0b-1cc4-4048-8cb2-3f0f550c6f14.png)

### 게시판
![image](https://user-images.githubusercontent.com/75346102/187379440-2247dd63-5065-438c-a74b-6c6e33d954d9.png)

### 게시판 등록
![image](https://user-images.githubusercontent.com/75346102/187379563-5f13be6a-738d-46e2-93ae-12a380286f7e.png)

### 게시글 보기
![image](https://user-images.githubusercontent.com/75346102/187379778-839e33db-15bf-48e5-bfb3-e4bc6557ce7c.png)

### 게시글 수정
![image](https://user-images.githubusercontent.com/75346102/187379851-922a194d-2c76-4188-996c-63c97c618a39.png)

### P.P.T
![image](https://user-images.githubusercontent.com/75346102/187380072-807f2ed1-762b-4ce5-9236-9fd874dbfd33.png)

### 충전
![image](https://user-images.githubusercontent.com/75346102/187380179-ba8f2135-a66b-4844-b8fd-99467883e6d6.png)
