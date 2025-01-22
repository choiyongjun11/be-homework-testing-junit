package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.springboot.helper.RandomPasswordGenerator.shuffleLetters;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        //given
        int numberOfUpperCaseLetters = 2; //대문자 2개
        int numberOfLowerCaseLetters = 5; //소문자 5개
        int numberOfNumeric = 2;  //숫자 2개
        int numberOfSpecialChars = 1; //특수문자 1개
        int expectedLength = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumeric + numberOfSpecialChars; //비밀번호 전체

        //when
        RandomPasswordGenerator generator = new RandomPasswordGenerator();
        String password = generator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters, numberOfNumeric, numberOfSpecialChars);

        //then
        assertNotNull(password, "생성된 패스워드는 null이 아니어야 합니다.");
        assertEquals(expectedLength, password.length(), "생성된 패스워드 길이가 기대값과 다릅니다.");

        //검증

        long upperCaseCount = password.chars().filter(Character::isUpperCase).count();
        long lowerCaseCount = password.chars().filter(Character::isLowerCase).count();
        long numericCount = password.chars().filter(Character::isDigit).count();
        long specialCharCount = password.chars().filter(ch -> !Character.isLetterOrDigit(ch)).count();

        assertEquals(numberOfUpperCaseLetters, upperCaseCount, "대문자 개수가 기대값과 다릅니다.");
        assertEquals(numberOfLowerCaseLetters, lowerCaseCount, "소문자 개수가 기대값과 다릅니다.");
        assertEquals(numberOfNumeric, numericCount, "숫자 개수가 기대값과 다릅니다.");
        assertEquals(numberOfSpecialChars, specialCharCount, "특수문자 개수가 기대값과 다릅니다.");

        //풀이

        //given

        /*
        int numberOfUpperCaseLetters = 3;
        int numberOfLowerCaseLetters = 3;
        int numberOfNumeric = 5;
        int numberOfSpecialChars = 2;

        int expectedPasswordLength = numberOfLowerCaseLetters + numberOfUpperCaseLetters + numberOfNumeric + numberOfSpecialChars;

        //when
        String randomPassword = RandomPasswordGenerator.generate(
                numberOfUpperCaseLetters, numberOfLowerCaseLetters, numberOfNumeric, numberOfSpecialChars);

        int actualUpperCaseCount = (int)randomPassword.chars()
                .filter(c-> Character.isUpperCase(c))
                        .count();

        int actualLowerCaseCount = (int)randomPassword.chars()
                .filter(c-> Character.isLowerCase(c))
                .count();

        int actualNumericCount = (int)randomPassword.chars()
                .filter(c-> Character.isDigit(c))
                .count();

        int actualSpecialCount = expectedPasswordLength - (actualUpperCaseCount + actualLowerCaseCount + actualNumericCount);


        //then

        //조건 1. 전체 길이가 맞는지
        assertEquals(expectedPasswordLength, randomPassword.length());
        //조건 2. 대문자의 갯수가 맞는지
        assertEquals(numberOfUpperCaseLetters,
                randomPassword.chars()
                        .filter(c-> Character.isUpperCase(c))
                        .count());

        //조건 3. 소문자의 갯수가 맞는지
        assertEquals(numberOfLowerCaseLetters, randomPassword.chars()
                .filter(c-> Character.isLowerCase(c))
                .count());

        // 조건 4. 숫자의 갯수가 맞는지 (숫자의 정의 0,1,2,3,4,5,6,7,8,9)
        assertEquals(numberOfNumeric, randomPassword.chars()
                .filter(c -> Character.isDigit(c))
                .count());
        // 조건 5. 특수문자의 갯수가 맞는지
        assertEquals(numberOfSpecialChars, randomPassword.chars()
                .filter(c -> "!@#$%^&*(),.\":{}|<>".indexOf(c) != -1)
                .count());
    }

    private int countUpperCaseChars(String str) {
        String upperString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;
        for(char c: str.toCharArray()) {
            if(upperString.indexOf(c) != -1) {
                count++;
            }
        }
        return count;

    }
         */

    }
}
