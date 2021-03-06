# Ch29_CustomView
## 커스텀 뷰 종류
1. **단순** - 단순 뷰는 내부적으로 복잡할 수 있지만, 자식 뷰가 없어서 구조가 간단하다. 단순 뷰는 대부분 자체적으로 커스텀 렌더링을 수행한다.

2. **복합(composite)** - 복합 뷰는 다른 뷰 객체들로 구성된다. 일반적으로 복합 뷰는 자식 뷰들을 관리하지만, 자신은 커스텀 렌더링을 하지 않는다. 대신에 렌더링은 각 자식 뷰에게 위임힌다.

## 커스텀 뷰 생성
1. 슈퍼 클래스를 선택한다.
단순 커스텀 뷰일 경우 - View는 비어있는 캔버스와 같음. 가장 많이 사용됨
복합 커스텀 뷰의 경우 - FrameLayout과 같이 적합한 레이아웃 클래스를 선택함

2. 선택한 슈퍼 클래스의 서브 클래스를 만든다. -> 슈퍼 클래스의 생성자를 오버라이드한
다

3. 서브 클래스에서 자기 나름의 동작을 커스터마이즈하기 위해 슈퍼 클래스의 주요 메서드들을 오버라이드 한다.



## 터치 이벤트 처리
View의 메서드인 setOnTouchListener()를 통해 처리

**MotionEvent**
* ACTION_DOWN - 사용자의 손가락이 화면을 터치함
* ACTION_MOVE - 사용자가 손가락을 화면 위에서 움직임
* ACTION_UP - 사용자가 화면에서 손가락을 뗌
* ACTION_CANCEL -  부모 뷰가 터치 이벤트를 가로챔


## onDraw()
앱이 론칭될 때 모든 뷰들은 부적합(invalid)한 상태다. -> 화면에 어떤 것도 그릴수 없는 상태.
안드로이드는 최상위 수준 View의 draw()메서드를 호출하면 이 상황을 해결 가능.
부모 뷰가 자신을 그리면 자식들 뷰도 그리게 된다. 모든 뷰가 자신을 그리면 최상위 수준 View는 더 이상 부적합하지 않게 된다.
Invalidate()를 호출하면 다시 뷰를 Invalid 상태를 만든다. 그러면 뷰는 다시 자신을 그리게 된다.








#android/실무에바로적용하는안드로이드