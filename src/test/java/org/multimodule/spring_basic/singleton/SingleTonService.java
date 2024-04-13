package org.multimodule.spring_basic.singleton;

/**
 * packageName    : org.multimodule.spring_basic.singleton
 * fileName       : SingleTonService
 * author         : AngryPig123
 * date           : 2024-04-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-13        AngryPig123       최초 생성
 */
public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

    private SingleTonService() {
    }

}
