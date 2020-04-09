# WebSocketDemo
구현 과정 및 내용 정리는 Notion 페이지([WebSocket 활용 Interactive Web App. 제작](https://www.notion.so/gentledot/WebSocket-Interactive-Web-App-367008549b624e8f9624bf790c988483))에 정리.

- 목표
    - [messaging-stomp-websocket](https://spring.io/guides/gs/messaging-stomp-websocket/)의 demo project를 분석
    - 분석한 내용을 기반으로 나만의 chatting application을 구현한다.
    

# 구현 내용
- 채팅 웹 페이지 구현
    - 테마
        - 사용자 이름을 입력하여 채팅 사이트에 입장하면 사이트에 입장한 사람들간에 채팅 송신과 수신이 가능한 web 페이지
    
    - 줄거리
        1. 브라우저를 열고 http://localhost/app/v1/chatLogin  에 접속한다.
        2. 사용할 이름을 설정하고 접속 버튼을 누르면 채팅 페이지에 접속한다.
        3. [http://localhost/app/v1/chatroom](http://localhost/app/v1/chatroom) 접속 하면 websocket 을 subscribe 처리
        4. 메시지를 입력하고 전송 버튼을 누르면  subscriber 전체에게 사용자 이름과 입력한 메시지가 전송되고 다른 사용자들은 전송된 메시지를 확인할 수 있다.
        5. 접속 종료 버튼 또는 브라우저를 닫으면 websocket에 disconnect 된다.
    
    - 시나리오
        - 사용자 접속
            1. [http://localhost/app/v1/chatLogin](http://localhost/app/v1/chatLogin) 접속
            2. 사용자 이름 입력 후 확인 (이름이 비어 있으면 접속할 수 없음)
            3. 이름이 입력되면 접속 버튼이 나타나 채팅 페이지에 접속할 수 있다.
        - 채팅 페이지 입장
            1. [http://localhost/app/v1/chatroom](http://localhost/app/v1/chatroom) 접속
            2. {사용자 이름} 님 환영합니다.  타이틀 출력
            3. 출력 메시지를 볼 수 있는 영역과 메시지 입력 영역이 있으며 "접속 종료" 버튼이 있음
            4. 메시지 입력 영역에 메시지 입력 후 "전송" 버튼을 누르면 메시지가 전송
            5. "접속 종료" 버튼 클릭 또는 브라우저 닫기 시 접속이 종료된다.
        - 접속 종료 후
            1. [http://localhost/app/v1/chatroom](http://localhost/app/v1/chatroom) 에 접속
            2. 사용자 이름 설정 없이 채팅방에 접속하였으므로 이름 설정 페이지 ([http://localhost/app/v1/chatLogin](http://localhost/app/v1/chatLogin)) 로 redirect
            

## Server-side 구현
- WebSocketConfig 구성
- ChatController 구현
- request, response 객체 구현