package christmas.view

import camp.nextstep.edu.missionutils.test.NsTest
import christmas.main
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest

class UnitAppTest : NsTest() {

    @Test
    fun `주문 메뉴 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<주문 메뉴>",
                "티본스테이크 1개",
                "바비큐립 1개",
                "초코케이크 2개",
                "제로콜라 1개"
            )
        }
    }

    @Test
    fun `할인 전 총주문 금액 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<할인 전 총주문 금액>",
                "142,000원"
            )
        }
    }

    @Test
    fun `증정 메뉴 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<증정 메뉴>",
                "샴페인 1개"
            )
        }
    }

    @Test
    fun `혜택 내역 표시 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<혜택 내역>",
                "크리스마스 디데이 할인: -1,200원",
                "평일 할인: -4,046원",
                "특별 할인: -1,000원",
                "증정 이벤트: -25,000원"
            )
        }
    }

    @Test
    fun `총혜택 금액 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<총혜택 금액>",
                "-31,246원"
            )
        }
    }

    @Test
    fun `할인 후 예상 금액 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<할인 후 예상 결제 금액>",
                "135,754원"
            )
        }
    }

    @Test
    fun `배지 정상 표시`(){
        assertSimpleTest {
            run("3","티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            Assertions.assertThat(output()).contains(
                "<12월 이벤트 배지>",
                "산타"
            )
        }
    }





    override fun runMain() {
        main()
    }

    companion object {
        private val LINE_SEPARATOR = System.lineSeparator()
    }
}