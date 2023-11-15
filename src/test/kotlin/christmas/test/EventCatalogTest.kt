package christmas.test

import OrderItem
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.main
import christmas.model.Date
import christmas.model.EventCatalog
import christmas.model.Order
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

class EventCatalogTest {

    fun createEventCatalog(date: Int, orderItems: List<OrderItem>): EventCatalog {
        val date = Date(date)
        val order = Order(orderItems)
        return EventCatalog(date, order.getTotalCost(), order)

    }

    @Nested
    inner class `10000원 미만의 주문`() {
        private lateinit var eventCatalog: EventCatalog

        @BeforeEach
        fun `이벤트 카탈로그 객체 생성`() {
            eventCatalog = createEventCatalog(
                date = 3,
                orderItems = listOf(
                    OrderItem("타파스", 1),
                    OrderItem("제로콜라",1)
                )
            )
        }

        @Test
        fun `주문 금액 10000원 미만으로 혜택 내역이 없는가?`() {
            Assertions.assertFalse(eventCatalog.hasEvent())
        }

        @Test
        fun `증정 메뉴가 없는가?`() {
            Assertions.assertFalse(eventCatalog.hasGiftEvent())
        }

        @Test
        fun `총혜택 금액이 0인가?`() {
            Assertions.assertEquals(eventCatalog.getTotalEventDiscountCost(), 0)
        }

        @Test
        fun `배지가 "없음"으로 뜨는가?`() {
            Assertions.assertEquals(eventCatalog.getEventBadge(), "없음")
        }
    }


    @Nested
    inner class `주말 할인 테스트`() {
        private lateinit var eventCatalog: EventCatalog



        @BeforeEach
        fun `이벤트 카탈로그 객체 생성`() {
            eventCatalog = createEventCatalog(
                date = 2,
                orderItems = listOf(
                    OrderItem("티본스테이크", 3),
                    OrderItem("제로콜라", 1),
                )
            )
        }

        @Test
        fun `주말 이벤트가 적용되어 있는가?`() {
            Assertions.assertTrue(eventCatalog.getEventCatalog().containsKey(EventCatalog.EventType.WEEKEND_DISCOUNT))
            Assertions.assertTrue(eventCatalog.getEventCatalog().containsValue(6069))
        }

    }

    @Nested
    inner class `평일 할인 테스트`() {
        private lateinit var eventCatalog: EventCatalog

        @BeforeEach
        fun `이벤트 카탈로그 객체 생성`() {
            eventCatalog = createEventCatalog(
                date = 31,
                orderItems = listOf(
                    OrderItem("티본스테이크", 3),
                    OrderItem("초코케이크", 5),
                )
            )
        }

        @Test
        fun `평일 이벤트가 적용되어 있는가?`() {
            Assertions.assertTrue(eventCatalog.getEventCatalog().containsKey(EventCatalog.EventType.WEEKDAY_DISCOUNT))
            Assertions.assertTrue(eventCatalog.getEventCatalog().containsValue(10115))
        }
    }


    @Nested
    inner class `특별 할인 테스트`() {
        private lateinit var eventCatalog: EventCatalog

        @BeforeEach
        fun `이벤트 카탈로그 객체 생성`() {
            eventCatalog = createEventCatalog(
                date = 25,
                orderItems = listOf(
                    OrderItem("티본스테이크", 3),
                    OrderItem("초코케이크", 5),
                )
            )
        }

        @Test
        fun `특별 이벤트가 적용되어 있는가?`() {
            Assertions.assertTrue(eventCatalog.getEventCatalog().containsKey(EventCatalog.EventType.SPECIAL_DISCOUNT))
            Assertions.assertTrue(eventCatalog.getEventCatalog().containsValue(1000))
        }
    }


}