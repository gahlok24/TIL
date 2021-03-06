# Ch6_안드로이드SDK
## 안드로이드 SDK 버전
![](Ch6_%E1%84%8B%E1%85%A1%E1%86%AB%E1%84%83%E1%85%B3%E1%84%85%E1%85%A9%E1%84%8B%E1%85%B5%E1%84%83%E1%85%B3SDK/1164923D-5BC3-4323-A274-EE5F5DA81092.png)
![Android Distribution Chart](https://cdn57.androidauthority.net/wp-content/uploads/2018/09/android-authority-android-distribution-september-2018-1.jpg)

각 ‘코드명’ 릴리즈 다음에는 증분적 릴리즈가 뒤따른다.

최신 버전의 안드로이드가 출시되어도 바로 교체되지 않는 이유는 제조사와 통신사의 customization으로 인한 파편화 때문이다. 제조사와 통신사는 구글에서 릴리즈하는 순정 안드로이드를 사용하지 않기 때문에 새로운 버전의 안드로이드를 이식하는데 시간이 걸린다.


## 호환성과 안드로이드 프로그래밍
새로운 릴리즈와 결합되는 업그레이드가 지연됨에 따라 호환성이 안드로이드 프로그래밍의 중요한 문제가 된다. 개발자는 폭넓은 시장에 대응하기 위해 모든 장치에서 잘 실행되는 앱을 만들어야 한다.

안드로이드의 레이아웃 시스템이 디바이스의 다양함에 잘 대응해준다. 하지만 태블릿의 경우 **configuration qualifier**로 처리해줘야 하며 안드로이드 TV나 안드로이드 웨어는 디자인을 앱과 달리 새로 재고할 필요성이 있다.

증분적 릴리즈들은 과거 버전과의 호환성 유지에 문제가 없지만 메이저 버전 업데이트는 문제가 있다. 이런 문제를 해결하기 위해 구글에서는 지원 라이브러리를 제공한다.

### 최소 SDK 버전
minSdkVersion 값은 앱을 설치하는 기준으로 삼는 최소한의 안드로이드 버전이다. 이보다 낮은 버전을 가진 디바이스는 앱을 설치 할 수 없다.

### 목표 SDK 버전
targetSdkVersion 값은 설계된 앱이 실행되는 API 레벨을 안드로이드에 알려준다. 대부분 가장 최신 버전의 안드로이드 버전을 사용한다. 이미 개발한 앱의 목표 SDK 버전을 올릴땐 문제가 생길 수 있으므로 항상 테스트가 필요하다.

### 컴파일 SDK 버전
컴파일 SDK 버전은 코드를 빌드할 때 사용할 버전을 나타낸다. 안드로이드 스튜디오가 import 문으로 참조되는 클래스나 메서드를 찾을 때 어떤 버전의 SDK에서 찾을 것인가를 결정하는 것이 컴파일 SDK 버전이다. 주로 가장 최신의 API 레벨을 사용하지만 예외도 있다.

SDK 버전을 변경하고 나면 build.gradle의 동기화가 필요하다.

## API 코드
앱을 사용하는 장치의 안드로이드 버전은 ` Build.VERSION.SDK_INT` 로 알 수 있다. 
이것을 통해 장치의 안드로이드 버전마다 앱의 동작을 달리 하여 호환성 문제를 해결할 수 있다.



#android/실무에바로적용하는안드로이드