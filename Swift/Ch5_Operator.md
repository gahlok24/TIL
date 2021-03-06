# Ch5_Operator
특정한 문자로 표현한 함수

**연산자의 분류**
* 단항 연산자 - 피연산자가 한 개인 연산자. !A
* 이항 연산자 - 피연산자가 두 개인 연산자. A + B
* 삼항 연산자 - 피연산자가 세 개인 연산자. A ? B : C
* 전위 연산자 - 연산자가 피연산자 앞에 위치하는 연산자 . !A
* 중위 연산자 - 연산자가 피연산자 사이에 위치하는 연산자.  A + B
* 후위 연산자 - 연산자가 피연산자 뒤에 위치하는 연산자.  A!

## 5.1 연산자의 종류
### 5.1.1. 할당 연산자
값을 할당
A = B


### 5.1.2 산술 연산자
* +
* -
* *
* /
* %

스위프트는 데이터 타입에 엄격하므로 서로 다른 자료형끼리의 연산을 엄격히 제한함
서로 다른 자료형끼리 연산을 할려먼 해당 타입으로 변환한 후 연산해야된다.


### 5.1.3 비교 연산자
* == 
* >=
* <=
* >
* <
* !+
* === : 참조가 같다. A === B -> A와 B가 같은 인스턴스를 가리키는지 비교함
* !== : 참조가 같지 않다
* ~= :  패턴 매치 되는지 확인



### 5.1.4 삼항 조건 연산자
Question ? A : B - Question의 불리언 값이 참이면 A를, 거짓이면 B를 반환


### 5.1.5 범위 연산자
* 폐쇄 범위 연산자 - A…B -> A-와 B를 포함하는 범위
* 반폐쇄 범위 연산자  - A..<B -> A와 B 미만까지의 범위
* 단방향 범위 연산자 - 
	* A… -> A 이상의 수를 묶어 범위를 표현, A를 포함
	* … A -> A이하의 수를 묶어 범위를 표현 , A를 포함
	* ..<A -> A미만의 수를 묶어 범위 표현, A 불포함


### 5.1.6 부울 연산자
* NOT연산자 - !B, 참 거짓 반전
* AND 부울 연산자. :A && B -> A와 B의 불리언 AND
* OR 부우 연산자 : A || B -> OR


### 5.1.7 비트 연산자
* NOT 비트 연사자 : ~A
* AND 비트 연산자 : A&B
* OR 비트 연산자 : A|B
* XOR 비트 연산자 : A^B
* 비트 이동 연산자 : A>>B, A<<B


### 5.1.8 복합 할당 연산자
Compound Assignment
할당 연산자와 다른 연산자가 하는 일을  한 번에 할 수 있도록 연산자 결합 가능
* A+=B
* A-=B
* A*=B
* A/=B
* A%=B
* A<<=N
* A>>=N
* A&=B
* A|=B
* A^=B


### 5.1.9 오버플로 연산자
오버플로에 대한 추가 알고리즘 및 로직 등을 설계하는 것이 일반적이었지만 스위프트는 기본 연산자를 통해 오버플로에 대비할 수 있도록 해줌

* 오버플로 더하기 연산 : &+
* 오버플로 빼기 연산 : &-
* 오버플로 곱하기 연산 : &*


### 5.1.10 기타 연사ㅏㄴ자
* nil 병합 연산자 - A??B -> A가 nil이 아니면 A를 반환하고 , A가 nil이면 B를 반환함
* 부호변경 연산자 -A -> A의 부호를 변경합니다.
* 옵셔널 강제 추출 연산자 : O!  -> O의 값을 강제로 추출 
* 옵셔녈 연산자 : V? -> V를 안전하게 추출하거나 V가 옵셔널임을 표현함.


## 5.2 연산자 우선순위와 결합방향
스위프트는 연산자 우선순위가 지정되어있으므로 우선순위가 높은 연산자가 먼저 실행된다.

또 연산의 결합방향도 지정되어 있다.

스위프트는 Obj-C를 기반으로 만들어졌지만 우선순위는 C 계열 언어와 완전히 같지는 않다.


## 5.3 사용자정의 연산자
사용자의 입맛에 맞게 연산자 역할을 부여 가능
할당 연산자 (=), 삼항 연산자(?:) 는 사용자 정의 역할을 부여할 수 없음.

* 전위 연산자 - 연산자가 피연산자 앞에 위치하는 연산자
* 중위 연산자 - 피연산자 사이에 위치하는 연산자
* 후위 연산자 - 피연산자 뒤에 위치하는 연산자


## 5.3.1 전위 연산자 정의와 구현

** -> 제곱 연산자로 사용자 정의
`prefix operator **`
연산자의 정의를 마치고 함수를 구현해줘야 한다.

```swift
prefix operator **

prefix func **(value: Int) -> Int {
	return value * value
}

let minusFive: Int = -5
let sqrtMinusFive: Int = **minusFive

print(sqrtMinusFive) // 25
```

스위프트 표준 라이브러리에 이미 전위 연산자가 존재할 경우 그냥 함수만 중복 정의하면 된다.


전위 연산자 함수 중복 정의와 사용
```swift
prefix func !(value: String) -> Bool {
	return value.isEmpty
}

var stringValue: String = "yagom"
var isEmptyString: Bool = !stringValue

print(isEmptyString) // false

stringValue = ""
isEmptyString = !stringValue

print(isEmptyString) // true
```


### 5.3.2 후위 연산자 정의와 구현
```swift
postfix operator **

postfix func **(value: Int) -> Int {
	return value + 10
}

let five: Int = 5
let fivePlusTen: Int = five**
```


전위 연산자와 후위 연산자를 한 번에 사용하게 되면 후위 연산을 먼저 실행한다
```swift
prefix operator **
postfix operator **

prefix func **(value: Int) -> Int {
	return value * value
}

postfix func **(value: Int) -> Int {
	return value + 10
}

let five: Int = 5
let sqrtFivePlusTen: Int = **five**

print(sqrtFivePlusTen) // (10 + 5) * (10 + 5) == 225
```


### 5.3.3 중위 연산자 정의와 구현
중우 연산자는 우선순위 그룹을 명시 가능

```swift
precedencegroup [우선순위 그룹 이름] {
	higherThan: [더 낮은 우선순위 그룹 이름]
	lowerThan: [더 높은 우선순위 그룹 이름]
	associativity: [결합방향(left / right / none)] // 기본값 none
	assignment: [할당방향 사용(true / false)]	// 기본값 false
}
```

associativity를 생략할 경우 기본값 none으로 설정됨







#Swift