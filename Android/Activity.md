# Activity
-  일종의 애플리케이션 구송 요소
	- 사용자가 전화 걸기, 사진 찍기, 이메일 보내기 등의 일을 할 수 있는 상호작용할 수 있는 화면을 제공
- 애플리케이션은 보통 여러 개의 액티비티가 느슨하게 서로 묶여 있는 형태로 구성됨.
- “Main”  액티비티로 지정된 액티비티가 애플리케이션 실행 되었을때 처음으로 보여지는 액티비티이다.
- 새로운 액티비티가 시작되면 이전 액티비티는 중단되지만 해당 액티비티를 스택(“back stack”)에 보존한다.
	- 따라서 사용자가 현재 액티비티를 끝내고 Back 버튼을 누르면 해당 액티비티가 스택에서 팝되고 이전 액티비티가 재개된다.


## 액티비티 생성
- Activity의 서브클래스를 생성해야함.
	- 서브클래스에서 액티비티 생성, 중단, 재개, 소멸 시기 등과 같은 수명 주기의 다양한 상태 간 액티비티가 전환될 때 시스템이 호출하는 콜백 메서드를 구현해야 한다.

대표 콜백 메서드 두가지


**`onCreate()`**
- 반드시 구현 해야 하는 메소드이다.
- 시스템이 액티비티를 생성할 때 이것을 호출.
- 액태비티 필수 구성 요소를 초기화함.
- 여기서 `setContentView()`를 호출해야 액티비티 사용자 인터페이스 레이아웃을 정의 가능

**`onPause()`**
- 시스템이 이 메소드를 호출하면 사용자가 액티비티를 떠난다는 첫 번째 신호이다.
	- 하지만 항상 액티비티가 소멸 중이라는 뜻은 아니다
- 현재 사용자 세션을 넘어서 지속되어야 하는 변경 사항을 커밋을 여기서 해줘야 한다.


### 사용자 인터페이스 구현
- 안드로이드는 여러 가지 뷰를 미리 만들어 제공
- 리소스에 지정된 XML 레이아웃 파일을 통해 소스 코드와 별개로 사용자 인터페이스를 구현 할 수 있다.
- `setContentView()`로 액티비티의 UI로서 레이아웃을 설정하고, 해당 레이아웃의 리소스 ID를 전달할 수 있다.

### 매니페스트에서 액티비티 선언
- 시스템에서 액티비티에 액새스 할 수 있게 하기 위해선 액티비티를 매니페스트 파일에 선언해야 함.

```xml
<manifest ... >
  <application ... >
      <activity android:name=".ExampleActivity" />
      ...
  </application ... >
  ...
</manifest >
```
- `android:name` - 액티비티 클래스 이름

**인텐트 필터**
액티비티, 서비스, 브로드캐스트 리비서가 반응할 인텐트의 타입을 정하게 해준다.
```xml
<activity android:name=".ExampleActivity" android:icon="@drawable/app_icon">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```
- `<action>` - 애플리케이션으로 가는 “주요” 진입 지점
- `<category>` - 이 액티비티가 시스템의 애플리케이션 시작 관리자에 목록으로 나열되어아 하는 것을 명시 (사용자가 이 액티비티를 시작할 수 있도록 해줌)
- “주요” 동작과 “시작 관리자 “ 범주가 있는 액티비티는 오직 하나여야 한다.
- 액티비티가 다른 애플리케이션 밑 해당 애플리케이션에서 전달된 암시적 인텐트에 응답하려면 액티비티에 추가로 인텐트 필터를 정의해야만 한다.










#android