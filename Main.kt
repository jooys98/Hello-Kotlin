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


    
}