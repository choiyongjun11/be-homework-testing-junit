package com.springboot.homework;

import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //Junit으로 작성해야 합니다. given, when, then
        //given
        int nowCount = 5; //현재 보유
        int earned = 3; //추가 스탬프
        int expectedTotal = 8; //기대값
        //when
        int actulTotal = nowCount + earned; //계산된 값
        //then   기대값 vs 계산값
        assertEquals(expectedTotal, actulTotal, "스탬프 총합 계산이 예상과 다르다.");


        //해답지
        /*
        //given
        int nowCount = 5;
        int earned =3;
        //when

        int actual = StampCalculator.calculateEarnedStampCount(nowCount, earned);
                int expected = nowCount + earned;
                assertEquals( expected, actual);

         int nowCount = 5;
        int earned = 3; //획득한 stmap

        //현재의  actual
        int actual = StampCalculator.calculateEarnedStampCount(nowCount,earned);
        //기대 expected
            int expected = nowCount + earned;
            assertEquals( expected, actual);
         */
        //given


    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //주문 (order)에 대한 정보를 가져온 후, 주문이 완료됐을 시, 스탬프(stamp)를 찍어야 합니다.
        // 스탬프를 찍고 난 후 누적 합계를 계산하면 됩니다.


        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);

        order.setOrderCoffees(List.of(orderCoffee1,orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

        int actual = StampCalculator.calculateEarnedStampCount(order);

        System.out.println(expected== actual);

        //해설지
        //given
        /*
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(10);

        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));
        int actual = StampCalculator.calculateEarnedStampCount(order);
        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();
        //then
        assertEquals(expected, actual);
        */
    }
}
