# ppumting (ppumping dating)
+ 같이 운동하기를 원하는 사람들을 위한 운동파트너 만남 및 PT 결제 사이트
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

