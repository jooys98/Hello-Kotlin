fun main() {
    println("안녕 코틀린?")
    val name = "주윤발"
// val: 불변(immutable) 변수 (Java의 final과 유사)
    var age = 28
    //var : 가변 변수 (값이 변할 수 있음)
    println("이름 : $name ,나이 : $age")
    //변수 앞에 $ 붙히고 ""로 감싸면 문자로 출력할 수 있음
    age = 80
    println("이름 : $name ,나이 : $age")
    // 여기서는 age 값이 재할당되어 80 으로 출력되는걸 볼 수 있다

//자바처럼 타입 선언이 아니라 문자열이면 "" 를 붙혀서 컴파일러가 타입을 추론하게 할 수 있다
    //명시적으로 변수 앞에 타입을 선언할 수 있다
    // var/val  변수명 : 타입명 = 값
    var email: String = "test@test.com"
    var sal: Long = 24000

    //또는 면시적 타입 지정 변수 선언 후 나중에 초기화 해도 된다
    val firstName: String

    // firstName 이라는 변수는 String 타입으로 하겠다고 선언
    firstName = "마라돼지" // 초기화

    println("내 별명은 : $firstName")


    // 코틀린에서는 기본타입이 전부 '객체'로 표현된다
    //자바에서는 소문자로 시작하는 기본타입에게 쓸수 있는 메서드를 제공하는 wrapper class 를 제공하지만
    //코틀린은 기본타입마저 객체 취급을 하기 때문에 타입명은 전부 대문자로 시작한다

//숫자 타입, 타입별 메모리 크기는 자바와 같다
    var int: Int = 0 // 4byte
    var long: Long = 0 // 8byte
    var byte: Byte = 0 // 1byte
    var double: Double = 0.0
    var float: Float = 0f
    var isFullTime: Boolean = false
    var char: Char = 'a'

    println(isFullTime)
    println(char)
    println(int)

    // 변수에 할당된값의 타입이 같다면 변수를 합해서 다른 변수의 값에 할당할 수 있다
//문자열 연결해서 출력하기
    var a = "돼지"
    var b = "마라"
    val c = b + a
    val d = "$b$a"
    println(c)
    println(d)

    //숫자연산 출력하기
    val x: Long = 23000
    val y: Long = 2
    println("내 전재산 : ${x * y}원 ㅎㅎ")

// 여러 줄 문자열 ("""로 감싸기)
    val employeeInfo = """
        이름: 주윤발
        나이: 20세
        시급: 120원
        주소: 서울시 관악구
    """.trimIndent()  // trimIndent()로 들여쓰기 제거

    println(employeeInfo)


    // if - else 문
    val payment = 120

    if (payment > 9800) {
        println("최저시급 이상입니다")
    } else {
        println("북조선로동자 입니다")
    }

// 변수에 조건에 따라 값 다르게 저장하기
    val paymentStatus = if (payment > 9800) "서울인" else "북조선로동자"
    println(paymentStatus)

    //변수에 if - else - else if 저장하기
    val hours: Long = 45
    val overtimeStatus = if (hours <= 40) {
        "정상 근무"
    } else if (hours <= 52) {
        "노예 근무"
    } else {
        "법정 한도 초과"
    }
    println("근무 상태: $overtimeStatus")


    val paymentCycle = "WEEKLY"

    // 기본 when 표현식 (switch - case 문 비슷한 문법)
    when (paymentCycle) {
        "WEEKLY" -> println("주급으로 지급합니다.")
        "MONTHLY" -> println("월급으로 지급합니다.")
        else -> println("지급 주기가 설정되지 않았습니다.")
    }


    // 범위 검사
    val employeeAge = 22
    val ageGroup = when (employeeAge) {
        in 1..17 -> "미성년자 (고용 불가)"
        in 18..30 -> "청년층"
        in 31..55 -> "중년층"
        else -> "장년층"
    }
    println("나이 그룹: $ageGroup")


//for 반복문
    for (i in 1..5) {
        println("숫자 : $i") // 1- 5 까지 출력
    }


    // 역순 반복
    for (i in 5 downTo 1) {
        println("역순 카운트: $i")
    }


    // 컬렉션 반복
    val employees = listOf("김민수", "이영희", "박철수", "정미나")
    for (employee in employees) {
        //하나씩 꺼낸다 in 리스트 (복수) 에서
        println("알바생: $employee")
    } // 리스트 안의 문자열들이 하나씩 출력된다

// 맵 반복
    val hourlyWages = mapOf(
        "김민수" to 10000,
        "이영희" to 9800,
        "박철수" to 10200
    )  //hourlyWages 안의 객체의 위치에 맞게
    // 김민수 -> salary , 10000 -> wage 가 되어 map 안의 객체들이 반복 출력된다
    for ((salary, wage) in hourlyWages) {
        println("$salary 의 시급: $wage 원")
    }

//NullPointerException 을 방지하는 null 안정성 함수
// employeeName 변수는 String? 타입으로 null 을 저장할 수 있다
// ? 기호가 붙은 타입은 해당 변수가 null 값을 가질 수 있다는 의미
    var employeeName: String? = "주윤발"
    // 주윤발 -> null 로 값 변경
    employeeName = null

    // 알바생 객체를 만들 클래스
    data class Employee(
        val name: String,
        val email: String,
        val age: Int,
        val hourlyWage: Int,
        val insuranceStatus: Boolean,
        val paymentCycle: String,
        val workingHours: Double? = null // null 값을 가질 수 있다
    )

    // 인스턴스를 리스트 화 시켜서 employeesList 에 저장하기
    val employeesList = listOf(
        Employee("윤바리", "joohd@@", 20, 10000, false, "WEEKLY", 40.0),
        Employee("돼지", "marapig", 21, 12000, true, "MONTHLY", 38.0)
    )
    println("\n[ 전체 알바생]")

// employeesList 에서 알바생들의 정보를 출력하기
    for ((index, employee) in employeesList.withIndex()) {
        println("${index + 1}. ${employee.name} (${employee.email}), ${employee.age}세")
    }

    println("\n[급여 정보]")
    for (emp in employeesList) {
        val sal = if (emp.workingHours != null) {
            val baseSal = emp.workingHours * emp.hourlyWage
            val tax = if (emp.insuranceStatus) 0.9 else 0.97 // 4대보험 유뮤에 따른 환율
            (baseSal * tax).toLong()
        } else {
            0
        }
        val payment = when (emp.paymentCycle) {
            "WEEKLY" -> "주급"
            "MONTHLY" -> "월급"
            else -> "미정"
        }

        val isJoin = if (emp.insuranceStatus) "가입" else "마가입"
 println("${emp.name}: $payment ${sal}원 4대보험 유무 : $isJoin")
    }
}