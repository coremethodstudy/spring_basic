package org.multimodule.spring_basic.scan.filter;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * packageName    : org.multimodule.spring_basic.scan.filter
 * fileName       : MyIncludeComponent
 * author         : AngryPig123
 * date           : 2024-04-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-14        AngryPig123       최초 생성
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
