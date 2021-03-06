# Ch19_SoundPool
## SoundPool
APK 내부의 리소스나 파일 시스템의 파일로부터 음원을 메모리로 로드하고 재생해준다.
한 번에 재생할 수 있는 음원의 최대 개수를 제어할 수도 있다.

MediaPlayer 서비스를 사용해서 16비트 PCM 모노노 스테레오 스트림으로 디코딩 해줌
-> 압축 음원을 앱에 포함시켜 배포할 수 있음

## SoundPool 생성
```java
SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0)
```

1. 첫번째 인자
	* 재생할 음원의 최대 개수
2. 두 번째 인자
	* 재생할 오디오 스트림의 종류
	* STREAM_MUSIC을 할 경우 장치의 음악과 게임이 동일한 볼륨 설정을 갖게 됨
3. 세 번째 인자
	* 샘플 레이트 컨버터의 퀄리티 -> 아무런 영향을 안 주므로 0을 넣어주면 됨


## 음원 재생
```kotlin
// 음원 ID, 왼쪽 볼륨, 오른쪽 볼륨, 스트림 우선순위, 반복재생, 재생률
soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
```


## 음원 클린업
음원 재생이 끝나면 SoundPool.release()를 호출하여 클린업해주어야 한다

```kotlin
soundPool.release()
```


## 프래그먼트 유보하기
`setRetainInstance(boolean)`
기본적으로 프래그먼트의 retainInstance 속성 값은 false 
-> 장치 회전 시에 유보(retained) 되지 않고 자신을 호스팅하는 액티비티와 더불어 소멸되었다가 다시 생성됨

장치 회전 시 뷰만 소멸되고 프래그먼트 인스턴스는 소멸되지 않음
-> 호스트 액티비티로부터 detach됨 (호스팅 액티비티가 없는 상태)

### 유보상태 가능 조건
1. `setRetainInstance(true)` 가 프래그먼트에 호출되었을 때
2. 구성 변경(일반적으로 장치 회전)으로 호스팅 액티비티가 소멸될 때

### 유보 단점
1. 복잡해짐 -> 에러 발생시 디버깅 힘듬
2. 유보 프래그먼트는 구성 변경에 따른 액티비티 소멸 상황만을 처리 -> 운영체제가 메모리를 회수하면서 액티비티 소멸되면 모든 유보 프래그먼트도 소멸됨 -> 데이터 유실


### 유보 사용 상황
데이터의 존속 기간이 관건

구성 변경을 유지하는 데 충분한 시간 동안만 존속할 필요가 있을때 사용git


#android/실무에바로적용하는안드로이드