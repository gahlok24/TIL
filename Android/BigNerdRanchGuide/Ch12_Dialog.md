# Ch12_Dialog
## Dialog(대화상자)
* 사용자의 주의를 끌고 입력을 받는 데 사용됨
* 선택할 내용이나 중요한 정보를 보여줄 때 유용하다.


## AppCompat 라이브러리
### AppCompat 라이브러리 사용 방법
의존성(Dependency)에 추가
Android Studio -> File -> Project Structure -> Dependencies 탭 -> 검색해서 추가

## DialogFragment
AlertDialog를 사용할 때는 Fragment의 서브 클래스인 DialogFragment의 인스턴스에 래핑하는 것이 좋다.

DialogFragment 없이 AlertDialog를 보여주는 것이 가능하지만 권장하지 않는다. 왜냐하면 FragmentManager에 의해 대화상자가 관리되는 것이 더 장점이 많고 화면 회전시 화면에서 사라지기 때문이다. 

## DialogFragment 보여주기
```kotlin
// 트랜잭션이 자동으로 생성되어 커밋됨
fun show(manager: FragmentManager, tag : String)

// 직접 트랜잭션을 생성하고 커밋해야 함
fun show(transaction: FragmentTransaction, tag: String)
```



## 두 프래그먼트 간에 데이터 전달하기
CrimeFragment에서 DialogFragment를 호출하고 그 결과를 받아야 하므로 프래그먼트 간의 데이터 전달이 필요함 -> Fragment.onActivityResult() 사용


### DatePickerFragment에 데이터 전달하기
DatePickerFragment를 생성할 때 번들을 생성하여 프래그먼트 인자로 건내주면 된다

```kotlin
fun newInstance(date: Date): DatePickerFragment {
    val args = Bundle()
    args.putSerializable(ARG_DATE, date)

    return DatePickerFragment().apply {
this.arguments= args
    }
}
```
	

### CrimeFragment로 데이터 반환하기
**목표 프래그먼트 설정하기**

`fun setTargetFragment(framgent: Fragment, requestCode: Int)`
이 메서드는 목표가 되는 프래그먼트와 요청 코드를 인자로 받는다. 여기서 요청 코드는 starActivityForResult(..)의 인자로 전달하는 것과 같은 의미의 코드다.


### 목표 프래그먼트로 데이터 전달하기
DatePickerFragment에서 CrimeFragment.onActivityResult(int, int, Intent) 메서드를 호출하면서 인자를 전달하면 된다.

* Activity.onActivityResult(…)
	ActivityManager가 부모 액티비티의  것을 (자식 액티비티가 끝난 후) 호출하는 메서드 액티비티를 처리할 때 Activity.onActivityResult(...)는 우리가 직접 호출하지 않는다. 그것은 ActivityManager의 일이기 때문. 그리고 액티비티가 그 메서드의 호출을 받은 후에 FragmentManager가 해당 프래그먼트의 Fragment.onActivityResult()를 호출한다.

**Fragment.onActivityResult(…)의 인자**
* `int requestCode `- 결과를 반환하는 목표 프래그먼트에 알려주기 위한 요청 코드, setTargetFragment(...)를 호출 시에 인자로 전달되었던 코드와 일치한다. 어떤 프래그먼트가 결과를 반환하는지 판단하는데 사용된다.
* `int resultCold` - 조치할 액션을 결정하는 결과 코드
* `Intent` - 엑스트라 데이터를 가질 수 있는 Intent 객체



#android/실무에바로적용하는안드로이드